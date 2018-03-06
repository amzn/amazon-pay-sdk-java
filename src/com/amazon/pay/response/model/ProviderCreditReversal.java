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
@XmlType(name = "ProviderCreditReversal", propOrder = {
    "providerId",
    "creditReversalAmount"
})
public class ProviderCreditReversal {

    @XmlElement(name = "ProviderId", required = true)
    protected String providerId;
    @XmlElement(name = "CreditReversalAmount", required = true)
    protected Price creditReversalAmount;

    /**
     * Default constructor
     * 
     */
    public ProviderCreditReversal() {
        super();
    }

    /**
     * Value constructor
     * @param creditReversalAmount The Credit Reversal Amount
     *
     * @param providerId The Provider ID
     * 
     */
    public ProviderCreditReversal(final String providerId, final Price creditReversalAmount) {
        this.providerId = providerId;
        this.creditReversalAmount = creditReversalAmount;
    }

    /**
     * @return the providerId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * @return the Credit Reversal Amount
     */
    public Price getCreditReversalAmount() {
        return creditReversalAmount;
    }

    /**
     * Returns the string representation of GetServiceStatusResult
     */
    @Override
    public String toString() {
        return "ProviderCreditReversal{" + "providerId=" + providerId + ", creditReversalAmount=" + creditReversalAmount.toString() + '}';
    }
}
