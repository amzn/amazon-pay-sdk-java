/**
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

public abstract class SetMWSAuthToken {
    private String mwsAuthToken;

    /**
     * Returns the MWS Auth Token
     *
     * @return mwsAuthToken
     */
    public String getMwsAuthToken() {
        return mwsAuthToken;
    }

    /**
     *@param mwsAuthToken Sets MWSAuthToken parameter in request. MWSAuthToken is required
     *                     only for third-party solution providers and marketplaces. Do not
     *                     specify this parameter for merchants creating their own custom integration.
     *
     * @return The MWSAuthToken
     */
    public SetMWSAuthToken setMwsAuthToken(String mwsAuthToken) {
        this.mwsAuthToken = mwsAuthToken;
        return this;
    }
}
