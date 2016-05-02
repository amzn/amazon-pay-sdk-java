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
 *         &lt;element name="AmazonAuthorizationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CaptureReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="CaptureAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="SellerCaptureNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String255" minOccurs="0"/>
 *         &lt;element name="SoftDescriptor" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String16" minOccurs="0"/>
 *         &lt;element name="ProviderCreditList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditList" minOccurs="0"/>
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
    "amazonAuthorizationId",
    "captureReferenceId",
    "captureAmount",
    "sellerCaptureNote",
    "softDescriptor",
    "providerCreditList"
})
@XmlRootElement(name = "CaptureRequest")
public class CaptureRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name="MWSAuthToken")
    protected String MWSAuthToken;
    @XmlElement(name = "AmazonAuthorizationId", required = true)
    protected String amazonAuthorizationId;
    @XmlElement(name = "CaptureReferenceId", required = true)
    protected String captureReferenceId;
    @XmlElement(name = "CaptureAmount", required = true)
    protected Price captureAmount;
    @XmlElement(name = "SellerCaptureNote")
    protected String sellerCaptureNote;
    @XmlElement(name = "SoftDescriptor")
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditList")
    protected ProviderCreditList providerCreditList;

    /**
     * Default constructor
     *
     */
    public CaptureRequest() {
        super();
    }

    /**
     * Value constructor without MWSAuthToken param, for non-delegated requests
     *
     */
    public CaptureRequest(final String sellerId, final String amazonAuthorizationId, final String captureReferenceId, final Price captureAmount, final String sellerCaptureNote, final String softDescriptor, final ProviderCreditList providerCreditList) {
        this(sellerId, ModelConstants.EMPTY_MWS_AUTH_TOKEN, amazonAuthorizationId, captureReferenceId, captureAmount, sellerCaptureNote, softDescriptor, providerCreditList);
    }

    /**
     * Value constructor
     *
     */
    public CaptureRequest(final String sellerId, final String MWSAuthToken, final String amazonAuthorizationId, final String captureReferenceId, final Price captureAmount, final String sellerCaptureNote, final String softDescriptor, final ProviderCreditList providerCreditList) {
        this.sellerId = sellerId;
        this.MWSAuthToken = MWSAuthToken;
        this.amazonAuthorizationId = amazonAuthorizationId;
        this.captureReferenceId = captureReferenceId;
        this.captureAmount = captureAmount;
        this.sellerCaptureNote = sellerCaptureNote;
        this.softDescriptor = softDescriptor;
        this.providerCreditList = providerCreditList;
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
     * Gets the value of the amazonAuthorizationId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
     * Sets the value of the amazonAuthorizationId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmazonAuthorizationId(String value) {
        this.amazonAuthorizationId = value;
    }

    public boolean isSetAmazonAuthorizationId() {
        return (this.amazonAuthorizationId!= null);
    }

    /**
     * Gets the value of the captureReferenceId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCaptureReferenceId() {
        return captureReferenceId;
    }

    /**
     * Sets the value of the captureReferenceId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCaptureReferenceId(String value) {
        this.captureReferenceId = value;
    }

    public boolean isSetCaptureReferenceId() {
        return (this.captureReferenceId!= null);
    }

    /**
     * Gets the value of the captureAmount property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getCaptureAmount() {
        return captureAmount;
    }

    /**
     * Sets the value of the captureAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setCaptureAmount(Price value) {
        this.captureAmount = value;
    }

    public boolean isSetCaptureAmount() {
        return (this.captureAmount!= null);
    }

    /**
     * Gets the value of the sellerCaptureNote property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSellerCaptureNote() {
        return sellerCaptureNote;
    }

    /**
     * Sets the value of the sellerCaptureNote property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSellerCaptureNote(String value) {
        this.sellerCaptureNote = value;
    }

    public boolean isSetSellerCaptureNote() {
        return (this.sellerCaptureNote!= null);
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
     * Gets the value of the providerCreditList property.
     *
     * @return
     *     possible object is
     *     {@link ProviderCreditList }
     *
     */
    public ProviderCreditList getProviderCreditList() {
        return providerCreditList;
    }

    /**
     * Sets the value of the providerCreditList property.
     *
     * @param value
     *     allowed object is
     *     {@link ProviderCreditList }
     *
     */
    public void setProviderCreditList(ProviderCreditList value) {
        this.providerCreditList = value;
    }

    public boolean isSetProviderCreditList() {
        return (this.providerCreditList!= null);
    }

    /**
     * Sets the value of the SellerId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the AmazonAuthorizationId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withAmazonAuthorizationId(String value) {
        setAmazonAuthorizationId(value);
        return this;
    }

    /**
     * Sets the value of the CaptureReferenceId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withCaptureReferenceId(String value) {
        setCaptureReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the CaptureAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withCaptureAmount(Price value) {
        setCaptureAmount(value);
        return this;
    }

    /**
     * Sets the value of the SellerCaptureNote property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withSellerCaptureNote(String value) {
        setSellerCaptureNote(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withSoftDescriptor(String value) {
        setSoftDescriptor(value);
        return this;
    }

    /**
     * Sets the value of the ProviderCreditList property.
     *
     * @param value
     * @return
     *     this instance
     */
    public CaptureRequest withProviderCreditList(ProviderCreditList value) {
        setProviderCreditList(value);
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
