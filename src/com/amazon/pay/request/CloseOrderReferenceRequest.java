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
package com.amazon.pay.request;

import java.io.Serializable;


/**
 * Container for the parameters to the CloseOrderReference operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CloseOrderReferenceRequest implements Serializable{

    //required parameters
    private String amazonOrderReferenceId;

    //optional parameters
    private String closureReason;
    private String mwsAuthToken;

    /**
     * @param amazonOrderReferenceId
     *              The ID of the order reference for which the details are being requested.
     *
     * @return CloseOrderReferenceRequest
     */
    public CloseOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     * Sets the reason for closing the order reference. This is for 
     * informational purposes only and is never displayed to the customer. 
     *
     * @param closureReason
     *
     */
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    /**
     * Sets MWSAuthToken parameter in request. MWSAuthToken is required only for third-party solution providers
     * and marketplaces. Do not specify this parameter for merchants creating their own custom integration. 
     *
     * @param mwsAuthToken
     */
    public CloseOrderReferenceRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The ID of the order reference for which the details are being requested.
     *
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Describes the reason for closing the order reference.
     * @return ClosureReason
     */
    public String getClosureReason() {
        return closureReason;
    }

    /**
     * Represents the MWSAuthToken parameter in request. MWSAuthToken is required only for third-party solution providers
     * and marketplaces. Do not specify this parameter for merchants creating their own custom integration. 

     * @return MWSAuthToken
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
        return "CloseOrderReferenceRequest{" + "amazonOrderReferenceId=" + amazonOrderReferenceId + ", closureReason=" + closureReason + ", mwsAuthToken="
                + mwsAuthToken + '}';
    }


}
