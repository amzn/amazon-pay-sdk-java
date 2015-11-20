/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.response.ipn.model;


import com.amazon.payments.paywithamazon.response.model.SolutionProviderOptions;
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

    public String getSellerId() {
        return sellerId;
    }


    public String getType() {
        return type;
    }


    public SolutionProviderOptions getOptions() {
        return options;
    }


}
