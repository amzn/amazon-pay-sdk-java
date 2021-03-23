/**
 * Copyright 2016-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl;

import com.amazon.pay.Config;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.response.parser.ResponseData;
import com.amazon.pay.types.Region;
import com.amazon.pay.types.ServiceConstants;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.codec.binary.Base64;

public class Util {

    private static PayLogUtil payLogUtil = new PayLogUtil();

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");

    /**
     * @param stringToSign parameter that contains string to sign
     *
     * @param secretKey parameter that contains the Merchant secret key
     *
     * @throws InvalidKeyException This is the exception for invalid Keys
     *         (invalid encoding, wrong length, uninitialized, etc).
     *
     * @throws NoSuchAlgorithmException This exception is thrown when a
     *         particular cryptographic algorithm is requested but is not
     *         available in the environment.
     *
     * @throws UnsupportedEncodingException The Character Encoding is not supported.
     *
     * @return signatureBase64 base64 encoded signature using specified secret key
     */
    public static String getSignature(String stringToSign, char[] secretKey) throws IllegalStateException, InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
        final ByteBuffer byteBuffer = Charset.forName(ServiceConstants.UTF_8).encode(CharBuffer.wrap(secretKey));
        final Mac mac = Mac.getInstance(ServiceConstants.HMAC_SHA256);
        mac.init(new SecretKeySpec(Arrays.copyOf(byteBuffer.array(), byteBuffer.limit()), ServiceConstants.HMAC_SHA256));
        final byte[] signature = mac.doFinal(stringToSign.getBytes(ServiceConstants.UTF_8));
        final String signatureBase64 = new String(Base64.encodeBase64(signature), ServiceConstants.UTF_8);
        return signatureBase64;
    }

    public static String getTimestamp() {
        final Date date = new Date();
        final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ssz";
        final SimpleDateFormat sdf = new SimpleDateFormat(ISO_FORMAT);
        final TimeZone utc = TimeZone.getTimeZone("UTC");
        sdf.setTimeZone(utc);
        String timeStamp = sdf.format(date);
        return timeStamp.replace("UTC", "Z");
    }

    /**
     * This method uses HttpURLConnection instance to make requests.
     *
     * @param method The HTTP method (GET,POST,PUT,etc.).
     * @param url The URL
     * @param urlParameters URL Parameters
     * @param headers Header key-value pairs
     * @return ResponseData
     * @throws IOException Signals that an I/O exception
     *         of some sort has occurred. This class is
     *         the general class of exceptions produced
     *         by failed or interrupted I/O operations.
     */
    public static ResponseData httpSendRequest(String method, String url, String urlParameters, Map<String,String> headers) throws IOException {

        payLogUtil.logMessage("Request:\nURL=" + url + "\nPOST Data=" + urlParameters);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setConnectTimeout(ServiceConstants.HTTP_CONNECT_TIMEOUT);
        con.setReadTimeout(ServiceConstants.HTTP_READ_TIMEOUT);

        if (headers != null && !headers.isEmpty()) {
            for (String key : headers.keySet()) {
                con.setRequestProperty(key, headers.get(key));
            }
        }
        con.setDoOutput(true);
        con.setRequestMethod(method);
        if (urlParameters != null) {
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
        }
        int responseCode = con.getResponseCode();

        BufferedReader in;
        if (responseCode != 200) {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
        } else {
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine).append(LINE_SEPARATOR);
        }
        in.close();
        return new ResponseData(responseCode, response.toString());
    }


    /**
     * This method uses PayConfig to set proxy settings and uses
     * HttpURLConnection instance to make requests.
     *
     * @param method The HTTP method (GET,POST,PUT,etc.).
     * @param url The URL
     * @param urlParameters URL Parameters
     * @param headers HTTP POST request headers
     * @param config client configuration container
     * @return ResponseData
     * @throws IOException Signals that an I/O exception
     *         of some sort has occurred. This class is
     *         the general class of exceptions produced
     *         by failed or interrupted I/O operations.
     */
    public static ResponseData httpSendRequest(String method, String url, String urlParameters, Map<String,String> headers, PayConfig config) throws IOException {

        Map<String,String> headerMap = new HashMap<String,String>();
        if (headers != null) {
            headerMap.putAll(headers);
        }

        if (config != null) {

            final String applicationName = config.getApplicationName();
            final String applicationVersion = config.getApplicationVersion();
            StringBuilder userAgent = new StringBuilder(ServiceConstants.GITHUB_SDK_NAME + "/" + ServiceConstants.APPLICATION_LIBRARY_VERSION);

            if ((applicationName != null && !applicationName.trim().isEmpty()) && (applicationVersion != null && !applicationVersion.trim().isEmpty())) {
                userAgent.append(" (" + applicationName + "/" + applicationVersion + "; ");
            } else if (applicationVersion != null && !applicationVersion.trim().isEmpty()) {
                userAgent.append(" (" + applicationVersion + "; ");
            } else if (applicationName != null && !applicationName.trim().isEmpty()) {
                userAgent.append(" (" + applicationName + "; ");
            } else {
                userAgent.append(" (");
            }

            userAgent.append("Java/" + JAVA_VERSION + "; " + OS_NAME + "/" + OS_VERSION + ")");
            headerMap.put("User-Agent", userAgent.toString());

            if (config.getProxyHost() != null) {
                Properties systemSettings = System.getProperties();
                systemSettings.put("proxySet", "true");
                systemSettings.put("http.proxyHost", config.getProxyHost());
                systemSettings.put("http.proxyPort", config.getProxyPort());
                if (config.getProxyUsername() != null && config.getProxyPassword() != null) {
                    String password = config.getProxyUsername() + ":" + config.getProxyPassword();
                    byte[] encodedPassword = Base64.encodeBase64(password.getBytes());
                    if (encodedPassword != null) {
                        headerMap.put("Proxy-Authorization", new String(encodedPassword));
                    }
                }
            }
        }

        ResponseData response = Util.httpSendRequest(method, url, urlParameters, headerMap);
        return response;
    }

    /**
     * @param str Performs additional processing on top of the URLEncoder.encode function to
     *            make the string encoding conform to RFC3986
     *
     * @return An encoded string taht conforms to RFC3986
     *
     * @throws UnsupportedEncodingException The Character Encoding is not supported.
     */
    public static String urlEncode(String str) throws UnsupportedEncodingException {
        String val = (str == null) ? "" : str;
        String encoded = URLEncoder.encode(val, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        return encoded;
    }

    /**
     * @param apiParameters Helper method to URL encode all parameter values in a Map
     * @throws UnsupportedEncodingException The Character Encoding is not supported.
     */
    public static void urlEncodeAPIParams(Map<String, String> apiParameters) throws UnsupportedEncodingException {
        for (Map.Entry<String, String> entry : apiParameters.entrySet()) {
            entry.setValue(urlEncode(entry.getValue()));
        }
    }

    /**
     * @param <T> the type of the class modeled by this {@code Class}
     *            object.  For example, the type of {@code String.class} is {@code
     *            Class<String>}.  Use {@code Class<?>} if the class being modeled is
     *            unknown.
     *
     * @param clazz Class of T
     *
     * @param jsonData JSON data to be converted
     *
     * @return A GSON object
     *
     */
    public static <T> T convertJsonToObject(String jsonData, Class<T> clazz) {
        Gson gson = new Gson();
        T object =  gson.fromJson(jsonData, clazz);
        return object;
    }

    /**
     * @param params Parameters to be converted to URL string
     * separated by ampersand
     *
     * @return An URL string that is separated by ampersand
     */
    public static String convertParameterMapToString(Map<String, String> params) {
        StringBuilder parameterString = new StringBuilder();
        Iterator<Map.Entry<String, String>> pairs = params.entrySet().iterator();
        while (pairs.hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            if (pair.getValue() != null) {
                parameterString.append(pair.getKey() + "=" + pair.getValue());
            } else {
                parameterString.append(pair.getKey() + "=");
            }
            if (pairs.hasNext()) {
                parameterString.append("&");
            }
        }
        return parameterString.toString();
    }

    /**
     * @param region Region parameter for the service url endpoint requested.
     *
     * @param environment Environment parameter for the service url endpoint requested.
     *
     * @return The Service URL endpoint
     *
     * @deprecated This method does not handle Service URL overrides.
     *             Please use getServiceURLEndpoint(Config config) method instead.
     */
    @Deprecated
    public static String getServiceURLEndpoint(Region region, Environment environment) {
        return ServiceConstants.mwsEndpointMappings.get(region) + getServiceVersionName(environment);
    }

    /**
     * @param config Config to get Service URL endpoint including service version name
     *
     * @return The Service URL endpoint
     */
    public static String getServiceURLEndpoint(Config config) {
        if (config.getOverrideServiceURL() != null) {
            return config.getOverrideServiceURL()
                    + getServiceVersionName(config.getEnvironment());
        } else {
            return ServiceConstants.mwsEndpointMappings.get(config.getRegion())
                    + getServiceVersionName(config.getEnvironment());
        }
    }

    /**
     * @param environment parameter to get Service version name
     *
     * @return The Service API Version Name
     */
    public static String getServiceVersionName(Environment environment) {
        String mwsServiceAPIVersionName;
        if (environment == Environment.SANDBOX) {
            mwsServiceAPIVersionName = "/" + "OffAmazonPayments_Sandbox" + "/" + ServiceConstants.AMAZON_PAY_API_VERSION;
        }
        else {
            mwsServiceAPIVersionName = "/" + "OffAmazonPayments" + "/" + ServiceConstants.AMAZON_PAY_API_VERSION;
        }
        return mwsServiceAPIVersionName;
    }

}
