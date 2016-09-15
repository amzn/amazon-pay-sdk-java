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
 * Container for the parameters to the closeAuthorization operation.
 *
 * For more information documentation, see
 * https://payments.amazon.com/documentation/
 */
public class CloseAuthorizationRequest implements Serializable{

    //required parameters
    private String amazonAuthorizationId;

    //optional parameters
    private String closureReason;
    private String mwsAuthToken;

    /**
     *
     * @param amazonAuthorizationId
     *              The authorization identifier that was generated by Amazon 
     *              in the earlier call to Authorize.
     *
     */
    public CloseAuthorizationRequest(String amazonAuthorizationId) {
        this.amazonAuthorizationId = amazonAuthorizationId;
    }

    /**
     *
     * @param closureReason
     *                  A description for the closure that is displayed in emails to the customer.
     */
    public CloseAuthorizationRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
        return this;
    }

    /**
     * Applicable for third-party solution providers only. 
     *
     * @param mwsAuthToken
     */
    public CloseAuthorizationRequest setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }

    /**
     * The authorization identifier that was generated by Amazon 
     *              in the earlier call to Authorize.
     *
     * @return AmazonAuthorizationId specified in request
     */
    public String getAmazonAuthorizationId() {
        return amazonAuthorizationId;
    }

    /**
     *  A description for the closure that is displayed in emails to the customer.
     *
     * @return ClosureReason specified in request
     */
    public String getClosureReason() {
        return closureReason;
    }

    /**
     * Applicable for third-party solution providers only. 
     *
     * @return MWSAuthToken specified in request
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
        return "CloseAuthorizationRequest{" + "amazonAuthorizationId=" + amazonAuthorizationId + ", closureReason=" + closureReason + ", mwsAuthToken="
                + mwsAuthToken + '}';
    }


}
