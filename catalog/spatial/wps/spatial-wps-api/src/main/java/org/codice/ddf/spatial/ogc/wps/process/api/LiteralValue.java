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
package org.codice.ddf.spatial.ogc.wps.process.api;
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.05.08 at 01:14:15 PM MST
//

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.ows.v_2_0.ValueType;
import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom2;
import org.jvnet.jaxb2_commons.lang.MergeStrategy2;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * Representation of a simple literal value (such as an integer, a real number, or a string).
 *
 * <p>
 *
 * <p>
 *
 * <p>String representation of the actual value (e.g., "49").
 *
 * <p>
 *
 * <p>
 *
 * <p>Java class for anonymous complex type.
 *
 * <p>
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <p>
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.opengis.net/ows/2.0&gt;ValueType"&gt;
 *       &lt;attribute name="dataType" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="uom" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiteralValue")
// todo (RWY) - had to replace this line to fix an issue with marshalling remove this file once
// https://github.com/highsource/ogc-schemas/pull/190 is merged and released
@XmlRootElement(name = "LiteralValue")
@SuppressWarnings("all")
public class LiteralValue extends ValueType
    implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2 {

  @XmlAttribute(name = "dataType")
  @XmlSchemaType(name = "anyURI")
  protected String dataType;

  @XmlAttribute(name = "uom")
  @XmlSchemaType(name = "anyURI")
  protected String uom;

  /**
   * Gets the value of the dataType property.
   *
   * @return possible object is {@link String }
   */
  public String getDataType() {
    return dataType;
  }

  /**
   * Sets the value of the dataType property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDataType(String value) {
    this.dataType = value;
  }

  public boolean isSetDataType() {
    return (this.dataType != null);
  }

  /**
   * Gets the value of the uom property.
   *
   * @return possible object is {@link String }
   */
  public String getUom() {
    return uom;
  }

  /**
   * Sets the value of the uom property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUom(String value) {
    this.uom = value;
  }

  public boolean isSetUom() {
    return (this.uom != null);
  }

  public String toString() {
    final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
    final StringBuilder buffer = new StringBuilder();
    append(null, buffer, strategy);
    return buffer.toString();
  }

  public StringBuilder append(
      ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    strategy.appendStart(locator, this, buffer);
    appendFields(locator, buffer, strategy);
    strategy.appendEnd(locator, this, buffer);
    return buffer;
  }

  public StringBuilder appendFields(
      ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
    super.appendFields(locator, buffer, strategy);
    {
      String theDataType;
      theDataType = this.getDataType();
      strategy.appendField(locator, this, "dataType", buffer, theDataType, this.isSetDataType());
    }
    {
      String theUom;
      theUom = this.getUom();
      strategy.appendField(locator, this, "uom", buffer, theUom, this.isSetUom());
    }
    return buffer;
  }

  public boolean equals(
      ObjectLocator thisLocator,
      ObjectLocator thatLocator,
      Object object,
      EqualsStrategy2 strategy) {
    if ((object == null) || (this.getClass() != object.getClass())) {
      return false;
    }
    if (this == object) {
      return true;
    }
    if (!super.equals(thisLocator, thatLocator, object, strategy)) {
      return false;
    }
    final LiteralValue that = ((LiteralValue) object);
    {
      String lhsDataType;
      lhsDataType = this.getDataType();
      String rhsDataType;
      rhsDataType = that.getDataType();
      if (!strategy.equals(
          LocatorUtils.property(thisLocator, "dataType", lhsDataType),
          LocatorUtils.property(thatLocator, "dataType", rhsDataType),
          lhsDataType,
          rhsDataType,
          this.isSetDataType(),
          that.isSetDataType())) {
        return false;
      }
    }
    {
      String lhsUom;
      lhsUom = this.getUom();
      String rhsUom;
      rhsUom = that.getUom();
      if (!strategy.equals(
          LocatorUtils.property(thisLocator, "uom", lhsUom),
          LocatorUtils.property(thatLocator, "uom", rhsUom),
          lhsUom,
          rhsUom,
          this.isSetUom(),
          that.isSetUom())) {
        return false;
      }
    }
    return true;
  }

  public boolean equals(Object object) {
    final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
    return equals(null, null, object, strategy);
  }

  public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
    int currentHashCode = super.hashCode(locator, strategy);
    {
      String theDataType;
      theDataType = this.getDataType();
      currentHashCode =
          strategy.hashCode(
              LocatorUtils.property(locator, "dataType", theDataType),
              currentHashCode,
              theDataType,
              this.isSetDataType());
    }
    {
      String theUom;
      theUom = this.getUom();
      currentHashCode =
          strategy.hashCode(
              LocatorUtils.property(locator, "uom", theUom),
              currentHashCode,
              theUom,
              this.isSetUom());
    }
    return currentHashCode;
  }

  public int hashCode() {
    final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
    return this.hashCode(null, strategy);
  }

  public Object clone() {
    return copyTo(createNewInstance());
  }

  public Object copyTo(Object target) {
    final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
    return copyTo(null, target, strategy);
  }

  public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
    final Object draftCopy = ((target == null) ? createNewInstance() : target);
    super.copyTo(locator, draftCopy, strategy);
    if (draftCopy instanceof LiteralValue) {
      final LiteralValue copy = ((LiteralValue) draftCopy);
      {
        Boolean dataTypeShouldBeCopiedAndSet =
            strategy.shouldBeCopiedAndSet(locator, this.isSetDataType());
        if (dataTypeShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceDataType;
          sourceDataType = this.getDataType();
          String copyDataType =
              ((String)
                  strategy.copy(
                      LocatorUtils.property(locator, "dataType", sourceDataType),
                      sourceDataType,
                      this.isSetDataType()));
          copy.setDataType(copyDataType);
        } else {
          if (dataTypeShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.dataType = null;
          }
        }
      }
      {
        Boolean uomShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, this.isSetUom());
        if (uomShouldBeCopiedAndSet == Boolean.TRUE) {
          String sourceUom;
          sourceUom = this.getUom();
          String copyUom =
              ((String)
                  strategy.copy(
                      LocatorUtils.property(locator, "uom", sourceUom),
                      sourceUom,
                      this.isSetUom()));
          copy.setUom(copyUom);
        } else {
          if (uomShouldBeCopiedAndSet == Boolean.FALSE) {
            copy.uom = null;
          }
        }
      }
    }
    return draftCopy;
  }

  public Object createNewInstance() {
    return new LiteralValue();
  }

  public void mergeFrom(Object left, Object right) {
    final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
    mergeFrom(null, null, left, right, strategy);
  }

  public void mergeFrom(
      ObjectLocator leftLocator,
      ObjectLocator rightLocator,
      Object left,
      Object right,
      MergeStrategy2 strategy) {
    super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
    if (right instanceof LiteralValue) {
      final LiteralValue target = this;
      final LiteralValue leftObject = ((LiteralValue) left);
      final LiteralValue rightObject = ((LiteralValue) right);
      {
        Boolean dataTypeShouldBeMergedAndSet =
            strategy.shouldBeMergedAndSet(
                leftLocator, rightLocator, leftObject.isSetDataType(), rightObject.isSetDataType());
        if (dataTypeShouldBeMergedAndSet == Boolean.TRUE) {
          String lhsDataType;
          lhsDataType = leftObject.getDataType();
          String rhsDataType;
          rhsDataType = rightObject.getDataType();
          String mergedDataType =
              ((String)
                  strategy.merge(
                      LocatorUtils.property(leftLocator, "dataType", lhsDataType),
                      LocatorUtils.property(rightLocator, "dataType", rhsDataType),
                      lhsDataType,
                      rhsDataType,
                      leftObject.isSetDataType(),
                      rightObject.isSetDataType()));
          target.setDataType(mergedDataType);
        } else {
          if (dataTypeShouldBeMergedAndSet == Boolean.FALSE) {
            target.dataType = null;
          }
        }
      }
      {
        Boolean uomShouldBeMergedAndSet =
            strategy.shouldBeMergedAndSet(
                leftLocator, rightLocator, leftObject.isSetUom(), rightObject.isSetUom());
        if (uomShouldBeMergedAndSet == Boolean.TRUE) {
          String lhsUom;
          lhsUom = leftObject.getUom();
          String rhsUom;
          rhsUom = rightObject.getUom();
          String mergedUom =
              ((String)
                  strategy.merge(
                      LocatorUtils.property(leftLocator, "uom", lhsUom),
                      LocatorUtils.property(rightLocator, "uom", rhsUom),
                      lhsUom,
                      rhsUom,
                      leftObject.isSetUom(),
                      rightObject.isSetUom()));
          target.setUom(mergedUom);
        } else {
          if (uomShouldBeMergedAndSet == Boolean.FALSE) {
            target.uom = null;
          }
        }
      }
    }
  }

  public LiteralValue withDataType(String value) {
    setDataType(value);
    return this;
  }

  public LiteralValue withUom(String value) {
    setUom(value);
    return this;
  }
}