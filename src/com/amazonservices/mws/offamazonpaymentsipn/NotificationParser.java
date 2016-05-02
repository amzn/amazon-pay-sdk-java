/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonservices.mws.offamazonpaymentsipn;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpaymentsipn.cache.Cache;
import com.amazonservices.mws.offamazonpaymentsipn.cache.ICache;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.INotification;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.*;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.singletons.IpnNotificationParserSingleton;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.singletons.SnsNotificationParserSingleton;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.singletons.XmlNotificationParserSingleton;
import com.amazonservices.mws.offamazonpaymentsipn.validators.*;

/**
 * Implementation of the notification parser for the 
 * OffAmazonPaymentsNotification system
 */
public class NotificationParser implements INotificationParser {

    /*
     * Instance of the parser used for receiving SNS messages
     */
    private final SnsNotificationParser snsNotificationParser;

    /*
     * Instance of the parser used for receiving IPN messages
     */
    private final IpnNotificationParser ipnNotificationParser;

    /**
     * Instance of the sns message validation class
     */
    private final SnsMessageValidator snsMessageValidator;

    /*
     * Instnace of the xml notification parser for IPN messages
     */
    private final XmlNotificationParser xmlNotificationParser;

    /**
     * Creates a new instance of the parse class using the java message 
     * validator implementation and default cache implementation.
     *
     * New parsers should be created through NotificationParserFactory
     * class
     */
    @Deprecated
    public NotificationParser(OffAmazonPaymentsServiceConfig config) {
        this(new Cache(), config);
    }

    /**
     * Creates a new instance of the parse class using the java message
     * validator implementation and default cache implementation
     * @param cache
     *
     * New instances of the notification parser should be created
     * through NotificationParserFactory
     */
    @Deprecated
    public NotificationParser(ICache cache, OffAmazonPaymentsServiceConfig config) {
        this.snsMessageValidator = new NotificationParserFactory(cache, config).createNewSnsMessageValidator();
        this.snsNotificationParser = SnsNotificationParserSingleton.getInstance();
        this.ipnNotificationParser = IpnNotificationParserSingleton.getInstance();
        this.xmlNotificationParser = XmlNotificationParserSingleton.getInstance();
    }


    /**
     * Create a new instance of the NotificationParser, taking in
     * all dependencies through DI.
     *
     * Merchants should not need to direct create this class, instead
     * use the NotificationParserFactory to manage creation of a
     * new NotificationParse
     *
     * @param snsNotificationParser parser to use for sns message
     * @param snsMessageValidator validator to use for sns message
     * @param ipnNotificationParser parser to use for the ipn portion of a message
     */
    public NotificationParser(SnsNotificationParser snsNotificationParser,
                              SnsMessageValidator snsMessageValidator,
                              IpnNotificationParser ipnNotificationParser,
                              XmlNotificationParser xmlNotificationParser) {
        this.snsMessageValidator = snsMessageValidator;
        this.snsNotificationParser = snsNotificationParser;
        this.ipnNotificationParser = ipnNotificationParser;
        this.xmlNotificationParser = xmlNotificationParser;
    }


    /**
     * Converts a http post request that has been broken down into
     * headers and a body to a notification.
     * @param headers The headers for this post as key value pairs.
     * @param body The body of this post message as a String
     * @return Instance of an INotification that matches the notification type
     * @throws NotificationsException if content is not a valid IPN
     */
    @Override
    public INotification parseRawMessage(Map<String, String> headers, String body) throws NotificationsException {
        Message snsMessage = snsNotificationParser.parseNotification(headers, body);
        snsMessageValidator.validateMessageIsTrusted(snsMessage);
        Message ipnMsg = ipnNotificationParser.parseSnsMessage(snsMessage);
        return this.xmlNotificationParser.parseIpnMessage(ipnMsg);
    }

    /**
     * Convert a raw http POST request that contains an IPN to convert 
     * to an object callers are expected to return a 503 http code 
     * if an  exception is thrown by this method, otherwise 
     * reply with an HTTP OK status
     * @param headers HTTP request headers
     * @param body HTTP POST body content
     * @return Instance of an INotification that matches the notification type
     * @throws com.amazonservices.mws.offamazonpayments.NotificationsException 
     */
    @Override
    public INotification parseRawMessage(HttpServletRequest request) throws NotificationsException {
        Map<String, String> headers = getMapFromRequest(request);
        String body = getBodyFromRequest(request);
        return parseRawMessage(headers, body);
    }

    /**
     * Pulls the headers out of the servlet request and
     * returns them as a map
     * @param request
     * @return a map of the headers
     */
    private Map<String, String> getMapFromRequest(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            map.put(headerName, request.getHeader(headerName));
        }

        return map;
    }

    /**
     * Pulls the body of the message out of the servlet request
     * @param request
     * @return The body of the post message as a string
     */
    private String getBodyFromRequest(HttpServletRequest request) {
        StringBuilder bodyBuilder = new StringBuilder();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while((line = reader.readLine()) != null) {
                bodyBuilder.append(line);
            }
        } catch (IOException e) {
        }
        
        return bodyBuilder.toString();
    }
}
