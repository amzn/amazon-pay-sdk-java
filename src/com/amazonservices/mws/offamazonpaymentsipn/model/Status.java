/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */
package com.amazonservices.mws.offamazonpaymentsipn.model;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.common.JSONFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.ReflectionFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.XmlFragmentBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Status complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Status">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastUpdateTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReasonDescription" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String255" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Status", propOrder = {
        "state",
        "lastUpdateTimestamp",
        "reasonCode",
        "reasonDescription"
})
public class Status {

    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "LastUpdateTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastUpdateTimestamp;
    @XmlElement(name = "ReasonCode")
    protected String reasonCode;
    @XmlElement(name = "ReasonDescription")
    protected String reasonDescription;

    /**
     * Default constructor
     *
     */
    public Status() {
        super();
    }

    /**
     * Value constructor
     *
     */
    public Status(final String state, final XMLGregorianCalendar lastUpdateTimestamp, final String reasonCode, final String reasonDescription) {
        this.state = state;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.reasonCode = reasonCode;
        this.reasonDescription = reasonDescription;
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setState(final String value) {
        this.state = value;
    }

    public boolean isSetState() {
        return (this.state != null);
    }

    /**
     * Gets the value of the lastUpdateTimestamp property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * Sets the value of the lastUpdateTimestamp property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setLastUpdateTimestamp(final XMLGregorianCalendar value) {
        this.lastUpdateTimestamp = value;
    }

    public boolean isSetLastUpdateTimestamp() {
        return (this.lastUpdateTimestamp != null);
    }

    /**
     * Gets the value of the reasonCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Sets the value of the reasonCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReasonCode(final String value) {
        this.reasonCode = value;
    }

    public boolean isSetReasonCode() {
        return (this.reasonCode != null);
    }

    /**
     * Gets the value of the reasonDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReasonDescription() {
        return reasonDescription;
    }

    /**
     * Sets the value of the reasonDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReasonDescription(final String value) {
        this.reasonDescription = value;
    }

    public boolean isSetReasonDescription() {
        return (this.reasonDescription != null);
    }

    /**
     * Sets the value of the State property.
     *
     * @param value
     * @return
     *     this instance
     */
    public Status withState(final String value) {
        setState(value);
        return this;
    }

    /**
     * Sets the value of the LastUpdateTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public Status withLastUpdateTimestamp(final XMLGregorianCalendar value) {
        setLastUpdateTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the ReasonCode property.
     *
     * @param value
     * @return
     *     this instance
     */
    public Status withReasonCode(final String value) {
        setReasonCode(value);
        return this;
    }

    /**
     * Sets the value of the ReasonDescription property.
     *
     * @param value
     * @return
     *     this instance
     */
    public Status withReasonDescription(final String value) {
        setReasonDescription(value);
        return this;
    }

    /**
     *
     * XML fragment representation of this object
     *
     * @return XML fragment for this object. Name for outer
     * tag expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    @Deprecated
    public String toXMLFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new XmlFragmentBuilder()).build();
    }

    /**
     *
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     *
     */
    @Deprecated
    public String toJSONFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new JSONFragmentBuilder()).build();
    }
}
