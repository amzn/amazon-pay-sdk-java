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
import java.net.URLDecoder;

/**
 * Container for the parameters to the GetOrderReferenceDetails operation.
 *
 * For more information documentation, see
 * https://pay.amazon.com/documentation/
 */
public class GetOrderReferenceDetailsRequest extends DelegateRequest<GetOrderReferenceDetailsRequest> implements Serializable {

    @Override
    protected GetOrderReferenceDetailsRequest getThis() {
        return this;
    }

    private String amazonOrderReferenceId;
    private String accessToken;
    @Deprecated
    private String addressConsentToken;


    /**
     *
     * @param amazonOrderReferenceId The order reference identifier.
     *                               This value is retrieved from the Amazon Button widget
     *                               after the buyer has successfully authenticated with Amazon.
     */
    public GetOrderReferenceDetailsRequest(String amazonOrderReferenceId) {
        this.amazonOrderReferenceId = amazonOrderReferenceId;
    }

    /**
     *
     * @param addressConsentToken The buyer address consent token. This value is retrieved
     *                            from the Amazon Button widget after the buyer has
     *                            successfully authenticated with Amazon.
     *
     * @return AddressConsentToken
     */
    @Deprecated
    public GetOrderReferenceDetailsRequest setAddressConsentToken(String addressConsentToken) {
        this.addressConsentToken = URLDecoder.decode(addressConsentToken);
        return this;
    }

    /**
     *
     * @return AddressConsentToken
     */
    @Deprecated
    public String getAddressConsentToken() {
        return this.addressConsentToken;
    }

    /**
     *
     * @param accessToken The buyer's access token. This value is retrieved
     *                    from the Amazon Button widget after the buyer has
     *                    successfully authenticated with Amazon.
     *
     * @return AccessToken
     */
    public GetOrderReferenceDetailsRequest setAccessToken(String accessToken) {
        this.accessToken = URLDecoder.decode(accessToken);
        return this;
    }

    /**
     *
     * @return AccessToken
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     *
     * @return AmazonOrderReferenceId
     */
    public String getAmazonOrderReferenceId() {
        return amazonOrderReferenceId;
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
        return "GetOrderReferenceDetailsRequest{"
                + "amazonOrderReferenceId=" + amazonOrderReferenceId
                + ", accessToken=" + accessToken
                + ", mwsAuthToken=" + getMwsAuthToken() + '}';
    }
}
