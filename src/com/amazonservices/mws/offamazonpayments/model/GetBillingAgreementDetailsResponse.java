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
 *         &lt;element ref="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}GetBillingAgreementDetailsResult"/>
 *         &lt;element ref="{http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01}ResponseMetadata"/>
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
    "getBillingAgreementDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetBillingAgreementDetailsResponse")
public class GetBillingAgreementDetailsResponse {

    @XmlElement(name = "GetBillingAgreementDetailsResult", required = true)
    protected GetBillingAgreementDetailsResult getBillingAgreementDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    /**
     * Default constructor
     * 
     */
    public GetBillingAgreementDetailsResponse() {
        super();
    }

    /**
     * Value constructor
     * 
     */
    public GetBillingAgreementDetailsResponse(final GetBillingAgreementDetailsResult getBillingAgreementDetailsResult, final ResponseMetadata responseMetadata) {
        this.getBillingAgreementDetailsResult = getBillingAgreementDetailsResult;
        this.responseMetadata = responseMetadata;
    }

    /**
     * Gets the value of the getBillingAgreementDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetBillingAgreementDetailsResult }
     *     
     */
    public GetBillingAgreementDetailsResult getGetBillingAgreementDetailsResult() {
        return getBillingAgreementDetailsResult;
    }

    /**
     * Sets the value of the getBillingAgreementDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBillingAgreementDetailsResult }
     *     
     */
    public void setGetBillingAgreementDetailsResult(GetBillingAgreementDetailsResult value) {
        this.getBillingAgreementDetailsResult = value;
    }

    public boolean isSetGetBillingAgreementDetailsResult() {
        return (this.getBillingAgreementDetailsResult!= null);
    }

    /**
     * Gets the value of the responseMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseMetadata }
     *     
     */
    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

    /**
     * Sets the value of the responseMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseMetadata }
     *     
     */
    public void setResponseMetadata(ResponseMetadata value) {
        this.responseMetadata = value;
    }

    public boolean isSetResponseMetadata() {
        return (this.responseMetadata!= null);
    }

    /**
     * Sets the value of the GetBillingAgreementDetailsResult property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetBillingAgreementDetailsResponse withGetBillingAgreementDetailsResult(GetBillingAgreementDetailsResult value) {
        setGetBillingAgreementDetailsResult(value);
        return this;
    }

    /**
     * Sets the value of the ResponseMetadata property.
     * 
     * @param value
     * @return
     *     this instance
     */
    public GetBillingAgreementDetailsResponse withResponseMetadata(ResponseMetadata value) {
        setResponseMetadata(value);
        return this;
    }
    

    @javax.xml.bind.annotation.XmlTransient
    private ResponseHeaderMetadata responseHeaderMetadata;


    /**
     * Checks whether the ResponseHeaderMetadata field has been set.
     */
    public boolean isSetResponseHeaderMetadata() { 
        return this.responseHeaderMetadata != null;
    }  


    /**
     * Sets the ResponseHeaderMetadata field.
     */
    public void setResponseHeaderMetadata(ResponseHeaderMetadata responseHeaderMetadata) { 
        this.responseHeaderMetadata = responseHeaderMetadata;
    } 


    /**
     * Gets the ResponseHeaderMetadata field.
     */
    public ResponseHeaderMetadata getResponseHeaderMetadata() {  
        return responseHeaderMetadata;
    }


    /**
     *
     * XML string representation of this object
     *
     * @return XML String
     */
    @Deprecated
    public String toXML() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new XmlFragmentBuilder()).withHeaders().build();
    }

    /**
     *
     * JSON string representation of this object
     *
     * @return JSON String
     */
    @Deprecated
    public String toJSON() throws OffAmazonPaymentsServiceException {
        return new ReflectionFragmentBuilder(this, new JSONFragmentBuilder()).withHeaders().build();
    }
}
