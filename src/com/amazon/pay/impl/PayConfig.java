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
package com.amazon.pay.impl;

import com.amazon.pay.Config;
import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Key;
import com.amazon.pay.types.Region;
import java.util.Enumeration;
import java.util.Properties;

public class PayConfig implements Config  {

    private String accessKey;
    private char[] secretKey;
    private String merchantId;
    private Region region;
    private Environment environment;
    private CurrencyCode currencyCode;
    private String applicationName;
    private String applicationVersion;
    private String proxyHost;
    private int proxyPort;
    private String proxyUsername;
    private String proxyPassword;
    private boolean useAutoRetryOnThrottle;
    private String overrideServiceURL;
    private String overrideProfileURL;

    /**
     * Constructor for PayConfig - container that stores all configuration parameters for client
     *
     * Required parameters are merchantId, accessKey and secretKey.
     * Specify them using
     * withSellerId() and withAccessKeyId() and withSecretKey()
     * Note that default currency code is USD and default region code is US
     * You can override default values using
     * withRegionCode() and withCurrencyCode()
     *
     * Default environment is Live mode.
     * You can override default environment using
     * withSandboxMode(true)
     *
     * Optional proxy parameters allow to connect via proxy using
     * parameters like withProxyHost(), withProxyPort(), withProxyUserName(), withProxyPassword().
     *
     */
    public PayConfig()  {

    }

    public PayConfig(Properties prop) {
        loadConfigurationFromProperties(prop);
        checkIfRequriedPropertiesExist();
    }


    /**
     * Returns the MerchantId from PayConfig
     *
     * @return merchantId
     */
    @Override
    public String getSellerId() {
        return merchantId;
    }


    /**
     *
     * @param merchantId - Sets MerchantId/SellerId in PayConfig
     */
    @Override
    public void setSellerId(String merchantId) {
        this.merchantId = merchantId;
    }


    /**
     *
     * @param merchantId - merchantId/sellerId is a unique identifier supplied by
     * Amazon when you first created your account. This ID can be found
     * in the Amazon Seller Central account.
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withSellerId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    /**
     * Returns AccessKey from PayConfig
     *
     * @return accessKeyId
     */
    @Override
    public String getAccessKey() {
        return accessKey;
    }


