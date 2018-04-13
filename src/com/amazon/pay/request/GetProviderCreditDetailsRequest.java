/**
 * Copyright 2016-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.request;

import java.io.Serializable;

/**
 * Container for the parameters to the GetProviderCreditDetailsRequest operation.
 *
 *  For more information documentation, see
 * https://pay.amazon.com/documentation/
 *
 */
public class GetProviderCreditDetailsRequest extends DelegateRequest<GetProviderCreditDetailsRequest> implements Serializable {

    @Override
    protected GetProviderCreditDetailsRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonProviderCreditId;
    private String sellerId;

    /**
     *
     * @param amazonProviderCreditId Provide Amazon Provider Credit ID in the request
     *
     * @param sellerId Provide the Seller ID in the request
     */
    public GetProviderCreditDetailsRequest(String amazonProviderCreditId , String sellerId) {
        this.amazonProviderCreditId = amazonProviderCreditId;
        this.sellerId = sellerId;
    }

    /**
     * @return amazonProviderCreditId
     */
    public String getAmazonProviderCreditId() {
        return amazonProviderCreditId;
    }

    /**
     * @return sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "GetProviderCreditDetailsRequest{"
                + "amazonProviderCreditId=" + amazonProviderCreditId
                + ", sellerId=" + sellerId
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
