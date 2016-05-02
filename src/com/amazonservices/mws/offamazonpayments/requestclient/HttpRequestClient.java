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
 *
 *  Off Amazon Payments Service Java Library
 *  API Version: 2013-01-01
 *
 */
package com.amazonservices.mws.offamazonpayments.requestclient;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsService;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.ErrorResponse;
import com.amazonservices.mws.offamazonpayments.model.ResponseHeaderMetadata;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.lang.reflect.Method;
import java.net.*;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConstants.CLIENT_VERSION;

public class HttpRequestClient {

    private static final Log LOG = LogFactory.getLog(HttpRequestClient.class);
    private static final String DEFAULT_ENCODING = "UTF-8";

    private static final JAXBContext JAXB_CONTEXT;
    private static final ThreadLocal<Unmarshaller> UNMARSHALLER;

    private static Pattern ERROR_PATTERN_ONE = Pattern.compile(".*\\<RequestId>(.*)\\</RequestId>.*\\<Error>" +
                    "\\<Code>(.*)\\</Code>\\<Message>(.*)\\</Message>\\</Error>.*(\\<Error>)?.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern ERROR_PATTERN_TWO = Pattern.compile(".*\\<Error>\\<Code>(.*)\\</Code>\\<Message>(.*)" +
                    "\\</Message>\\</Error>.*(\\<Error>)?.*\\<RequestID>(.*)\\</RequestID>.*",
            Pattern.MULTILINE | Pattern.DOTALL);
    private static Pattern ERROR_PATTERN_THREE = Pattern.compile(".*\\<Error>.*\\<Type>(.*)\\</Type>.*\\<Code>(.*)\\</Code>.*\\<Message>(.*)" +
                    "\\</Message>.*\\</Error>.*(\\<Error>)?.*\\<RequestID>(.*)\\</RequestID>.*",
            Pattern.MULTILINE | Pattern.DOTALL);

    private final HttpClient httpClient;
    private final OffAmazonPaymentsServiceConfig config;
    private final String awsAccessKeyId;
    private final String awsSecretAccessKey;

    static {
        try {
            JAXB_CONTEXT = JAXBContext.newInstance("com.amazonservices.mws.offamazonpayments.model", OffAmazonPaymentsService.class.getClassLoader());
        } catch (JAXBException ex) {
            throw new ExceptionInInitializerError(ex);
        }
        UNMARSHALLER = new ThreadLocal<Unmarshaller>() {
            @Override
            protected synchronized Unmarshaller initialValue() {
                try {
                    return JAXB_CONTEXT.createUnmarshaller();
                } catch(JAXBException e) {
                    throw new ExceptionInInitializerError(e);
                }
            }
        };
    }

    /**
     * Create a new instance of the HttpRequestClient that wraps the ApacheHttpClient library
     *
     * @param httpClient
     * @param config
     */
    public HttpRequestClient(HttpClient httpClient, OffAmazonPaymentsServiceConfig config) {
        this.httpClient = httpClient;
        this.config = config;
        this.awsAccessKeyId = config.getAccessKeyId();
        this.awsSecretAccessKey = config.getSecretAccessKey();
    }

