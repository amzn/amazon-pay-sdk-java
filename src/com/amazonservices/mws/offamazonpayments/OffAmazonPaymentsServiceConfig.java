/******************************************************************************
 *  Copyright 2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * ****************************************************************************
 */

package com.amazonservices.mws.offamazonpayments;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.amazonservices.mws.offamazonpayments.regionproperties.RegionDependentSettings;
import com.amazonservices.mws.offamazonpayments.regionproperties.UrlBuilder;

import static com.amazonservices.mws.offamazonpayments.PropertyKey.*;

/**
 * Configuration for accessing Off Amazon Payments Service service
 */
public class OffAmazonPaymentsServiceConfig {

	private String accessKeyId = null;
	private String secretAccessKey = null;
	private String applicationName = null;
	private String applicationVersion = null;
	private String sellerId = null;
	private Region region = null;
	private Environment environment = null;
	private String serviceURL = null;
	private String widgetURL = null;
	private String userAgent = null;
	private String signatureVersion = "2";
	private String signatureMethod = "HmacSHA256";
	private String proxyHost = null;
	private int proxyPort = -1;
	private String proxyUsername = null;
	private String proxyPassword = null;
	private int maxErrorRetry = 3;
	private int maxConnections = 100;
	private String clientId = null;
	private String certCN = "";

	private Properties prop = null;
	private Map<Region, RegionDependentSettings> regionList;

	public OffAmazonPaymentsServiceConfig() {
		setupRegionList();
	}

    public OffAmazonPaymentsServiceConfig(Properties prop)
            throws NullPointerException {

        this();
        this.prop = prop;

        if (prop.isEmpty())
            throw new IllegalArgumentException(
                    "Properties are empty, Need required propeties to proceed configuring PaymentExecutionConfig");
        else {
            if (checkProperty(ACCESS_KEY_ID))
                this.setAccessKeyId(this.getValueForPropertyKey(ACCESS_KEY_ID));

            if (checkProperty(SECRET_ACCESS_KEY))
                this.setSecretAccessKey(this.getValueForPropertyKey(SECRET_ACCESS_KEY));

            if (checkProperty(APPLICATION_NAME))
                this.setApplicationName(this.getValueForPropertyKey(APPLICATION_NAME));

            if (checkProperty(APPLICATION_VERSION))
                this.setApplicationVersion(this.getValueForPropertyKey(APPLICATION_VERSION));

            if (checkProperty(SELLER_ID))
                this.setSellerId(this.getValueForPropertyKey(SELLER_ID));

            if (checkProperty(CERT_CN))
                this.setCertCN(this.getValueForPropertyKey(CERT_CN));

            if (checkProperty(ENVIRONMENT)) {
                Environment environment = Environment.valueOf(
                        this.getValueForPropertyKey(ENVIRONMENT).toUpperCase());
                this.setEnvironment(environment);
            }

            if (checkProperty(REGION)) {
                Region region = Region.valueOf(this.getValueForPropertyKey(REGION)
                        .toUpperCase());
                this.setRegion(region);
            }

            String serviceUrl = this.getValueForPropertyKey(SERVICE_URL);
            if (serviceUrl != null)
                this.serviceURL = serviceUrl;

            String widgetUrl = this.getValueForPropertyKey(WIDGET_URL);
            if (widgetUrl != null)
                this.widgetURL = widgetUrl;

            String proxyHost = this.getValueForPropertyKey(PROXY_HOST);
            if (proxyHost != null)
                this.setProxyHost(proxyHost);

            if (this.getValueForPropertyKey(PROXY_PORT) != null)
                this.setProxyPort(Integer.parseInt(this.getValueForPropertyKey(PROXY_HOST)));

            String proxyUsername = this.getValueForPropertyKey(PROXY_USERNAME);
            if (proxyUsername != null)
                this.setProxyUsername(proxyUsername);

            String proxyPassword = this.getValueForPropertyKey(PROXY_PASSWORD);
            if (proxyPassword != null)
                this.setProxyPassword(proxyPassword);

            if (this.getValueForPropertyKey(MAX_ERROR_RETRY) != null)
                this.setMaxErrorRetry(Integer.parseInt(
                        this.getValueForPropertyKey(MAX_ERROR_RETRY)));

            if (this.getValueForPropertyKey(MAX_CONNECTIONS) != null)
                this.setMaxConnections(Integer.parseInt(
                        this.getValueForPropertyKey(MAX_CONNECTIONS)));

            String clientId = this.getValueForPropertyKey(CLIENT_ID);
            if (clientId != null) {
                this.setClientId(clientId);
            }
        }
    }

