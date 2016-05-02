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
package com.amazonservices.mws.offamazonpaymentsipn.unittest.notificationmetadata;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import java.util.Date;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.NotificationMetadataType;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.SnsNotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class SnsNotificationMetadataTest {

    @Test
    public void testCreateSnsNotificationMetadataFromValidSnsMessage() throws NotificationsException {
        String expectedTopicArn = "arn:aws:sns:us-east-1:598607868003:A341L3VCFKNMIYA074997131C7YZGL81KKR";
        String expectedMessageId = "ad26db82-463d-536f-963c-927c067afb7d";

        Message msg = getMessageFromFields(expectedTopicArn, expectedMessageId);
        SnsNotificationMetadata notificationMetadata = new SnsNotificationMetadata(msg);

        assertEquals(NotificationMetadataType.Sns, notificationMetadata.getNotificationMetadataType());
        assertEquals(expectedTopicArn, notificationMetadata.getTopicArn());
        assertEquals(expectedMessageId, notificationMetadata.getMessageId());
    }

    @Test
    public void testParseTimestampIntoDate() throws ParseException, NotificationsException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String timestamp = "2013-05-03T10:45:27Z";

        Date expectedDtTimestamp = dateFormatter.parse(timestamp);
        Message msg = getMessageFromFields(timestamp, "sdfsdf", "dsfdsf");
        SnsNotificationMetadata notificationMetadata = new SnsNotificationMetadata(msg);

        assertEquals(expectedDtTimestamp, notificationMetadata.getTimestamp());
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveTimestampField() {
        String expectedException = "Error with message - mandatory field Timestamp cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("Timestamp", expectedException);
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveTopicArnField() {
        String expectedException = "Error with message - mandatory field TopicArn cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("TopicArn", expectedException);
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveMessageIdField() {
        String expectedException = "Error with message - mandatory field MessageId cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("MessageId", expectedException);
    }

    private void throwExceptionWhenMandatoryFieldIsNotPresent(final String field, final String expectedException)
    {
        try {
            Map<String, String> fields = getFixutureFieldsAsMap();
            fields.remove(field);
            Message msg = Utilities.convertMapToMessage(fields);

            new SnsNotificationMetadata(msg);
            fail("Expected exception not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }

    private static Map<String, String> getFixutureFieldsAsMap() {
        return getFieldsAsDictionary("2013-05-03T10:45:27Z", "fdsfdsc", "3dfsdf83434-34248390-3423");
    }

    private Message getMessageFromFields(final String expectedTimestamp, final String expectedTopicArn, final String expectedMessageId) throws NotificationsException {
        Map<String, String> values = getFieldsAsDictionary(expectedTimestamp, expectedTopicArn, expectedMessageId);
        return Utilities.convertMapToMessage(values);
    }

    private static Map<String, String> getFieldsAsDictionary(final String expectedTimestamp, final String expectedTopicArn, final String expectedMessageId) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("TopicArn", expectedTopicArn);
        values.put("MessageId", expectedMessageId);
        values.put("Timestamp", expectedTimestamp);
        return values;
    }

    private Message getMessageFromFields(final String expectedTopicArn, final String expectedMessageId) throws NotificationsException {
        return getMessageFromFields("2013-05-03T22:45:27.265Z", expectedTopicArn, expectedMessageId);
    }
}
