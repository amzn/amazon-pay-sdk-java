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
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="SellerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SellerBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "sellerId",
        "sellerBillingAgreementId"
})
@XmlRootElement(name = "SellerBillingAgreementAttributes")
public class SellerBillingAgreementAttributes {

    @XmlElement(name = "SellerId")
    protected String sellerId;
    @XmlElement(name = "SellerBillingAgreementId")
    protected String sellerBillingAgreementId;

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
    public SellerBillingAgreementAttributes(final String sellerId, final String sellerBillingAgreementId) {
        this.sellerId = sellerId;
        this.sellerBillingAgreementId = sellerBillingAgreementId;
    }

    /**
     * Gets the value of the sellerId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSellerId() {
        return this.sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSellerId(final String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId != null);
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
        return this.sellerBillingAgreementId;
    }

    /**
     * Sets the value of the sellerBillingAgreementId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSellerBillingAgreementId(final String value) {
        this.sellerBillingAgreementId = value;
    }

    public boolean isSetSellerBillingAgreementId() {
        return (this.sellerBillingAgreementId != null);
    }

    /**
     * Sets the value of the SellerId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public SellerBillingAgreementAttributes withSellerId(final String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the SellerBillingAgreementId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public SellerBillingAgreementAttributes withSellerBillingAgreementId(final String value) {
        setSellerBillingAgreementId(value);
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
