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
 * Container for the parameters to the GetRefundDetails operation.
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class GetRefundDetailsRequest extends DelegateRequest<GetRefundDetailsRequest> implements Serializable {

    @Override
    protected GetRefundDetailsRequest getThis() {
        return this;
    }

    private String amazonRefundId;

    /**
     *
     * @param amazonRefundId The Amazon-generated identifier for this refund transaction.
     */
    public GetRefundDetailsRequest(String amazonRefundId) {
        this.amazonRefundId = amazonRefundId;
    }

    /**
     *
     * @return amazonRefundId
     */
    public String getAmazonRefundId() {
        return amazonRefundId;
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
        return "GetRefundDetailsRequest{"
                + "amazonRefundId=" + amazonRefundId
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }

}
