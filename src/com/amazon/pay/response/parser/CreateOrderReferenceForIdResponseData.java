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
package com.amazon.pay.response.parser;

import com.amazon.pay.response.model.CreateOrderReferenceForIdResponse;
import com.amazon.pay.response.model.OrderReferenceDetails;
import java.io.Serializable;

/**
 * Response from CreateOrderReferenceForId service API, as returned by Amazon Pay
 */
public final class CreateOrderReferenceForIdResponseData extends ResponseData implements Serializable {

    private String requestId;
    private OrderReferenceDetails orderDetails;

    public CreateOrderReferenceForIdResponseData(
            final CreateOrderReferenceForIdResponse response, final ResponseData rawResponse) {
        super(rawResponse);
        if (response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if (response.getCreateOrderReferenceForIdResult() != null) {
               orderDetails = response.getCreateOrderReferenceForIdResult().getOrderReferenceDetails();
            }
        }
    }

    /**
     * @return  The requestId that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

     /**
     * Encapsulates details about an Order Reference object and its current state.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752660
     *
     * @return orderDetails
     *
     */
    public OrderReferenceDetails getDetails() {
        return orderDetails;
    }

    /**
     * Returns the string representation of CreateOrderReferenceForIdResponseData
     */
    @Override
    public String toString() {
        return "CreateOrderReferenceForIdResponseData{" +
                "requestId=" + requestId + ", orderDetails=" +
                orderDetails.toString() + "}";
    }

}
