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
 * <p>Java class for Destination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Destination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DestinationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhysicalDestination" type="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}Address" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Destination", propOrder = {
    "destinationType",
    "physicalDestination"
})
public class Destination {

    @XmlElement(name = "DestinationType")
    protected String destinationType;
    @XmlElement(name = "PhysicalDestination")
    protected Address physicalDestination;

    /**
     * Default constructor
     * 
     */
    public Destination() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public Destination(final String destinationType, final Address physicalDestination) {
        this.destinationType = destinationType;
        this.physicalDestination = physicalDestination;
    }

    /**
     * Gets the value of the destinationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationType() {
        return destinationType;
    }

    /**
     * Sets the value of the destinationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationType(String value) {
        this.destinationType = value;
    }

    public boolean isSetDestinationType() {
        return (this.destinationType!= null);
    }

    /**
     * Gets the value of the physicalDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getPhysicalDestination() {
        return physicalDestination;
    }

    /**
     * Sets the value of the physicalDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setPhysicalDestination(Address value) {
        this.physicalDestination = value;
    }

    public boolean isSetPhysicalDestination() {
        return (this.physicalDestination!= null);
    }

    /**
     * Sets the value of the DestinationType property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Destination withDestinationType(String value) {
        setDestinationType(value);
        return this;
    }

    /**
     * Sets the value of the PhysicalDestination property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public Destination withPhysicalDestination(Address value) {
        setPhysicalDestination(value);
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
