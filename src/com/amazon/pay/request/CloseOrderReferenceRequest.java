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
 * Container for the parameters to the CloseOrderReference operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class CloseOrderReferenceRequest extends DelegateRequest<CloseOrderReferenceRequest> implements Serializable {

    @Override
    protected CloseOrderReferenceRequest getThis() {
        return this;
    }

    //required parameters
    private String amazonOrderReferenceId;

    //optional parameters
    private String closureReason;

    /**
     * @param amazonOrderReferenceId
     *              The ID of the order reference for which the details are being requested.
     */
    public CloseOrderReferenceRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     * @param closureReason Sets the reason for closing the order reference. This is for
     *                      informational purposes only and is never displayed to the customer.
     *
     * @return The ClosureReason
     */
    public CloseOrderReferenceRequest setClosureReason(String closureReason) {
        this.closureReason = closureReason;
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
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CloseOrderReferenceRequest{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", closureReason=" + closureReason
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
