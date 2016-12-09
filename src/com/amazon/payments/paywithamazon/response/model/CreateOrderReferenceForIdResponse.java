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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This represents the parsed response from the Amazon Payments
 * CreateOrderReferenceForId API.
 *
 * <CreateOrderReferenceForIdResponse xmlns="http://mws.amazonservices.com/schema/OffAmazonPayments/2013-01-01">
 *   <CreateOrderReferenceForIdResult>
 *     <OrderReferenceDetails>
 *       ...
 *     </OrderReferenceDetails>
 *   </CreateOrderReferenceForIdResult>
 *   <ResponseMetadata>
 *     <RequestId>4d5e0306-257e-4a13-b2ad-45b891c3de2a</RequestId>
 *   </ResponseMetadata>
 * </CreateOrderReferenceForIdResponse>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createOrderReferenceForIdResult",
    "responseMetadata"
})
@XmlRootElement(name = "CreateOrderReferenceForIdResponse")
public class CreateOrderReferenceForIdResponse {

    @XmlElement(name = "CreateOrderReferenceForIdResult", required = true)
    protected CreateOrderReferenceForIdResult createOrderReferenceForIdResult;
    @XmlElement(name = "ResponseMetadata", required = true)
    protected ResponseMetadata responseMetadata;

    public CreateOrderReferenceForIdResponse() {
        super();
    }

    public CreateOrderReferenceForIdResult getCreateOrderReferenceForIdResult() {
        return createOrderReferenceForIdResult;
    }

    public ResponseMetadata getResponseMetadata() {
        return responseMetadata;
    }

}
