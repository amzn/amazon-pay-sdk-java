/*******************************************************************************
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
 * *****************************************************************************
 */

package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;

import static com.amazonservices.mws.offamazonpayments.common.FragmentBuilderConstants.FRAGMENT_NAMESPACE;

public class JSONFragmentBuilder implements FragmentBuilder {

    private static final String JSON_FIELD_SEPARATOR = ", ";
    private static final String JSON_KEY_VALUE_SEPARATOR = " : ";
    private static final String JSON_HEADER_POSTFIX = "\" : {";
    private static final String JSON_HEADER_PREFIX = "{\"";
    private static final String JSON_NAMESPACE_DELIMITER = quoteJSON("@xmlns");
    private static final String JSON_VERSION_STRING = quoteJSON(FRAGMENT_NAMESPACE);
    private static final String JSON_OPEN_NODE = "{";
    private static final String JSON_CLOSE_NODE = "}";
    private static final String JSON_ARRAY_START = "[";
    private static final String JSON_ARRAY_CLOSE = "]";

    private StringBuilder buffer = new StringBuilder();
    private boolean first = true;
    private boolean hasHeader = false;
    private boolean firstElementInCollection = true;

    @Override
    public void addFieldToFragmentIfSet(String fieldName, Object fieldValue) throws OffAmazonPaymentsServiceException {
        if (fieldValue != null) {
            checkForFirstItemInBuffer();
            buffer.append(quoteJSON(fieldName));
            buffer.append(JSON_KEY_VALUE_SEPARATOR);
            buffer.append(getValueForObject(fieldValue));
        }
    }

    private void checkForFirstItemInBuffer() {
        if (!first) {
            buffer.append(JSON_FIELD_SEPARATOR);
        } else {
            first = false;
        }
    }

    @Override
    public void addHeaderFieldWith(String className) {
        buffer.append(JSON_HEADER_PREFIX + className + JSON_HEADER_POSTFIX);
        buffer.append(JSON_NAMESPACE_DELIMITER);
        buffer.append(JSON_KEY_VALUE_SEPARATOR);
        buffer.append(JSON_VERSION_STRING);
        buffer.append(JSON_FIELD_SEPARATOR);
        hasHeader = true;
    }

    private String getValueForObject(Object fieldValue) throws OffAmazonPaymentsServiceException {
        if ( ReflectionUtils.shouldPrintValueOfType(fieldValue) ) {
            return quoteJSON(fieldValue.toString());
        }
        else {
            return JSON_OPEN_NODE + ReflectionUtils.invokeMethodOn(fieldValue, "toJSONFragment").toString() + JSON_CLOSE_NODE;
        }
    }

    @Override
    public String build() {
        if (hasHeader) {
            buffer.append(JSON_CLOSE_NODE).append(JSON_CLOSE_NODE);
        }

        return buffer.toString();
    }

    @Override
    public void addCollectionHeader(String fieldName) {
        checkForFirstItemInBuffer();
        buffer.append(quoteJSON(fieldName)).append(JSON_KEY_VALUE_SEPARATOR).append(JSON_ARRAY_START);
        firstElementInCollection = true;
    }

    @Override
    public void addCollectionValue(String collectionName, Object fieldValue) throws OffAmazonPaymentsServiceException {
        if (fieldValue != null) {
            if (!firstElementInCollection) {
                buffer.append(JSON_FIELD_SEPARATOR);
            }

            buffer.append(getValueForObject(fieldValue));
            firstElementInCollection = false;
        }
    }

    @Override
    public void closeCollectionHeader(String fieldName) {
        buffer.append(JSON_ARRAY_CLOSE);
    }

    /**
     *
     * Quote JSON string
     */
    private static String quoteJSON(String string) {
        StringBuffer sb = new StringBuffer();
        sb.append("\"");
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    if (c <  ' ') {
                        sb.append("\\u" + String.format("%03x", Integer.valueOf(c)));
                    } else {
                        sb.append(c);
                    }
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}
