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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProviderCreditList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProviderCreditList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="member" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ProviderCredit" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProviderCreditList", propOrder = {
    "member"
})
public class ProviderCreditList {

    @XmlElement(required = true)
    protected List<ProviderCredit> member;

    /**
     * Default constructor
     * 
     */
    public ProviderCreditList() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public ProviderCreditList(final List<ProviderCredit> member) {
        this.member = member;
    }


    public List<ProviderCredit> getMember() {
        if (member == null) {
            member = new ArrayList<ProviderCredit>();
        }
        return this.member;
    }



}
