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
 * <p>Java class for RefundDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonRefundId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="SellerRefundNote" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundType" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}RefundType"/>
 *         &lt;element name="RefundAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="FeeRefunded" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RefundStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="SoftDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderCreditReversalSummaryList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditReversalSummaryList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundDetails", propOrder = {
    "amazonRefundId",
    "refundReferenceId",
    "sellerRefundNote",
    "refundType",
    "refundAmount",
    "feeRefunded",
    "creationTimestamp",
    "refundStatus",
    "softDescriptor",
    "providerCreditReversalSummaryList"
})
public class RefundDetails {

    @XmlElement(name = "AmazonRefundId", required = true)
    protected String amazonRefundId;
    @XmlElement(name = "RefundReferenceId", required = true)
    protected String refundReferenceId;
    @XmlElement(name = "SellerRefundNote", required = true)
    protected String sellerRefundNote;
    @XmlElement(name = "RefundType", required = true)
    protected RefundType refundType;
    @XmlElement(name = "RefundAmount", required = true)
    protected Price refundAmount;
    @XmlElement(name = "FeeRefunded", required = true)
    protected Price feeRefunded;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "RefundStatus", required = true)
    protected Status refundStatus;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditReversalSummaryList")
    protected ProviderCreditReversalSummaryList providerCreditReversalSummaryList;

    /**
     * Default constructor
     * 
     */
    public RefundDetails() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public RefundDetails(final String amazonRefundId, final String refundReferenceId, final String sellerRefundNote, final RefundType refundType, final Price refundAmount, final Price feeRefunded, final XMLGregorianCalendar creationTimestamp, final Status refundStatus, final String softDescriptor, final ProviderCreditReversalSummaryList providerCreditReversalSummaryList) {
        this.amazonRefundId = amazonRefundId;
        this.refundReferenceId = refundReferenceId;
        this.sellerRefundNote = sellerRefundNote;
        this.refundType = refundType;
        this.refundAmount = refundAmount;
        this.feeRefunded = feeRefunded;
        this.creationTimestamp = creationTimestamp;
        this.refundStatus = refundStatus;
        this.softDescriptor = softDescriptor;
        this.providerCreditReversalSummaryList = providerCreditReversalSummaryList;
    }

    /**
     * Gets the value of the amazonRefundId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonRefundId() {
        return amazonRefundId;
    }

    /**
     * Sets the value of the amazonRefundId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonRefundId(String value) {
        this.amazonRefundId = value;
    }

    public boolean isSetAmazonRefundId() {
        return (this.amazonRefundId!= null);
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
     * Gets the value of the refundType property.
     * 
     * @return
     *     possible object is
     *     {@link RefundType }
     *     
     */
    public RefundType getRefundType() {
        return refundType;
    }

    /**
     * Sets the value of the refundType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundType }
     *     
     */
    public void setRefundType(RefundType value) {
        this.refundType = value;
    }

    public boolean isSetRefundType() {
        return (this.refundType!= null);
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
     * Gets the value of the feeRefunded property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getFeeRefunded() {
        return feeRefunded;
    }

    /**
     * Sets the value of the feeRefunded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setFeeRefunded(Price value) {
        this.feeRefunded = value;
    }

    public boolean isSetFeeRefunded() {
        return (this.feeRefunded!= null);
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
     * Gets the value of the refundStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getRefundStatus() {
        return refundStatus;
    }

    /**
     * Sets the value of the refundStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setRefundStatus(Status value) {
        this.refundStatus = value;
    }

    public boolean isSetRefundStatus() {
        return (this.refundStatus!= null);
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
     * Gets the value of the providerCreditReversalSummaryList property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderCreditReversalSummaryList }
     *     
     */
    public ProviderCreditReversalSummaryList getProviderCreditReversalSummaryList() {
        return providerCreditReversalSummaryList;
    }

    /**
     * Sets the value of the providerCreditReversalSummaryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderCreditReversalSummaryList }
     *     
     */
    public void setProviderCreditReversalSummaryList(ProviderCreditReversalSummaryList value) {
        this.providerCreditReversalSummaryList = value;
    }

    public boolean isSetProviderCreditReversalSummaryList() {
        return (this.providerCreditReversalSummaryList!= null);
    }

    /**
     * Sets the value of the AmazonRefundId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withAmazonRefundId(String value) {
        setAmazonRefundId(value);
        return this;
    }

    /**
     * Sets the value of the RefundReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withRefundReferenceId(String value) {
        setRefundReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the SellerRefundNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withSellerRefundNote(String value) {
        setSellerRefundNote(value);
        return this;
    }

    /**
     * Sets the value of the RefundType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withRefundType(RefundType value) {
        setRefundType(value);
        return this;
    }

    /**
     * Sets the value of the RefundAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withRefundAmount(Price value) {
        setRefundAmount(value);
        return this;
    }

    /**
     * Sets the value of the FeeRefunded property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withFeeRefunded(Price value) {
        setFeeRefunded(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withCreationTimestamp(XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the RefundStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withRefundStatus(Status value) {
        setRefundStatus(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withSoftDescriptor(String value) {
        setSoftDescriptor(value);
        return this;
    }

    /**
     * Sets the value of the ProviderCreditReversalSummaryList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public RefundDetails withProviderCreditReversalSummaryList(ProviderCreditReversalSummaryList value) {
        setProviderCreditReversalSummaryList(value);
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
