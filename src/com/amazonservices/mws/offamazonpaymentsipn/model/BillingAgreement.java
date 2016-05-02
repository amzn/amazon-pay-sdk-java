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
 * <p>Java class for BillingAgreement complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BillingAgreement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AmazonBillingAgreementId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SellerBillingAgreementAttributes" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}SellerBillingAgreementAttributes" minOccurs="0"/>
 *         &lt;element name="BillingAgreementStatus" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAgreementStatus" />
 *         &lt;element name="CreationTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *         &lt;element name="BillingAgreementLimits" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}BillingAgreementLimits" />
 *         &lt;element name="BillingAgreementConsent" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BillingAgreement", propOrder = {
        "amazonBillingAgreementId",
        "sellerBillingAgreementAttributes",
        "billingAgreementStatus",
        "creationTimestamp",
        "billingAgreementLimits",
        "billingAgreementConsent"
})
@XmlRootElement(name = "BillingAgreement")
public class BillingAgreement {

    @XmlElement(name = "AmazonBillingAgreementId", required = true)
    protected String amazonBillingAgreementId;
    @XmlElement(name = "SellerBillingAgreementAttributes")
    protected SellerBillingAgreementAttributes sellerBillingAgreementAttributes;
    @XmlElement(name = "BillingAgreementStatus", required = true)
    protected BillingAgreementStatus billingAgreementStatus;
    @XmlElement(name = "CreationTimestamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTimestamp;
    @XmlElement(name = "BillingAgreementLimits", required = true)
    protected  BillingAgreementLimits billingAgreementLimits;
    @XmlElement(name = "BillingAgreementConsent", required = true)
    protected boolean billingAgreementConsent;

    /**
     * Default constructor
     *
     */
    public BillingAgreement() {
        super();
    }

    /**
     * Value constructor
     *
     */
    public BillingAgreement(final String amazonBillingAgreementId, final SellerBillingAgreementAttributes sellerBillingAgreementAttributes, final BillingAgreementStatus billingAgreementStatus, final XMLGregorianCalendar creationTimestamp, final BillingAgreementLimits billingAgreementLimits, final boolean billingAgreementConsent) {
        this.amazonBillingAgreementId = amazonBillingAgreementId;
        this.sellerBillingAgreementAttributes = sellerBillingAgreementAttributes;
        this.billingAgreementStatus = billingAgreementStatus;
        this.creationTimestamp = creationTimestamp;
        this.billingAgreementLimits = billingAgreementLimits;
        this.billingAgreementConsent = billingAgreementConsent;
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
        return this.amazonBillingAgreementId;
    }

    /**
     * Sets the value of the amazonBillingAgreementId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAmazonBillingAgreementId(final String value) {
        this.amazonBillingAgreementId = value;
    }

    public boolean isSetAmazonBillingAgreementId() {
        return (this.amazonBillingAgreementId != null);
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
        return this.sellerBillingAgreementAttributes;
    }

    /**
     * Sets the value of the sellerBillingAgreementAttributes property.
     *
     * @param value
     *     allowed object is
     *     {@link SellerBillingAgreementAttributes }
     *
     */
    public void setSellerBillingAgreementAttributes(final SellerBillingAgreementAttributes value) {
        this.sellerBillingAgreementAttributes = value;
    }

    public boolean isSetSellerBillingAgreementAttributes() {
        return (this.sellerBillingAgreementAttributes != null);
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
        return this.billingAgreementStatus;
    }

    /**
     * Sets the value of the billingAgreementStatus property.
     *
     * @param value
     *     allowed object is
     *     {@link BillingAgreementStatus }
     *
     */
    public void setBillingAgreementStatus(final BillingAgreementStatus value) {
        this.billingAgreementStatus = value;
    }

    public boolean isSetBillingAgreementStatus() {
        return (this.billingAgreementStatus != null);
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
        return this.creationTimestamp;
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
     * Gets the value of the billingAgreementLimits property.
     *
     * @return
     *     possible object is
     *     {@link BillingAgreementLimits }
     *
     */
    public BillingAgreementLimits getBillingAgreementLimits() {
        return this.billingAgreementLimits;
    }

    /**
     * Sets the value of the billingAgreementLimits property.
     *
     * @param value
     *     allowed object is
     *     {@link BillingAgreementLimits }
     *
     */
    public void setBillingAgreementLimits(final BillingAgreementLimits value) {
        this.billingAgreementLimits = value;
    }

    public boolean isSetBillingAgreementLimits() {
        return (this.billingAgreementLimits != null);
    }

    /**
     * Gets the value of the billingAgreementConsent property.
     *
     * @return
     *     possible object is
     *     {@link boolean }
     *
     */
    public boolean getBillingAgreementConsent() {
        return this.billingAgreementConsent;
    }

    /**
     * Sets the value of the billingAgreementConsent property.
     *
     * @param value
     *     allowed object is
     *     {@link boolean }
     *
     */
    public void setBillingAgreementConsent(final boolean value) {
        this.billingAgreementConsent = value;
    }

    public boolean isBillingAgreementConsent() {
        return true;
    }

    /**
     * Sets the value of the AmazonBillingAgreementId property.
     *
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreement withAmazonBillingAgreementId(final String value) {
        setAmazonBillingAgreementId(value);
        return this;
    }

    /**
     * Sets the value of the SellerBillingAgreementAttributes property.
     *
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreement withSellerBillingAgreementAttributes(final SellerBillingAgreementAttributes value) {
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
    public BillingAgreement withBillingAgreementStatus(final BillingAgreementStatus value) {
        setBillingAgreementStatus(value);
        return this;
    }

    /**
     * Sets the value of the CreationTimestamp property.
     *
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreement withCreationTimestamp(final XMLGregorianCalendar value) {
        setCreationTimestamp(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementLimits property.
     *
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreement withAmazonAuthorizationId(final BillingAgreementLimits value) {
        setBillingAgreementLimits(value);
        return this;
    }

    /**
     * Sets the value of the BillingAgreementConsent property.
     *
     * @param value
     * @return
     *     this instance
     */
    public BillingAgreement withAmazonAuthorizationId(final boolean value) {
        setBillingAgreementConsent(value);
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
