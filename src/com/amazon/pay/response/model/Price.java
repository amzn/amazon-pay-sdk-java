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
 * Currency type and amount.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Price", propOrder = {
    "amount",
    "currencyCode"
})
public class Price {

    @XmlElement(name = "Amount", required = true)
    protected String amount;
    @XmlElement(name = "CurrencyCode", required = true)
    protected String currencyCode;

    public Price() {
        super();
    }

    public Price(String amount , String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }
    /**
     * The currency amount. The number of decimal places must be appropriate 
     * for the currency code specified. A period is the only valid decimal 
     * separator for the amount value.
     * 
     * @return amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Three-digit currency code. In ISO 4217 format.
     * 
     * @return currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public String toString() {
        return "Price{" + "amount=" + amount + ", currencyCode=" + currencyCode + '}';
    }


}
