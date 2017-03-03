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

import com.amazon.pay.response.model.RefundDetails;
import com.amazon.pay.response.model.RefundResponse;
import java.io.Serializable;

/**
 * Response from Refund service API, as returned by Amazon Pay
 */
public final class RefundResponseData  extends ResponseData implements Serializable {
    
    private String requestId;
    private RefundDetails refundDetails;
    
    public RefundResponseData(RefundResponse refundResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(refundResponse != null) {
            if(refundResponse.getRefundResult() != null) {
                refundDetails = refundResponse.getRefundResult().getRefundDetails();
            }
            this.requestId = refundResponse.getResponseMetadata().getRequestId();
        }
    }

    /**
     * @return  The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Encapsulates details about a Refund object and its status.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752740
     * 
     * @return refundDetails
     */
    public RefundDetails getDetails() {
        return refundDetails;
    }

    /**
     * Returns the string representation of RefundResponseData
     */
    @Override
    public String toString() {
        return "RefundResponseData{" + "requestId=" + requestId + ", refundDetails=" + refundDetails.toString() + '}';
    }
    

}