    private String getValueForPropertyKey(PropertyKey propertyKey) {
        return this.prop.getProperty(propertyKey.getPropertyKey());
    }

    /**
     * Function to check the properties file if required values are set
     */
    private boolean checkProperty(PropertyKey propertyKey) {
        if (this.prop.getProperty(propertyKey.toString()) == null)
            throw new NullPointerException(propertyKey.toString() +
                    " is not set, this is a required property to execute the sample");
        else
            return true;
    }

	/**
	 * Gets SignatureVersion property
	 * 
	 * @return Signature Version for signing requests
	 */
	public String getSignatureVersion() {
		return signatureVersion;
	}

	/**
	 * Sets SignatureVersion property
	 * 
	 * @param signatureVersion
	 *            Signature Version for signing requests
	 */
	public void setSignatureVersion(String signatureVersion) {
		this.signatureVersion = signatureVersion;
	}

	/**
	 * Sets SignatureVersion property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param signatureVersion
	 *            Signature Version for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withSignatureVersion(
			String signatureVersion) {
		setSignatureVersion(signatureVersion);
		return this;
	}

	/**
	 * Checks if SignatureVersion property is set
	 * 
	 * @return true if SignatureVersion property is set
	 */
	public boolean isSetSignatureVersion() {
		return true;
	}

	/**
	 * Gets SignatureMethod property
	 * 
	 * @return Signature Method for signing requests
	 */
	public String getSignatureMethod() {
		return signatureMethod;
	}

	/**
	 * Sets SignatureMethod property
	 * 
	 * @param signatureMethod
	 *            Signature Method for signing requests
	 */
	public void setSignatureMethod(String signatureMethod) {
		this.signatureMethod = signatureMethod;
	}

	/**
	 * Sets SignatureMethod property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param signatureMethod
	 *            Signature Method for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withSignatureMethod(
			String signatureMethod) {
		setSignatureMethod(signatureMethod);
		return this;
	}

	/**
	 * Checks if SignatureMethod property is set
	 * 
	 * @return true if SignatureMethod property is set
	 */
	public boolean isSetSignatureMethod() {
		return true;
	}

	/**
	 * Gets UserAgent property
	 * 
	 * @return User Agent String to use when sending request
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * Sets UserAgent property
	 * 
	 * @param userAgent
	 *            User Agent String to use when sending request
	 * 
	 */
	public void setUserAgent(String applicationName, String applicationVersion,
			String programmingLanguage, String... additionalNameValuePairs) {
		if (applicationName == null)
			throw new IllegalArgumentException("applicationName cannot be NULL");
		if (applicationVersion == null)
			throw new IllegalArgumentException(
					"applicationVersion cannot be NULL");
		if (programmingLanguage == null)
			throw new IllegalArgumentException(
					"programmingLanguage cannot be NULL");
		if (additionalNameValuePairs.length % 2 != 0)
			throw new IllegalArgumentException(
					"there must be a matching value for every name you pass in");
		StringBuilder b = new StringBuilder();
		b.append(applicationName);
		b.append("/");
		b.append(applicationVersion);
		b.append(" (Language=");
		b.append(programmingLanguage);
		int i = 0;
		while (i < additionalNameValuePairs.length) {
			String name = additionalNameValuePairs[i];
			String value = additionalNameValuePairs[i + 1];
			b.append("; ");
			b.append(name);
			b.append("=");
			b.append(value);
			i += 2;
		}
		b.append(")");
		this.userAgent = b.toString();
	}

	/**
	 * Sets UserAgent property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param userAgent
	 *            User Agent String to use when sending request
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withUserAgent(String applicationName,
			String applicationVersion, String programmingLanguage,
			String... additionalNameValuePairs) {
		setUserAgent(applicationName, applicationVersion, programmingLanguage,
				additionalNameValuePairs);
		return this;
	}

	/**
	 * Checks if UserAgent property is set
	 * 
	 * @return true if UserAgent property is set
	 */
	public boolean isSetUserAgent() {
		return this.userAgent != null;
	}

	/**
	 * Gets ServiceURL property
	 * 
	 * @return Service Endpoint URL
	 */
	public String getServiceURL() {
		String url = null;

		if (StringUtils.isNotEmpty(serviceURL)) {
			url = serviceURL;
			url = UrlBuilder.buildMwsUrlWithBaseForEnvironment(url,
					this.environment);
		} else {
			if (!regionList.containsKey(this.region))
				return null;
			url = regionList.get(this.region).getMwsUrlForEnvironment(
					this.environment);
		}

		return url;
	}

