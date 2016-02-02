package com.amazon.payments.paywithamazon;

import com.amazon.payments.paywithamazon.impl.PaymentsConfig;
import com.amazon.payments.paywithamazon.response.model.Environment;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import com.amazon.payments.paywithamazon.types.Region;

public interface Config {

    /**
     * Returns AccessKey from PaymentsConfig
     *
     * @return accessKeyId
     */
    String getAccessKey();

    /**
     * Returns the application name from PaymentsConfig
     *
     * @return applicationName
     *
     */
    String getApplicationName();

    /**
     * Returns the application version set in PaymentsConfig
     *
     * @return applicationVersion
     *
     */
    String getApplicationVersion();

    /**
     * Returns currencyCode in PaymentsConfig
     * @see com.amazon.payments.lpa.types.CurrencyCode
     *
     * @return currencyCode
     */
    CurrencyCode getCurrencyCode();

    /**
     * Returns the environment from PaymentsConfig
     * @see com.amazon.payments.lpa.types.Environment
     *
     * @return environment
     */
    Environment getEnvironment();

    /**
     * Returns the proxy host set in the PaymentsConfig
     *
     * @return proxyHost
     */
    String getProxyHost();

    /**
     * Returns proxy password in PaymentsConfig
     *
     * @return proxyPassword
     */
    String getProxyPassword();

    /**
     * Returns proxy port from PaymentsConfig
     *
     * @return proxyPort
     */
    int getProxyPort();

    /**
     * Returns proxy username from PaymentsConfig
     *
     * @return proxyUsername
     */
    String getProxyUsername();

    /**
     * Returns region code from PaymentsConfig
     *
     * @see com.amazon.payments.lpa.types.Region
     *
     * @return region
     */
    Region getRegion();

    /**
     * Returns SecretKey from PaymentsConfig
     *
     * @return secretAccessKey
     *
     */
    String getSecretKey();

    /**
     * Returns the MerchantId/SellerId from PaymentsConfig
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
     * Sets AccessKey in PaymentsConfig
     *
     * @param accessKeyId
     */
    void setAccessKey(String accessKeyId);

    /**
     * Sets Application Name in PaymentsConfig
     *
     * @param applicationName
     */
    void setApplicationName(String applicationName);

    /**
     * Sets Application Version in PaymentsConfig
     *
     * @param applicationVersion
     */
    void setApplicationVersion(String applicationVersion);

    /**
     * Sets currencyCode in PaymentsConfig
     * @see com.amazon.payments.lpa.types.CurrencyCode
     * @param currencyCode
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     *  Sets environment in PaymentsConfig.
     *  {@link com.amazon.payments.lpa.types.Environment Environment}.
     *
     * @param isSandbox
     */
    void setEnvironment(Environment environment);

    /**
     * Sets proxy host in PaymentsConfig
     *
     * @param proxyHost
     */
    void setProxyHost(String proxyHost);

    /**
     * Set proxy password in PaymentsConfig
     *
     * @param proxyPassword
     */
    void setProxyPassword(String proxyPassword);

    /**
     * Sets proxy port in PaymentsConfig
     *
     * @param proxyPort
     */
    void setProxyPort(int proxyPort);

    /**
     * Sets proxy username in PaymentsConfig
     *
     * @param proxyUsername
     */
    void setProxyUsername(String proxyUsername);

    /**
     * Identifies region associated with Login And Pay with Amazon API operations.
     *                  {@link com.amazon.payments.lpa.types.Region Region}.
     *
     * @param region
     *
     */
    void setRegion(Region region);

    /**
     * Sets SecretKey in PaymentsConfig
     *
     * @param secretAccessKey
     */
    void setSecretKey(String secretAccessKey);

    /**
     * Sets MerchantId/SellerId in PaymentsConfig
     *
     * @param sellerId
     */
    void setSellerId(String sellerId);

    /**
     * Sets autoRetryOnThrottle in PaymentsConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle
     */
    void setUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle);

    /**
     * Sets AccessKey in PaymentsConfig
     *
     * @param accessKeyId
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withAccessKey(String accessKeyId);

    /**
     * This method sets application name in PaymentsConfig
     *
     * @param applicationName
     *
     * @return
     *          Returns updated PaymentsConfig object
     */
    PaymentsConfig withApplicationName(String applicationName);

    /**
     * This method sets application version in PaymentsConfig
     *
     * @param applicationVersion
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withApplicationVersion(String applicationVersion);

    /**
     * Represents currency code to be used for all Login And Pay with Amazon API operations.
     *                  Accepts three-digit currency code. In ISO 4217 format.
     *                  {@link com.amazon.payments.lpa.types.CurrencyCode CurrencyCode}
     *
     * @param currencyCode
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withCurrencyCode(CurrencyCode currencyCode);

    /**
     * This method sets proxy host in PaymentsConfig
     *
     * @param proxyHost
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withProxyHost(String proxyHost);

    /**
     * Sets proxy username in PaymentsConfig.
     * @param proxyPassword
     *
     * @return
     *          Returns updated PaymentsConfig object
     */
    PaymentsConfig withProxyPassword(String proxyPassword);

    /**
     * This method sets proxy port in PaymentsConfig
     *
     * @param proxyPort
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withProxyPort(int proxyPort);

    /**
     *  This methods sets proxy username in PaymentsConfig
     *
     * @param proxyUsername
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withProxyUsername(String proxyUsername);

    /**
     * Identifies region associated with Login And Pay with Amazon API operations.
     *                  {@link com.amazon.payments.lpa.types.Region Region}.
     *
     * @param region
     *
     * @return Returns updated PaymentsConfig object
     *
     */
    PaymentsConfig withRegion(Region region);

    /**
     *  If true, sets environment to SANDBOX mode.
     *  {@link com.amazon.payments.lpa.types.Environment Environment}.
     *
     * @param isSandbox
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withSandboxMode(boolean isSandbox);

    /**
     * Sets SecretKey in PaymentsConfig
     * @param secretAccessKey
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withSecretKey(String secretAccessKey);

    /**
     * Your merchantId/sellerId is a unique identifier supplied by
     * Amazon when you first created your account. This ID can be found
     * in the Amazon Seller Central account.
     *
     * @param sellerId
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withSellerId(String sellerId);

    /**
     * Sets autoRetryOnThrottle in PaymentsConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @return Returns updated PaymentsConfig object
     */
    PaymentsConfig withUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle);
    
}
