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
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class CancelOrderReferenceRequest implements Serializable{

    //required parameters
    private final String amazonOrderReferenceId;

    //optional parameters
    private String cancelationReason;
    private String mwsAuthToken;

    /*
    * @param amazonOrderReferenceId
    *      The order reference identifier. This value is retrieved 
    *      from the Amazon Button widget after the buyer has successfully 
    *      authenticated with Amazon.
    * 
    * @return CancelOrderReferenceeRequest 
    *           Container holding authorize operation parameters
    */
    public CancelOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     * Optional parameter 
     *
     * @param cancelationReason Describes the reason for the cancelation. This is for 
     * informational purposes only and is never displayed to the customer. 
     * The value can be retrieved in future GetOrderReferenceDetails calls.
     * Maximum: 1024 characters
     */
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        return this;
    }

    /**
     * Applicable for third-party solution providers only. 
     *
     * @param mwsAuthToken
     */
    public CancelOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     *  Represents the order reference identifier.
     *
     * @return Returns AmazonOrderReferenceId from request
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /*
     * Describes the reason for the cancelation. This is for 
     * informational purposes only and is never displayed to the customer. 
     * The value can be retrieved in future GetOrderReferenceDetails calls.
     * Maximum: 1024 characters 
    
    * @return Returns cancelationReason from request
    */
    public String getCancelationReason() {
        return cancelationReason;
    }

    /**
     * Applicable for third-party solution providers only. 
     *
     * @return Returns mwsAuthToken from request
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
        return "CancelOrderReferenceRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", cancelationReason="
                + cancelationReason + ", mwsAuthToken=" + mwsAuthToken + '}';
    }



}
