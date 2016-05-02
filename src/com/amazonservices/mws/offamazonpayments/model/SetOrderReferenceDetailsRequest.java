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
 *         &lt;element name="SellerId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}NonEmptyString"/>
 *         &lt;element name="MWSAuthToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmazonOrderReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrderReferenceAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderReferenceAttributes"/>
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
    "sellerId",
    "MWSAuthToken",
    "amazonOrderReferenceId",
    "orderReferenceAttributes"
})
@XmlRootElement(name = "SetOrderReferenceDetailsRequest")
public class SetOrderReferenceDetailsRequest {

    @XmlElement(name = "SellerId", required = true)
    protected String sellerId;
    @XmlElement(name="MWSAuthToken")
    protected String MWSAuthToken;
    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;
    @XmlElement(name = "OrderReferenceAttributes", required = true)
    protected OrderReferenceAttributes orderReferenceAttributes;

    /**
     * Default constructor
     * 
     */
    public SetOrderReferenceDetailsRequest() {
        super();
    }

    /**
     * Value constructor without MWSAuthToken param, for non-delegated requests
     *
     */
    public SetOrderReferenceDetailsRequest(final String sellerId, final String amazonOrderReferenceId, final OrderReferenceAttributes orderReferenceAttributes) {
        this(sellerId, amazonOrderReferenceId, orderReferenceAttributes, ModelConstants.EMPTY_MWS_AUTH_TOKEN);
    }

    /**
     * Value constructor
     *
     */
    public SetOrderReferenceDetailsRequest(final String sellerId, final String amazonOrderReferenceId, final OrderReferenceAttributes orderReferenceAttributes, final String MWSAuthToken) {
        this.sellerId = sellerId;
        this.MWSAuthToken = MWSAuthToken;
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.orderReferenceAttributes = orderReferenceAttributes;
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
     * Gets the value of the amazonOrderReferenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Sets the value of the amazonOrderReferenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonOrderReferenceId(String value) {
        this.amazonOrderReferenceId = value;
    }

    public boolean isSetAmazonOrderReferenceId() {
        return (this.amazonOrderReferenceId!= null);
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
     * Sets the value of the SellerId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SetOrderReferenceDetailsRequest withSellerId(String value) {
        setSellerId(value);
        return this;
    }

    /**
     * Sets the value of the AmazonOrderReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SetOrderReferenceDetailsRequest withAmazonOrderReferenceId(String value) {
        setAmazonOrderReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the OrderReferenceAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public SetOrderReferenceDetailsRequest withOrderReferenceAttributes(OrderReferenceAttributes value) {
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