    /**
     *
     * @param accessKey - Sets AccessKey in PayConfig
     */
    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }


    /**
     *
     * @param accessKey - Sets AccessKey in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }


    /**
     * Returns SecretKey from PayConfig
     *
     * @return secretAccessKey
     *
     */
    @Override
    public char[] getSecretKey() {
        return secretKey;
    }


    /**
     * @deprecated(since = "3.7.0") This method is deprecated, instead use setSecretKey(char[] secretKey)
     * @param secretKey - Sets SecretKey in PayConfig
     */
    @Override
    @Deprecated
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey.toCharArray();
    }
    
    /**
    * @param secretKey - Sets SecretKey in PayConfig
    */
   @Override
   public void setSecretKey(char[] secretKey) {
       this.secretKey = secretKey;
   }


    /**
     * @deprecated(since = "3.7.0") This method is deprecated, instead use withSecretKey(char[] privateKey)
     * @param secretKey - Sets SecretKey in PayConfig
     * @return Returns updated PayConfig object
     */
   @Deprecated
    public PayConfig withSecretKey(String secretKey) {
        this.secretKey = secretKey.toCharArray();
        return this;
    }
    
    /**
     * @param secretKey - Sets SecretKey in PayConfig
     * @return Returns updated PayConfig object
     */
    public PayConfig withSecretKey(char[] secretKey) {
        this.secretKey = secretKey;
        return this;
    }


    /**
     * Returns region code from PayConfig
     *
     * @see com.amazon.pay.Config
     *
     * @return region
     */
    @Override
    public Region getRegion() {
        return region;
    }


    /**
     *
     * @param region - Identifies region associated with Amazon Pay API operations.
     *
     */
    @Override
    public void setRegion(Region region) {
        this.region = region;
    }


    /**
     *
     * @param region - Identifies region associated with Amazon Pay API operations.
     *
     * @return Returns updated PayConfig object
     *
     */
    public PayConfig withRegion(Region region) {
        this.region = region;
        return this;
    }


    /**
     * Returns the environment from PayConfig
     *
     * @return environment
     */
    @Override
    public Environment getEnvironment() {
        return environment;
    }


    /**
     *
     * @param environment - Sets environment in PayConfig.
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


    /**
     *
     *
     * @param isSandbox - If true, sets environment to SANDBOX mode.
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withSandboxMode(boolean isSandbox) {
        if (isSandbox)
            this.environment = Environment.SANDBOX;
        else
            this.environment = Environment.LIVE;
        return this;
    }


    /**
     * Returns currencyCode in PayConfig
     * @see com.amazon.pay.impl.PayConfig
     *
     * @return currencyCode
     */
    @Override
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }


    /**
     *
     * @param currencyCode  - Sets currencyCode in PayConfig
     */
    @Override
    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     *
     * @param currencyCode - Represents currency code to be used for all Amazon Pay API operations.
     *                       Accepts three-digit currency code, such as USD (dollars), EUR (euros), GBP (pounds) or JPY (Japanese Yen).
     *                       The currency code in ISO 4217 format.
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    /**
     * Returns the application name from PayConfig
     *
     * @return applicationName
     *
     */
    @Override
    public String getApplicationName() {
        return applicationName;
    }


    /**
     * Sets Application Name in PayConfig
     *
     * @param applicationName - Sets application name
     */
    @Override
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }


    /**
     *
     * @param applicationName - This method sets application name in PayConfig
     *
     * @return - Returns updated PayConfig object
     *
     */
    public PayConfig withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }


    /**
     * Returns the application version set in PayConfig
     *
     * @return applicationVersion
     *
     */
    @Override
    public String getApplicationVersion() {
        return applicationVersion;
    }


    /**
     *
     * @param applicationVersion -Sets Application Version in PayConfig
     */
    @Override
    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }


    /**
     *
     * @param applicationVersion - This method sets application version in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }


    /**
     * Returns the proxy host set in the PayConfig
     *
     * @return proxyHost
     */
    @Override
    public String getProxyHost() {
        return proxyHost;
    }


    /**
     *
     * @param proxyHost - Sets proxy host in PayConfig
     */
    @Override
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }


    /**
     *
     * @param proxyHost - This method sets proxy host in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
        return this;
    }


    /**
     * Returns proxy port from PayConfig
     *
     * @return proxyPort
     */
    @Override
    public int getProxyPort() {
        return proxyPort;
    }


    /**
     *
     * @param proxyPort - Sets proxy port in PayConfig
     */
    @Override
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }


    /**
     *
     * @param proxyPort - This method sets proxy port in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }


    /**
     * Returns proxy username from PayConfig
     *
     * @return proxyUsername
     */
    @Override
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     *
     * @param proxyUsername - Sets proxy username in PayConfig
     */
    @Override
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }


    /**
     *
     * @param proxyUsername - This methods sets proxy username in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
        return this;
    }


    /**
     * Returns proxy password in PayConfig
     *
     * @return proxyPassword
     */
    @Override
    public String getProxyPassword() {
        return proxyPassword;
    }


    /**
     *
     * @param proxyPassword - Set proxy password in PayConfig
     */
    @Override
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }


    /**
     *
     * @param proxyPassword - Sets proxy username in PayConfig.
     *
     * @return
     *          Returns updated PayConfig object
     */
    public PayConfig withProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
        return this;
    }


    /**
     * Returns true if Client retries on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @return useAutoRetryOnThrottle
     */
    @Override
    public boolean isUseAutoRetryOnThrottle() {
        return useAutoRetryOnThrottle;
    }


    /**
     * Sets autoRetryOnThrottle in PayConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle - argument that sets autoRetryOnThrottle in PayConfig
     */
    @Override
    public void setUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle) {
        this.useAutoRetryOnThrottle = useAutoRetryOnThrottle;
    }


    /**
     * Sets autoRetryOnThrottle in PayConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle  - argument that sets autoRetryOnThrottle in PayConfig
     *
     * @return Returns updated PayConfig object
     */
    public PayConfig withUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle) {
        this.useAutoRetryOnThrottle = useAutoRetryOnThrottle;
        return this;
    }


    /**
     * Returns overridden MWS Service URL in PayConfig
     *
     * @return overrideServiceURL
     */
    @Override
    public String getOverrideServiceURL() {
        return overrideServiceURL;
    }


    /**
     * @param overrideServiceURL Sets MWS Service URL override in PayConfig
     * This should only be used if you need to programmatically override the default MWS service endpoint
     * provided by the SDK's mwsEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     */
    @Override
    public void setOverrideServiceURL(String overrideServiceURL) {
        this.overrideServiceURL = overrideServiceURL;
    }


    /**
     * @param overrideServiceURL Sets MWS Service URL override in PayConfig
     * This should only be used if you need to programmatically override the default MWS service endpoint
     * provided by the SDK's mwsEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     *
     * @return PayConfig
     */
    public PayConfig withOverrideServiceURL(String overrideServiceURL) {
        this.overrideServiceURL = overrideServiceURL;
        return this;
    }


    /**
     * Returns overridden LWA Profile URL in PayConfig
     *
     * @return overrideProfileURL
     */
    @Override
    public String getOverrideProfileURL() {
        return overrideProfileURL;
    }


    /**
     * @param overrideProfileURL Sets LWA Profile URL override in PayConfig
     * This should only be used if you need to programmatically override the default LWA profile endpoint
     * provided by the SDK's profileEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     */
    @Override
    public void setOverrideProfileURL(String overrideProfileURL) {
        this.overrideProfileURL = overrideProfileURL;
    }


    /**
     * @param overrideProfileURL Sets LWA Profile URL override in PayConfig
     * This should only be used if you need to programmatically override the default LWA profile endpoint
     * provided by the SDK's profileEndpointMappingsMap in com.amazon.pay.types.ServiceConstants.
     *
     * @return PayConfig
     */
    public PayConfig withOverrideProfileURL(String overrideProfileURL) {
        this.overrideProfileURL = overrideProfileURL;
        return this;
    }


    private PayConfig loadConfigurationFromProperties(Properties prop) {
        if (prop == null || prop.isEmpty())
            throw new IllegalArgumentException("Properties are empty, Need required propeties to proceed configuring amazon Pay client");

        Enumeration enumeration = prop.propertyNames();

        while (enumeration.hasMoreElements()) {
            String property = (String) enumeration.nextElement();
            try {
                switch (Key.valueOf(property.toUpperCase())) {
                    case ACCESS_KEY:
                        this.setAccessKey(prop.getProperty(property));
                        break;
                    case SECRET_KEY:
                        this.setSecretKey(prop.getProperty(property).toCharArray());
                        break;
                    case MERCHANT_ID:
                        this.setSellerId(prop.getProperty(property));
                        break;
                    case ENVIRONMENT:
                        Environment env = Environment.valueOf(prop.getProperty(property).toUpperCase());
                        this.setEnvironment(env);
                        break;
                    case REGION:
                        Region reg = Region.valueOf((prop.getProperty(property)).toUpperCase());
                        this.setRegion(reg);
                        break;
                    case CURRENCY_CODE:
                        CurrencyCode currency = CurrencyCode.valueOf((prop.getProperty(property)).toUpperCase());
                        this.setCurrencyCode(currency);
                        break;
                    case PROXY_HOST:
                        String proxyHostProperty = prop.getProperty(property);
                        this.setProxyHost(proxyHostProperty);
                        break;
                    case PROXY_PORT:
                        String proxyPortProperty = prop.getProperty(property);
                        if (proxyPortProperty != null && !proxyPortProperty.isEmpty())
                            this.setProxyPort(Integer.parseInt(proxyPortProperty));
                        break;
                    case PROXY_USERNAME:
                        String proxyUsernameProperty = prop.getProperty(property);
                        this.setProxyUsername(proxyUsernameProperty);
                        break;
                    case PROXY_PASSWORD:
                        String proxyPasswordProperty = prop.getProperty(property);
                        this.setProxyPassword(proxyPasswordProperty);
                        break;
                    case APPLICATION_NAME:
                        String applicationNameProperty = prop.getProperty(property);
                        this.setApplicationName(applicationNameProperty);
                        break;
                    case APPLICATION_VERSION:
                        String applicationVersionProperty = prop.getProperty(property);
                        this.setApplicationVersion(applicationVersionProperty);
                        break;
                    case AUTO_RETRY_ON_THROTTLE:
                        String useAutoRetyOnThrottle = prop.getProperty(property);
                        this.setUseAutoRetryOnThrottle(Boolean.valueOf(useAutoRetyOnThrottle));
                        break;
                    case OVERRIDE_SERVICE_URL:
                        String overrideServiceURL = prop.getProperty(property);
                        this.setOverrideServiceURL(overrideServiceURL);
                        break;
                    case OVERRIDE_PROFILE_URL:
                        String overrideProfileURL = prop.getProperty(property);
                        this.setOverrideProfileURL(overrideProfileURL);
                        break;
                    default:
                        throw new AmazonClientException(("Client error, unable to set client configuration property [Key: "
                                + property +", Value: " + prop.getProperty(property) + "]. " ));
                }
            } catch(IllegalArgumentException e) {
                throw new IllegalArgumentException("Unable to process client configuration parameter [Key: "
                        + property +", Value: " + prop.getProperty(property) + "]. " , e);
            }
        }

        return this;
    }


    /**
     * Helper method to check if required values are set.
     *
     * @throws IllegalArgumentException If required values are missing.
     */
    private boolean checkIfRequriedPropertiesExist() {
        if (this.accessKey == null)
            generateException(Key.ACCESS_KEY);
        else if (this.secretKey == null || this.secretKey.length == 0)
            generateException(Key.SECRET_KEY);
        else if (this.merchantId == null)
            generateException(Key.MERCHANT_ID);
        else if (this.environment == null)
            generateException(Key.ENVIRONMENT);
        else if (this.region == null)
            generateException(Key.REGION);
        else if (this.currencyCode == null)
            generateException(Key.CURRENCY_CODE);
        return true;

    }


    private void generateException(Key propertyKey) {
        throw new IllegalArgumentException(propertyKey.toString() +
                " property is not set, this is a required property for Amazon Pay client configuration");
    }


    /**
     * The string representation of configuration parameters
     *
     * @return Returns the string representation of configuration parameters
     */
    @Override
    public String toString() {
        return "PayConfig{" +
                "accessKeyId=" + accessKey +
                ", sellerId=" + merchantId +
                ", region=" + region +
                ", environment=" + environment +
                ", currencyCode=" + currencyCode +
                ", applicationName=" + applicationName +
                ", applicationVersion=" + applicationVersion +
                ", proxyHost=" + proxyHost +
                ", proxyPort=" + proxyPort +
                ", proxyUsername=" + proxyUsername +
                ", proxyPassword=" + proxyPassword +
                ", useAutoRetryOnThrottle=" + useAutoRetryOnThrottle +
                ", overrideServiceURL=" + overrideServiceURL +
                ", overrideProfileURL=" + overrideProfileURL +
                "}";
    }


}
