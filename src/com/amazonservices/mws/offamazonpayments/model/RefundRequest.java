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
 *         &lt;element name="AmazonCaptureId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="RefundAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="SellerRefundNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String255" minOccurs="0"/>
 *         &lt;element name="SoftDescriptor" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String16" minOccurs="0"/>
 *         &lt;element name="ProviderCreditReversalList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditReversalList" minOccurs="0"/>
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
    "amazonCaptureId",
    "refundReferenceId",
    "refundAmount",
    "sellerRefundNote",
    "softDescriptor",
    "providerCreditReversalList"
})
@XmlRootElement(name = "RefundRequest")
public class RefundRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name="MWSAuthToken")
    protected String MWSAuthToken;
    @XmlElement(name = "AmazonCaptureId", required = true)
    protected String amazonCaptureId;
    @XmlElement(name = "RefundReferenceId", required = true)
    protected String refundReferenceId;
    @XmlElement(name = "RefundAmount", required = true)
    protected Price refundAmount;
    @XmlElement(name = "SellerRefundNote")
    protected String sellerRefundNote;
    @XmlElement(name = "SoftDescriptor")
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditReversalList")
    protected ProviderCreditReversalList providerCreditReversalList;

    /**
     * Default constructor
     * 
     */
    public RefundRequest() {
        super();
    }

    /**
     * Value constructor without MWSAuthToken param, for non-delegated requests
     *
     */
    public RefundRequest(final String sellerId, final String amazonCaptureId, final String refundReferenceId, final Price refundAmount, final String sellerRefundNote, final String softDescriptor, final ProviderCreditReversalList providerCreditReversalList) {
        this(sellerId, amazonCaptureId, refundReferenceId, refundAmount, sellerRefundNote, softDescriptor, providerCreditReversalList, ModelConstants.EMPTY_MWS_AUTH_TOKEN);
    }

    /**
     * Value constructor
     *
     */
    public RefundRequest(final String sellerId, final String amazonCaptureId, final String refundReferenceId, final Price refundAmount, final String sellerRefundNote, final String softDescriptor, final ProviderCreditReversalList providerCreditReversalList, final String MWSAuthToken) {
        this.sellerId = sellerId;
        this.MWSAuthToken = MWSAuthToken;
        this.amazonCaptureId = amazonCaptureId;
        this.refundReferenceId = refundReferenceId;
        this.refundAmount = refundAmount;
        this.sellerRefundNote = sellerRefundNote;
        this.softDescriptor = softDescriptor;
        this.providerCreditReversalList = providerCreditReversalList;
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
     * Gets the value of the amazonCaptureId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonCaptureId() {
        return amazonCaptureId;
    }

    /**
     * Sets the value of the amazonCaptureId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonCaptureId(String value) {
        this.amazonCaptureId = value;
    }

    public boolean isSetAmazonCaptureId() {
        return (this.amazonCaptureId!= null);
    }

    /**
     * Gets the value of the refundReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundReferenceId() {
        return refundReferenceId;
    }

    /**
     * Sets the value of the refundReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundReferenceId(String value) {
        this.refundReferenceId = value;
    }

    public boolean isSetRefundReferenceId() {
        return (this.refundReferenceId!= null);
    }

    /**
     * Gets the value of the refundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setRefundAmount(Price value) {
        this.refundAmount = value;
    }

    public boolean isSetRefundAmount() {
        return (this.refundAmount!= null);
    }

    /**
     * Gets the value of the sellerRefundNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerRefundNote() {
        return sellerRefundNote;
    }

    /**
     * Sets the value of the sellerRefundNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerRefundNote(String value) {
        this.sellerRefundNote = value;
    }

    public boolean isSetSellerRefundNote() {
        return (this.sellerRefundNote!= null);
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
     * Gets the value of the providerCreditReversalList property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderCreditReversalList }
     *     
     */
    public ProviderCreditReversalList getProviderCreditReversalList() {
        return providerCreditReversalList;
    }

    /**
     * Sets the value of the providerCreditReversalList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderCreditReversalList }
     *     
     */
    public void setProviderCreditReversalList(ProviderCreditReversalList value) {
        this.providerCreditReversalList = value;
    }

    public boolean isSetProviderCreditReversalList() {
        return (this.providerCreditReversalList!= null);
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the AmazonCaptureId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withAmazonCaptureId(String value) {
        setAmazonCaptureId(value);
        return this;
    }

    /**
     * Sets the value of the RefundReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withRefundReferenceId(String value) {
        setRefundReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the RefundAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withRefundAmount(Price value) {
        setRefundAmount(value);
        return this;
    }

    /**
     * Sets the value of the SellerRefundNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withSellerRefundNote(String value) {
        setSellerRefundNote(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withSoftDescriptor(String value) {
        setSoftDescriptor(value);
        return this;
    }

    /**
     * Sets the value of the ProviderCreditReversalList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundRequest withProviderCreditReversalList(ProviderCreditReversalList value) {
        setProviderCreditReversalList(value);
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
