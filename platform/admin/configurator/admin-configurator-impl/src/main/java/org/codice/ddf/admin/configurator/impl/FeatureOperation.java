/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.ddf.admin.configurator.impl;

import static org.apache.karaf.features.FeaturesService.Option.NoAutoRefreshBundles;
import static org.codice.ddf.admin.configurator.impl.ConfigValidator.validateString;
import static org.codice.ddf.admin.configurator.impl.OsgiUtils.getBundleContext;

import com.google.common.collect.Sets;
import ddf.security.permission.KeyValueCollectionPermission;
import ddf.security.permission.Permissions;
import java.util.EnumSet;
import org.apache.karaf.features.Feature;
import org.apache.karaf.features.FeatureState;
import org.apache.karaf.features.FeaturesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.codice.ddf.admin.configurator.ConfiguratorException;
import org.codice.ddf.admin.configurator.Operation;
import org.codice.ddf.admin.configurator.Result;
import org.codice.ddf.internal.admin.configurator.actions.FeatureActions;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Transactional handler for starting and stopping features. */
public class FeatureOperation implements Operation<Void> {
  private static final String INTERNAL_ERROR = "Internal error";

  private static final String SECURITY_ERROR = "Security error";

  public static class Actions implements FeatureActions {
    @Override
    public FeatureOperation start(String featureName) throws ConfiguratorException {
      validateString(featureName, "Missing feature name");
      return new FeatureOperation(
          featureName,
          true,
          getBundleContext(),
          SecurityUtils.getSubject(),
          getPermissionsService(getBundleContext()));
    }

    @Override
    public FeatureOperation stop(String featureName) throws ConfiguratorException {
      validateString(featureName, "Missing feature name");
      return new FeatureOperation(
          featureName,
          false,
          getBundleContext(),
          SecurityUtils.getSubject(),
          getPermissionsService(getBundleContext()));
    }

    private Permissions getPermissionsService(BundleContext bundleContext) {
      ServiceReference<Permissions> serviceReference =
          bundleContext.getServiceReference(Permissions.class);
      if (serviceReference != null) {
        return bundleContext.getService(serviceReference);
      }
      return null;
    }

    @Override
    public boolean isFeatureStarted(String featureName) throws ConfiguratorException {
      return start(featureName).readState();
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(FeatureOperation.class);

  private final String featureName;

  private final boolean newState;

  private final BundleContext bundleContext;

  private final Subject subject;

  private final boolean initActivationState;

  private Permissions permissions;

  private FeatureOperation(
      String featureName,
      boolean newState,
      BundleContext bundleContext,
      Subject subject,
      Permissions permissions) {
    this.featureName = featureName;
    this.newState = newState;
    this.bundleContext = bundleContext;
    this.subject = subject;
    this.permissions = permissions;

    initActivationState = lookupFeatureStatus(getFeaturesService(), featureName);
  }

  @Override
  public Result<Void> commit() throws ConfiguratorException {
    if (!isPermittedToViewFeature(featureName)) {
      LOGGER.debug("Error installing/uninstalling feature");
      throw new ConfiguratorException(SECURITY_ERROR);
    }

    FeaturesService featuresService = getFeaturesService();
    try {
      if (initActivationState != newState) {
        if (newState) {
          featuresService.installFeature(featureName, EnumSet.of(NoAutoRefreshBundles));
        } else {
          featuresService.uninstallFeature(featureName);
        }
      }
    } catch (Exception e) {
      LOGGER.debug("Error installing/uninstalling feature", e);
      throw new ConfiguratorException(INTERNAL_ERROR);
    }

    return ResultImpl.pass();
  }

  @Override
  public Result<Void> rollback() throws ConfiguratorException {
    FeaturesService featuresService = getFeaturesService();
    try {
      if (initActivationState != lookupFeatureStatus(featuresService, featureName)) {
        if (initActivationState) {
          featuresService.installFeature(featureName, EnumSet.of(NoAutoRefreshBundles));
        } else {
          featuresService.uninstallFeature(featureName);
        }
      }
    } catch (Exception e) {
      LOGGER.debug("Error installing/uninstalling feature", e);
      throw new ConfiguratorException(INTERNAL_ERROR);
    }

    return ResultImpl.rollback();
  }

  Boolean readState() throws ConfiguratorException {
    return lookupFeatureStatus(getFeaturesService(), featureName);
  }

  private FeaturesService getFeaturesService() {
    ServiceReference<FeaturesService> serviceReference =
        bundleContext.getServiceReference(FeaturesService.class);
    return bundleContext.getService(serviceReference);
  }

  private Boolean lookupFeatureStatus(FeaturesService featuresService, String featureName)
      throws ConfiguratorException {
    try {
      Feature feature = featuresService.getFeature(featureName);
      return featuresService.getState(
              String.format("%s/%s", feature.getName(), feature.getVersion()))
          == FeatureState.Started;
    } catch (Exception e) {
      throw new ConfiguratorException(String.format("No feature found named %s", featureName), e);
    }
  }

  private boolean isPermittedToViewFeature(String featureName) {
    KeyValueCollectionPermission serviceToCheck =
        permissions.buildKeyValueCollectionPermission(
            "view-feature.name",
            permissions.buildKeyValuePermission("feature.name", Sets.newHashSet(featureName)));

    return subject.isPermitted(serviceToCheck);
  }
}
