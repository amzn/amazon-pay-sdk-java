package com.amazon.payments.paywithamazon.impl;

import com.amazon.payments.paywithamazon.Config;
import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;
import com.amazon.payments.paywithamazon.response.model.Environment;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import com.amazon.payments.paywithamazon.types.Key;
import com.amazon.payments.paywithamazon.types.Region;
import java.util.Enumeration;
import java.util.Properties;

public class PaymentsConfig implements Config  {

    private String accessKey;
    private String secretKey;
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

    /**
     * Constructor for PaymentsConfig - container that stores all configuration parameters for client
     *
     * Required parameters are merchantId, accessKey and secretKey.
     * Specify them using
     * .withSellerId() & .withAccessKeyId() & .withSecretKey()

     * Note that default currency code is USD and default region code is US
     * You can override default values using
     * .withRegionCode() & .withCurrencyCode()
     *
     * Default environment is Live mode.
     * You can override default environment using
     * .withSandboxMode(true)
     *
     * Optional proxy parameters allow to connect via proxy using
     * parameters like withProxyHost(), withProxyPort(), withProxyUserName(), withProxyPassword().
     *
     */
    public PaymentsConfig()  {

    }

    public PaymentsConfig(Properties prop) {
        loadConfigurationFromProperties(prop);
        checkIfRequriedPropertiesExist();
    }


    /**
     * Returns the MerchantId from PaymentsConfig
     *
     * @return merchantId
     */
    @Override
    public String getSellerId() {
        return merchantId;
    }


    /**
     *
     * @param merchantId - Sets MerchantId/SellerId in PaymentsConfig
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
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withSellerId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    /**
     * Returns AccessKey from PaymentsConfig
     *
     * @return accessKeyId
     */
    @Override
    public String getAccessKey() {
        return accessKey;
    }


