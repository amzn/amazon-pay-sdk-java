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

import com.amazon.pay.response.model.CaptureDetails;
import com.amazon.pay.response.model.CaptureResponse;
import java.io.Serializable;

/**
 * Response from Capture service API, as returned by Amazon Pay
 */
public final class CaptureResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    private CaptureDetails captureDetails;
    
    public CaptureResponseData(CaptureResponse captureResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(captureResponse != null) {
            if(captureResponse.getCaptureResult() != null) {
                captureDetails = captureResponse.getCaptureResult().getCaptureDetails();
            }
            this.requestId = captureResponse.getResponseMetadata().getRequestId();
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
     * Encapsulates details about a Capture object and its status.
     * Documentation: https://pay.amazon.com/documentation/apireference/201751630#201752580
     * 
     * @return captureDetails
     */
    public CaptureDetails getDetails() {
        return captureDetails;
    }

    /**
     * Returns the string representation of CaptureResponseData
     */
    @Override
    public String toString() {
        return "CaptureResponseData{" + "requestId=" + requestId + ", captureDetails=" + captureDetails.toString() + '}';
    }

    
}
