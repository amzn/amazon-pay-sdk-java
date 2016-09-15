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
 * The total amount of an order represented by an Order Reference object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderTotal", propOrder = {
    "currencyCode",
    "amount"
})
public class OrderTotal {

    @XmlElement(name = "CurrencyCode")
    protected String currencyCode;
    @XmlElement(name = "Amount")
    protected String amount;

    public OrderTotal() {
        super();
    }

    /**
     * A three-digit currency code, formatted based on the ISO 4217 standard. 
     * 
     * @return currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * The currency amount.
     * 
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "OrderTotal{" + "currencyCode=" + currencyCode + ", amount=" + amount + '}';
    }


}
