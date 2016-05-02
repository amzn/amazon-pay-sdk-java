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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OrderReferenceDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderReferenceDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonOrderReferenceId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Buyer" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Buyer"/>
 *         &lt;element name="OrderTotal" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderTotal" minOccurs="0"/>
 *         &lt;element name="SellerNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String1024" minOccurs="0"/>
 *         &lt;element name="PlatformId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Destination" minOccurs="0"/>
 *         &lt;element name="BillingAddress" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAddress" minOccurs="0"/>
 *         &lt;element name="ReleaseEnvironment" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ReleaseEnvironment"/>
 *         &lt;element name="SellerOrderAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerOrderAttributes" minOccurs="0"/>
 *         &lt;element name="OrderReferenceStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}OrderReferenceStatus"/>
 *         &lt;element name="Constraints" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Constraints" minOccurs="0"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpirationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ParentDetails" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ParentDetails" minOccurs="0"/>
 *         &lt;element name="IdList" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}IdList" minOccurs="0"/>
 *         &lt;element name="OrderLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RequestPaymentAuthorization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReferenceDetails", propOrder = {
    "amazonOrderReferenceId",
    "buyer",
    "orderTotal",
    "sellerNote",
    "platformId",
    "destination",
    "billingAddress",
    "releaseEnvironment",
    "sellerOrderAttributes",
    "orderReferenceStatus",
    "constraints",
    "creationTimestamp",
    "expirationTimestamp",
    "parentDetails",
    "idList",
    "orderLanguage",
    "requestPaymentAuthorization"
})
public class OrderReferenceDetails {

    @XmlElement(name = "AmazonOrderReferenceId", required = true)
    protected String amazonOrderReferenceId;
    @XmlElement(name = "Buyer", required = true)
    protected Buyer buyer;
    @XmlElement(name = "OrderTotal")
    protected OrderTotal orderTotal;
    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    @XmlElement(name = "PlatformId")
    protected String platformId;
    @XmlElement(name = "Destination")
    protected Destination destination;
    @XmlElement(name = "BillingAddress")
    protected BillingAddress billingAddress;
    @XmlElement(name = "ReleaseEnvironment", required = true)
    protected ReleaseEnvironment releaseEnvironment;
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;
    @XmlElement(name = "OrderReferenceStatus", required = true)
    protected OrderReferenceStatus orderReferenceStatus;
    @XmlElement(name = "Constraints")
    protected Constraints constraints;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;
    @XmlElement(name = "ParentDetails")
    protected ParentDetails parentDetails;
    @XmlElement(name = "IdList")
    protected IdList idList;
    @XmlElement(name = "OrderLanguage")
    protected String orderLanguage;
    @XmlElement(name = "RequestPaymentAuthorization")
    protected boolean requestPaymentAuthorization;
    /**
     * Default constructor
     * 
     */
    public OrderReferenceDetails() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public OrderReferenceDetails(final String amazonOrderReferenceId, final Buyer buyer, final OrderTotal orderTotal, final String sellerNote, final String platformId, final Destination destination, final BillingAddress billingAddress, final ReleaseEnvironment releaseEnvironment, final SellerOrderAttributes sellerOrderAttributes, final OrderReferenceStatus orderReferenceStatus, final Constraints constraints, final XMLGregorianCalendar creationTimestamp, final XMLGregorianCalendar expirationTimestamp, final ParentDetails parentDetails, final IdList idList, final String orderLanguage, final boolean requestPaymentAuthorization) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
        this.buyer = buyer;
        this.orderTotal = orderTotal;
        this.sellerNote = sellerNote;
        this.platformId = platformId;
        this.destination = destination;
        this.billingAddress = billingAddress;
        this.releaseEnvironment = releaseEnvironment;
        this.sellerOrderAttributes = sellerOrderAttributes;
        this.orderReferenceStatus = orderReferenceStatus;
        this.constraints = constraints;
        this.creationTimestamp = creationTimestamp;
        this.expirationTimestamp = expirationTimestamp;
        this.parentDetails = parentDetails;
        this.idList = idList;
        this.orderLanguage = orderLanguage;
        this.requestPaymentAuthorization = requestPaymentAuthorization;
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
     * Gets the value of the buyer property.
     * 
     * @return
     *     possible object is
     *     {@link Buyer }
     *     
     */
    public Buyer getBuyer() {
        return buyer;
    }

    /**
     * Sets the value of the buyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Buyer }
     *     
     */
    public void setBuyer(Buyer value) {
        this.buyer = value;
    }

