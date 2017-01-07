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

import com.amazon.payments.paywithamazon.response.model.ValidateBillingAgreementResult;
import com.amazon.payments.paywithamazon.response.model.ValidateBillingAgreementResponse;
import java.io.Serializable;

/**
 * Response from ValidateBillingAgreement service API, as returned by Amazon Payments
 */
public final class ValidateBillingAgreementResponseData extends ResponseData implements Serializable{

    private String requestId;
    private ValidateBillingAgreementResult validateBillingAgreementResult;

    public ValidateBillingAgreementResponseData(ValidateBillingAgreementResponse response, ResponseData rawResponse) {
        super(rawResponse);
        if (response != null) {
            if (response.getResponseMetadata() != null) {
                this.requestId = response.getResponseMetadata().getRequestId();

                if (response.getValidateBillingAgreementResult() != null) {
                    validateBillingAgreementResult = response.getValidateBillingAgreementResult();
                }
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
     * Encapsulates details about a ValidateBillingAgreement object and its current state.
     * Documentation: https://payments.amazon.com/developer/documentation/apireference/201751720
     *
     * @return Object containing Validation Result, Failure Reason Code, and Billing Agreement Status
     */
    public ValidateBillingAgreementResult getResult() {
        return validateBillingAgreementResult;
    }


    /**
     * Returns the string representation of ValidateBillingAgreementResponseData
     * @return
     */
    @Override
    public String toString() {
        return "ValidateBillingAgreementResponseData{"
                + "requestId=" + requestId
                + ", validateBillingAgreementResult=" + validateBillingAgreementResult.toString() + '}';
    }

}
