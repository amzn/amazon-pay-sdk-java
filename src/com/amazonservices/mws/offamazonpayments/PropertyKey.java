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

public enum PropertyKey {
    ACCESS_KEY_ID("accessKeyId"),
    SECRET_ACCESS_KEY("secretAccessKey"),
    APPLICATION_NAME("applicationName"),
    APPLICATION_VERSION("applicationVersion"),
    SELLER_ID("sellerId"),
    ENVIRONMENT("environment"),
    REGION("region"),
    SERVICE_URL("serviceURL"),
    WIDGET_URL("widgetURL"),
    PROXY_HOST("proxyHost"),
    PROXY_PORT("proxyPort"),
    PROXY_USERNAME("proxyUsername"),
    PROXY_PASSWORD("proxyPassword"),
    MAX_ERROR_RETRY("maxErrorRetry"),
    MAX_CONNECTIONS("maxConnections"),
    CLIENT_ID("clientId"),
    CERT_CN("certCN");

    private final String propertyKey;

    private PropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    @Override
    public String toString() {
        return getPropertyKey();
    }
}
