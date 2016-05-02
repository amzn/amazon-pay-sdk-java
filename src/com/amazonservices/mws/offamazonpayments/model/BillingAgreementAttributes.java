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
 * <p>Java class for BillingAgreementAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingAgreementAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlatformId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SellerNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String1024" minOccurs="0"/>
 *         &lt;element name="SellerBillingAgreementAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerBillingAgreementAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementAttributes", propOrder = {
    "platformId",
    "sellerNote",
    "sellerBillingAgreementAttributes"
})
public class BillingAgreementAttributes {

    @XmlElement(name = "PlatformId")
    protected String platformId;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "SellerBillingAgreementAttributes")
    protected SellerBillingAgreementAttributes sellerBillingAgreementAttributes;

    /**
     * Default constructor
     * 
     */
    public BillingAgreementAttributes() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public BillingAgreementAttributes(final String platformId, final String sellerNote, final SellerBillingAgreementAttributes sellerBillingAgreementAttributes) {
        this.platformId = platformId;
        this.sellerNote = sellerNote;
        this.sellerBillingAgreementAttributes = sellerBillingAgreementAttributes;
    }

    /**
     * Gets the value of the platformId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Sets the value of the platformId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatformId(String value) {
        this.platformId = value;
    }

    public boolean isSetPlatformId() {
        return (this.platformId!= null);
    }

    /**
     * Gets the value of the sellerNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Sets the value of the sellerNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerNote(String value) {
        this.sellerNote = value;
    }

    public boolean isSetSellerNote() {
        return (this.sellerNote!= null);
    }

    /**
     * Gets the value of the sellerBillingAgreementAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link SellerBillingAgreementAttributes }
     *     
     */
    public SellerBillingAgreementAttributes getSellerBillingAgreementAttributes() {
        return sellerBillingAgreementAttributes;
    }

    /**
     * Sets the value of the sellerBillingAgreementAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerBillingAgreementAttributes }
     *     
     */
    public void setSellerBillingAgreementAttributes(SellerBillingAgreementAttributes value) {
        this.sellerBillingAgreementAttributes = value;
    }

    public boolean isSetSellerBillingAgreementAttributes() {
        return (this.sellerBillingAgreementAttributes!= null);
    }

    /**
     * Sets the value of the PlatformId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementAttributes withPlatformId(String value) {
        setPlatformId(value);
        return this;
    }

    /**
     * Sets the value of the SellerNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementAttributes withSellerNote(String value) {
        setSellerNote(value);
        return this;
    }

    /**
     * Sets the value of the SellerBillingAgreementAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementAttributes withSellerBillingAgreementAttributes(SellerBillingAgreementAttributes value) {
        setSellerBillingAgreementAttributes(value);
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
