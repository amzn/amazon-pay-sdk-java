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

import javax.xml.datatype.XMLGregorianCalendar;

public class XmlFragmentBuilder implements FragmentBuilder {

    private static final String XML_ELEMENT_OPEN_TAG = "<";
    private static final String XML_TAG_CLOSE = ">";
    private static final String XML_ELEMENT_CLOSE_TAG = "</";
    private static final String XML_AMPERSAND_ESCAPED = "&amp;";
    private static final String XML_LESS_THAN_ESCAPED = "&lt;";
    private static final String XML_GREATER_THAN_ESCAPED = "&gt;";
    private static final String XML_BACKSLASH_ESCAPED = "&#039;";
    private static final String XML_QUOTE_ESCAPED = "&quot;";
    private static final String XML_NS = " xmlns=\"" + FragmentBuilderConstants.FRAGMENT_NAMESPACE + "\"";

    private StringBuffer buffer = new StringBuffer();
    private boolean hasHeader = false;
    private String headerCloseTag = null;
    private String errorTagName = null;

    @Override
    public void addFieldToFragmentIfSet(String fieldName, Object fieldValue) throws OffAmazonPaymentsServiceException {
        if (fieldValue != null) {
            buffer.append(XML_ELEMENT_OPEN_TAG).append(fieldName).append(XML_TAG_CLOSE);
            buffer.append(getValueForObject(fieldValue));
            buffer.append(XML_ELEMENT_CLOSE_TAG).append(fieldName).append(XML_TAG_CLOSE);
        }
    }

    @Override
    public void addHeaderFieldWith(String className) {
        buffer.append(XML_ELEMENT_OPEN_TAG).append(className).append(XML_NS).append(XML_TAG_CLOSE);
        hasHeader = true;
        headerCloseTag = XML_ELEMENT_CLOSE_TAG + className + XML_TAG_CLOSE;
    }

    private String getValueForObject(Object fieldValue) throws OffAmazonPaymentsServiceException {
        if ( ReflectionUtils.shouldPrintValueOfType(fieldValue) ) {
            return escapeXML(fieldValue.toString());
        } else {
            return ReflectionUtils.invokeMethodOn(fieldValue, "toXMLFragment").toString();
        }
    }

    @Override
    public String build() {
        if (hasHeader) {
            this.buffer.append(headerCloseTag);
        }
        return this.buffer.toString();
    }

    @Override
    public void addCollectionHeader(String fieldName) {
        //noop
    }

    @Override
    public void addCollectionValue(String collectionName, Object fieldValue) throws OffAmazonPaymentsServiceException {
        this.addFieldToFragmentIfSet(collectionName, fieldValue);
    }

    @Override
    public void closeCollectionHeader(String fieldName) {
        //noop
    }

    /**
     *
     * Escape XML special characters
     */
    private static String escapeXML(String string) {
        if (string == null)
            return "null";
        StringBuffer sb = new StringBuffer();
        int length = string.length();
        for (int i = 0; i < length; ++i) {
            char c = string.charAt(i);
            switch (c) {
                case '&':
                    sb.append(XML_AMPERSAND_ESCAPED);
                    break;
                case '<':
                    sb.append(XML_LESS_THAN_ESCAPED);
                    break;
                case '>':
                    sb.append(XML_GREATER_THAN_ESCAPED);
                    break;
                case '\'':
                    sb.append(XML_BACKSLASH_ESCAPED);
                    break;
                case '"':
                    sb.append(XML_QUOTE_ESCAPED);
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
