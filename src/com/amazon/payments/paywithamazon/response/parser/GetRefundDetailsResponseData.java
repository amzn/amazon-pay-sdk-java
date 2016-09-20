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
package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.response.model.GetRefundDetailsResponse;
import com.amazon.payments.paywithamazon.response.model.RefundDetails;
import java.io.Serializable;

/**
 * Response from GetRefundDetails service API, as returned by Amazon Payments
 */
public final class GetRefundDetailsResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    private RefundDetails refundDetails;
    
    public GetRefundDetailsResponseData(GetRefundDetailsResponse getRefundDetailsResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(getRefundDetailsResponse != null) {
            if(getRefundDetailsResponse.getGetRefundDetailsResult() != null) {
                refundDetails = getRefundDetailsResponse.getGetRefundDetailsResult().getRefundDetails();
            }
            this.requestId = getRefundDetailsResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about a Refund object and its status.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752740
     * 
     * @return refundDetails
     */
    public RefundDetails getDetails() {
        return refundDetails;
    }

    /**
     * Returns the string representation of GetRefundDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetRefundDetailsResponseData{" + "requestId=" + requestId + ", refundDetails=" + refundDetails.toString() + '}';
    }

    
}
