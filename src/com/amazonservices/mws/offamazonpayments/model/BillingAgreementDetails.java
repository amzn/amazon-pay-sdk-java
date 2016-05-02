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
 * <p>Java class for BillingAgreementDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BillingAgreementDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BillingAgreementLimits" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAgreementLimits" minOccurs="0"/>
 *         &lt;element name="Buyer" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Buyer"/>
 *         &lt;element name="SellerNote" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}String1024" minOccurs="0"/>
 *         &lt;element name="PlatformId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Destination" minOccurs="0"/>
 *         &lt;element name="BillingAddress" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAddress" minOccurs="0"/>
 *         &lt;element name="ReleaseEnvironment" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ReleaseEnvironment"/>
 *         &lt;element name="SellerBillingAgreementAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerBillingAgreementAttributes" minOccurs="0"/>
 *         &lt;element name="BillingAgreementStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAgreementStatus"/>
 *         &lt;element name="Constraints" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Constraints" minOccurs="0"/>
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ExpirationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="BillingAgreementConsent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="OrderLanguage" type="{http://www.w3.org/2001/XMLSchema}string"  minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreementDetails", propOrder = {
    "amazonBillingAgreementId",
    "billingAgreementLimits",
    "buyer",
    "sellerNote",
    "platformId",
    "destination",
    "billingAddress",
    "releaseEnvironment",
    "sellerBillingAgreementAttributes",
    "billingAgreementStatus",
    "constraints",
    "creationTimestamp",
    "expirationTimestamp",
    "billingAgreementConsent",
    "orderLanguage"
})
public class BillingAgreementDetails {

    @XmlElement(name = "AmazonBillingAgreementId", required = true)
    protected String amazonBillingAgreementId;
    @XmlElement(name = "BillingAgreementLimits")
    protected BillingAgreementLimits billingAgreementLimits;
    @XmlElement(name = "Buyer", required = true)
    protected Buyer buyer;
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
    @XmlElement(name = "SellerBillingAgreementAttributes")
    protected SellerBillingAgreementAttributes sellerBillingAgreementAttributes;
    @XmlElement(name = "BillingAgreementStatus", required = true)
    protected BillingAgreementStatus billingAgreementStatus;
    @XmlElement(name = "Constraints")
    protected Constraints constraints;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "ExpirationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationTimestamp;
    @XmlElement(name = "BillingAgreementConsent")
    protected Boolean billingAgreementConsent;
    @XmlElement(name = "OrderLanguage")
    protected String orderLanguage;
    

    /**
     * Default constructor
     * 
     */
    public BillingAgreementDetails() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public BillingAgreementDetails(final String amazonBillingAgreementId, final BillingAgreementLimits billingAgreementLimits, final Buyer buyer, final String sellerNote, final String platformId, final Destination destination, final BillingAddress billingAddress, final ReleaseEnvironment releaseEnvironment, final SellerBillingAgreementAttributes sellerBillingAgreementAttributes, final BillingAgreementStatus billingAgreementStatus, final Constraints constraints, final XMLGregorianCalendar creationTimestamp, final XMLGregorianCalendar expirationTimestamp, final Boolean billingAgreementConsent, final String orderLanguage) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        this.billingAgreementLimits = billingAgreementLimits;
        this.buyer = buyer;
        this.sellerNote = sellerNote;
        this.platformId = platformId;
        this.destination = destination;
        this.billingAddress = billingAddress;
        this.releaseEnvironment = releaseEnvironment;
        this.sellerBillingAgreementAttributes = sellerBillingAgreementAttributes;
        this.billingAgreementStatus = billingAgreementStatus;
        this.constraints = constraints;
        this.creationTimestamp = creationTimestamp;
        this.expirationTimestamp = expirationTimestamp;
        this.billingAgreementConsent = billingAgreementConsent;
        this.orderLanguage = orderLanguage;
    }

    /**
     * Gets the value of the amazonBillingAgreementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmazonBillingAgreementId() {
        return amazonBillingAgreementId;
    }

    /**
     * Sets the value of the amazonBillingAgreementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmazonBillingAgreementId(String value) {
        this.amazonBillingAgreementId = value;
    }

    public boolean isSetAmazonBillingAgreementId() {
        return (this.amazonBillingAgreementId!= null);
    }

    /**
     * Gets the value of the billingAgreementLimits property.
     * 
     * @return
     *     possible object is
     *     {@link BillingAgreementLimits }
     *     
     */
    public BillingAgreementLimits getBillingAgreementLimits() {
        return billingAgreementLimits;
    }

    /**
     * Sets the value of the billingAgreementLimits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAgreementLimits }
     *     
     */
    public void setBillingAgreementLimits(BillingAgreementLimits value) {
        this.billingAgreementLimits = value;
    }

    public boolean isSetBillingAgreementLimits() {
        return (this.billingAgreementLimits!= null);
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
     * Gets the value of the billingAgreementStatus property.
     * 
     * @return
     *     possible object is
     *     {@link BillingAgreementStatus }
     *     
     */
    public BillingAgreementStatus getBillingAgreementStatus() {
        return billingAgreementStatus;
    }

    /**
     * Sets the value of the billingAgreementStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAgreementStatus }
     *     
     */
    public void setBillingAgreementStatus(BillingAgreementStatus value) {
        this.billingAgreementStatus = value;
    }

    public boolean isSetBillingAgreementStatus() {
        return (this.billingAgreementStatus!= null);
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
     * Gets the value of the billingAgreementConsent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBillingAgreementConsent() {
        return billingAgreementConsent;
    }

    /**
     * Sets the value of the billingAgreementConsent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBillingAgreementConsent(Boolean value) {
        this.billingAgreementConsent = value;
    }

    public boolean isSetBillingAgreementConsent() {
        return (this.billingAgreementConsent!= null);
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
     * Sets the value of the AmazonBillingAgreementId property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withAmazonBillingAgreementId(String value) {
        setAmazonBillingAgreementId(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementLimits property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withBillingAgreementLimits(BillingAgreementLimits value) {
        setBillingAgreementLimits(value);
        return this;
    }

    /**
     * Sets the value of the Buyer property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withBuyer(Buyer value) {
        setBuyer(value);
        return this;
    }

    /**
     * Sets the value of the SellerNote property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withSellerNote(String value) {
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
    public BillingAgreementDetails withPlatformId(String value) {
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
    public BillingAgreementDetails withDestination(Destination value) {
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
    public BillingAgreementDetails withBillingAddress(BillingAddress value) {
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
    public BillingAgreementDetails withReleaseEnvironment(ReleaseEnvironment value) {
        setReleaseEnvironment(value);
        return this;
    }

    /**
     * Sets the value of the SellerBillingAgreementAttributes property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withSellerBillingAgreementAttributes(SellerBillingAgreementAttributes value) {
        setSellerBillingAgreementAttributes(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementStatus property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withBillingAgreementStatus(BillingAgreementStatus value) {
        setBillingAgreementStatus(value);
        return this;
    }

    /**
     * Sets the value of the Constraints property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withConstraints(Constraints value) {
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
    public BillingAgreementDetails withCreationTimestamp(XMLGregorianCalendar value) {
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
    public BillingAgreementDetails withExpirationTimestamp(XMLGregorianCalendar value) {
        setExpirationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementConsent property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withBillingAgreementConsent(Boolean value) {
        setBillingAgreementConsent(value);
        return this;
    }
    
    /**
     * Sets the value of the OrderLanguage property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreementDetails withOrderLanguage(String value) {
        setOrderLanguage(value);
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