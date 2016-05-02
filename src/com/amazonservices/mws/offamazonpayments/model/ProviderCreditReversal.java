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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProviderCreditReversal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditReversal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProviderId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="CreditReversalAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversal", propOrder = {
    "providerId",
    "creditReversalAmount"
})
public class ProviderCreditReversal {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;

    /**
     * Default constructor
     * 
     */
    public ProviderCreditReversal() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ProviderCreditReversal(final String providerId, final Price creditReversalAmount) {
        this.providerId = providerId;
        this.creditReversalAmount = creditReversalAmount;
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
     * Sets the value of the ProviderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversal withProviderId(String value) {
        setProviderId(value);
        return this;
    }

    /**
     * Sets the value of the CreditReversalAmount property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversal withCreditReversalAmount(Price value) {
        setCreditReversalAmount(value);
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
