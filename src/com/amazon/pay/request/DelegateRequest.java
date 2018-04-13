/**
 * Copyright 2017-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

public abstract class DelegateRequest<T extends DelegateRequest<T>> {

    private String mwsAuthToken;
    private String sellerId;

    protected abstract T getThis();

    /**
     * Returns the MWS Auth Token
     *
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     * @param mwsAuthToken Sets MWSAuthToken parameter in request. MWSAuthToken is required
     *                     only for third-party solution providers and marketplaces. Do not
     *                     specify this parameter for merchants creating their own custom integration.
     *
     * @return The subclass object
     */
    public T setMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return getThis();
    }

    /**
     * @param mwsAuthToken Sets MWSAuthToken parameter in request. MWSAuthToken is required
     *                     only for third-party solution providers and marketplaces. Do not
     *                     specify this parameter for merchants creating their own custom integration.
     *                     Does same thing as setMWSAuthToken.
     *
     * @return The subclass object
     */
    public T withMWSAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return getThis();
    }

    /**
     * Returns the request-specific sellerId
     *
     * @return sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId Sets request-specific merchant ID in order to override any merchant ID
     *                   supplied from the Config object.  This is useful for third-party solution
     *                   providers that deal with hundreds or thousands of merchant ID's at the
     *                   same time and do not want to contruct a new Config object for each request.
     *
     * @return The subclass object
     */
    public T setSellerId(String sellerId) {
        this.sellerId = sellerId;
        return getThis();
    }

}
