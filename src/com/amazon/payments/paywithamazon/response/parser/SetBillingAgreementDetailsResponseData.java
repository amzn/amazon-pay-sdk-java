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

import com.amazon.payments.paywithamazon.response.model.BillingAgreementDetails;
import com.amazon.payments.paywithamazon.response.model.SetBillingAgreementDetailsResponse;
import java.io.Serializable;

/**
 * Response from SetBillingAgreementDetails service API, as returned by Amazon Payments
 */
public final class SetBillingAgreementDetailsResponseData extends ResponseData implements Serializable{
    
    private String requestId;
    private BillingAgreementDetails billingAgreementDetails;
    
    public SetBillingAgreementDetailsResponseData(SetBillingAgreementDetailsResponse response , ResponseData rawResponse) {
        super(rawResponse);
        if(response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if(response.getSetBillingAgreementDetailsResult() != null) { 
               billingAgreementDetails = response.getSetBillingAgreementDetailsResult().getBillingAgreementDetails();
            }
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
     * Encapsulates details about a Billing Agreement object and its current state.
     * Documentation: https://payments.amazon.com/documentation/apireference/201751630#201752500
     * 
     * @return billingAgreementDetails
     */
    public BillingAgreementDetails getDetails() {
        return billingAgreementDetails;
    }

    @Override
    public String toString() {
        return "SetBillingAgreementDetailsResponseData{" + "requestId=" + requestId + ", billingAgreementDetails=" + billingAgreementDetails.toString() + '}';
    }
    
    
    

}
