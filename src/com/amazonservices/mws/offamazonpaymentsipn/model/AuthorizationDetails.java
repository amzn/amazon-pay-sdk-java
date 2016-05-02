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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for AuthorizationDetails complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AuthorizationDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonAuthorizationId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorizationReferenceId" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String32"/>
 *         &lt;element name="AuthorizationAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="CapturedAmount" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="AuthorizationFee" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Price"/>
 *         &lt;element name="IdList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}IdList"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpirationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="AddressVerificationCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AuthorizationStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Status"/>
 *         &lt;element name="OrderItemCategories" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderItemCategories"/>
 *         &lt;element name="CaptureNow" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SoftDescriptor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuthorizationDetails", propOrder = {
        "amazonAuthorizationId",
        "authorizationReferenceId",
        "authorizationAmount",
        "capturedAmount",
        "authorizationFee",
        "idList",
        "creationTimestamp",
        "expirationTimestamp",
        "addressVerificationCode",
        "authorizationStatus",
        "orderItemCategories",
        "captureNow",
        "softDescriptor",
        "softDecline"
})
@XmlRootElement(name = "AuthorizationDetails")
public class AuthorizationDetails {

    @XmlElement(name = "AmazonAuthorizationId", required = true)
    protected String amazonAuthorizationId;
    @XmlElement(name = "AuthorizationReferenceId", required = true)
    protected String authorizationReferenceId;
    @XmlElement(name = "AuthorizationAmount", required = true)
    public Price authorizationAmount;
    @XmlElement(name = "CapturedAmount", required = true)
    public Price capturedAmount;
    @XmlElement(name = "AuthorizationFee", required = true)
    public  Price authorizationFee;
    @XmlElement(name = "IdList", required = true)
    protected IdList idList;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;    
    @XmlElement(name = "AddressVerificationCode")
    protected String addressVerificationCode;
    @XmlElement(name = "AuthorizationStatus", required = true)
    protected Status authorizationStatus;
    @XmlElement(name = "OrderItemCategories", required = true)
    protected OrderItemCategories orderItemCategories;
    @XmlElement(name = "CaptureNow")
    protected boolean captureNow;
    @XmlElement(name = "SoftDescriptor", required = true)
    protected String softDescriptor;
    @XmlElement(name = "SoftDecline", required = true)
    protected boolean softDecline;
    /**
     * Default constructor
     *
     */
    public AuthorizationDetails() {
        super();
    }

    /**
     * Value constructor
     *
     */
    public AuthorizationDetails(final String amazonAuthorizationId, final String authorizationReferenceId, final Price authorizationAmount, final Price capturedAmount, final Price authorizationFee, final IdList idList, final XMLGregorianCalendar creationTimestamp, final XMLGregorianCalendar expirationTimestamp, final String addressVerificationCode, final Status authorizationStatus, final OrderItemCategories orderItemCategories, final boolean captureNow, final String softDescriptor, final boolean softDecline) {
        this.amazonAuthorizationId = amazonAuthorizationId;
        this.authorizationReferenceId = authorizationReferenceId;
        this.authorizationAmount = authorizationAmount;
        this.capturedAmount = capturedAmount;
        this.authorizationFee = authorizationFee;
        this.idList = idList;
        this.creationTimestamp = creationTimestamp;
        this.expirationTimestamp = expirationTimestamp;
        this.addressVerificationCode = addressVerificationCode;
        this.authorizationStatus = authorizationStatus;
        this.orderItemCategories = orderItemCategories;
        this.captureNow = captureNow;
        this.softDescriptor = softDescriptor;
        this.softDecline = softDecline;
    }

    /**
     * Gets the value of the amazonAuthorizationId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
     * Sets the value of the amazonAuthorizationId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmazonAuthorizationId(final String value) {
        this.amazonAuthorizationId = value;
    }

    public boolean isSetAmazonAuthorizationId() {
        return (this.amazonAuthorizationId != null);
    }

    /**
     * Gets the value of the authorizationReferenceId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAuthorizationReferenceId() {
        return authorizationReferenceId;
    }

    /**
     * Sets the value of the authorizationReferenceId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAuthorizationReferenceId(final String value) {
        this.authorizationReferenceId = value;
    }

    public boolean isSetAuthorizationReferenceId() {
        return (this.authorizationReferenceId != null);
    }

    /**
     * Gets the value of the authorizationAmount property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getAuthorizationAmount() {
        return authorizationAmount;
    }

    /**
     * Sets the value of the authorizationAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setAuthorizationAmount(final Price value) {
        this.authorizationAmount = value;
    }

    public boolean isSetAuthorizationAmount() {
        return (this.authorizationAmount != null);
    }

    /**
     * Gets the value of the capturedAmount property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getCapturedAmount() {
        return capturedAmount;
    }

    /**
     * Sets the value of the capturedAmount property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setCapturedAmount(final Price value) {
        this.capturedAmount = value;
    }

    public boolean isSetCapturedAmount() {
        return (this.capturedAmount != null);
    }

    /**
     * Gets the value of the authorizationFee property.
     *
     * @return
     *     possible object is
     *     {@link Price }
     *
     */
    public Price getAuthorizationFee() {
        return authorizationFee;
    }

