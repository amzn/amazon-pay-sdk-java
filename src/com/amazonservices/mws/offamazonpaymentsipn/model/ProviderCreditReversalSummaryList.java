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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.common.JSONFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.ReflectionFragmentBuilder;
import com.amazonservices.mws.offamazonpayments.common.XmlFragmentBuilder;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalSummary;

/**
 * <p>
 * Java class for ProviderCreditReversalSummaryList complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditReversalSummaryList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="member" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCreditReversalSummary" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditReversalSummaryList", propOrder = { "providerCreditReversalSummary" })
public class ProviderCreditReversalSummaryList {
    @XmlElement(name = "ProviderCreditReversalSummary", required = false)
    protected List<ProviderCreditReversalSummary> providerCreditReversalSummary;

    public ProviderCreditReversalSummaryList() {
        super();
    }

    public ProviderCreditReversalSummaryList(final List<ProviderCreditReversalSummary> providerCreditReversalSummary) {
        this.providerCreditReversalSummary = providerCreditReversalSummary;
    }

    public List<ProviderCreditReversalSummary> getProviderCreditReversalSummary() {
        if (providerCreditReversalSummary == null) {
            providerCreditReversalSummary = new ArrayList<ProviderCreditReversalSummary>();
        }
        return this.providerCreditReversalSummary;
    }

    public boolean isSetProviderCreditReversalSummary() {
        return ((this.providerCreditReversalSummary != null) && (!this.providerCreditReversalSummary.isEmpty()));
    }

    public void unsetProviderCreditReversalSummary() {
        this.providerCreditReversalSummary = null;
    }

    public ProviderCreditReversalSummaryList withProviderCreditReversalSummary(ProviderCreditReversalSummary... values) {
        for (ProviderCreditReversalSummary value : values) {
            getProviderCreditReversalSummary().add(value);
        }
        return this;
    }

    public void setProviderCreditReversalSummary(List<ProviderCreditReversalSummary> providerCreditReversalSummary) {
        this.providerCreditReversalSummary = providerCreditReversalSummary;
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
