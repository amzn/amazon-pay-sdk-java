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
package com.amazonservices.mws.offamazonpaymentsipn.unittest;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.INotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.SnsNotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utilities {
    /**
     * Given a Map, return a message object that contains these fields
     * @param msgContents contents of the message
     * @return the message object
     * @throws NotificationsException
     */
    public static Message convertMapToMessage(Map<String, String> msgContents) throws NotificationsException {
        String jsonStr = convertMapToJsonString(msgContents);
        return new Message(jsonStr);
    }

    /**
     * Given a Map, return the Json string generated from that map
     * @param msgContents the contents of the message
     * @return a JSON string representation of the map
     */
    public static String convertMapToJsonString(Map<String, String> msgContents) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(msgContents);
    }

    /**
     * Create sns text notification metadata
     * @return notificationMetadata
     * @throws NotificationsException
     */
    public static INotificationMetadata createTestSnsNotificationMetadata() throws NotificationsException {
        return createTestSnsNotificationMetadata("dfdsfdsfwerw334", "fddfdsf");
    }

    /**
     * Create sns text notification metadata
     * @param messageId message id required
     * @param topicArn topic arn required
     * @return notification metadata with the specified data
     * @throws NotificationsException
     */
    public static INotificationMetadata createTestSnsNotificationMetadata(String messageId, String topicArn) throws NotificationsException {
        Map<String, String> snsMetadataFields = new HashMap<String, String>();
        snsMetadataFields.put("Type", "Notification");
        snsMetadataFields.put("Message", "Test");
        snsMetadataFields.put("Timestamp", "2013-05-03T10:45:27.123Z");
        snsMetadataFields.put("TopicArn", topicArn);
        snsMetadataFields.put("MessageId", messageId);
        return new SnsNotificationMetadata(convertMapToMessage(snsMetadataFields));
    }

    /**
     * Generates a valid set of sns headers
     * @return Map of headers
     */
    public static Map<String, String> getSnsHeaderFields() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-amz-sns-message-type", "Notification");
        return headers;
    }
    
    public static void verifyExceptionThrownWithMessage(NotificationsException e, String expectedException)
    {
        assertEquals( e.getMessage(), expectedException);
    }
}
