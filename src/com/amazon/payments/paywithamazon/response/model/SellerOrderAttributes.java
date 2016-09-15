/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.response.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Provides more context about an order that is represented by an Order Reference object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerOrderAttributes", propOrder = {
    "sellerOrderId",
    "storeName",
    "orderItemCategories",
    "customInformation"
})
public class SellerOrderAttributes {

    @XmlElement(name = "SellerOrderId")
    protected String sellerOrderId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "OrderItemCategories")
    protected OrderItemCategories orderItemCategories;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    public SellerOrderAttributes() {
        super();
    }


    /**
     * The merchant-specified identifier of this order. This is displayed to the 
     * buyer in their emails and transaction history on the Amazon Payments website.
     * 
     * @return sellerOrderId
     */
    public String getSellerOrderId() {
        return sellerOrderId;
    }


    /**
     * The identifier of the store from which the order was placed. This overrides 
     * the default value in Seller Central under Settings > Account Settings. 
     * It is displayed to the buyer in their emails and transaction history 
     * on the Amazon Payments website.
     * 
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }


    /**
     * 
     * @return orderItemCategories
     */
    public OrderItemCategories getOrderItemCategories() {
        return orderItemCategories;
    }


    /**
     * Any additional information that you want to include with this order reference.
     * 
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Returns string representation of SellerOrderAttributes
     */
    @Override
    public String toString() {
        return "SellerOrderAttributes{" + "sellerOrderId=" + sellerOrderId + ", storeName=" + storeName + ", orderItemCategories=" 
                + orderItemCategories.toString() + ", customInformation=" + customInformation + '}';
    }

}
