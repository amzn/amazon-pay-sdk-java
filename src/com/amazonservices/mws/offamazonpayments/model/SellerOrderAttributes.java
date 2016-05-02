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
 * <p>Java class for SellerOrderAttributes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SellerOrderAttributes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SellerOrderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StoreName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrderItemCategories" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderItemCategories" minOccurs="0"/>
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
@XmlType(name = "SellerOrderAttributes", propOrder = {
    "sellerOrderId",
    "storeName",
    "orderItemCategories",
    "customInformation"
})
public class SellerOrderAttributes {

    @XmlElement(name = "SellerOrderId")
    protected String sellerOrderId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "OrderItemCategories")
    protected OrderItemCategories orderItemCategories;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    /**
     * Default constructor
     * 
     */
    public SellerOrderAttributes() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public SellerOrderAttributes(final String sellerOrderId, final String storeName, final OrderItemCategories orderItemCategories, final String customInformation) {
        this.sellerOrderId = sellerOrderId;
        this.storeName = storeName;
        this.orderItemCategories = orderItemCategories;
        this.customInformation = customInformation;
    }

    /**
     * Gets the value of the sellerOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }

    /**
     * Sets the value of the sellerOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerOrderId(String value) {
        this.sellerOrderId = value;
    }

    public boolean isSetSellerOrderId() {
        return (this.sellerOrderId!= null);
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
     * Gets the value of the orderItemCategories property.
     * 
     * @return
     *     possible object is
     *     {@link OrderItemCategories }
     *     
     */
    public OrderItemCategories getOrderItemCategories() {
        return orderItemCategories;
    }

    /**
     * Sets the value of the orderItemCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderItemCategories }
     *     
     */
    public void setOrderItemCategories(OrderItemCategories value) {
        this.orderItemCategories = value;
    }

    public boolean isSetOrderItemCategories() {
        return (this.orderItemCategories!= null);
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
     * Sets the value of the SellerOrderId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerOrderAttributes withSellerOrderId(String value) {
        setSellerOrderId(value);
        return this;
    }

    /**
     * Sets the value of the StoreName property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerOrderAttributes withStoreName(String value) {
        setStoreName(value);
        return this;
    }

    /**
     * Sets the value of the OrderItemCategories property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerOrderAttributes withOrderItemCategories(OrderItemCategories value) {
        setOrderItemCategories(value);
        return this;
    }

    /**
     * Sets the value of the CustomInformation property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SellerOrderAttributes withCustomInformation(String value) {
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
