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
 * Provides more context about an agreement that is represented by a Billing Agreement object.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SellerBillingAgreementAttributes", propOrder = {
    "sellerBillingAgreementId",
    "storeName",
    "customInformation"
})
public class SellerBillingAgreementAttributes {

    @XmlElement(name = "SellerBillingAgreementId")
    protected String sellerBillingAgreementId;
    @XmlElement(name = "StoreName")
    protected String storeName;
    @XmlElement(name = "CustomInformation")
    protected String customInformation;

    public SellerBillingAgreementAttributes() {
        super();
    }

    /**
     * The merchant-specified identifier of this billing agreement.
     * 
     * @return sellerBillingAgreementId
     */
    public String getSellerBillingAgreementId() {
        return sellerBillingAgreementId;
    }


    /**
     * The identifier of the store from which the order was placed. This 
     * overrides the default value in Seller Central under Settings > Account Settings.
     * It is displayed to the buyer in their emails and transaction history on the Amazon Payments website.
     * 
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }


    /**
     * Any additional information that you wish to include with this billing agreement.
     * 
     * @return customInformation
     */
    public String getCustomInformation() {
        return customInformation;
    }

    /**
     * Returns the string representation of SellerBillingAgreementAttributes
     */
    @Override
    public String toString() {
        return "SellerBillingAgreementAttributes{" + "sellerBillingAgreementId=" + sellerBillingAgreementId + ", storeName=" + storeName + ", customInformation=" + customInformation + '}';
    }


 
 
}
