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

import com.amazon.pay.response.model.GetOrderReferenceDetailsResponse;
import com.amazon.pay.response.model.OrderReferenceDetails;
import java.io.Serializable;

/**
 * Response from GetOrderReferenceDetails service API, as returned by Amazon Pay
 */
public final class GetOrderReferenceDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private OrderReferenceDetails orderReferenceDetails;
    
    public GetOrderReferenceDetailsResponseData(GetOrderReferenceDetailsResponse response , ResponseData rawResponse) {
        super(rawResponse);
        if(response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if(response.getGetOrderReferenceDetailsResult() != null) { 
               orderReferenceDetails = response.getGetOrderReferenceDetailsResult().getOrderReferenceDetails();
            }
        }
    }

    /**
     * The requestID that uniquely identifies the service request
     * the caller made.
     * 
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Encapsulates details about an Order Reference object and its current state.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752660
     * @return orderReferenceDetails
     */
    public OrderReferenceDetails getDetails() {
        return orderReferenceDetails;
    }

    /**
     * Returns the string representation of GetOrderReferenceDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetOrderReferenceDetailsResponseData{" + "requestId=" + requestId + ", orderReferenceDetails=" + orderReferenceDetails.toString() + '}';
    }
    
    
    

}
