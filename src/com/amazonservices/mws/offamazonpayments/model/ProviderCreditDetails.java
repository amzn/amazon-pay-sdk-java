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
 * <p>Java class for ProviderCreditDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonProviderCreditId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="SellerId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="ProviderId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="CreditReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
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
    "providerId",
    "creditReferenceId",
    "creditAmount",
    "creditReversalAmount",
    "creditReversalIdList",
    "creationTimestamp",
    "creditStatus"
})
public class ProviderCreditDetails {

    @XmlElement(name = "AmazonProviderCreditId", required = true)
    protected String amazonProviderCreditId;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditReferenceId", required = true)
    protected String creditReferenceId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreditReversalIdList", required = true)
    protected IdList creditReversalIdList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditStatus", required = true)
    protected Status creditStatus;

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
    public ProviderCreditDetails(final String amazonProviderCreditId, final String sellerId, final String providerId, final String creditReferenceId, final Price creditAmount, final Price creditReversalAmount, final IdList creditReversalIdList, final XMLGregorianCalendar creationTimestamp, final Status creditStatus) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.sellerId = sellerId;
        this.providerId = providerId;
        this.creditReferenceId = creditReferenceId;
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
    public void setAmazonProviderCreditId(String value) {
        this.amazonProviderCreditId = value;
    }

    public boolean isSetAmazonProviderCreditId() {
        return (this.amazonProviderCreditId!= null);
    }

    /**
     * Gets the value of the sellerId property.
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
     * Sets the value of the sellerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerId(String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId!= null);
    }

    /**
     * Gets the value of the providerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * Sets the value of the providerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderId(String value) {
        this.providerId = value;
    }

    public boolean isSetProviderId() {
        return (this.providerId!= null);
    }

    /**
     * Gets the value of the creditReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditReferenceId() {
        return creditReferenceId;
    }

    /**
     * Sets the value of the creditReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReferenceId(String value) {
        this.creditReferenceId = value;
    }

    public boolean isSetCreditReferenceId() {
        return (this.creditReferenceId!= null);
    }

    /**
     * Gets the value of the creditAmount property.
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
     * Sets the value of the creditAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setCreditAmount(Price value) {
        this.creditAmount = value;
    }

    public boolean isSetCreditAmount() {
        return (this.creditAmount!= null);
    }

    /**
     * Gets the value of the creditReversalAmount property.
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
     * Sets the value of the creditReversalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setCreditReversalAmount(Price value) {
        this.creditReversalAmount = value;
    }

    public boolean isSetCreditReversalAmount() {
        return (this.creditReversalAmount!= null);
    }

    /**
     * Gets the value of the creditReversalIdList property.
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
     * Sets the value of the creditReversalIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdList }
     *     
     */
    public void setCreditReversalIdList(IdList value) {
        this.creditReversalIdList = value;
    }

    public boolean isSetCreditReversalIdList() {
        return (this.creditReversalIdList!= null);
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
    public void setCreationTimestamp(XMLGregorianCalendar value) {
        this.creationTimestamp = value;
    }

    public boolean isSetCreationTimestamp() {
        return (this.creationTimestamp!= null);
    }

    /**
     * Gets the value of the creditStatus property.
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
     * Sets the value of the creditStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setCreditStatus(Status value) {
        this.creditStatus = value;
    }

    public boolean isSetCreditStatus() {
        return (this.creditStatus!= null);
    }

    /**
     * Sets the value of the AmazonProviderCreditId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withAmazonProviderCreditId(String value) {
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
    public ProviderCreditDetails withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the ProviderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withProviderId(String value) {
        setProviderId(value);
        return this;
    }

    /**
     * Sets the value of the CreditReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreditReferenceId(String value) {
        setCreditReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the CreditAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditDetails withCreditAmount(Price value) {
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
    public ProviderCreditDetails withCreditReversalAmount(Price value) {
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
    public ProviderCreditDetails withCreditReversalIdList(IdList value) {
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
    public ProviderCreditDetails withCreationTimestamp(XMLGregorianCalendar value) {
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
    public ProviderCreditDetails withCreditStatus(Status value) {
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
