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
package com.amazonservices.mws.offamazonpaymentsipn.unittest.parsers;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.SnsNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class SnsNotificationParserTest {
    private static final String SNS_HEADER = "x-amz-sns-message-type";

    private SnsNotificationParser snsNotificationParser;

    @Before
    public void setUp() {
        this.snsNotificationParser = new SnsNotificationParser();
    }

    @Test
    public void testCreateMessageForValidSnsJsonString() throws NotificationsException
    {
        String expectedMessage = "value";
        String expectedType = "Notification";
        String snsJson = GetMessageForFields(expectedMessage, expectedType);

        Message msg;
        msg = this.snsNotificationParser.parseNotification(Utilities.getSnsHeaderFields(), snsJson);

        assertEquals(expectedMessage, msg.getMandatoryField("Message"));
        assertEquals(expectedType, msg.getMandatoryField("Type"));
    }

    @Test
    public void testThrowExceptionIfTypeFieldCannotBeFound()
    {
        String expectedException = "Error with message - mandatory field Type cannot be found";
        Map<String, String> fields = GetDefaultFields();
        fields.remove("Type");
        String jsonString = Utilities.convertMapToJsonString(fields);

        try {
            this.snsNotificationParser.parseNotification(Utilities.getSnsHeaderFields(), jsonString);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testThrowExceptionIfTypeIsNotNotification()
    {
        String expectedException = "Error with sns notification - unexpected message with Type of test";
        String snsJson = GetMessageForFields("test", "test");

        try {
            this.snsNotificationParser.parseNotification(Utilities.getSnsHeaderFields(), snsJson);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testThrowExceptionIfSnsHeaderIsNotPresent()
    {
        String expectedException = "Error with message - header does not contain x-amz-sns-message-type";
        String snsJson = GetMessageForDefaultFields();
        Map<String, String> headers = Utilities.getSnsHeaderFields();
        headers.remove(SNS_HEADER);

        try {
            this.snsNotificationParser.parseNotification(headers, snsJson);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testThrowExceptionIfSnsHeaderIsNotEqualToNotification()
    {
        String expectedException = "Error with sns message - header x-amz-sns-message-type has value test, expected Notification";
        String snsJson = GetMessageForDefaultFields();
        Map<String, String> headers = Utilities.getSnsHeaderFields();
        headers.remove(SNS_HEADER);
        headers.put(SNS_HEADER, "test");

        try {
            this.snsNotificationParser.parseNotification(headers, snsJson);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testThrowExceptionIfNoHeadersAreProvided()
    {
        String expectedException = "Expected headers to be passed, null value received";
        String snsJson = GetMessageForDefaultFields();

        try {
            this.snsNotificationParser.parseNotification(null, snsJson);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    @Test
    public void testAddSnsMetadataToMessage() throws NotificationsException
    {
        String snsJson = GetMessageForDefaultFields();

        Message msg = this.snsNotificationParser.parseNotification(Utilities.getSnsHeaderFields(), snsJson);

        assertNotNull(msg.getMetadata());
    }

    private String GetMessageForFields(String expectedMessage, String type)
    {
        return Utilities.convertMapToJsonString(GetMapForFields(expectedMessage, type));
    }

    private String GetMessageForDefaultFields()
    {
        return Utilities.convertMapToJsonString(GetDefaultFields());
    }

    private Map<String, String> GetDefaultFields()
    {
        return GetMapForFields("test", "Notification");
    }

    private Map<String, String> GetMapForFields(String expectedMessage, String expectedType)
    {
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("Message", expectedMessage);
        fields.put("Type", expectedType);
        fields.put("Timestamp", "2013-05-03T10:45:27.123Z");
        fields.put("TopicArn", "arn:aws:sns:us-east-1:598607868003:A341L3VCFKNMIYA074997131C7YZGL81KKR");
        fields.put("MessageId", "ad26db82-463d-536f-963c-927c067afb7d");
        return fields;
    }
}
