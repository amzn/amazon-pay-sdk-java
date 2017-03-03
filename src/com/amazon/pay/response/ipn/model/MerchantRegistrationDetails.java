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
package com.amazon.pay.response.ipn.model;

import com.amazon.pay.response.model.SolutionProviderOptions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MerchantRegistrationDetails", propOrder = { "sellerId", "type", "options" })
public class MerchantRegistrationDetails {

    @XmlElement(name = "SellerId", required = true)
    public String sellerId;
    @XmlElement(name = "Type", required = true)
    public String type;
    @XmlElement(name = "Options", required = true)
    public SolutionProviderOptions options;

    public MerchantRegistrationDetails() {
        super();
    }

    public MerchantRegistrationDetails(final String sellerId, final String type,
            final SolutionProviderOptions options) {
        this.sellerId = sellerId;
        this.type = type;
        this.options = options;
    }

    /**
     * Returns the sellerId from MerchantRegistrationDetails
     * 
     * @return  Returns the sellerId from MerchantRegistrationDetails
     */
    public String getSellerId() {
        return sellerId;
    }


    /**
     * Returns the type from MerchantRegistrationDetails
     * 
     * @return Returns the type from MerchantRegistrationDetails
     */
    public String getType() {
        return type;
    }


    /**
     * Returns the options from MerchantRegistrationDetails
     * 
     * @return Returns the options from MerchantRegistrationDetails
     */
    public SolutionProviderOptions getOptions() {
        return options;
    }

    /**
     * Returns the string representation of MerchantRegistrationDetails
     * 
     * @return Returns the string representation of MerchantRegistrationDetails
     */
    @Override
    public String toString() {
        return "MerchantRegistrationDetails{" + "sellerId=" + sellerId + ", type=" + type + ", options=" 
                + options.toString() + '}';
    }


}