    public boolean isSetBuyer() {
        return (this.buyer!= null);
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
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Destination }
     *     
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destination }
     *     
     */
    public void setDestination(Destination value) {
        this.destination = value;
    }

    public boolean isSetDestination() {
        return (this.destination!= null);
    }
    
    /**
     * Gets the value of the billingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link BillingAddress }
     *     
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets the value of the billingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAddress }
     *     
     */
    public void setBillingAddress(BillingAddress value) {
        this.billingAddress = value;
    }

    public boolean isSetBillingAddress() {
        return (this.billingAddress!= null);
    }


    /**
     * Gets the value of the releaseEnvironment property.
     * 
     * @return
     *     possible object is
     *     {@link ReleaseEnvironment }
     *     
     */
    public ReleaseEnvironment getReleaseEnvironment() {
        return releaseEnvironment;
    }

    /**
     * Sets the value of the releaseEnvironment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReleaseEnvironment }
     *     
     */
    public void setReleaseEnvironment(ReleaseEnvironment value) {
        this.releaseEnvironment = value;
    }

    public boolean isSetReleaseEnvironment() {
        return (this.releaseEnvironment!= null);
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
     * Gets the value of the orderReferenceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OrderReferenceStatus }
     *     
     */
    public OrderReferenceStatus getOrderReferenceStatus() {
        return orderReferenceStatus;
    }

    /**
     * Sets the value of the orderReferenceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderReferenceStatus }
     *     
     */
    public void setOrderReferenceStatus(OrderReferenceStatus value) {
        this.orderReferenceStatus = value;
    }

    public boolean isSetOrderReferenceStatus() {
        return (this.orderReferenceStatus!= null);
    }

    /**
     * Gets the value of the constraints property.
     * 
     * @return
     *     possible object is
     *     {@link Constraints }
     *     
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * Sets the value of the constraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Constraints }
     *     
     */
    public void setConstraints(Constraints value) {
        this.constraints = value;
    }

    public boolean isSetConstraints() {
        return (this.constraints!= null);
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
    public void setCreationTimestamp(XMLGregorianCalendar value) {
        this.creationTimestamp = value;
    }

    public boolean isSetCreationTimestamp() {
        return (this.creationTimestamp!= null);
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
    public void setExpirationTimestamp(XMLGregorianCalendar value) {
        this.expirationTimestamp = value;
    }

    public boolean isSetExpirationTimestamp() {
        return (this.expirationTimestamp!= null);
    }

    /**
     * Gets the value of the parentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ParentDetails }
     *     
     */
    public ParentDetails getParentDetails() {
        return parentDetails;
    }

    /**
     * Sets the value of the parentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParentDetails }
     *     
     */
    public void setParentDetails(ParentDetails value) {
        this.parentDetails = value;
    }

    public boolean isSetParentDetails() {
        return (this.parentDetails!= null);
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
    public void setIdList(IdList value) {
        this.idList = value;
    }

    public boolean isSetIdList() {
        return (this.idList!= null);
    }
    
    /**
     * Gets the value of the OrderLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderLanguage() {
        return orderLanguage;
    }

    /**
     * Sets the value of the OrderLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderLanguage(String value) {
        this.orderLanguage = value;
    }

    public boolean isSetOrderLanguage() {
        return (this.orderLanguage!= null);
    }
    
    /**
     * Gets the value of the RequestPaymentAuthorization property.
     * 
     * @return
     *     possible object is
     *     {@link boolean }
     *     
     */
    public boolean isRequestPaymentAuthorization() {
        return requestPaymentAuthorization;
    }

    /**
     * Sets the value of the RequestPaymentAuthorization property.
     * 
     * @param value
     *     allowed object is
     *     {@link boolean }
     *     
     */
    public void setRequestPaymentAuthorization(boolean value) {
        this.requestPaymentAuthorization = value;
    }

    /**
     * Sets the value of the AmazonOrderReferenceId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withAmazonOrderReferenceId(String value) {
        setAmazonOrderReferenceId(value);
        return this;
    }

    /**
     * Sets the value of the Buyer property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withBuyer(Buyer value) {
        setBuyer(value);
        return this;
    }

    /**
     * Sets the value of the OrderTotal property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withOrderTotal(OrderTotal value) {
        setOrderTotal(value);
        return this;
    }

    /**
     * Sets the value of the SellerNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withSellerNote(String value) {
        setSellerNote(value);
        return this;
    }

    /**
     * Sets the value of the PlatformId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withPlatformId(String value) {
        setPlatformId(value);
        return this;
    }

    /**
     * Sets the value of the Destination property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withDestination(Destination value) {
        setDestination(value);
        return this;
    }

    /**
     * Sets the value of the BillingAddress property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withBillingAddress(BillingAddress value) {
        setBillingAddress(value);
        return this;
    }

    /**
     * Sets the value of the ReleaseEnvironment property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withReleaseEnvironment(ReleaseEnvironment value) {
        setReleaseEnvironment(value);
        return this;
    }

    /**
     * Sets the value of the SellerOrderAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withSellerOrderAttributes(SellerOrderAttributes value) {
        setSellerOrderAttributes(value);
        return this;
    }

    /**
     * Sets the value of the OrderReferenceStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withOrderReferenceStatus(OrderReferenceStatus value) {
        setOrderReferenceStatus(value);
        return this;
    }

    /**
     * Sets the value of the Constraints property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withConstraints(Constraints value) {
        setConstraints(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withCreationTimestamp(XMLGregorianCalendar value) {
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
    public OrderReferenceDetails withExpirationTimestamp(XMLGregorianCalendar value) {
        setExpirationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the ParentDetails property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withParentDetails(ParentDetails value) {
        setParentDetails(value);
        return this;
    }
    
    /**
     * Sets the value of the IdList property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withIdList(IdList value) {
        setIdList(value);
        return this;
    }

    /**
     * Sets the value of the OrderLanguage property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withOrderLanguage(String value) {
        setOrderLanguage(value);
        return this;
    }
    
    /**
     * Sets the value of the RequestPaymentAuthorization property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public OrderReferenceDetails withRequestPaymentAuthorization(boolean value) {
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
