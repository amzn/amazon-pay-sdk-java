package com.amazon.payments.lpa;

import com.amazon.payments.lpa.types.Environment;
import com.amazon.payments.lpa.types.Region;

public class ClientConfig {
        private String accessKeyId;
	private String secretAccessKey;
	private String sellerId;
	private Region region;
	private Environment environment;
        private String applicationName;
        private String applicationVersion;
        private String proxyHost = null;
        private int proxyPort = -1;
        private String proxyUsername;
        private String proxyPassword;
        private String currencyCode;

        
    /*
     * Create client configuration
     * @param merchantId
     * @param accessKey
     * @param secretKey
     * @param region 
     * @param environment 
    */
    public ClientConfig(String merchantId, String accessKey, String secretKey, Region region, Environment environment, String currencyCode) {
        this.accessKeyId = accessKey;
        this.secretAccessKey = secretKey;
        this.sellerId = merchantId;
        this.region = region;
        this.environment = environment;
        this.currencyCode = currencyCode;
    }
    
    public Region getRegion() {
        return region;
    }
        
    public String getAccessKeyId() {
        return accessKeyId;
    }
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public String getSellerId() {
        return sellerId;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public ClientConfig withApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public ClientConfig withApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
        return this;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public ClientConfig withProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
        return this;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public ClientConfig withProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }

    public String getProxyUsername() {
        return proxyUsername;
    }

    public ClientConfig withProxyUsername(String proxyUsername) {
        this.proxyUsername = proxyUsername;
        return this;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public ClientConfig withProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public ClientConfig withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    
}