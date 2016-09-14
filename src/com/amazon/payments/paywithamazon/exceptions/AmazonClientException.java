package com.amazon.payments.paywithamazon.exceptions;

import com.amazon.payments.paywithamazon.response.parser.ResponseData;
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
