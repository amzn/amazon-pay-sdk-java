/*******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

package com.amazonservices.mws.offamazonpayments.model;

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
 * <p>Java class for BillingAgreementLimits complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingAgreementLimits">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmountLimitPerTimePeriod" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price" minOccurs="0"/>
 *         &lt;element name="TimePeriodStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="TimePeriodEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="CurrentRemainingBalance" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementLimits", propOrder = {
    "amountLimitPerTimePeriod",
    "timePeriodStartDate",
    "timePeriodEndDate",
    "currentRemainingBalance"
})
public class BillingAgreementLimits {

    @XmlElement(name = "AmountLimitPerTimePeriod")
    protected Price amountLimitPerTimePeriod;
    @XmlElement(name = "TimePeriodStartDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timePeriodStartDate;
    @XmlElement(name = "TimePeriodEndDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timePeriodEndDate;
    @XmlElement(name = "CurrentRemainingBalance")
    protected Price currentRemainingBalance;

    /**
     * Default constructor
     * 
     */
    public BillingAgreementLimits() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public BillingAgreementLimits(final Price amountLimitPerTimePeriod, final XMLGregorianCalendar timePeriodStartDate, final XMLGregorianCalendar timePeriodEndDate, final Price currentRemainingBalance) {
        this.amountLimitPerTimePeriod = amountLimitPerTimePeriod;
        this.timePeriodStartDate = timePeriodStartDate;
        this.timePeriodEndDate = timePeriodEndDate;
        this.currentRemainingBalance = currentRemainingBalance;
    }

    /**
     * Gets the value of the amountLimitPerTimePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getAmountLimitPerTimePeriod() {
        return amountLimitPerTimePeriod;
    }

    /**
     * Sets the value of the amountLimitPerTimePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setAmountLimitPerTimePeriod(Price value) {
        this.amountLimitPerTimePeriod = value;
    }

    public boolean isSetAmountLimitPerTimePeriod() {
        return (this.amountLimitPerTimePeriod!= null);
    }

    /**
     * Gets the value of the timePeriodStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimePeriodStartDate() {
        return timePeriodStartDate;
    }

    /**
     * Sets the value of the timePeriodStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimePeriodStartDate(XMLGregorianCalendar value) {
        this.timePeriodStartDate = value;
    }

    public boolean isSetTimePeriodStartDate() {
        return (this.timePeriodStartDate!= null);
    }

    /**
     * Gets the value of the timePeriodEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimePeriodEndDate() {
        return timePeriodEndDate;
    }

    /**
     * Sets the value of the timePeriodEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimePeriodEndDate(XMLGregorianCalendar value) {
        this.timePeriodEndDate = value;
    }

    public boolean isSetTimePeriodEndDate() {
        return (this.timePeriodEndDate!= null);
    }

    /**
     * Gets the value of the currentRemainingBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getCurrentRemainingBalance() {
        return currentRemainingBalance;
    }

    /**
     * Sets the value of the currentRemainingBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setCurrentRemainingBalance(Price value) {
        this.currentRemainingBalance = value;
    }

    public boolean isSetCurrentRemainingBalance() {
        return (this.currentRemainingBalance!= null);
    }

    /**
     * Sets the value of the AmountLimitPerTimePeriod property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementLimits withAmountLimitPerTimePeriod(Price value) {
        setAmountLimitPerTimePeriod(value);
        return this;
    }

    /**
     * Sets the value of the TimePeriodStartDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementLimits withTimePeriodStartDate(XMLGregorianCalendar value) {
        setTimePeriodStartDate(value);
        return this;
    }

    /**
     * Sets the value of the TimePeriodEndDate property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementLimits withTimePeriodEndDate(XMLGregorianCalendar value) {
        setTimePeriodEndDate(value);
        return this;
    }

    /**
     * Sets the value of the CurrentRemainingBalance property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementLimits withCurrentRemainingBalance(Price value) {
        setCurrentRemainingBalance(value);
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
