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
 *         &lt;element name="ValidationResult" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}RequestStatus"/>
 *         &lt;element name="FailureReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillingAgreementStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAgreementStatus" minOccurs="0"/>
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
    "validationResult",
    "failureReasonCode",
    "billingAgreementStatus"
})
@XmlRootElement(name = "ValidateBillingAgreementResult")
public class ValidateBillingAgreementResult {

    @XmlElement(name = "ValidationResult", required = true)
    protected RequestStatus validationResult;
    @XmlElement(name = "FailureReasonCode")
    protected String failureReasonCode;
    @XmlElement(name = "BillingAgreementStatus")
    protected BillingAgreementStatus billingAgreementStatus;

    /**
     * Default constructor
     * 
     */
    public ValidateBillingAgreementResult() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ValidateBillingAgreementResult(final RequestStatus validationResult, final String failureReasonCode, final BillingAgreementStatus billingAgreementStatus) {
        this.validationResult = validationResult;
        this.failureReasonCode = failureReasonCode;
        this.billingAgreementStatus = billingAgreementStatus;
    }

    /**
     * Gets the value of the validationResult property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getValidationResult() {
        return validationResult;
    }

    /**
     * Sets the value of the validationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setValidationResult(RequestStatus value) {
        this.validationResult = value;
    }

    public boolean isSetValidationResult() {
        return (this.validationResult!= null);
    }

    /**
     * Gets the value of the failureReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailureReasonCode() {
        return failureReasonCode;
    }

    /**
     * Sets the value of the failureReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailureReasonCode(String value) {
        this.failureReasonCode = value;
    }

    public boolean isSetFailureReasonCode() {
        return (this.failureReasonCode!= null);
    }

    /**
     * Gets the value of the billingAgreementStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BillingAgreementStatus }
     *     
     */
    public BillingAgreementStatus getBillingAgreementStatus() {
        return billingAgreementStatus;
    }

    /**
     * Sets the value of the billingAgreementStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAgreementStatus }
     *     
     */
    public void setBillingAgreementStatus(BillingAgreementStatus value) {
        this.billingAgreementStatus = value;
    }

    public boolean isSetBillingAgreementStatus() {
        return (this.billingAgreementStatus!= null);
    }

    /**
     * Sets the value of the ValidationResult property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ValidateBillingAgreementResult withValidationResult(RequestStatus value) {
        setValidationResult(value);
        return this;
    }

    /**
     * Sets the value of the FailureReasonCode property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ValidateBillingAgreementResult withFailureReasonCode(String value) {
        setFailureReasonCode(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ValidateBillingAgreementResult withBillingAgreementStatus(BillingAgreementStatus value) {
        setBillingAgreementStatus(value);
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
