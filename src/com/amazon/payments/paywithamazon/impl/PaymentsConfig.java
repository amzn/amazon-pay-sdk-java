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
    private String sellerId;
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
     * Required parameters are merchantId/sellerId, accessKey and secretKey.
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
        //default values
        this.region = Region.US;
        this.environment = Environment.LIVE;
        this.currencyCode = CurrencyCode.USD;
    }
    
    public PaymentsConfig(Properties prop) {
        loadConfigurationFromProperties(prop);
        checkIfRequriedPropertiesExist();
    }
    
    /**
     * Returns the MerchantId/SellerId from PaymentsConfig
     * 
     * @return sellerId
     */
    @Override
    public String getSellerId() {
        return sellerId;
    }
    
    /**
     * Sets MerchantId/SellerId in PaymentsConfig
     * 
     * @param sellerId 
     */
    @Override
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
    
    /**
     * Your merchantId/sellerId is a unique identifier supplied by 
     * Amazon when you first created your account. This ID can be found 
     * in the Amazon Seller Central account.  
     * 
     * @param sellerId 
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
    public PaymentsConfig withSellerId(String sellerId) {
        this.sellerId = sellerId;
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
     * Sets AccessKey in PaymentsConfig
     * 
     * @param accessKey 
     */
    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
    
    /**
     * Sets AccessKey in PaymentsConfig
     * 
     * @param accessKey 
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * Sets SecretKey in PaymentsConfig
     * 
     * @param secretKey 
     */
    @Override
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    
    /**
     * Sets SecretKey in PaymentsConfig
     * @param secretKey 
     * @return Returns updated PaymentsConfig object
     */
    @Override
    public PaymentsConfig withSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }


    
    /**
     * Returns region code from PaymentsConfig
     * 
     * @see com.amazon.payments.lpa.types.Region
     * 
     * @return region
     */
    @Override
    public Region getRegion() {
        return region;
    }
    
    /**
     * Identifies region associated with Login And Pay with Amazon API operations. 
     *                  {@link com.amazon.payments.lpa.types.Region Region}.
     * 
     * @param region
     * 
     */
    @Override
    public void setRegion(Region region) {
        this.region = region;
    }
    
        
    /**
     * Identifies region associated with Login And Pay with Amazon API operations. 
     *                  {@link com.amazon.payments.lpa.types.Region Region}.
     * 
     * @param region
     * 
     * @return Returns updated PaymentsConfig object
     * 
     */
    @Override
    public PaymentsConfig withRegion(Region region) {
        this.region = region;
        return this;
    }    
    
    
    

    /**
     * Returns the environment from PaymentsConfig
     * @see com.amazon.payments.lpa.types.Environment
     * 
     * @return environment
     */
    @Override
    public Environment getEnvironment() {
        return environment;
    }

    /**
     *  Sets environment in PaymentsConfig. 
     *  {@link com.amazon.payments.lpa.types.Environment Environment}.
     * 
     * @param environment 
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
    
    
    /**
     *  If true, sets environment to SANDBOX mode. 
     *  {@link com.amazon.payments.lpa.types.Environment Environment}.
     * 
     * @param isSandbox 
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
    public PaymentsConfig withSandboxMode(boolean isSandbox) {
        if(isSandbox) 
            this.environment = Environment.SANDBOX;
        else 
            this.environment = Environment.LIVE;
        return this;
    }
    
    

    
    
    
    /**
     * Returns currencyCode in PaymentsConfig
     * @see com.amazon.payments.lpa.types.CurrencyCode
     * 
     * @return currencyCode
     */
    @Override
    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }
    
    /**
     * Sets currencyCode in PaymentsConfig
     * @see com.amazon.payments.lpa.types.CurrencyCode
     * @param currencyCode 
     */
    @Override
    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }
    
    /**
     * Represents currency code to be used for all Login And Pay with Amazon API operations. 
     *                  Accepts three-digit currency code. In ISO 4217 format.   
     *                  {@link com.amazon.payments.lpa.types.CurrencyCode CurrencyCode}
     * 
     * @param currencyCode
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * @param applicationName 
     */
    @Override
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * This method sets application name in PaymentsConfig
     * 
     * @param applicationName 
     * 
     * @return 
     *          Returns updated PaymentsConfig object
     */
    @Override
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
     * Sets Application Version in PaymentsConfig
     * 
     * @param applicationVersion 
     */
    @Override
    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    /**
     * This method sets application version in PaymentsConfig
     * 
     * @param applicationVersion 
     *                    
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * Sets proxy host in PaymentsConfig
     * 
     * @param proxyHost 
     */
    @Override
    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }
    
    /**
     * This method sets proxy host in PaymentsConfig
     * 
     * @param proxyHost 
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * Sets proxy port in PaymentsConfig
     * 
     * @param proxyPort 
     */
    @Override
    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }
    
    /**
     * This method sets proxy port in PaymentsConfig
     * 
     * @param proxyPort
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * Sets proxy username in PaymentsConfig
     * 
     * @param proxyUsername 
     */
    @Override
    public void setProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
    }

    
    /**
     *  This methods sets proxy username in PaymentsConfig
     * 
     * @param proxyUsername 
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
     * Set proxy password in PaymentsConfig
     * 
     * @param proxyPassword 
     */
    @Override
    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    /**
     * Sets proxy username in PaymentsConfig.
     * @param proxyPassword
     *             
     * @return 
     *          Returns updated PaymentsConfig object
     */
    @Override
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
     * @param useAutoRetryOnThrottle
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
     * @param useAutoRetryOnThrottle
     * 
     * @return Returns updated PaymentsConfig object
     */
    @Override
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
        else if(this.sellerId == null)
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
                + "sellerId=" + sellerId + ", region=" + region + ", environment=" + environment + ", currencyCode=" +
                currencyCode + ", applicationName=" + applicationName + ", applicationVersion=" + applicationVersion + ", "
                + "proxyHost=" + proxyHost + ", proxyPort=" + proxyPort + ", proxyUsername=" + proxyUsername + ", proxyPassword=" + 
                proxyPassword + ", useAutoRetryOnThrottle=" + useAutoRetryOnThrottle + '}';
    }


}