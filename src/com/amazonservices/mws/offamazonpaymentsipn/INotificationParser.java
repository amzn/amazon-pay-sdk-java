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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.amazonservices.mws.offamazonpaymentsipn.notifications.INotification;

public interface INotificationParser {
    /**
     * Convert a raw http POST request that contains an IPN to convert 
     * to an object callers are expected to return a 503 http code 
     * if an  exception is thrown by this method, otherwise 
     * reply with an HTTP OK status
     * @param headers The HttpServletRequest object that will contain the 
     * headers and the body for this post message
     * @return Instance of an INotification that matches the notification type
     * @throws NotificationsException if content is not a valid IPN
     */
    INotification parseRawMessage(HttpServletRequest request) throws NotificationsException;
    
    /**
     * Converts a http post request that has been broken down into
     * headers and a body to a notification.
     * @param headers The headers for this post as key value pairs.
     * @param body The body of this post message as a String
     * @return Instance of an INotification that matches the notification type
     * @throws NotificationsException if content is not a valid IPN
     */
    INotification parseRawMessage(Map<String, String> headers, String body) throws NotificationsException;
}
