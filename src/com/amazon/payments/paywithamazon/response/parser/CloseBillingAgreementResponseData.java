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

import com.amazon.payments.paywithamazon.response.model.CloseBillingAgreementResponse;
import java.io.Serializable;

/**
 * Response from CloseBillingAgreement service API, as returned by Amazon Payments
 */
public final class CloseBillingAgreementResponseData  extends ResponseData implements Serializable{
    
    private String requestId;
    
    public CloseBillingAgreementResponseData(CloseBillingAgreementResponse closeBillingAgreementResponse , ResponseData rawResponse) {
        super(rawResponse);
        if(closeBillingAgreementResponse != null) {
            if(closeBillingAgreementResponse.getResponseMetadata() != null) {
                this.requestId = closeBillingAgreementResponse.getResponseMetadata().getRequestId();
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
     * Returns the string representation of CloseBillingAgreementResponseData
     */
    @Override
    public String toString() {
        return "CloseBillingAgreementResponseData{" + "requestId=" + requestId + '}';
    }
    
    
}