	/**
	 * Sets ServiceURL property
	 * 
	 * @param serviceURL
	 *            Service Endpoint URL
	 * 
	 */
	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	/**
	 * Sets ServiceURL property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param serviceURL
	 *            Service Endpoint URL
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withServiceURL(String serviceURL) {
		setServiceURL(serviceURL);
		return this;
	}

	/**
	 * Checks if ServiceURL property is set
	 * 
	 * @return true if ServiceURL property is set
	 */
	public boolean isSetServiceURL() {
		return this.serviceURL != null;
	}

	/**
	 * Gets WidgetURL property
	 * 
	 * @return Widget Endpoint URL
	 */
	public String getWidgetURL() {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(widgetURL)) {
			if (!regionList.containsKey(this.region))
				return null;

			String locale = regionList.get(this.region).getLocale();
			String customUrl = widgetURL;
			builder.append(UrlBuilder
					.buildWidgetUrlWithBaseAndLocaleForEnvironment(customUrl,
							locale, this.environment));
		} else {
            if (!regionList.containsKey(this.region))
                return null;
            builder.append(regionList.get(this.region)
                    .getWidgetUrlForEnvironment(this.environment));
        }

		return builder.toString();
	}

	/**
	 * Sets ServiceURL property
	 * 
	 * @param serviceURL
	 *            Service Endpoint URL
	 * 
	 */
	public void setWidgetURL(String widgetURL) {
		this.widgetURL = widgetURL;
	}

	/**
	 * Sets WidgetURL property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param widgetURL
	 *            widget URL
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withWidgetURL(String widgetURL) {
		setWidgetURL(widgetURL);
		return this;
	}

	/**
	 * Checks if WidgetURL property is set
	 * 
	 * @return true if WidgetURL property is set
	 */
	public boolean isSetWidgetURL() {
		return this.widgetURL != null;
	}

	/**
	 * Gets ProxyHost property
	 * 
	 * @return Proxy Host for connection
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * Sets ProxyHost property
	 * 
	 * @param proxyHost
	 *            Proxy Host for connection
	 * 
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * Sets ProxyHost property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param proxyHost
	 *            Proxy Host for connection
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withProxyHost(String proxyHost) {
		setProxyHost(proxyHost);
		return this;
	}

	/**
	 * Checks if ProxyHost property is set
	 * 
	 * @return true if ProxyHost property is set
	 */
	public boolean isSetProxyHost() {
		return this.proxyHost != null;
	}

	/**
	 * Gets ProxyPort property
	 * 
	 * @return Proxy Port for connection
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * Sets ProxyPort property
	 * 
	 * @param proxyPort
	 *            Proxy Port for connection
	 * 
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * Sets ProxyPort property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param proxyPort
	 *            Proxy Port for connection
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withProxyPort(int proxyPort) {
		setProxyPort(proxyPort);
		return this;
	}

	/**
	 * Checks if ProxyPort property is set
	 * 
	 * @return true if ProxyPort property is set
	 */
	public boolean isSetProxyPort() {
		return this.proxyPort != -1;
	}

	/**
	 * Gets ProxyUsername property
	 * 
	 * @return Proxy Username
	 */
	public String getProxyUsername() {
		return proxyUsername;
	}

	/**
	 * Sets ProxyUsername property
	 * 
	 * @param proxyUsername
	 *            Proxy Username for connection
	 * 
	 */
	public void setProxyUsername(String proxyUsername) {
		this.proxyUsername = proxyUsername;
	}

	/**
	 * Sets ProxyUsername property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param proxyUsername
	 *            Proxy Username for connection
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withProxyUsername(String proxyUsername) {
		setProxyUsername(proxyUsername);
		return this;
	}

	/**
	 * Checks if ProxyUsername property is set
	 * 
	 * @return true if ProxyUsername property is set
	 */
	public boolean isSetProxyUsername() {
		return this.proxyUsername != null;
	}

	/**
	 * Gets ProxyPassword property
	 * 
	 * @return Proxy Password
	 */
	public String getProxyPassword() {
		return proxyPassword;
	}

	/**
	 * Sets ProxyPassword property
	 * 
	 * @param proxyPassword
	 *            Proxy Password for connection
	 * 
	 */
	public void setProxyPassword(String proxyPassword) {
		this.proxyPassword = proxyPassword;
	}

	/**
	 * Sets ProxyPassword property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param proxyPassword
	 *            Proxy Password for connection
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withProxyPassword(String proxyPassword) {
		setProxyPassword(proxyPassword);
		return this;
	}

	/**
	 * Checks if ProxyPassword property is set
	 * 
	 * @return true if ProxyPassword property is set
	 */
	public boolean isSetProxyPassword() {
		return this.proxyPassword != null;
	}

	/**
	 * Gets MaxErrorRetry property
	 * 
	 * @return Max number of retries on 500th errors
	 */
	public int getMaxErrorRetry() {
		return maxErrorRetry;
	}

	/**
	 * Sets MaxErrorRetry property
	 * 
	 * @param maxErrorRetry
	 *            Max number of retries on 500th errors
	 * 
	 */
	public void setMaxErrorRetry(int maxErrorRetry) {
		this.maxErrorRetry = maxErrorRetry;
	}

	/**
	 * Sets MaxErrorRetry property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param maxErrorRetry
	 *            Max number of retries on 500th errors
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withMaxErrorRetry(int maxErrorRetry) {
		setMaxErrorRetry(maxErrorRetry);
		return this;
	}

	/**
	 * Checks if MaxErrorRetry property is set
	 * 
	 * @return true if MaxErrorRetry property is set
	 */
	public boolean isSetMaxErrorRetry() {
		return this.maxErrorRetry > 0;
	}

	/**
	 * Gets MaxConnections property
	 * 
	 * @return Max number of http connections
	 */
	public int getMaxConnections() {
		return maxConnections;
	}

	/**
	 * Sets MaxConnections property
	 * 
	 * @param maxConnections
	 *            Max number of http connections
	 * 
	 */
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * Sets MaxConnections property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param maxConnections
	 *            Max number of http connections
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withMaxConnections(int maxConnections) {
		setMaxConnections(maxConnections);
		return this;
	}

	/**
	 * Checks if MaxConnections property is set
	 * 
	 * @return true if MaxConnections property is set
	 */
	public boolean isSetMaxConnections() {
		return this.maxConnections > 0;
	}

	/**
	 * Gets AccessKeyId property
	 * 
	 * @return Access Key Id for signing requests
	 */
	public String getAccessKeyId() {
		return accessKeyId;
	}

	/**
	 * Sets AccessKeyId property
	 * 
	 * @param accessKeyId
	 *            Access Key Id for signing requests
	 */
	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	/**
	 * Sets AccessKeyId property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param accessKeyId
	 *            Access Key Id for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withAccessKeyId(String accessKeyId) {
		setAccessKeyId(accessKeyId);
		return this;
	}

	/**
	 * Checks if AccessKeyId property is set
	 * 
	 * @return true if AccessKeyId property is set
	 */
	public boolean isSetAccessKeyId() {
		return this.accessKeyId != null;
	}

	/**
	 * Gets SecretAccessKey property
	 * 
	 * @return Secret Access Key for signing requests
	 */
	public String getSecretAccessKey() {
		return secretAccessKey;
	}

	/**
	 * Sets SecretAccessKey property
	 * 
	 * @param secretAccessKey
	 *            Secret Access Key for signing requests
	 */
	public void setSecretAccessKey(String secretAccessKey) {
		this.secretAccessKey = secretAccessKey;
	}

	/**
	 * Sets SecretAccessKey property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param secretAccessKey
	 *            Secret Access Key for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withSecretAccessKey(
			String secretAccessKey) {
		setSecretAccessKey(secretAccessKey);
		return this;
	}

	/**
	 * Checks if SecretAccessKey property is set
	 * 
	 * @return true if SecretAccessKey property is set
	 */
	public boolean isSetSecretAccessKey() {
		return this.secretAccessKey != null;
	}

	/**
	 * Gets SellerId property
	 * 
	 * @return Seller Id for signing requests
	 */
	public String getSellerId() {
		return sellerId;
	}

	/**
	 * Sets SellerId property
	 * 
	 * @param sellerId
	 *            Seller Id for signing requests
	 */
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	/**
	 * Sets SellerId property and returns current OffAmazonPaymentsServiceConfig
	 * 
	 * @param sellerId
	 *            Seller Id for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withSellerId(String sellerId) {
		setSellerId(sellerId);
		return this;
	}

	/**
	 * Checks if SellerId property is set
	 * 
	 * @return true if SellerId property is set
	 */
	public boolean isSetSellerId() {
		return this.sellerId != null;
	}

	/**
	 * Gets Environment property
	 * 
	 * @return Environment for signing requests
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * Sets Environment property
	 * 
	 * @param Environment
	 *            for signing requests
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	/**
	 * Sets Environment property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param environment
	 *            Environment for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withEnvironment(
			Environment environment) {
		setEnvironment(environment);
		return this;
	}

	/**
	 * Checks if Environment property is set
	 * 
	 * @return true if Environment property is set
	 */
	public boolean isSetEnvironment() {
		return this.environment != null;
	}

	/**
	 * Gets Region property
	 * 
	 * @return Region for signing requests
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Sets Region property
	 * 
	 * @param region
	 *            Region for signing requests
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Sets Region property and returns current OffAmazonPaymentsServiceConfig
	 * 
	 * @param region
	 *            Region for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withRegion(Region region) {
		setRegion(region);
		return this;
	}

	/**
	 * Checks if Region property is set
	 * 
	 * @return true if Region property is set
	 */
	public boolean isSetRegion() {
		return this.region != null;
	}

	/**
	 * Gets ApplicationName property
	 * 
	 * @return Application Name for signing requests
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * Sets ApplicationName property
	 * 
	 * @param applicationName
	 *            Application Name for signing requests
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * Sets ApplicationName property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param applicationName
	 *            Application Name for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withApplicationName(
			String applicationName) {
		setApplicationName(applicationName);
		return this;
	}

	/**
	 * Checks if ApplicationName property is set
	 * 
	 * @return true if ApplicationName property is set
	 */
	public boolean isSetApplicationName() {
		return this.applicationName != null;
	}

	/**
	 * Gets ApplicationVersion property
	 * 
	 * @return Application Version for signing requests
	 */
	public String getApplicationVersion() {
		return applicationVersion;
	}

	/**
	 * Sets ApplicationVersion property
	 * 
	 * @param applicationVersion
	 *            Application Version for signing requests
	 */
	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	/**
	 * Sets ApplicationVersion property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param applicationVersion
	 *            Application Version for signing requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withApplicationVersion(
			String applicationVersion) {
		setApplicationVersion(applicationVersion);
		return this;
	}

	/**
	 * Checks if ApplicationVersion property is set
	 * 
	 * @return true if ApplicationVersion property is set
	 */
	public boolean isSetApplicationVersion() {
		return this.applicationVersion != null;
	}

	/**
	 * Returns the default currency code for this region
	 * 
	 * @return string currency code for use in service calls
	 */
	public String getCurrencyCode() {
		return this.regionList.get(this.region).getCurrencyCode();
	}

	/**
	 * Checks if the currency code is set
	 * 
	 * @return true if a currency code can be derived
	 */
	public boolean isSetCurrencyCode() {
		if (isSetRegion()) {
			return regionList.containsKey(this.region);
		}

		return false;
	}
	

	/**
	 * Checks if ClientId property is set
	 * 
	 * @return true if clientId property is set
	 */
	public boolean isSetClientId() {
		return this.clientId != null;
	}

	/**
	 * Gets ClientId property
	 * 
	 * @return clientId for making LwA requests
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Sets ClientId property
	 * 
	 * @param clientId
	 *            clientId for making LwA requests
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Sets ClientId property and returns current
	 * OffAmazonPaymentsServiceConfig
	 * 
	 * @param clientId
	 *            clientId for making LwA requests
	 * 
	 * @return OffAmazonPaymentsServiceConfig
	 */
	public OffAmazonPaymentsServiceConfig withClientId(String clientId) {
		setClientId(clientId);
		return this;
	}

    /*
     * Get certCN property
     *
     * @return certCN for validating signing cert for IPN messages
     */
    public String getCertCN() {
		return this.certCN;
	}

    /*
     * Sets CertCN property
     *
     * @param certCN
     *          certificate name to validate certificate used
     *          to sign IPN messages
     *
     */
    public void setCertCN(String certCN) {
        this.certCN = certCN;
    }

    /**
     * Sets CertCN property and returns current
     * OffAmazonPaymentsServiceConfig
     *
     * @param certCN
     *          certificate name to validate certificate used
     *          to sign IPN messages
     *
     * @return OffAmazonPaymentsServiceConfig
     */
    public OffAmazonPaymentsServiceConfig withCertCN(String certCN) {
        setCertCN(certCN);
        return this;
    }

    /**
     * Setup the region list configuration
     *
     */
    private void setupRegionList() {
        this.regionList = new HashMap<Region, RegionDependentSettings>();
        this.regionList.put(Region.DE, new RegionDependentSettings(Region.DE));
        this.regionList.put(Region.UK, new RegionDependentSettings(Region.UK));
        this.regionList.put(Region.US, new RegionDependentSettings(Region.US));
        this.regionList.put(Region.NA, new RegionDependentSettings(Region.US));
        this.regionList.put(Region.JP, new RegionDependentSettings(Region.JP));
    }

}