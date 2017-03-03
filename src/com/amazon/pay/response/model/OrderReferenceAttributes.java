/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.response.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
* The merchant-specified attributes of an Order Reference object.
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderReferenceAttributes", propOrder = {
    "orderTotal",
    "platformId",
    "sellerNote",
    "sellerOrderAttributes"
})
public class OrderReferenceAttributes {

    @XmlElement(name = "OrderTotal", required = true)
    protected OrderTotal orderTotal;
    
    @XmlElement(name = "PlatformId")
    protected String platformId;

    @XmlElement(name = "SellerNote")
    protected String sellerNote;
    
    @XmlElement(name = "SellerOrderAttributes")
    protected SellerOrderAttributes sellerOrderAttributes;

    public OrderReferenceAttributes() {
        super();
    }

    /**
     * Specifies the total amount of the order represented by this order reference.
     * 
     * @return orderTotal
     */
    public OrderTotal getOrderTotal() {
        return orderTotal;
    }

    /**
     * Represents the SellerId of the Solution Provider that developed the platform. 
     * This value should only be provided by Solution Providers. It should not be 
     * provided by merchants creating their own custom integration.
     * 
     * @return platformId
     */
    public String getPlatformId() {
        return platformId;
    }


    /**
     * Represents a description of the order that is displayed in emails to the buyer.
     * 
     * @return sellerNote
     */
    public String getSellerNote() {
        return sellerNote;
    }

    /**
     * Provides more context about the order that is represented by this order reference.
     * 
     * @return sellerOrderAttributes
     */
    public SellerOrderAttributes getSellerOrderAttributes() {
        return sellerOrderAttributes;
    }

    @Override
    public String toString() {
        return "OrderReferenceAttributes{" + "orderTotal=" + orderTotal.toString() + ", platformId=" 
                + platformId + ", sellerNote=" + sellerNote + ", sellerOrderAttributes=" + sellerOrderAttributes.toString() + '}';
    }


 
}