    /**
     * Invokes request using parameters from parameters map.
     * Returns response of the T type passed to this method
     */
    public <T> T invoke(Class<T> clazz, Map<String, String> parameters)
            throws OffAmazonPaymentsServiceException {

        String actionName = parameters.get("Action");
        T response = null;
        String responseBodyString = null;
        ResponseHeaderMetadata responseHeaderMetadata = null;
        PostMethod method = new PostMethod(config.getServiceURL());
        int status = -1;

        LOG.debug("Invoking" + actionName + " request. Current parameters: " + parameters);

        try {

            Method responseHeaderMetadataSetter = clazz.getMethod("setResponseHeaderMetadata", ResponseHeaderMetadata.class);

            /* Set content type and encoding */
            LOG.debug("Setting content-type to application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + DEFAULT_ENCODING.toLowerCase());
            /* Set X-Amazon-User-Agent to header */
            method.addRequestHeader("X-Amazon-User-Agent", config.getUserAgent());

            /* Add required request parameters and set request body */
            LOG.debug("Adding required parameters...");
            addRequiredParametersToRequest(method, parameters);
            LOG.debug("Done adding additional required parameters. Parameters now: " + parameters);

            boolean shouldRetry = true;
            int retries = 0;
            do {
                LOG.debug("Sending Request to host:  " + config.getServiceURL());

                try {
                    /* Submit request */
                    status = httpClient.executeMethod(method);

                    responseHeaderMetadata = getResponseHeaderMetadata(method);

                    /* Consume response stream */
                    responseBodyString = getResponsBodyAsString(method.getResponseBodyAsStream());

                    /* Successful response. Attempting to unmarshal into the <Action>Response type */
                    if (status == HttpStatus.SC_OK) {
                        shouldRetry = false;
                        LOG.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);
                        LOG.debug("Attempting to unmarshal into the " + actionName + "Response type...");

                        response = clazz.cast(getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString))));

                        responseHeaderMetadataSetter.invoke(response, responseHeaderMetadata);

                        LOG.debug("Unmarshalled response into " + actionName + "Response type.");

                    } else { /* Unsucessful response. Attempting to unmarshall into ErrorResponse  type */

                        LOG.debug("Received Response. Status: " + status + ". " +
                                "Response Body: " + responseBodyString);

                        if ((status == HttpStatus.SC_INTERNAL_SERVER_ERROR && pauseIfRetryNeeded(++retries))) {
                            shouldRetry = true;
                        } else {
                            LOG.debug("Attempting to unmarshal into the ErrorResponse type...");
                            ErrorResponse errorResponse = (ErrorResponse) getUnmarshaller().unmarshal(new StreamSource(new StringReader(responseBodyString)));

                            LOG.debug("Unmarshalled response into the ErrorResponse type.");

                            com.amazonservices.mws.offamazonpayments.model.Error error = errorResponse.getError().get(0);
                            if (status == HttpStatus.SC_SERVICE_UNAVAILABLE && !(error.getCode().equals("RequestThrottled")) && pauseIfRetryNeeded(++retries)) {
                                shouldRetry = true;
                            } else {
                                shouldRetry = false;
                                throw new OffAmazonPaymentsServiceException(error.getMessage(), status, error.getCode(), error.getType(),
                                        errorResponse.getRequestId(), errorResponse.toXML(), responseHeaderMetadata);
                            }
                        }
                    }
                } catch (JAXBException je) {
                    /* Response cannot be unmarshalled neither as <Action>Response or ErrorResponse types.
                    Checking for other possible errors. */

                    LOG.debug("Caught JAXBException", je);
                    LOG.debug("Response cannot be unmarshalled neither as " + actionName + "Response or ErrorResponse types." +
                            "Checking for other possible errors.");

                    OffAmazonPaymentsServiceException awse = processErrors(responseBodyString, status, responseHeaderMetadata);

                    throw awse;

                } catch (IOException ioe) {
                    LOG.debug("Caught IOException exception", ioe);
                    throw new OffAmazonPaymentsServiceException("Internal Error", ioe);
                } catch (Exception e) {
                    LOG.debug("Caught Exception", e);
                    throw new OffAmazonPaymentsServiceException(e);
                } finally {
                    method.releaseConnection();
                }
            } while (shouldRetry);

        } catch (OffAmazonPaymentsServiceException se) {
            LOG.debug("Caught OffAmazonPaymentsServiceException", se);
            throw se;

        } catch (Throwable t) {
            LOG.debug("Caught Exception", t);
            throw new OffAmazonPaymentsServiceException(t);
        }
        return response;
    }



    /**
     * Extract response metadata from the response headers.
     */
    private ResponseHeaderMetadata getResponseHeaderMetadata(PostMethod method) {
        Header requestId = method.getResponseHeader("x-mws-request-id");
        Header responseContext = method.getResponseHeader("x-mws-response-context");
        Header timestamp = method.getResponseHeader("x-mws-timestamp");

        List<String> responseContextList = null;
        if (responseContext != null) {
            String value = responseContext.getValue();
            responseContextList = Arrays.asList(value.split(","));
        }

        return new ResponseHeaderMetadata(
                requestId != null ? requestId.getValue() : null,
                responseContextList,
                timestamp != null ? timestamp.getValue() : null);
    }

    /**
     * Read stream into string
     * @param input stream to read
     */
    private String getResponsBodyAsString(InputStream input) throws IOException {
        String responsBodyString = null;
        try {
            Reader reader = new InputStreamReader(input, DEFAULT_ENCODING);
            StringBuilder b = new StringBuilder();
            char[] c = new char[1024];
            int len;
            while (0 < (len = reader.read(c))) {
                b.append(c, 0, len);
            }
            responsBodyString = b.toString();
        } finally {
            input.close();
        }
        return responsBodyString;
    }

    /**
     * Exponential sleep on failed request. Sleeps and returns true if retry needed
     * @param retries current retry
     * @throws java.lang.InterruptedException
     */
    private boolean pauseIfRetryNeeded(int retries)
            throws InterruptedException {
        if (retries <= config.getMaxErrorRetry()) {
            long delay = (long) (Math.pow(4, retries) * 100L);
            LOG.debug("Retriable error detected, will retry in " + delay + "ms, attempt number: " + retries);
            Thread.sleep(delay);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add authentication related and version parameter and set request body
     * with all of the parameters
     */
    private void addRequiredParametersToRequest(PostMethod method, Map<String, String> parameters)
            throws SignatureException {
        parameters.put("Version", CLIENT_VERSION);
        parameters.put("SignatureVersion", config.getSignatureVersion());
        parameters.put("Timestamp", getFormattedTimestamp());
        parameters.put("AWSAccessKeyId",  this.awsAccessKeyId);
        parameters.put("Signature", signParameters(parameters, this.awsSecretAccessKey));
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            method.addParameter(entry.getKey(), entry.getValue());
        }
    }

    private OffAmazonPaymentsServiceException processErrors(String responseString, int status, ResponseHeaderMetadata responseHeaderMetadata)  {
        OffAmazonPaymentsServiceException ex = null;
        Matcher matcher = null;
        if (responseString != null && responseString.startsWith("<")) {
            matcher = ERROR_PATTERN_ONE.matcher(responseString);
            if (matcher.matches()) {
                ex = new OffAmazonPaymentsServiceException(matcher.group(3), status,
                        matcher.group(2), "Unknown", matcher.group(1), responseString, responseHeaderMetadata);
            } else {
                matcher = ERROR_PATTERN_TWO.matcher(responseString);
                if (matcher.matches()) {
                    ex = new OffAmazonPaymentsServiceException(matcher.group(2), status,
                            matcher.group(1), "Unknown", matcher.group(4), responseString, responseHeaderMetadata);
                } else {matcher = ERROR_PATTERN_THREE.matcher(responseString);
                    if (matcher.matches()) {
                        ex = new OffAmazonPaymentsServiceException(matcher.group(3), status,
                                matcher.group(2), matcher.group(1) , matcher.group(5), responseString, responseHeaderMetadata);
                    }else {
                        ex =  new OffAmazonPaymentsServiceException("Internal Error", status);
                        LOG.debug("Service Error. Response Status: " + status);
                    }
                }
            }
        } else {
            ex =  new OffAmazonPaymentsServiceException("Internal Error", status);
            LOG.debug("Service Error. Response Status: " + status);
        }
        return ex;
    }

    /**
     * Formats date as ISO 8601 timestamp
     */
    private String getFormattedTimestamp() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        return df.format(new Date());
    }

    /**
     * Computes RFC 2104-compliant HMAC signature for request parameters
     * Implements AWS Signature, as per following spec:
     *
     * If Signature Version is 0, it signs concatenated Action and Timestamp
     *
     * If Signature Version is 1, it performs the following:
     *
     * Sorts all  parameters (including SignatureVersion and excluding Signature,
     * the value of which is being created), ignoring case.
     *
     * Iterate over the sorted list and append the parameter name (in original case)
     * and then its value. It will not URL-encode the parameter values before
     * constructing this string. There are no separators.
     *
     * If Signature Version is 2, string to sign is based on following:
     *
     *    1. The HTTP Request Method followed by an ASCII newline (%0A)
     *    2. The HTTP Host header in the form of lowercase host, followed by an ASCII newline.
     *    3. The URL encoded HTTP absolute path component of the URI
     *       (up to but not including the query string parameters);
     *       if this is empty use a forward '/'. This parameter is followed by an ASCII newline.
     *    4. The concatenation of all query string components (names and values)
     *       as UTF-8 characters which are URL encoded as per RFC 3986
     *       (hex characters MUST be uppercase), sorted using lexicographic byte ordering.
     *       Parameter names are separated from their values by the '=' character
     *       (ASCII character 61), even if the value is empty.
     *       Pairs of parameter and values are separated by the '&' character (ASCII code 38).
     *
     */
    private String signParameters(Map<String, String> parameters, String key)
            throws  SignatureException {

        String signatureVersion = parameters.get("SignatureVersion");
        String algorithm = "HmacSHA1";
        String stringToSign = null;
        if ("0".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV0(parameters);
        } else if ("1".equals(signatureVersion)) {
            stringToSign = calculateStringToSignV1(parameters);
        } else if ("2".equals(signatureVersion)) {
            algorithm = config.getSignatureMethod();
            parameters.put("SignatureMethod", algorithm);
            stringToSign = calculateStringToSignV2(parameters);
        } else {
            throw new SignatureException("Invalid Signature Version specified");
        }
        LOG.debug("Calculated string to sign: " + stringToSign);
        return sign(stringToSign, key, algorithm);
    }

    /**
     * Calculate String to Sign for SignatureVersion 0
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV0(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
        data.append(parameters.get("Action")).append(parameters.get("Timestamp"));
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 1
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV1(Map<String, String> parameters) {
        StringBuilder data = new StringBuilder();
        Map<String, String> sorted =  new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        sorted.putAll(parameters);
        Iterator pairs = sorted.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry pair = (Map.Entry)pairs.next();
            data.append(pair.getKey());
            data.append(pair.getValue());
        }
        return data.toString();
    }

    /**
     * Calculate String to Sign for SignatureVersion 2
     * @param parameters request parameters
     * @return String to Sign
     * @throws java.security.SignatureException
     */
    private String calculateStringToSignV2(Map<String, String> parameters)
            throws SignatureException {
        StringBuilder data = new StringBuilder();
        data.append("POST");
        data.append("\n");
        java.net.URI endpoint = null;
        try {
            endpoint = new java.net.URI(config.getServiceURL());
        } catch (URISyntaxException ex) {
            LOG.debug("URI Syntax Exception", ex);
            throw new SignatureException("URI Syntax Exception thrown " +
                    "while constructing string to sign", ex);
        }
        data.append(endpoint.getHost().toLowerCase());
        if (!usesAStandardPort(config.getServiceURL())) {
            data.append(":");
            data.append(endpoint.getPort());
        }
        data.append("\n");

        String uri = null;
        uri = endpoint.getPath();
        data.append(urlEncode(uri, true));
        data.append("\n");

        Map<String, String> sorted = new TreeMap<String, String>();
        sorted.putAll(parameters);
        Iterator<Map.Entry<String, String>> pairs = sorted.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            String key = pair.getKey();
            data.append(urlEncode(key, false));
            data.append("=");
            String value = pair.getValue();
            data.append(urlEncode(value, false));
            if (pairs.hasNext()) {
                data.append("&");
            }
        }
        return data.toString();
    }

    private static boolean usesAStandardPort(String url) {
        boolean usesHttps = usesHttps(url);
        int portNumber = extractPortNumber(url, usesHttps);
        return usesHttps && portNumber == HttpsURL.DEFAULT_PORT || !usesHttps
                && portNumber == HttpURL.DEFAULT_PORT;
    }

    private static boolean usesHttps(String url) {
        try {
            new HttpsURL(url) /* throws an exception if not HTTPS */;
            return true;
        } catch (URIException e) {
            return false;
        }
    }

    private static int extractPortNumber(String url, boolean usesHttps) {
        try {
            HttpURL httpUrl = usesHttps ? new HttpsURL(url) : new HttpURL(url);
            return httpUrl.getPort();
        } catch (URIException e) {
            throw new RuntimeException("not a URL", e);
        }
    }

    private String urlEncode(String value, boolean path) {
        String encoded = null;
        try {
            encoded = URLEncoder.encode(value, DEFAULT_ENCODING)
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E","~");
            if (path) {
                encoded = encoded.replace("%2F", "/");
            }
        } catch (UnsupportedEncodingException ex) {
            LOG.debug("Unsupported Encoding Exception", ex);
            throw new RuntimeException(ex);
        }
        return encoded;
    }

    /**
     * Computes RFC 2104-compliant HMAC signature.
     *
     */
    private String sign(String data, String key, String algorithm) throws SignatureException {
        byte [] signature;
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.getBytes(), algorithm));
            signature = Base64.encodeBase64(mac.doFinal(data.getBytes(DEFAULT_ENCODING)));
        } catch (Exception e) {
            throw new SignatureException("Failed to generate signature: " + e.getMessage(), e);
        }

        return new String(signature);
    }

    /**
     * Get unmarshaller for current thread
     */
    private Unmarshaller getUnmarshaller() {
        return UNMARSHALLER.get();
    }

}
