/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.exceptions;

import com.amazon.pay.response.parser.ResponseData;
import java.io.Serializable;

/**
 *   AmazonClientException represents any internal errors that are encountered inside the client while
 *   attempting to make the request or handle the response.  For example
 *   if a network connection is not available. Or if for some reason even if SDK is unable 
 *   to parse the response, using this exception you can still retrieve the raw API response.
 */
public class AmazonClientException extends RuntimeException implements Serializable {

    private final String message;
    private int statusCode;
    private String rawResponse;

    private static final long serialVersionUID = 1L;

    /**
     * Constructs AmazonClientException with given ResponseData response, 
     * message and underlying exception object
     *
     * @param response
     *              Response object containing API response and statusCode information 
     * @param message
     *              An error message describing the error
     * @param exception
     *              Original underlying exception
     */
    public AmazonClientException(ResponseData response , String message , Exception exception) {
        super("Client Exception: " + message , exception);
        this.rawResponse = response.toXML();
        this.statusCode = response.getStatusCode();
        this.message = message;
    }

    /**
     * Constructs AmazonClientException with given message and underlying exception
     *
     * @param message
     *              An error message describing the error
     * @param exception
     *              Original underlying exception
     */
    public AmazonClientException(String message , Exception exception) {
        super(message , exception);
        this.message = message;
    }

    /**
     * Constructs AmazonClientException with given message
     *
     * @param message
     *              An error message describing the error
     */
    public AmazonClientException(String message) {
        this.message = message;
    }

    /**
     * @return The HTTP status code that was returned with this service
     *         exception.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Returns raw content of HTTP response if for some reason the SDK cannot parse the HTTP
     * response from a service
     *
     * @return The raw content of the HTTP response
     */
    public String getResponseXml() {
        return rawResponse;
    }

    /**
     * A message code that describes the error condition in a human-readable form.
     *
     * @return message
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * The string representation of exception message details
     *
     * @return The string representation of exception message details
     */
    @Override
    public String toString() {
        return getMessage()
                + " (Status Code: " + getStatusCode()
                + "; Raw Response XML: " + getResponseXml() +")";
    }


}
