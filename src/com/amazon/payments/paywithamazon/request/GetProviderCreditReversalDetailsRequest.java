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
package com.amazon.payments.paywithamazon.request;

import java.io.Serializable;

/**
 * Container for the parameters to the 
 * {@link com.amazon.payments.lpa.Client#getProviderCreditReversalDetails(GetProviderCreditReversalDetailsRequest) GetProviderCreditReversalDetails operation}.
 *
 */
public class GetProviderCreditReversalDetailsRequest implements Serializable{
    
    //required parameters
    private final String amazonProviderCreditReversalId;
    private final String sellerId;
    
    //optional parameters
    private String mwsAuthToken;
    
    /**
     * 
     * @param amazonProviderCreditReversalId
     * @param sellerId 
     */
    public GetProviderCreditReversalDetailsRequest(String amazonProviderCreditReversalId , String sellerId) {
        this.amazonProviderCreditReversalId = amazonProviderCreditReversalId;
        this.sellerId = sellerId;
    }

    /**
     * Sets value for mwsAuthToken
     * @param mwsAuthToken
     */
    public GetProviderCreditReversalDetailsRequest setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * 
     * @return amazonProviderCreditReversalId
     */
    public String getAmazonProviderCreditReversalId() {
        return amazonProviderCreditReversalId;
    }

    /**
     * 
     * @return sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * 
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
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
        return "GetProviderCreditReversalDetailsRequest{" + "amazonProviderCreditReversalId=" + amazonProviderCreditReversalId + ", sellerId=" 
                + sellerId + ", mwsAuthToken=" + mwsAuthToken + '}';
    }
            

}
