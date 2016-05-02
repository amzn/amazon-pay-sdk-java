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
 *         &lt;element name="AmazonProviderCreditId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderSellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreditAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreditReversalAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreditReversalIdList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}IdList"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CreditStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
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
    "amazonProviderCreditId",
    "sellerId",
    "providerSellerId",
    "creditAmount",
    "creditReversalAmount",
    "creditReversalIdList",
    "creationTimestamp",
    "creditStatus"
})
public class ProviderCreditDetails {

    @XmlElement(name = "AmazonProviderCreditId", required = true)
    public String amazonProviderCreditId;
    @XmlElement(name = "SellerId", required = true)
    public String sellerId;
    @XmlElement(name = "ProviderSellerId", required = true)
    public String providerSellerId;
    @XmlElement(name = "CreditAmount", required = true)
    public Price creditAmount;
    @XmlElement(name = "CreditReversalAmount", required = true)
    public Price creditReversalAmount;
    @XmlElement(name = "CreditReversalIdList", required = true)
    public IdList creditReversalIdList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditStatus", required = true)
    public Status creditStatus;

    /**
     * Default constructor
     *
     */
    public ProviderCreditDetails() {
        super();
    }

    /**
     * Value constructor
     *
     */
    public ProviderCreditDetails(final String amazonProviderCreditId, final String sellerId, final String providerSellerId, final Price creditAmount, final Price creditReversalAmount, final IdList creditReversalIdList, final XMLGregorianCalendar creationTimestamp, final Status creditStatus) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.sellerId = sellerId;
        this.providerSellerId = providerSellerId;
        this.creditAmount = creditAmount;
        this.creditReversalAmount = creditReversalAmount;
        this.creditReversalIdList = creditReversalIdList;
        this.creationTimestamp = creationTimestamp;
        this.creditStatus = creditStatus;

    }

    /**
     * Gets the value of the amazonProviderCreditId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * Sets the value of the amazonProviderCreditId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmazonProviderCreditId(final String value) {
        this.amazonProviderCreditId = value;
    }

    public boolean isSetAmazonProviderCreditId() {
        return (this.amazonProviderCreditId != null);
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
     * Gets the value of the CreditAmount property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getCreditAmount() {
        return creditAmount;
    }

    /**
     * Sets the value of the CreditAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setCreditAmount(final Price value) {
        this.creditAmount = value;
    }

    public boolean isSetCreditAmount() {
        return (this.creditAmount != null);
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
     * Gets the value of the CreditReversalIdList property.
     *
     * @return
     *     possible object is
     *     {@link IdList }
     *
     */
    public IdList getCreditReversalIdList() {
        return creditReversalIdList;
    }

    /**
     * Sets the value of the CreditReversalIdList property.
     *
     * @param value
     *     allowed object is
     *     {@link IdList }
     *
     */
    public void setCreditReversalIdList(final IdList value) {
        this.creditReversalIdList = value;
    }

    public boolean isSetCreditReversalIdList() {
        return (this.creditReversalIdList != null);
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
     * Gets the value of the CreditStatus property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getCreditStatus() {
        return creditStatus;
    }

    /**
     * Sets the value of the CreditStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setCreditStatus(final Status value) {
        this.creditStatus = value;
    }

    public boolean isSetCreditStatus() {
        return (this.creditStatus != null);
    }

    /**
     * Sets the value of the AmazonProviderCreditId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withAmazonProviderCreditId(final String value) {
        setAmazonProviderCreditId(value);
        return this;
    }

    /**
     * Sets the value of the SellerId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withSellerId(final String value) {
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
    public ProviderCreditDetails withProviderSellerId(final String value) {
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
    public ProviderCreditDetails withCreditAmount(final Price value) {
        setCreditAmount(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreditReversalAmount(final Price value) {
        setCreditReversalAmount(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalIdList property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreditReversalIdList(final IdList value) {
        setCreditReversalIdList(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the CreditStatus property.
     *
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreditStatus(final Status value) {
        setCreditStatus(value);
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
