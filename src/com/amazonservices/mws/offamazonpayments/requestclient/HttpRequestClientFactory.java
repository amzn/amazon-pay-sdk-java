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
package com.amazonservices.mws.offamazonpayments.requestclient;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import static com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConstants.CLIENT_VERSION;

public class HttpRequestClientFactory {

    private static final Log LOG = LogFactory.getLog(HttpRequestClientFactory.class);

    private static final String APPLICATION_LIBRARY_VERSION = "DEVELOPMENT-BUILD";

    private final OffAmazonPaymentsServiceConfig config;

    public HttpRequestClientFactory(OffAmazonPaymentsServiceConfig config) {
        this.config = config;
    }

    public HttpRequestClient createInstance() {
        return configureNewHttpClient();
    }

    /**
     * Configure HttpClient with set of defaults as well as configuration from
     * MarketplaceWebServiceProductsConfig instance
     */
    private HttpRequestClient configureNewHttpClient() {

        /* Set http client parameters */
        HttpClientParams httpClientParams = new HttpClientParams();
        if (config.getUserAgent() == null) {
            config.setUserAgent(quoteAppName(config.getApplicationName()), quoteAppVersion(config.getApplicationVersion()),
                    quoteAttributeValue("Java/" + System.getProperty("java.version") + "/"
                            + System.getProperty("java.class.version") + "/" + System.getProperty("java.vendor")),

                    quoteAttributeName("Platform"), quoteAttributeValue("" + System.getProperty("os.name") + "/"
                            + System.getProperty("os.arch") + "/" + System.getProperty("os.version")),

                    quoteAttributeName("MWSClientVersion"), quoteAttributeValue(CLIENT_VERSION),
                    quoteAttributeName("ApplicationLibraryVersion"), quoteAttributeValue(APPLICATION_LIBRARY_VERSION));

        }
        httpClientParams.setParameter(HttpMethodParams.USER_AGENT, config.getUserAgent());
        httpClientParams.setParameter(HttpClientParams.RETRY_HANDLER, new HttpMethodRetryHandler() {

            public boolean retryMethod(HttpMethod method, IOException exception, int executionCount) {
                if (executionCount > 3) {
                    LOG.debug("Maximum Number of Retry attempts reached, will not retry");
                    return false;
                }
                LOG.debug("Retrying request. Attempt " + executionCount);
                if (exception instanceof NoHttpResponseException) {
                    LOG.debug("Retrying on NoHttpResponseException");
                    return true;
                }
                if (exception instanceof InterruptedIOException) {
                    LOG.debug("Will not retry on InterruptedIOException", exception);
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                    LOG.debug("Will not retry on UnknownHostException", exception);
                    return false;
                }
                if (!method.isRequestSent()) {
                    LOG.debug("Retrying on failed sent request");
                    return true;
                }
                return false;
            }
        });

        /* Set host configuration */
        HostConfiguration hostConfiguration = new HostConfiguration();

        /* Set connection manager parameters */
        HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
        connectionManagerParams.setConnectionTimeout(50000);
        connectionManagerParams.setSoTimeout(50000);
        connectionManagerParams.setStaleCheckingEnabled(true);
        connectionManagerParams.setTcpNoDelay(true);
        connectionManagerParams.setMaxTotalConnections(config.getMaxConnections());
        connectionManagerParams.setMaxConnectionsPerHost(hostConfiguration, config.getMaxConnections());

        /* Set connection manager */
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.setParams(connectionManagerParams);

        /* Set http client */
        HttpClient httpClient = new HttpClient(httpClientParams, connectionManager);

        /* Set proxy if configured */
        if (config.isSetProxyHost() && config.isSetProxyPort()) {
            LOG.info("Configuring Proxy. Proxy Host: " + config.getProxyHost() + "Proxy Port: " + config.getProxyPort());
            hostConfiguration.setProxy(config.getProxyHost(), config.getProxyPort());
            if (config.isSetProxyUsername() && config.isSetProxyPassword()) {
                httpClient.getState().setProxyCredentials(new AuthScope(config.getProxyHost(), config.getProxyPort()),
                        new UsernamePasswordCredentials(config.getProxyUsername(), config.getProxyPassword()));

            }
        }

        httpClient.setHostConfiguration(hostConfiguration);
        return new HttpRequestClient(httpClient, config);
    }

    /**
     * Remove all leading whitespace, trailing whitespace, repeated whitespace
     * and replace any interior whitespace with a single space
     */
    private String clean(String s) {
        return s.replaceAll("\\s", " ").replaceAll(" {2,}", " ").trim();
    }

    private String quoteAppName(String s) {
        return clean(s).replace("\\", "\\\\").replace("/", "\\/");
    }

    private String quoteAppVersion(String s) {
        return clean(s).replace("\\", "\\\\").replace("(", "\\(");
    }

    private String quoteAttributeName(String s) {
        return clean(s).replace("\\", "\\\\").replace("=", "\\=");
    }

    private String quoteAttributeValue(String s) {
        return clean(s).replace("\\", "\\\\").replace(";", "\\;").replace(")", "\\)");
    }
}