    /**
     *
     * @param accessKey - Sets AccessKey in PaymentsConfig
     */
    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }


    /**
     *
     * @param accessKey - Sets AccessKey in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }


    /**
     * Returns SecretKey from PaymentsConfig
     *
     * @return secretAccessKey
     *
     */
    @Override
    public String getSecretKey() {
        return secretKey;
    }


    /**
     *
     * @param secretKey - Sets SecretKey in PaymentsConfig
     */
    @Override
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    /**
     *
     * @param secretKey - Sets SecretKey in PaymentsConfig
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }


    /**
     * Returns region code from PaymentsConfig
     *
     * @see com.amazon.payments.paywithamazon.Config
     *
     * @return region
     */
    @Override
    public Region getRegion() {
        return region;
    }


    /**
     *
     * @param region - Identifies region associated with Login And Pay with Amazon API operations.
     *
     */
    @Override
    public void setRegion(Region region) {
        this.region = region;
    }


    /**
     *
     * @param region - Identifies region associated with Login And Pay with Amazon API operations.
     *
     * @return Returns updated PaymentsConfig object
     *
     */
    public PaymentsConfig withRegion(Region region) {
        this.region = region;
        return this;
    }


    /**
     * Returns the environment from PaymentsConfig
     *
     * @return environment
     */
    @Override
    public Environment getEnvironment() {
        return environment;
    }


    /**
     *
     * @param environment - Sets environment in PaymentsConfig.
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
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withSandboxMode(boolean isSandbox) {
        if(isSandbox)
            this.environment = Environment.SANDBOX;
        else
            this.environment = Environment.LIVE;
        return this;
    }


    /**
     * Returns currencyCode in PaymentsConfig
     * @see com.amazon.payments.paywithamazon.impl.PaymentsConfig
     *
     * @return currencyCode
     */
    @Override
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }


    /**
     *
     * @param currencyCode  - Sets currencyCode in PaymentsConfig
     */
    @Override
    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }


    /**
     *
     * @param currencyCode - Represents currency code to be used for all Login And Pay with Amazon API operations.
     *                       Accepts three-digit currency code, such as USD (dollars), EUR (euros), GBP (pounds) or JPY (Japanese Yen).
     *                       The currency code in ISO 4217 format.
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    /**
     * Returns the application name from PaymentsConfig
     *
     * @return applicationName
     *
     */
    @Override
    public String getApplicationName() {
        return applicationName;
    }


    /**
     * Sets Application Name in PaymentsConfig
     *
     * @param applicationName - Sets application name
     */
    @Override
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }


    /**
     *
     * @param applicationName - This method sets application name in PaymentsConfig
     *
     * @return - Returns updated PaymentsConfig object
     *
     */
    public PaymentsConfig withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }


    /**
     * Returns the application version set in PaymentsConfig
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
     * @param applicationVersion -Sets Application Version in PaymentsConfig
     */
    @Override
    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }


    /**
     *
     * @param applicationVersion - This method sets application version in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }


    /**
     * Returns the proxy host set in the PaymentsConfig
     *
     * @return proxyHost
     */
    @Override
    public String getProxyHost() {
        return proxyHost;
    }


    /**
     *
     * @param proxyHost - Sets proxy host in PaymentsConfig
     */
    @Override
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }


    /**
     *
     * @param proxyHost - This method sets proxy host in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
        return this;
    }


    /**
     * Returns proxy port from PaymentsConfig
     *
     * @return proxyPort
     */
    @Override
    public int getProxyPort() {
        return proxyPort;
    }


    /**
     *
     * @param proxyPort - Sets proxy port in PaymentsConfig
     */
    @Override
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }


    /**
     *
     * @param proxyPort - This method sets proxy port in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }


    /**
     * Returns proxy username from PaymentsConfig
     *
     * @return proxyUsername
     */
    @Override
    public String getProxyUsername() {
        return proxyUsername;
    }

    /**
     *
     * @param proxyUsername - Sets proxy username in PaymentsConfig
     */
    @Override
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }


    /**
     *
     * @param proxyUsername - This methods sets proxy username in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
        return this;
    }


    /**
     * Returns proxy password in PaymentsConfig
     *
     * @return proxyPassword
     */
    @Override
    public String getProxyPassword() {
        return proxyPassword;
    }


    /**
     *
     * @param proxyPassword - Set proxy password in PaymentsConfig
     */
    @Override
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }


    /**
     *
     * @param proxyPassword - Sets proxy username in PaymentsConfig.
     *
     * @return
     *          Returns updated PaymentsConfig object
     */
    public PaymentsConfig withProxyPassword(String proxyPassword) {
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
     * Sets autoRetryOnThrottle in PaymentsConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle - argument that sets autoRetryOnThrottle in PaymentsConfig
     */
    @Override
    public void setUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle) {
        this.useAutoRetryOnThrottle = useAutoRetryOnThrottle;
    }


    /**
     * Sets autoRetryOnThrottle in PaymentsConfig
     * If set to true, client will retry on service exceptions that are either 500 internal server
     * errors, 503 service unavailable errors, service throttling errors.
     *
     * @param useAutoRetryOnThrottle  - argument that sets autoRetryOnThrottle in PaymentsConfig
     *
     * @return Returns updated PaymentsConfig object
     */
    public PaymentsConfig withUseAutoRetryOnThrottle(boolean useAutoRetryOnThrottle) {
        this.useAutoRetryOnThrottle = useAutoRetryOnThrottle;
        return this;
    }


    private PaymentsConfig loadConfigurationFromProperties(Properties prop) {
        if (prop == null || prop.isEmpty())
            throw new IllegalArgumentException("Properties are empty, Need required propeties to proceed configuring amazon payments client");

        Enumeration enumeration = prop.propertyNames();

        while(enumeration.hasMoreElements()) {
            String property = (String) enumeration.nextElement();
            try {
                switch (Key.valueOf(property.toUpperCase())) {
                    case ACCESS_KEY:
                        this.setAccessKey(prop.getProperty(property));
                        break;
                    case SECRET_KEY:
                        this.setSecretKey(prop.getProperty(property));
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
                        if(proxyPortProperty != null && !proxyPortProperty.isEmpty())
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
        else if(this.secretKey == null)
            generateException(Key.SECRET_KEY);
        else if(this.merchantId == null)
            generateException(Key.MERCHANT_ID);
        else if(this.environment == null)
            generateException(Key.ENVIRONMENT);
        else if(this.region == null)
            generateException(Key.REGION);
        else if(this.currencyCode == null)
            generateException(Key.CURRENCY_CODE);
        return true;

    }


    private void generateException(Key propertyKey) {
        throw new IllegalArgumentException(propertyKey.toString() +
                " property is not set, this is a required property for Amazon Payments client configuration");
    }


    /**
     * The string representation of configuration parameters
     *
     * @return Returns the string representation of configuration parameters
     */
    @Override
    public String toString() {
        return "PaymentsConfig{" + "accessKeyId=" + accessKey + ", secretAccessKey=" + secretKey + ", "
                + "sellerId=" + merchantId + ", region=" + region + ", environment=" + environment + ", currencyCode=" +
                currencyCode + ", applicationName=" + applicationName + ", applicationVersion=" + applicationVersion + ", "
                + "proxyHost=" + proxyHost + ", proxyPort=" + proxyPort + ", proxyUsername=" + proxyUsername + ", proxyPassword=" +
                proxyPassword + ", useAutoRetryOnThrottle=" + useAutoRetryOnThrottle + '}';
    }


}
