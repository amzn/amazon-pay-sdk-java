/**
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.payments.paywithamazon.exceptions;

import com.amazon.payments.paywithamazon.response.model.ErrorResponse;
import com.amazon.payments.paywithamazon.response.parser.ResponseData;
import com.amazon.payments.paywithamazon.response.model.Error;
import java.io.Serializable;

/**
 * AmazonServiceException represents an error response as returned
 * by Login and Pay with Amazon API. Receiving an exception of this type indicates that
 * the caller's request was correctly transmitted to the service, but for some
 * reason, the service was not able to process it, and returned an error
 * response instead.  AmazonServiceException provides callers several pieces of
 * information that can be used to obtain more information about the error and
 * why it occurred.
 */
public class AmazonServiceException extends Exception implements Serializable {

    private String message;
    private int statusCode;
    private String errorCode;
    private String errorType;
    private String requestId;
    private String rawResponse;

    private static final long serialVersionUID = 1L;

    /**
     * Constructs AmazonServiceException using error code, error type, error message 
     * from errorResponse and raw paymentsResponse
     *
     * @param errorResponse
     *                  An ErrorResponse object
     * @param response
     *                  Specify raw response received from Login and Pay with Amazon API
     */
    public AmazonServiceException(ErrorResponse errorResponse , ResponseData response) {
        super(response.toXML());

        this.rawResponse = response.toXML();
        this.statusCode = response.getStatusCode();

        if(errorResponse != null && errorResponse.getError() != null) {
            this.requestId = errorResponse.getRequestId();
            if(!errorResponse.getError().isEmpty()) {
                Error error = errorResponse.getError().get(0);
                this.message = error.getMessage();
                this.errorCode = error.getCode();
                this.errorType = error.getType();
            }

        }
    }

    /**
     * Constructs AmazonServiceException using error message and underlying exception cause
     *
     * @param message
     *              A message describing the error
     * @param exception
     *              Underlying exception cause
     */
    public AmazonServiceException(String message , Exception exception) {
        super(message , exception);
        this.message = message;
    }

    /**
     * Constructs AmazonServiceException using given message 
     *
     * @param message
     *          A message describing the error
     */
    public AmazonServiceException(String message) {
        super(message);
    }

    /**
     * The HTTP status code that was returned with this service
     *         exception.
     *
     * @return The HTTP status code that was returned with this service
     *         exception.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * An error code that identifies the type of error that occurred.
     *
     * @return An error code that identifies the type of error that occurred.
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Indicates who is responsible for this exception 
     *
     * @return An error type, identifying either the receiver or the sender as the 
     * originator of the error.

     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * The requestID that uniquely identifies the service request
     * the caller made.
     *
     * @return The requestID that uniquely identifies the service request
     * the caller made.
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * A message code that describes the error condition in a human-readable form.
     *
     * @return A message code that describes the error condition in a human-readable form.
     */
    public String getErrorMessage() {
        return message;
    }

    /**
     * Returns raw content of HTTP rawResponse if for some reason the SDK cannot parse the HTTP
     * rawResponse from a service
     *
     * @return The raw content of the HTTP rawResponse
     */
    public String getResponseXml() {
        return rawResponse;
    }


    /**
     * The String representation of exception details 
     *
     * @return Returns AmazonServiceException exception details as String
     */
    @Override
    public String toString() {
        return getErrorMessage()
                + " (Status Code: " + getStatusCode()
                + "; Error Code: " + getErrorCode()
                + "; Request ID: " + getRequestId()
                + "; Raw Response XML: " + getResponseXml() +")";
    }

}
