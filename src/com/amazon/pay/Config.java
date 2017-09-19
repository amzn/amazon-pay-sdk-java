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
     * Returns AccessKey from PayConfig
     *
     * @return accessKeyId
     */
    String getAccessKey();

    /**
     * Returns the application name from PayConfig
     *
     * @return applicationName
     *
     */
    String getApplicationName();

    /**
     * Returns the application version set in PayConfig
     *
     * @return applicationVersion
     *
     */
    String getApplicationVersion();

    /**
     * Returns currencyCode in PayConfig
     *
     * @return currencyCode
     */
    CurrencyCode getCurrencyCode();

    /**
     * Returns the environment from PayConfig
     *
     * @return environment
     */
    Environment getEnvironment();

    /**
     * Returns the proxy host set in the PayConfig
     *
     * @return proxyHost
     */
    String getProxyHost();

    /**
     * Returns proxy password in PayConfig
     *
     * @return proxyPassword
     */
    String getProxyPassword();

    /**
     * Returns proxy port from PayConfig
     *
     * @return proxyPort
     */
    int getProxyPort();

    /**
     * Returns proxy username from PayConfig
     *
     * @return proxyUsername
     */
    String getProxyUsername();

    /**
     * Returns region code from PayConfig
     *
     * @see com.amazon.pay.impl.PayConfig
     *
     * @return region
     */
    Region getRegion();

    /**
     * Returns SecretKey from PayConfig
     *
     * @return secretAccessKey
     *
     */
    String getSecretKey();

    /**
     * Returns the MerchantId/SellerId from PayConfig
     *
     * @return sellerId
     */
    String getSellerId();

    /**
     * Returns true if Client retries on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     */
    boolean isUseAutoRetryOnThrottle();

    /**
     * Sets AccessKey in PayConfig
     *
     * @param accessKeyId
     */
    void setAccessKey(String accessKeyId);

    /**
     * Sets Application Name in PayConfig
     *
     * @param applicationName
     */
    void setApplicationName(String applicationName);

    /**
     * Sets Application Version in PayConfig
     *
     * @param applicationVersion
     */
    void setApplicationVersion(String applicationVersion);

    /**
     * Sets currencyCode in PayConfig
     * @param currencyCode
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     *  Sets environment in PayConfig.
     *
     * @param environment
     */
    void setEnvironment(Environment environment);

    /**
     * Sets proxy host in PayConfig
     *
     * @param proxyHost
     */
    void setProxyHost(String proxyHost);

    /**
     * Set proxy password in PayConfig
     *
     * @param proxyPassword
     */
    void setProxyPassword(String proxyPassword);

    /**
     * Sets proxy port in PayConfig
     *
     * @param proxyPort
     */
    void setProxyPort(int proxyPort);

    /**
     * Sets proxy username in PayConfig
     *
     * @param proxyUsername
     */
    void setProxyUsername(String proxyUsername);

    /**
     * Identifies region associated with Amazon Pay API operations.
     *
     * @param region
     *
     */
    void setRegion(Region region);

    /**
     * Sets SecretKey in PayConfig
     *
     * @param secretAccessKey
     */
    void setSecretKey(String secretAccessKey);

    /**
     * Sets MerchantId/SellerId in PayConfig
     *
     * @param sellerId
     */
    void setSellerId(String sellerId);

    /**
     * Sets autoRetryOnThrottle in PayConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle
     */
    void setUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle);

    /**
     * Returns overridden MWS Service URL in PayConfig
     *
     * @return overrideServiceURL
     */
    String getOverrideServiceURL();

    /**
     * Sets MWS Service URL override in PayConfig
     * This should only be used if you need to programmatically override the default MWS service endpoint
     * provided by the SDK's mwsEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     *
     * @param overrideServiceURL
     */
    void setOverrideServiceURL(String overrideServiceURL);

    /**
     * Returns overridden LWA Profile URL in PayConfig
     *
     * @return overrideProfileURL
     */
    String getOverrideProfileURL();

    /**
     * Sets LWA Profile URL override in PayConfig
     * This should only be used if you need to programmatically override the default LWA profile endpoint
     * provided by the SDK's profileEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     *
     * @param overrideProfileURL
     */
    void setOverrideProfileURL(String overrideProfileURL);

}
