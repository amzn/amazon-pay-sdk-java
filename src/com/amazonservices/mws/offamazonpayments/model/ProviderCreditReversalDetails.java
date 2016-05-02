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
 * <p>Java class for ProviderCreditReversalDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditReversalDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonProviderCreditReversalId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="SellerId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="ProviderId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="CreditReversalReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="CreditReversalAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CreditReversalStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="CreditReversalNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalDetails", propOrder = {
    "amazonProviderCreditReversalId",
    "sellerId",
    "providerId",
    "creditReversalReferenceId",
    "creditReversalAmount",
    "creationTimestamp",
    "creditReversalStatus",
    "creditReversalNote"
})
public class ProviderCreditReversalDetails {

    @XmlElement(name = "AmazonProviderCreditReversalId", required = true)
    protected String amazonProviderCreditReversalId;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditReversalReferenceId", required = true)
    protected String creditReversalReferenceId;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CreditReversalStatus", required = true)
    protected Status creditReversalStatus;
    @XmlElement(name = "CreditReversalNote")
    protected String creditReversalNote;

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
    public ProviderCreditReversalDetails(final String amazonProviderCreditReversalId, final String sellerId, final String providerId, final String creditReversalReferenceId, final Price creditReversalAmount, final XMLGregorianCalendar creationTimestamp, final Status creditReversalStatus, final String creditReversalNote) {
        this.amazonProviderCreditReversalId = amazonProviderCreditReversalId;
        this.sellerId = sellerId;
        this.providerId = providerId;
        this.creditReversalReferenceId = creditReversalReferenceId;
        this.creditReversalAmount = creditReversalAmount;
        this.creationTimestamp = creationTimestamp;
        this.creditReversalStatus = creditReversalStatus;
        this.creditReversalNote = creditReversalNote;
    }

    /**
     * Gets the value of the amazonProviderCreditReversalId property.
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
     * Sets the value of the amazonProviderCreditReversalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonProviderCreditReversalId(String value) {
        this.amazonProviderCreditReversalId = value;
    }

    public boolean isSetAmazonProviderCreditReversalId() {
        return (this.amazonProviderCreditReversalId!= null);
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
     * Gets the value of the creditReversalReferenceId property.
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
     * Sets the value of the creditReversalReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReversalReferenceId(String value) {
        this.creditReversalReferenceId = value;
    }

    public boolean isSetCreditReversalReferenceId() {
        return (this.creditReversalReferenceId!= null);
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
     * Gets the value of the creditReversalStatus property.
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
     * Sets the value of the creditReversalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setCreditReversalStatus(Status value) {
        this.creditReversalStatus = value;
    }

    public boolean isSetCreditReversalStatus() {
        return (this.creditReversalStatus!= null);
    }

    /**
     * Gets the value of the creditReversalNote property.
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
     * Sets the value of the creditReversalNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReversalNote(String value) {
        this.creditReversalNote = value;
    }

    public boolean isSetCreditReversalNote() {
        return (this.creditReversalNote!= null);
    }

    /**
     * Sets the value of the AmazonProviderCreditReversalId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withAmazonProviderCreditReversalId(String value) {
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
    public ProviderCreditReversalDetails withSellerId(String value) {
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
    public ProviderCreditReversalDetails withProviderId(String value) {
        setProviderId(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalReferenceId(String value) {
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
    public ProviderCreditReversalDetails withCreditReversalAmount(Price value) {
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
    public ProviderCreditReversalDetails withCreationTimestamp(XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalStatus(Status value) {
        setCreditReversalStatus(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalDetails withCreditReversalNote(String value) {
        setCreditReversalNote(value);
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
