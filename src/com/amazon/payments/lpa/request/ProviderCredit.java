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

package com.amazon.payments.lpa.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProviderCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCredit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProviderId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="CreditAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCredit", propOrder = {
    "providerId",
    "creditAmount"
})
public class ProviderCredit {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditAmount", required = true)
    protected Price creditAmount;

    /**
     * Default constructor
     * 
     */
    public ProviderCredit() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ProviderCredit(final String providerId, final Price creditAmount) {
        this.providerId = providerId;
        this.creditAmount = creditAmount;
    }

    public String getProviderId() {
        return providerId;
    }


    public Price getCreditAmount() {
        return creditAmount;
    }


}
