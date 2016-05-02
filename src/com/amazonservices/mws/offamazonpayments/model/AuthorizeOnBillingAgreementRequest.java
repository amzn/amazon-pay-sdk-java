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
import com.amazonservices.mws.offamazonpayments.common.ModelConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="MWSAuthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmazonBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorizationReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="AuthorizationAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="SellerAuthorizationNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String255" minOccurs="0"/>
 *         &lt;element name="TransactionTimeout" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="CaptureNow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SoftDescriptor" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String16" minOccurs="0"/>
 *         &lt;element name="SellerNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String1024" minOccurs="0"/>
 *         &lt;element name="PlatformId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SellerOrderAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerOrderAttributes" minOccurs="0"/>
 *         &lt;element name="InheritShippingAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sellerId",
    "MWSAuthToken",
    "amazonBillingAgreementId",
    "authorizationReferenceId",
    "authorizationAmount",
    "sellerAuthorizationNote",
    "transactionTimeout",
    "captureNow",
    "softDescriptor",
    "sellerNote",
    "platformId",
    "sellerOrderAttributes",
    "inheritShippingAddress"
})
@XmlRootElement(name = "AuthorizeOnBillingAgreementRequest")
public class AuthorizeOnBillingAgreementRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name="MWSAuthToken")
    protected String MWSAuthToken;
    @XmlElement(name = "AmazonBillingAgreementId", required = true)
    protected String amazonBillingAgreementId;
    @XmlElement(name = "AuthorizationReferenceId", required = true)
    protected String authorizationReferenceId;
    @XmlElement(name = "AuthorizationAmount", required = true)
    protected Price authorizationAmount;
    @XmlElement(name = "SellerAuthorizationNote")
    protected String sellerAuthorizationNote;
    @XmlElement(name = "TransactionTimeout")
    protected Integer transactionTimeout;
    @XmlElement(name = "CaptureNow")
    protected Boolean captureNow;
    @XmlElement(name = "SoftDescriptor")
    protected String softDescriptor;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "PlatformId")
    protected String platformId;
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;
    @XmlElement(name = "InheritShippingAddress")
    protected Boolean inheritShippingAddress;

    /**
     * Default constructor
     * 
     */
    public AuthorizeOnBillingAgreementRequest() {
        super();
    }

    /**
     * Value constructor without MWSAuthToken param, for non-delegated requests
     * 
     */
    public AuthorizeOnBillingAgreementRequest(final String sellerId, final String amazonBillingAgreementId, final String authorizationReferenceId, final Price authorizationAmount, final String sellerAuthorizationNote, final Integer transactionTimeout, final Boolean captureNow, final String softDescriptor, final String sellerNote, final String platformId, final SellerOrderAttributes sellerOrderAttributes, final Boolean inheritShippingAddress) {
        this(sellerId, amazonBillingAgreementId, authorizationReferenceId, authorizationAmount, sellerAuthorizationNote, transactionTimeout, captureNow, softDescriptor, sellerNote, platformId, sellerOrderAttributes, inheritShippingAddress, ModelConstants.EMPTY_MWS_AUTH_TOKEN);
    }

    /**
     * Value constructor
     *
     */
    public AuthorizeOnBillingAgreementRequest(final String sellerId, final String amazonBillingAgreementId, final String authorizationReferenceId, final Price authorizationAmount, final String sellerAuthorizationNote, final Integer transactionTimeout, final Boolean captureNow, final String softDescriptor, final String sellerNote, final String platformId, final SellerOrderAttributes sellerOrderAttributes, final Boolean inheritShippingAddress, final String MWSAuthToken) {
        this.sellerId = sellerId;
        this.MWSAuthToken = MWSAuthToken;
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
        this.sellerAuthorizationNote = sellerAuthorizationNote;
        this.transactionTimeout = transactionTimeout;
        this.captureNow = captureNow;
        this.softDescriptor = softDescriptor;
        this.sellerNote = sellerNote;
        this.platformId = platformId;
        this.sellerOrderAttributes = sellerOrderAttributes;
        this.inheritShippingAddress = inheritShippingAddress;
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
     * Get the value of MWSAuthToken.
     *
     * @return The value of MWSAuthToken.
     */
    public String getMWSAuthToken() {
        return MWSAuthToken;
    }

    /**
     * Set the value of MWSAuthToken.
     *
     * @param MWSAuthToken
     *            The new value to set.
     */
    public void setMWSAuthToken(String MWSAuthToken) {
        this.MWSAuthToken = MWSAuthToken;
    }

    /**
     * Check to see if MWSAuthToken is set.
     *
     * @return true if MWSAuthToken is set.
     */
    public boolean isSetMWSAuthToken() {
        return MWSAuthToken != null;
    }

    /**
     * Gets the value of the amazonBillingAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     * Sets the value of the amazonBillingAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonBillingAgreementId(String value) {
        this.amazonBillingAgreementId = value;
    }

    public boolean isSetAmazonBillingAgreementId() {
        return (this.amazonBillingAgreementId!= null);
    }

    /**
     * Gets the value of the authorizationReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    /**
     * Sets the value of the authorizationReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationReferenceId(String value) {
        this.authorizationReferenceId = value;
    }

    public boolean isSetAuthorizationReferenceId() {
        return (this.authorizationReferenceId!= null);
    }

    /**
     * Gets the value of the authorizationAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * Sets the value of the authorizationAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setAuthorizationAmount(Price value) {
        this.authorizationAmount = value;
    }

    public boolean isSetAuthorizationAmount() {
        return (this.authorizationAmount!= null);
    }

    /**
     * Gets the value of the sellerAuthorizationNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerAuthorizationNote() {
        return sellerAuthorizationNote;
    }

    /**
     * Sets the value of the sellerAuthorizationNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerAuthorizationNote(String value) {
        this.sellerAuthorizationNote = value;
    }

    public boolean isSetSellerAuthorizationNote() {
        return (this.sellerAuthorizationNote!= null);
    }

    /**
     * Gets the value of the transactionTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransactionTimeout() {
        return transactionTimeout;
    }

    /**
     * Sets the value of the transactionTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransactionTimeout(Integer value) {
        this.transactionTimeout = value;
    }

    public boolean isSetTransactionTimeout() {
        return (this.transactionTimeout!= null);
    }

    /**
     * Gets the value of the captureNow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCaptureNow() {
        return captureNow;
    }

    /**
     * Sets the value of the captureNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCaptureNow(Boolean value) {
        this.captureNow = value;
    }

    public boolean isSetCaptureNow() {
        return (this.captureNow!= null);
    }

    /**
     * Gets the value of the softDescriptor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * Sets the value of the softDescriptor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoftDescriptor(String value) {
        this.softDescriptor = value;
    }

    public boolean isSetSoftDescriptor() {
        return (this.softDescriptor!= null);
    }

    /**
     * Gets the value of the sellerNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Sets the value of the sellerNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerNote(String value) {
        this.sellerNote = value;
    }

    public boolean isSetSellerNote() {
        return (this.sellerNote!= null);
    }

    /**
     * Gets the value of the platformId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Sets the value of the platformId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformId(String value) {
        this.platformId = value;
    }

    public boolean isSetPlatformId() {
        return (this.platformId!= null);
    }

    /**
     * Gets the value of the sellerOrderAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link SellerOrderAttributes }
     *     
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    /**
     * Sets the value of the sellerOrderAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerOrderAttributes }
     *     
     */
    public void setSellerOrderAttributes(SellerOrderAttributes value) {
        this.sellerOrderAttributes = value;
    }

    public boolean isSetSellerOrderAttributes() {
        return (this.sellerOrderAttributes!= null);
    }

    /**
     * Gets the value of the inheritShippingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     * Sets the value of the inheritShippingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInheritShippingAddress(Boolean value) {
        this.inheritShippingAddress = value;
    }

    public boolean isSetInheritShippingAddress() {
        return (this.inheritShippingAddress!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the AmazonBillingAgreementId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withAmazonBillingAgreementId(String value) {
        setAmazonBillingAgreementId(value);
        return this;
    }

    /**
     * Sets the value of the AuthorizationReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withAuthorizationReferenceId(String value) {
        setAuthorizationReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the AuthorizationAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withAuthorizationAmount(Price value) {
        setAuthorizationAmount(value);
        return this;
    }

    /**
     * Sets the value of the SellerAuthorizationNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withSellerAuthorizationNote(String value) {
        setSellerAuthorizationNote(value);
        return this;
    }

    /**
     * Sets the value of the TransactionTimeout property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withTransactionTimeout(Integer value) {
        setTransactionTimeout(value);
        return this;
    }

    /**
     * Sets the value of the CaptureNow property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withCaptureNow(Boolean value) {
        setCaptureNow(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withSoftDescriptor(String value) {
        setSoftDescriptor(value);
        return this;
    }

    /**
     * Sets the value of the SellerNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withSellerNote(String value) {
        setSellerNote(value);
        return this;
    }

    /**
     * Sets the value of the PlatformId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withPlatformId(String value) {
        setPlatformId(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withSellerOrderAttributes(SellerOrderAttributes value) {
        setSellerOrderAttributes(value);
        return this;
    }

    /**
     * Sets the value of the InheritShippingAddress property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizeOnBillingAgreementRequest withInheritShippingAddress(Boolean value) {
        setInheritShippingAddress(value);
        return this;
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
