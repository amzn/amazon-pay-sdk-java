/**
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CancelOrderReferenceRequest extends DelegateRequest<CancelOrderReferenceRequest> implements Serializable{

    @Override
    protected CancelOrderReferenceRequest getThis() {
        return this;
    }

    //required parameters
    private final String amazonOrderReferenceId;

    //optional parameters
    private String cancelationReason;

    /*
    * @param amazonOrderReferenceId
    *      The order reference identifier. This value is retrieved
    *      from the Amazon Button widget after the buyer has successfully
    *      authenticated with Amazon.
    *
    * @return CancelOrderReferenceRequest
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
     *
     * @return Returns a reference to this object so that methods can be chained together.
     */
    public CancelOrderReferenceRequest setCancelReason(String cancelationReason) {
        this.cancelationReason = cancelationReason;
        return this;
    }

    /**
     * Represents the order reference identifier.
     *
     * @return Returns AmazonOrderReferenceId from request
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
    }

    /**
     * Describes the reason for the cancelation. This is for
     * informational purposes only and is never displayed to the customer.
     * The value can be retrieved in future GetOrderReferenceDetails calls.
     * Maximum: 1024 characters
     *
     * @return Returns cancelationReason from request
     */
    public String getCancelationReason() {
        return cancelationReason;
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
        return "CancelOrderReferenceRequest{"
            + "amazonOrderReferenceId=" + amazonOrderReferenceId
            + ", cancelationReason=" + cancelationReason
            + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
