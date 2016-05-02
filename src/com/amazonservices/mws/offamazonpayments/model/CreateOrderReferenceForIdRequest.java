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
import com.amazonservices.mws.offamazonpayments.common.ModelConstants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="MWSAuthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InheritShippingAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ConfirmNow" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OrderReferenceAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderReferenceAttributes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "sellerId",
    "MWSAuthToken",
    "idType",
    "inheritShippingAddress",
    "confirmNow",
    "orderReferenceAttributes"
})
@XmlRootElement(name = "CreateOrderReferenceForIdRequest")
public class CreateOrderReferenceForIdRequest {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name="MWSAuthToken")
    protected String MWSAuthToken;
    @XmlElement(name = "IdType", required = true)
    protected String idType;
    @XmlElement(name = "InheritShippingAddress")
    protected Boolean inheritShippingAddress;
    @XmlElement(name = "ConfirmNow")
    protected Boolean confirmNow;
    @XmlElement(name = "OrderReferenceAttributes")
    protected OrderReferenceAttributes orderReferenceAttributes;

    /**
     * Default constructor
     * 
     */
    public CreateOrderReferenceForIdRequest() {
        super();
    }

    /**
     * Value constructor without MWSAuthToken param, for non-delegated requests
     *
     */
    public CreateOrderReferenceForIdRequest(final String id, final String sellerId, final String idType, final Boolean inheritShippingAddress, final Boolean confirmNow, final OrderReferenceAttributes orderReferenceAttributes) {
        this(id, sellerId, idType, inheritShippingAddress, confirmNow, orderReferenceAttributes, ModelConstants.EMPTY_MWS_AUTH_TOKEN);
    }

    /**
     * Value constructor
     *
     */
    public CreateOrderReferenceForIdRequest(final String id, final String sellerId, final String idType, final Boolean inheritShippingAddress, final Boolean confirmNow, final OrderReferenceAttributes orderReferenceAttributes, final String MWSAuthToken) {
        this.id = id;
        this.sellerId = sellerId;
        this.MWSAuthToken = MWSAuthToken;
        this.idType = idType;
        this.inheritShippingAddress = inheritShippingAddress;
        this.confirmNow = confirmNow;
        this.orderReferenceAttributes = orderReferenceAttributes;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
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
        return sellerId;
    }

    /**
     * Sets the value of the sellerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSellerId(String value) {
        this.sellerId = value;
    }

    public boolean isSetSellerId() {
        return (this.sellerId!= null);
    }

    /**
     * Get the value of MWSAuthToken.
     *
     * @return The value of MWSAuthToken.
     */
    public String getMWSAuthToken() {
        return MWSAuthToken;
    }

    /**
     * Set the value of MWSAuthToken.
     *
     * @param MWSAuthToken
     *            The new value to set.
     */
    public void setMWSAuthToken(String MWSAuthToken) {
        this.MWSAuthToken = MWSAuthToken;
    }

    /**
     * Check to see if MWSAuthToken is set.
     *
     * @return true if MWSAuthToken is set.
     */
    public boolean isSetMWSAuthToken() {
        return MWSAuthToken != null;
    }

    /**
     * Gets the value of the idType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdType() {
        return idType;
    }

    /**
     * Sets the value of the idType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdType(String value) {
        this.idType = value;
    }

    public boolean isSetIdType() {
        return (this.idType!= null);
    }

    /**
     * Gets the value of the inheritShippingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInheritShippingAddress() {
        return inheritShippingAddress;
    }

    /**
     * Sets the value of the inheritShippingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInheritShippingAddress(Boolean value) {
        this.inheritShippingAddress = value;
    }

    public boolean isSetInheritShippingAddress() {
        return (this.inheritShippingAddress!= null);
    }

    /**
     * Gets the value of the confirmNow property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirmNow() {
        return confirmNow;
    }

    /**
     * Sets the value of the confirmNow property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfirmNow(Boolean value) {
        this.confirmNow = value;
    }

    public boolean isSetConfirmNow() {
        return (this.confirmNow!= null);
    }

    /**
     * Gets the value of the orderReferenceAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link OrderReferenceAttributes }
     *     
     */
    public OrderReferenceAttributes getOrderReferenceAttributes() {
        return orderReferenceAttributes;
    }

    /**
     * Sets the value of the orderReferenceAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReferenceAttributes }
     *     
     */
    public void setOrderReferenceAttributes(OrderReferenceAttributes value) {
        this.orderReferenceAttributes = value;
    }

    public boolean isSetOrderReferenceAttributes() {
        return (this.orderReferenceAttributes!= null);
    }

    /**
     * Sets the value of the Id property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withId(String value) {
        setId(value);
        return this;
    }

    /**
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the IdType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withIdType(String value) {
        setIdType(value);
        return this;
    }

    /**
     * Sets the value of the InheritShippingAddress property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withInheritShippingAddress(Boolean value) {
        setInheritShippingAddress(value);
        return this;
    }

    /**
     * Sets the value of the ConfirmNow property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withConfirmNow(Boolean value) {
        setConfirmNow(value);
        return this;
    }

    /**
     * Sets the value of the OrderReferenceAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public CreateOrderReferenceForIdRequest withOrderReferenceAttributes(OrderReferenceAttributes value) {
        setOrderReferenceAttributes(value);
        return this;
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
