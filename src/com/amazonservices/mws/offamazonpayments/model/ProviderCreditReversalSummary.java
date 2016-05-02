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
 * <p>Java class for ProviderCreditReversalSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditReversalSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProviderId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="ProviderCreditReversalId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalSummary", propOrder = {
    "providerId",
    "providerCreditReversalId"
})
public class ProviderCreditReversalSummary {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "ProviderCreditReversalId", required = true)
    protected String providerCreditReversalId;

    /**
     * Default constructor
     * 
     */
    public ProviderCreditReversalSummary() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ProviderCreditReversalSummary(final String providerId, final String providerCreditReversalId) {
        this.providerId = providerId;
        this.providerCreditReversalId = providerCreditReversalId;
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
     * Gets the value of the providerCreditReversalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderCreditReversalId() {
        return providerCreditReversalId;
    }

    /**
     * Sets the value of the providerCreditReversalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderCreditReversalId(String value) {
        this.providerCreditReversalId = value;
    }

    public boolean isSetProviderCreditReversalId() {
        return (this.providerCreditReversalId!= null);
    }

    /**
     * Sets the value of the ProviderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalSummary withProviderId(String value) {
        setProviderId(value);
        return this;
    }

    /**
     * Sets the value of the ProviderCreditReversalId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public ProviderCreditReversalSummary withProviderCreditReversalId(String value) {
        setProviderCreditReversalId(value);
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
