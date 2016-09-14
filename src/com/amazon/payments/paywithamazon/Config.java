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
     *
     * @return currencyCode
     */
    CurrencyCode getCurrencyCode();

    /**
     * Returns the environment from PaymentsConfig
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
     * @see com.amazon.payments.paywithamazon.impl.PaymentsConfig
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
     * @param currencyCode
     */
    void setCurrencyCode(CurrencyCode currencyCode);

    /**
     *  Sets environment in PaymentsConfig.
     *
     * @param environment
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


}
