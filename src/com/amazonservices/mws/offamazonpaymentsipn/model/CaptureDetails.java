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
 * Java class for CaptureDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonCaptureId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CaptureReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="CaptureAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="RefundedAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CaptureFee" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="IdList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}IdList"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CaptureStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="SoftDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderCreditSummaryList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditSummaryList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureDetails", propOrder = { "amazonCaptureId", "captureReferenceId", "captureAmount",
        "refundedAmount", "captureFee", "idList", "creationTimestamp", "captureStatus", "softDescriptor",
        "providerCreditSummaryList" })
public class CaptureDetails {

    @XmlElement(name = "AmazonCaptureId", required = true)
    public String amazonCaptureId;
    @XmlElement(name = "CaptureReferenceId", required = true)
    public String captureReferenceId;
    @XmlElement(name = "CaptureAmount", required = true)
    public Price captureAmount;
    @XmlElement(name = "RefundedAmount", required = true)
    public Price refundedAmount;
    @XmlElement(name = "CaptureFee", required = true)
    public Price captureFee;
    @XmlElement(name = "IdList", required = true)
    public IdList idList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    public XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CaptureStatus", required = true)
    public Status captureStatus;
    @XmlElement(name = "SoftDescriptor", required = true)
    public String softDescriptor;
    @XmlElement(name = "ProviderCreditSummaryList", required = true)
    public ProviderCreditSummaryList providerCreditSummaryList;

    public CaptureDetails() {
        super();
    }

    public CaptureDetails(final String amazonCaptureId, final String captureReferenceId, final Price captureAmount,
            final Price refundedAmount, final Price captureFee, final IdList idList,
            final XMLGregorianCalendar creationTimestamp, final Status captureStatus, final String softDescriptor,
            final ProviderCreditSummaryList providerCreditSummaryList) {
        this.amazonCaptureId = amazonCaptureId;
        this.captureReferenceId = captureReferenceId;
        this.captureAmount = captureAmount;
        this.refundedAmount = refundedAmount;
        this.captureFee = captureFee;
        this.idList = idList;
        this.creationTimestamp = creationTimestamp;
        this.captureStatus = captureStatus;
        this.softDescriptor = softDescriptor;
        this.providerCreditSummaryList = providerCreditSummaryList;

    }

    public String getAmazonCaptureId() {
        return amazonCaptureId;
    }

    public void setAmazonCaptureId(final String value) {
        this.amazonCaptureId = value;
    }

    public boolean isSetAmazonCaptureId() {
        return (this.amazonCaptureId != null);
    }

    public String getCaptureReferenceId() {
        return captureReferenceId;
    }

    public void setCaptureReferenceId(final String value) {
        this.captureReferenceId = value;
    }

    public boolean isSetCaptureReferenceId() {
        return (this.captureReferenceId != null);
    }

    public Price getCaptureAmount() {
        return captureAmount;
    }

    public void setCaptureAmount(final Price value) {
        this.captureAmount = value;
    }

    public boolean isSetCaptureAmount() {
        return (this.captureAmount != null);
    }

    public Price getRefundedAmount() {
        return refundedAmount;
    }
    
    public void setRefundedAmount(final Price value) {
        this.refundedAmount = value;
    }

    public boolean isSetRefundedAmount() {
        return (this.refundedAmount != null);
    }

    public Price getCaptureFee() {
        return captureFee;
    }

    public void setCaptureFee(final Price value) {
        this.captureFee = value;
    }

    public boolean isSetCaptureFee() {
        return (this.captureFee != null);
    }

    public IdList getIdList() {
        return idList;
    }

    public void setIdList(final IdList value) {
        this.idList = value;
    }

    public boolean isSetIdList() {
        return (this.idList != null);
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

    public Status getCaptureStatus() {
        return captureStatus;
    }

    public void setCaptureStatus(final Status value) {
        this.captureStatus = value;
    }

    public boolean isSetCaptureStatus() {
        return (this.captureStatus != null);
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

    public ProviderCreditSummaryList getProviderCreditSummaryList() {
        return providerCreditSummaryList;
    }

    public void setProviderCreditSummaryList(final ProviderCreditSummaryList value) {
        this.providerCreditSummaryList = value;
    }

    public boolean isSetProviderCreditSummaryList() {
        return (this.providerCreditSummaryList != null);
    }

    public CaptureDetails withAmazonCaptureId(final String value) {
        setAmazonCaptureId(value);
        return this;
    }

    public CaptureDetails withCaptureReferenceId(final String value) {
        setCaptureReferenceId(value);
        return this;
    }

    public CaptureDetails withCaptureAmount(final Price value) {
        setCaptureAmount(value);
        return this;
    }

    public CaptureDetails withRefundedAmount(final Price value) {
        setRefundedAmount(value);
        return this;
    }

    public CaptureDetails withCaptureFee(final Price value) {
        setCaptureFee(value);
        return this;
    }

    public CaptureDetails withIdList(final IdList value) {
        setIdList(value);
        return this;
    }

    public CaptureDetails withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    public CaptureDetails withCaptureStatus(final Status value) {
        setCaptureStatus(value);
        return this;
    }

    public CaptureDetails withSoftDescriptor(final String value) {
        setSoftDescriptor(value);
        return this;
    }

    public CaptureDetails withProviderCreditSummaryList(final ProviderCreditSummaryList value) {
        setProviderCreditSummaryList(value);
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
