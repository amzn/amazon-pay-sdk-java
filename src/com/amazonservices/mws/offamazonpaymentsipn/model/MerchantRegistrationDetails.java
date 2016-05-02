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
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for MerchantRegistrationDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MerchantRegistrationDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Options" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SolutionProviderOptions"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantRegistrationDetails", propOrder = { "sellerId", "type", "options" })
public class MerchantRegistrationDetails {

    @XmlElement(name = "SellerId", required = true)
    public String sellerId;
    @XmlElement(name = "Type", required = true)
    public String type;
    @XmlElement(name = "Options", required = true)
    public SolutionProviderOptions options;

    public MerchantRegistrationDetails() {
        super();
    }

    public MerchantRegistrationDetails(final String sellerId, final String type,
            final SolutionProviderOptions options) {
        this.sellerId = sellerId;
        this.type = type;
        this.options = options;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(final String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId != null);
    }

    public String getType() {
        return type;
    }

    public void setType(final String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type != null);
    }

    public SolutionProviderOptions getOptions() {
        return options;
    }

    public void setOptions(final SolutionProviderOptions value) {
        this.options = value;
    }

    public boolean isSetOptions() {
        return (this.options != null);
    }

    public MerchantRegistrationDetails withSellerId(final String value) {
        setSellerId(value);
        return this;
    }

    public MerchantRegistrationDetails withType(final String value) {
        setType(value);
        return this;
    }

    public MerchantRegistrationDetails withOptions(final SolutionProviderOptions value) {
        setOptions(value);
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
