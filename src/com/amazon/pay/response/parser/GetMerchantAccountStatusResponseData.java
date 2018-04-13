/**
 * Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import com.amazon.pay.response.model.AccountStatus;
import com.amazon.pay.response.model.GetMerchantAccountStatusResponse;

import java.io.Serializable;

/**
 * Response from GetMerchantAccountStatus API, as returned by Amazon Pay
 */
public final class GetMerchantAccountStatusResponseData extends ResponseData implements Serializable {

    private String requestId;
    private AccountStatus accountStatus;

    public GetMerchantAccountStatusResponseData(GetMerchantAccountStatusResponse response, ResponseData rawResponse) {
        super(rawResponse);
        if (response != null) {
            this.requestId = response.getResponseMetadata().getRequestId();
            if (response.getMerchantAccountStatusResult() != null) {
                accountStatus = response.getMerchantAccountStatusResult().getAccountStatus();
            }
        }
    }

    /**
     * The AccountStatus enum that identifies the merchant acconut as
     * being ACTIVE or INACTIVE.
     *
     * @return  The AccountStatus enum.
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
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
     * Returns the string representation of GetOrderReferenceDetailsResponseData
     */
    @Override
    public String toString() {
        return "GetServiceStatusResponseData{" + "requestId=" + requestId +
                ", accountStatus=" + accountStatus + "}";
    }

}
