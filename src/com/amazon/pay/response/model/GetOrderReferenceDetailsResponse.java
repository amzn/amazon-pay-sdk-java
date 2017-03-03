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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getOrderReferenceDetailsResult",
    "responseMetadata"
})
@XmlRootElement(name = "GetOrderReferenceDetailsResponse")
public class GetOrderReferenceDetailsResponse {

    @XmlElement(name = "GetOrderReferenceDetailsResult", required = true)
    protected GetOrderReferenceDetailsResult getOrderReferenceDetailsResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public GetOrderReferenceDetailsResponse() {
        super();
    }
    
    public GetOrderReferenceDetailsResult getGetOrderReferenceDetailsResult() {
        return getOrderReferenceDetailsResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }
    
    
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "orderReferenceDetails"
    })
    @XmlRootElement(name = "GetOrderReferenceDetailsResult")
    public static class GetOrderReferenceDetailsResult {

        @XmlElement(name = "OrderReferenceDetails")
        protected OrderReferenceDetails orderReferenceDetails;

        public GetOrderReferenceDetailsResult() {
            super();
        }

        public OrderReferenceDetails getOrderReferenceDetails() {
            return orderReferenceDetails;
        }
    }
}