    /**
     * Sets the value of the authorizationFee property.
     *
     * @param value
     *     allowed object is
     *     {@link Price }
     *
     */
    public void setAuthorizationFee(final Price value) {
        this.authorizationFee = value;
    }

    public boolean isSetAuthorizationFee() {
        return (this.authorizationFee != null);
    }

    /**
     * Gets the value of the idList property.
     *
     * @return
     *     possible object is
     *     {@link IdList }
     *
     */
    public IdList getIdList() {
        return idList;
    }

    /**
     * Sets the value of the idList property.
     *
     * @param value
     *     allowed object is
     *     {@link IdList }
     *
     */
    public void setIdList(final IdList value) {
        this.idList = value;
    }

    public boolean isSetIdList() {
        return (this.idList != null);
    }

    /**
     * Gets the value of the creationTimestamp property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Sets the value of the creationTimestamp property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
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
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     * Sets the value of the expirationTimestamp property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setExpirationTimestamp(final XMLGregorianCalendar value) {
        this.expirationTimestamp = value;
    }

    public boolean isSetExpirationTimestamp() {
        return (this.expirationTimestamp != null);
    }

    /**
     * Gets the value of the addressVerificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressVerificationCode() {
        return addressVerificationCode;
    }

    /**
     * Sets the value of the addressVerificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressVerificationCode(String value) {
        this.addressVerificationCode = value;
    }

    public boolean isSetAddressVerificationCode() {
        return (this.addressVerificationCode!= null);
    }
    
    /**
     * Gets the value of the authorizationStatus property.
     *
     * @return
     *     possible object is
     *     {@link Status }
     *
     */
    public Status getAuthorizationStatus() {
        return authorizationStatus;
    }

    /**
     * Sets the value of the authorizationStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link Status }
     *
     */
    public void setAuthorizationStatus(final Status value) {
        this.authorizationStatus = value;
    }

    public boolean isSetAuthorizationStatus() {
        return (this.authorizationStatus != null);
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
    public void setOrderItemCategories(final OrderItemCategories value) {
        this.orderItemCategories = value;
    }

    public boolean isSetOrderItemCategories() {
        return (this.orderItemCategories != null);
    }

    /**
     * Gets the value of the captureNow property.
     *
     */
    public boolean isCaptureNow() {
        return captureNow;
    }

    /**
     * Sets the value of the captureNow property.
     *
     */
    public void setCaptureNow(final boolean value) {
        this.captureNow = value;
    }

    public boolean isSetCaptureNow() {
        return true;
    }

    /**
     * Gets the value of the softDescriptor property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSoftDescriptor() {
        return softDescriptor;
    }

    /**
     * Sets the value of the softDescriptor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSoftDescriptor(final String value) {
        this.softDescriptor = value;
    }

    public boolean isSetSoftDescriptor() {
        return (this.softDescriptor != null);
    }

   
    public boolean isSoftDecline() {
        return softDecline;
    }
    
    /**
     * Sets the value of the softDecline property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSoftDecline(boolean softDecline) {
        this.softDecline = softDecline;
    }
    
    public boolean isSetSoftDecline() {
        return true;
    }

    /**
     * Sets the value of the AmazonAuthorizationId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAmazonAuthorizationId(final String value) {
        setAmazonAuthorizationId(value);
        return this;
    }

    /**
     * Sets the value of the AuthorizationReferenceId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAuthorizationReferenceId(final String value) {
        setAuthorizationReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the AuthorizationAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAuthorizationAmount(final Price value) {
        setAuthorizationAmount(value);
        return this;
    }

    /**
     * Sets the value of the CapturedAmount property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withCapturedAmount(final Price value) {
        setCapturedAmount(value);
        return this;
    }

    /**
     * Sets the value of the AuthorizationFee property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAuthorizationFee(final Price value) {
        setAuthorizationFee(value);
        return this;
    }

    /**
     * Sets the value of the IdList property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withIdList(final IdList value) {
        setIdList(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the ExpirationTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withExpirationTimestamp(final XMLGregorianCalendar value) {
        setExpirationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the AddressVerificationCode property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAddressVerificationCode(String value) {
        setAddressVerificationCode(value);
        return this;
    }
    
    /**
     * Sets the value of the AuthorizationStatus property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withAuthorizationStatus(final Status value) {
        setAuthorizationStatus(value);
        return this;
    }

    /**
     * Sets the value of the OrderItemCategories property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withOrderItemCategories(final OrderItemCategories value) {
        setOrderItemCategories(value);
        return this;
    }

    /**
     * Sets the value of the CaptureNow property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withCaptureNow(final boolean value) {
        setCaptureNow(value);
        return this;
    }

    /**
     * Sets the value of the SoftDescriptor property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withSoftDescriptor(final String value) {
        setSoftDescriptor(value);
        return this;
    }
    
    /**
     * Sets the value of the SoftDecline property.
     *
     * @param value
     * @return
     *     this instance
     */
    public AuthorizationDetails withSoftDecline(final boolean value) {
        setSoftDecline(value);
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
