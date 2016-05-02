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
 * <p>Java class for ProviderCreditDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ProviderCreditDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonProviderCreditReversalId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderSellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreditReversalReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreditReversalAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CreditReversalNote" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreditReversalStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditDetails", propOrder = {
    "amazonProviderCreditReversalId",
    "sellerId",
    "providerSellerId",
    "creditReversalReferenceId",
    "creditReversalAmount",
    "creationTimestamp",
    "creditReversalNote",
    "creditReversalStatus"
})
public class ProviderCreditReversalDetails {

    @XmlElement(name = "AmazonProviderCreditReversalId", required = true)
    public String amazonProviderCreditReversalId;
    @XmlElement(name = "SellerId", required = true)
    public String sellerId;
    @XmlElement(name = "ProviderSellerId", required = true)
    public String providerSellerId;
    @XmlElement(name = "CreditReversalReferenceId", required = true)
    public String creditReversalReferenceId;
    @XmlElement(name = "CreditReversalAmount", required = true)
    public Price creditReversalAmount;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditReversalNote", required = true)
    public String creditReversalNote;
    @XmlElement(name = "CreditReversalStatus", required = true)
    public Status creditReversalStatus;

    /**
     * Default constructor
     *
     */
    public ProviderCreditReversalDetails() {
        super();
    }

    /**
     * Value constructor
     *
     */
    public ProviderCreditReversalDetails(final String amazonProviderCreditReversalId, final String sellerId, final String providerSellerId, final String creditReversalReferenceId, final Price creditReversalAmount, final XMLGregorianCalendar creationTimestamp, final String creditReversalNote, final Status creditReversalStatus) {
        this.amazonProviderCreditReversalId = amazonProviderCreditReversalId;
        this.sellerId = sellerId;
        this.providerSellerId = providerSellerId;
        this.creditReversalReferenceId = creditReversalReferenceId;
        this.creditReversalAmount = creditReversalAmount;
        this.creationTimestamp = creationTimestamp;
        this.creditReversalNote = creditReversalNote;
        this.creditReversalStatus = creditReversalStatus;

    }

    /**
     * Gets the value of the AmazonProviderCreditReversalId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmazonProviderCreditReversalId() {
        return amazonProviderCreditReversalId;
    }

    /**
     * Sets the value of the AmazonProviderCreditReversalId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmazonProviderCreditReversalId(final String value) {
        this.amazonProviderCreditReversalId = value;
    }

    public boolean isSetAmazonProviderCreditReversalId() {
        return (this.amazonProviderCreditReversalId != null);
    }

    /**
     * Gets the value of the SellerId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Sets the value of the SellerId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSellerId(final String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId != null);
    }

    /**
     * Gets the value of the ProviderSellerId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProviderSellerId() {
        return providerSellerId;
    }

    /**
     * Sets the value of the ProviderSellerId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProviderSellerId(final String value) {
        this.providerSellerId = value;
    }

    public boolean isSetProviderSellerId() {
        return (this.providerSellerId != null);
    }

    /**
     * Gets the value of the CreditReversalReferenceId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreditReversalReferenceId() {
        return creditReversalReferenceId;
    }

    /**
     * Sets the value of the CreditReversalReferenceId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreditReversalReferenceId(final String value) {
        this.creditReversalReferenceId = value;
    }

    public boolean isSetCreditReversalReferenceId() {
        return (this.creditReversalReferenceId != null);
    }

    /**
     * Gets the value of the CreditReversalAmount property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    /**
     * Sets the value of the CreditReversalAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setCreditReversalAmount(final Price value) {
        this.creditReversalAmount = value;
    }

    public boolean isSetCreditReversalAmount() {
        return (this.creditReversalAmount != null);
    }

    /**
     * Gets the value of the creationTimestamp property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Sets the value of the creationTimestamp property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setCreationTimestamp(final XMLGregorianCalendar value) {
        this.creationTimestamp = value;
    }

    public boolean isSetCreationTimestamp() {
        return (this.creationTimestamp != null);
    }

    /**
     * Gets the value of the CreditReversalNote property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreditReversalNote() {
        return creditReversalNote;
    }

    /**
     * Sets the value of the CreditReversalNote property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreditReversalNote(final String value) {
        this.creditReversalNote= value;
    }

    public boolean isSetCreditReversalNote() {
        return (this.creditReversalNote != null);
    }

    /**
     * Gets the value of the CreditReversalStatus property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getCreditReversalStatus() {
        return creditReversalStatus;
    }

    /**
     * Sets the value of the CreditReversalStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setCreditReversalStatus(final Status value) {
        this.creditReversalStatus = value;
    }

    public boolean isSetCreditReversalStatus() {
        return (this.creditReversalStatus != null);
    }

    /**
     * Sets the value of the AmazonProviderCreditReversalId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withAmazonProviderCreditReversalId(final String value) {
        setAmazonProviderCreditReversalId(value);
        return this;
    }

    /**
     * Sets the value of the SellerId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withSellerId(final String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the ProviderSellerId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withProviderSellerId(final String value) {
        setProviderSellerId(value);
        return this;
    }

    /**
     * Sets the value of the CreditAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalReferenceId(final String value) {
        setCreditReversalReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalAmount(final Price value) {
        setCreditReversalAmount(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }
    
    /**
     * Sets the value of the CreditReversalNote property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalNote(final String value) {
        setCreditReversalNote(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalStatus property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalStatus(final Status value) {
        setCreditReversalStatus(value);
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
