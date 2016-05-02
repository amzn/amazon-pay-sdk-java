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
 * <p>Java class for CaptureDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonCaptureId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CaptureReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="SellerCaptureNote" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CaptureAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="RefundedAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CaptureFee" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="IdList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}IdList"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CaptureStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="SoftDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProviderCreditSummaryList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditSummaryList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureDetails", propOrder = {
    "amazonCaptureId",
    "captureReferenceId",
    "sellerCaptureNote",
    "captureAmount",
    "refundedAmount",
    "captureFee",
    "idList",
    "creationTimestamp",
    "captureStatus",
    "softDescriptor",
    "providerCreditSummaryList"
})
public class CaptureDetails {

    @XmlElement(name = "AmazonCaptureId", required = true)
    protected String amazonCaptureId;
    @XmlElement(name = "CaptureReferenceId", required = true)
    protected String captureReferenceId;
    @XmlElement(name = "SellerCaptureNote", required = true)
    protected String sellerCaptureNote;
    @XmlElement(name = "CaptureAmount", required = true)
    protected Price captureAmount;
    @XmlElement(name = "RefundedAmount", required = true)
    protected Price refundedAmount;
    @XmlElement(name = "CaptureFee", required = true)
    protected Price captureFee;
    @XmlElement(name = "IdList", required = true)
    protected IdList idList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "CaptureStatus", required = true)
    protected Status captureStatus;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "ProviderCreditSummaryList")
    protected ProviderCreditSummaryList providerCreditSummaryList;

    /**
     * Default constructor
     * 
     */
    public CaptureDetails() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public CaptureDetails(final String amazonCaptureId, final String captureReferenceId, final String sellerCaptureNote, final Price captureAmount, final Price refundedAmount, final Price captureFee, final IdList idList, final XMLGregorianCalendar creationTimestamp, final Status captureStatus, final String softDescriptor, final ProviderCreditSummaryList providerCreditSummaryList) {
        this.amazonCaptureId = amazonCaptureId;
        this.captureReferenceId = captureReferenceId;
        this.sellerCaptureNote = sellerCaptureNote;
        this.captureAmount = captureAmount;
        this.refundedAmount = refundedAmount;
        this.captureFee = captureFee;
        this.idList = idList;
        this.creationTimestamp = creationTimestamp;
        this.captureStatus = captureStatus;
        this.softDescriptor = softDescriptor;
        this.providerCreditSummaryList = providerCreditSummaryList;
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
     * Gets the value of the refundedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getRefundedAmount() {
        return refundedAmount;
    }

    /**
     * Sets the value of the refundedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setRefundedAmount(Price value) {
        this.refundedAmount = value;
    }

    public boolean isSetRefundedAmount() {
        return (this.refundedAmount!= null);
    }

    /**
     * Gets the value of the captureFee property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getCaptureFee() {
        return captureFee;
    }

    /**
     * Sets the value of the captureFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setCaptureFee(Price value) {
        this.captureFee = value;
    }

    public boolean isSetCaptureFee() {
        return (this.captureFee!= null);
    }

    /**
     * Gets the value of the idList property.
     * 
     * @return
     *     possible object is
     *     {@link IdList }
     *     
     */
    public IdList getIdList() {
        return idList;
    }

    /**
     * Sets the value of the idList property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdList }
     *     
     */
    public void setIdList(IdList value) {
        this.idList = value;
    }

    public boolean isSetIdList() {
        return (this.idList!= null);
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
     * Gets the value of the captureStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getCaptureStatus() {
        return captureStatus;
    }

    /**
     * Sets the value of the captureStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setCaptureStatus(Status value) {
        this.captureStatus = value;
    }

    public boolean isSetCaptureStatus() {
        return (this.captureStatus!= null);
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
     * Gets the value of the providerCreditSummaryList property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderCreditSummaryList }
     *     
     */
    public ProviderCreditSummaryList getProviderCreditSummaryList() {
        return providerCreditSummaryList;
    }

    /**
     * Sets the value of the providerCreditSummaryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderCreditSummaryList }
     *     
     */
    public void setProviderCreditSummaryList(ProviderCreditSummaryList value) {
        this.providerCreditSummaryList = value;
    }

    public boolean isSetProviderCreditSummaryList() {
        return (this.providerCreditSummaryList!= null);
    }

    /**
     * Sets the value of the AmazonCaptureId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withAmazonCaptureId(String value) {
        setAmazonCaptureId(value);
        return this;
    }

    /**
     * Sets the value of the CaptureReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withCaptureReferenceId(String value) {
        setCaptureReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the SellerCaptureNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withSellerCaptureNote(String value) {
        setSellerCaptureNote(value);
        return this;
    }

    /**
     * Sets the value of the CaptureAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withCaptureAmount(Price value) {
        setCaptureAmount(value);
        return this;
    }

    /**
     * Sets the value of the RefundedAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withRefundedAmount(Price value) {
        setRefundedAmount(value);
        return this;
    }

    /**
     * Sets the value of the CaptureFee property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withCaptureFee(Price value) {
        setCaptureFee(value);
        return this;
    }

    /**
     * Sets the value of the IdList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withIdList(IdList value) {
        setIdList(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withCreationTimestamp(XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the CaptureStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withCaptureStatus(Status value) {
        setCaptureStatus(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withSoftDescriptor(String value) {
        setSoftDescriptor(value);
        return this;
    }

    /**
     * Sets the value of the ProviderCreditSummaryList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CaptureDetails withProviderCreditSummaryList(ProviderCreditSummaryList value) {
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
