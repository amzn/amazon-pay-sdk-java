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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;



/**
 * <p>Java class for OrderReferenceDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OrderReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonOrderReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OrderTotal" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderTotal" minOccurs="0"/>
 *         &lt;element name="SellerOrderAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerOrderAttributes" minOccurs="0"/>
 *         &lt;element name="OrderReferenceStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderReferenceStatus"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpirationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReference", propOrder = {
        "amazonOrderReferenceId",
        "orderTotal",
        "sellerOrderAttributes",
        "orderReferenceStatus",
        "creationTimestamp",
        "expirationTimestamp"
})
public class OrderReference {

    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;
    @XmlElement(name = "OrderTotal")
    protected OrderTotal orderTotal;
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;
    @XmlElement(name = "OrderReferenceStatus", required = true)
    protected OrderReferenceStatus orderReferenceStatus;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;

    /**
     * Default constructor
     */
    public OrderReference() {
        super();
    }

    /**
     * Value constructor
     */
    public OrderReference(final String amazonOrderReferenceId, final OrderTotal orderTotal, final SellerOrderAttributes sellerOrderAttributes, final OrderReferenceStatus orderReferenceStatus, final XMLGregorianCalendar creationTimestamp, final XMLGregorianCalendar expirationTimestamp) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.orderTotal = orderTotal;
        this.sellerOrderAttributes = sellerOrderAttributes;
        this.orderReferenceStatus = orderReferenceStatus;
        this.creationTimestamp = creationTimestamp;
        this.expirationTimestamp = expirationTimestamp;
    }

    /**
     * Gets the value of the amazonOrderReferenceId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Sets the value of the amazonOrderReferenceId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAmazonOrderReferenceId(final String value) {
        this.amazonOrderReferenceId = value;
    }

    public boolean isSetAmazonOrderReferenceId() {
        return (this.amazonOrderReferenceId != null);
    }

    /**
     * Gets the value of the orderTotal property.
     *
     * @return possible object is
     * {@link OrderTotal }
     */
    public OrderTotal getOrderTotal() {
        return orderTotal;
    }

    /**
     * Sets the value of the orderTotal property.
     *
     * @param value allowed object is
     *              {@link OrderTotal }
     */
    public void setOrderTotal(final OrderTotal value) {
        this.orderTotal = value;
    }

    public boolean isSetOrderTotal() {
        return (this.orderTotal != null);
    }

    /**
     * Gets the value of the sellerOrderAttributes property.
     *
     * @return possible object is
     * {@link SellerOrderAttributes }
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    /**
     * Sets the value of the sellerOrderAttributes property.
     *
     * @param value allowed object is
     *              {@link SellerOrderAttributes }
     */
    public void setSellerOrderAttributes(final SellerOrderAttributes value) {
        this.sellerOrderAttributes = value;
    }

    public boolean isSetSellerOrderAttributes() {
        return (this.sellerOrderAttributes != null);
    }

    /**
     * Gets the value of the orderReferenceStatus property.
     *
     * @return possible object is
     * {@link OrderReferenceStatus }
     */
    public OrderReferenceStatus getOrderReferenceStatus() {
        return orderReferenceStatus;
    }

    /**
     * Sets the value of the orderReferenceStatus property.
     *
     * @param value allowed object is
     *              {@link OrderReferenceStatus }
     */
    public void setOrderReferenceStatus(final OrderReferenceStatus value) {
        this.orderReferenceStatus = value;
    }

    public boolean isSetOrderReferenceStatus() {
        return (this.orderReferenceStatus != null);
    }

    /**
     * Gets the value of the creationTimestamp property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Sets the value of the creationTimestamp property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreationTimestamp(final XMLGregorianCalendar value) {
        this.creationTimestamp = value;
    }

    public boolean isSetCreationTimestamp() {
        return (this.creationTimestamp != null);
    }

    /**
     * Gets the value of the expirationTimestamp property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     * Sets the value of the expirationTimestamp property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setExpirationTimestamp(final XMLGregorianCalendar value) {
        this.expirationTimestamp = value;
    }

    public boolean isSetExpirationTimestamp() {
        return (this.expirationTimestamp != null);
    }

    /**
     * Sets the value of the AmazonOrderReferenceId property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withAmazonOrderReferenceId(final String value) {
        setAmazonOrderReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the OrderTotal property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withOrderTotal(final OrderTotal value) {
        setOrderTotal(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderAttributes property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withSellerOrderAttributes(final SellerOrderAttributes value) {
        setSellerOrderAttributes(value);
        return this;
    }

    /**
     * Sets the value of the OrderReferenceStatus property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withOrderReferenceStatus(final OrderReferenceStatus value) {
        setOrderReferenceStatus(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the ExpirationTimestamp property.
     *
     * @param value
     * @return this instance
     */
    public OrderReference withExpirationTimestamp(final XMLGregorianCalendar value) {
        setExpirationTimestamp(value);
        return this;
    }

    /**
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
     * JSON fragment representation of this object
     *
     * @return JSON fragment for this object. Name for outer
     * object expected to be set by calling method. This fragment
     * returns inner properties representation only
     */
    @Deprecated
    public String toJSONFragment() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new JSONFragmentBuilder()).build();
    }
}