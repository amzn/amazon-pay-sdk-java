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

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDescriptor", propOrder = {
        "name",
        "accountNumberTail",
        "useAmazonBalanceFirst"
})

public class PaymentDescriptor {
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "AccountNumberTail")
    protected String accountNumberTail;
    @XmlElement(name = "UseAmazonBalanceFirst")
    protected Boolean useAmazonBalanceFirst;

    public PaymentDescriptor() {
        super();
    }

    /**
     * @return The name or type of card.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The account number tail.
     */
    public String getAccountNumberTail() {
        return accountNumberTail;
    }

    /**
     * Indicates if Amazon Balance should be used
     * @return useAmazonBalanceFirst
     */
    public Boolean isUseAmazonBalanceFirst() {
        return useAmazonBalanceFirst;
    }

    @Override
    public String toString() {
        return "PaymentDescriptor{"
                + "name=" + name
                + ", accountNumberTail=" + accountNumberTail
                + ", useAmazonBalanceFirst=" + useAmazonBalanceFirst + '}';
    }
}
