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
package com.amazon.pay;

import com.amazon.pay.impl.PayConfig;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Region;

public interface Config {

    /**
     * @return Returns AccessKey from PayConfig
     */
    String getAccessKey();

    /**
     * @return Returns the application name from PayConfig
     */
    String getApplicationName();

    /**
     * @return Returns the application version set in PayConfig
     */
    String getApplicationVersion();

    /**
     * @return Returns currencyCode in PayConfig
     */
    CurrencyCode getCurrencyCode();

    /**
     * @return Returns the environment from PayConfig
     */
    Environment getEnvironment();

    /**
     * @return Returns the proxy host set in the PayConfig
     */
    String getProxyHost();

    /**
     * @return Returns proxy password in PayConfig
     */
    String getProxyPassword();

    /**
     * @return Returns proxy port from PayConfig
     */
    int getProxyPort();

    /**
     * @return Returns proxy username from PayConfig
     */
    String getProxyUsername();

    /**
     * @return Returns region code from PayConfig
     */
    Region getRegion();

    /**
     * @return Returns SecretKey from PayConfig
     */
    String getSecretKey();

    /**
     * @return Returns the MerchantId/SellerId from PayConfig
     */
    String getSellerId();

    /**
     * @return Returns true if Client retries on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     */
    boolean isUseAutoRetryOnThrottle();

    /**
     * @param accessKeyId Sets AccessKey in PayConfig
     */
    void setAccessKey(String accessKeyId);

    /**
     * @param applicationName Sets Application Name in PayConfig
     */
    void setApplicationName(String applicationName);

    /**
     * @param applicationVersion Sets Application Version in PayConfig
     */
    void setApplicationVersion(String applicationVersion);

    /**
     * @param currencyCode Sets currencyCode in PayConfig
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     * @param environment Sets environment in PayConfig
     */
    void setEnvironment(Environment environment);

    /**
     * @param proxyHost Sets proxy host in PayConfig
     */
    void setProxyHost(String proxyHost);

    /**
     * @param proxyPassword Sets proxy password in PayConfig
     */
    void setProxyPassword(String proxyPassword);

    /**
     * @param proxyPort Sets proxy port in PayConfig
     */
    void setProxyPort(int proxyPort);

    /**
     * @param proxyUsername Sets proxy username in PayConfig
     */
    void setProxyUsername(String proxyUsername);

    /**
     * @param region Identifies region associated with Amazon Pay API operations.
     */
    void setRegion(Region region);

    /**
     * @param secretAccessKey Sets SecretKey in PayConfig
     */
    void setSecretKey(String secretAccessKey);

    /**
     * @param sellerId Sets MerchantId/SellerId in PayConfig
     */
    void setSellerId(String sellerId);

    /**
     * @param useAutoRetryOnThrottle Sets autoRetryOnThrottle in PayConfig
     *        If set to true, client will retry on service exceptions that are either 500 internal server
     *        errors, 503 service unavailable errors, service throttling errors.
     */
    void setUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle);

    /**
     * @return overrideServiceURL Returns overridden MWS Service URL in PayConfig
     */
    String getOverrideServiceURL();

    /**
     * @param overrideServiceURL Sets MWS Service URL override in PayConfig
     * This should only be used if you need to programmatically override the default MWS service endpoint
     * provided by the SDK's mwsEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     */
    void setOverrideServiceURL(String overrideServiceURL);

    /**
     * @return overrideProfileURL Returns overridden LWA Profile URL in PayConfig
     */
    String getOverrideProfileURL();

    /**
     * @param overrideProfileURL Sets LWA Profile URL override in PayConfig
     *        This should only be used if you need to programmatically override the default LWA profile endpoint
     *        provided by the SDK's profileEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     */
    void setOverrideProfileURL(String overrideProfileURL);

}
