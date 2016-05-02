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
 * <p>Java class for OrderReferenceAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderReferenceAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrderTotal" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderTotal"/>
 *         &lt;element name="PlatformId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SellerNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String1024" minOccurs="0"/>
 *         &lt;element name="RequestPaymentAuthorization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SellerOrderAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerOrderAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReferenceAttributes", propOrder = {
    "orderTotal",
    "platformId",
    "sellerNote",
    "requestPaymentAuthorization",
    "sellerOrderAttributes"
})
public class OrderReferenceAttributes {

    @XmlElement(name = "OrderTotal", required = true)
    protected OrderTotal orderTotal;
    
    @XmlElement(name = "PlatformId")
    protected String platformId;

    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    
    @XmlElement(name = "RequestPaymentAuthorization")
    protected Boolean requestPaymentAuthorization;
    
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;

    /**
     * Default constructor
     * 
     */
    public OrderReferenceAttributes() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OrderReferenceAttributes(final OrderTotal orderTotal, final String platformId, final String sellerNote, final SellerOrderAttributes sellerOrderAttributes, final Boolean requestPaymentAuthorization) {
        this.orderTotal = orderTotal;
        this.platformId = platformId;
        this.sellerNote = sellerNote;
        this.sellerOrderAttributes = sellerOrderAttributes;
        this.requestPaymentAuthorization = requestPaymentAuthorization;
    }

    /**
     * Gets the value of the orderTotal property.
     * 
     * @return
     *     possible object is
     *     {@link OrderTotal }
     *     
     */
    public OrderTotal getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the value of the orderTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderTotal }
     *     
     */
    public void setOrderTotal(OrderTotal value) {
        this.orderTotal = value;
    }

    public boolean isSetOrderTotal() {
        return (this.orderTotal!= null);
    }

    /**
     * Gets the value of the PlatformId property.
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
     * Sets the value of the PlatformId property.
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
     * Gets the value of the sellerOrderAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link SellerOrderAttributes }
     *     
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    /**
     * Sets the value of the sellerOrderAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellerOrderAttributes }
     *     
     */
    public void setSellerOrderAttributes(SellerOrderAttributes value) {
        this.sellerOrderAttributes = value;
    }

    public boolean isSetSellerOrderAttributes() {
        return (this.sellerOrderAttributes!= null);
    }

    /**
     * Gets the value of the requestPaymentAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequestPaymentAuthorization() {
        return requestPaymentAuthorization;
    }
    
    /**
     * Sets the value of the requestPaymentAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequestPaymentAuthorization(Boolean value) {
        this.requestPaymentAuthorization = value;
    }
    
    public boolean isSetRequestPaymentAuthorization() {
        return (this.requestPaymentAuthorization!= null);
    }

    /**
     * Sets the value of the OrderTotal property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceAttributes withOrderTotal(OrderTotal value) {
        setOrderTotal(value);
        return this;
    }

    /**
     * Sets the value of the PlatformId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceAttributes withPlatformId(String value) {
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
    public OrderReferenceAttributes withSellerNote(String value) {
        setSellerNote(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceAttributes withSellerOrderAttributes(SellerOrderAttributes value) {
        setSellerOrderAttributes(value);
        return this;
    }
    
    /**
     * Sets the value of the RequestPaymentAuthorization property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceAttributes withRequestPaymentAuthorization(Boolean value) {
        setRequestPaymentAuthorization(value);
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
