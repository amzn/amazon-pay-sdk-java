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
 * <p>Java class for SellerBillingAgreementAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellerBillingAgreementAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StoreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerBillingAgreementAttributes", propOrder = {
    "sellerBillingAgreementId",
    "storeName",
    "customInformation"
})
public class SellerBillingAgreementAttributes {

    @XmlElement(name = "SellerBillingAgreementId")
    protected String sellerBillingAgreementId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    /**
     * Default constructor
     * 
     */
    public SellerBillingAgreementAttributes() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SellerBillingAgreementAttributes(final String sellerBillingAgreementId, final String storeName, final String customInformation) {
        this.sellerBillingAgreementId = sellerBillingAgreementId;
        this.storeName = storeName;
        this.customInformation = customInformation;
    }

    /**
     * Gets the value of the sellerBillingAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
    }

    /**
     * Sets the value of the sellerBillingAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerBillingAgreementId(String value) {
        this.sellerBillingAgreementId = value;
    }

    public boolean isSetSellerBillingAgreementId() {
        return (this.sellerBillingAgreementId!= null);
    }

    /**
     * Gets the value of the storeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets the value of the storeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreName(String value) {
        this.storeName = value;
    }

    public boolean isSetStoreName() {
        return (this.storeName!= null);
    }

    /**
     * Gets the value of the customInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Sets the value of the customInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomInformation(String value) {
        this.customInformation = value;
    }

    public boolean isSetCustomInformation() {
        return (this.customInformation!= null);
    }

    /**
     * Sets the value of the SellerBillingAgreementId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerBillingAgreementAttributes withSellerBillingAgreementId(String value) {
        setSellerBillingAgreementId(value);
        return this;
    }

    /**
     * Sets the value of the StoreName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerBillingAgreementAttributes withStoreName(String value) {
        setStoreName(value);
        return this;
    }

    /**
     * Sets the value of the CustomInformation property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerBillingAgreementAttributes withCustomInformation(String value) {
        setCustomInformation(value);
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
