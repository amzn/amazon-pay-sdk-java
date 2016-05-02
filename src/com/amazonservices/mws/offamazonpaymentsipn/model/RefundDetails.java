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
 * <p>
 * Java class for RefundDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonRefundId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="RefundType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RefundAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="FeeRefunded" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="RefundStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="SoftDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderCreditReversalSummaryList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditReversalSummaryList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundDetails", propOrder = { "amazonRefundId", "refundReferenceId", "refundType", "refundAmount",
        "feeRefunded", "creationTimestamp", "refundStatus", "softDescriptor", "providerCreditReversalSummaryList" })
public class RefundDetails {

    @XmlElement(name = "AmazonRefundId", required = true)
    protected String amazonRefundId;
    @XmlElement(name = "RefundReferenceId", required = true)
    protected String refundReferenceId;
    @XmlElement(name = "RefundType", required = true)
    protected String refundType;
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
    @XmlElement(name = "ProviderCreditReversalSummaryList", required = true)
    public ProviderCreditReversalSummaryList providerCreditReversalSummaryList;

    public RefundDetails() {
        super();
    }

    public RefundDetails(final String amazonRefundId, final String refundReferenceId, final String sellerRefundNote,
                         final String refundType, final Price refundAmount, final Price feeRefunded,
                         final XMLGregorianCalendar creationTimestamp, final Status refundStatus, final String softDescriptor,
                         final ProviderCreditReversalSummaryList providerCreditReversalSummaryList) {
        this.amazonRefundId = amazonRefundId;
        this.refundReferenceId = refundReferenceId;
        this.refundType = refundType;
        this.refundAmount = refundAmount;
        this.feeRefunded = feeRefunded;
        this.creationTimestamp = creationTimestamp;
        this.refundStatus = refundStatus;
        this.softDescriptor = softDescriptor;
        this.providerCreditReversalSummaryList = providerCreditReversalSummaryList;
    }

    public String getAmazonRefundId() {
        return amazonRefundId;
    }

    public void setAmazonRefundId(final String value) {
        this.amazonRefundId = value;
    }

    public boolean isSetAmazonRefundId() {
        return (this.amazonRefundId != null);
    }

    public String getRefundReferenceId() {
        return refundReferenceId;
    }

    public void setRefundReferenceId(final String value) {
        this.refundReferenceId = value;
    }

    public boolean isSetRefundReferenceId() {
        return (this.refundReferenceId != null);
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(final String value) {
        this.refundType = value;
    }

    public boolean isSetRefundType() {
        return (this.refundType != null);
    }

    public Price getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(final Price value) {
        this.refundAmount = value;
    }

    public boolean isSetRefundAmount() {
        return (this.refundAmount != null);
    }

    public Price getFeeRefunded() {
        return feeRefunded;
    }

    public void setFeeRefunded(final Price value) {
        this.feeRefunded = value;
    }

    public boolean isSetFeeRefunded() {
        return (this.feeRefunded != null);
    }

    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(final XMLGregorianCalendar value) {
        this.creationTimestamp = value;
    }

    public boolean isSetCreationTimestamp() {
        return (this.creationTimestamp != null);
    }

    public Status getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(final Status value) {
        this.refundStatus = value;
    }

    public boolean isSetRefundStatus() {
        return (this.refundStatus != null);
    }

    public String getSoftDescriptor() {
        return softDescriptor;
    }

    public void setSoftDescriptor(final String value) {
        this.softDescriptor = value;
    }

    public boolean isSetSoftDescriptor() {
        return (this.softDescriptor != null);
    }

    public ProviderCreditReversalSummaryList getProviderCreditReversalSummaryList() {
        return providerCreditReversalSummaryList;
    }

    public void setProviderCreditReversalSummaryList(final ProviderCreditReversalSummaryList value) {
        this.providerCreditReversalSummaryList = value;
    }

    public boolean isSetProviderCreditReversalSummaryList() {
        return (this.providerCreditReversalSummaryList != null);
    }

    public RefundDetails withAmazonRefundId(final String value) {
        setAmazonRefundId(value);
        return this;
    }

    public RefundDetails withRefundReferenceId(final String value) {
        setRefundReferenceId(value);
        return this;
    }

    public RefundDetails withRefundType(final String value) {
        setRefundType(value);
        return this;
    }

    public RefundDetails withRefundAmount(final Price value) {
        setRefundAmount(value);
        return this;
    }

    public RefundDetails withFeeRefunded(final Price value) {
        setFeeRefunded(value);
        return this;
    }

    public RefundDetails withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    public RefundDetails withRefundStatus(final Status value) {
        setRefundStatus(value);
        return this;
    }

    public RefundDetails withSoftDescriptor(final String value) {
        setSoftDescriptor(value);
        return this;
    }

    public RefundDetails withProviderCreditReversalSummaryList(final ProviderCreditReversalSummaryList value) {
        setProviderCreditReversalSummaryList(value);
        return this;
    }

    /**
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
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    @Deprecated
    public String toJSONFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new JSONFragmentBuilder()).build();
    }
}