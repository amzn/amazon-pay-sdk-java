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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.IpnNotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.NotificationMetadataType;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class IpnNotificationMetadataTest {

    @Test
    public void testCreateIpnNotificationMetadataForValidIpnMessage() throws NotificationsException {
        String expectedReleaseEnvironment = "sandbox";
        String expectedNotificationReferenceId = "33dsfsdf343-3434-3434";
        IpnNotificationMetadata ipnNotificationMetadata = null;

        Message ipnMsg = _createNotificationReferenceMessage(expectedReleaseEnvironment, expectedNotificationReferenceId);
        ipnNotificationMetadata = new IpnNotificationMetadata(ipnMsg, null);

        assertEquals(expectedReleaseEnvironment, ipnNotificationMetadata.getReleaseEnvironment());
        assertEquals(expectedNotificationReferenceId, ipnNotificationMetadata.getNotificationReferenceId());
        assertTrue(NotificationMetadataType.Ipn == ipnNotificationMetadata.getNotificationMetadataType());
    }

    @Test
    public void testCreateParseTimestampIntoDate() throws ParseException, NotificationsException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String timestamp = "2013-05-03T10:45:27Z";
        Date expectedTimestamp = null;

        expectedTimestamp = dateFormatter.parse(timestamp);

        Message ipnMsg = createNotificationReferenceMessage("sandbox", "33dsfsdf343-3434-3434", timestamp);
        IpnNotificationMetadata ipnNotificationMetadata = new IpnNotificationMetadata(ipnMsg, null);

        assertEquals(expectedTimestamp, ipnNotificationMetadata.getTimestamp());
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveTimestampField() {
        String expectedException = "Error with message - mandatory field Timestamp cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("Timestamp", expectedException);
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveReleaseEnvironmentField() {
        String expectedException = "Error with message - mandatory field ReleaseEnvironment cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("ReleaseEnvironment", expectedException);
    }

    @Test
    public void testThrowExceptionIfIpnMessageDoesNotHaveNotificationReferenceIdField() {
        String expectedException = "Error with message - mandatory field NotificationReferenceId cannot be found";
        throwExceptionWhenMandatoryFieldIsNotPresent("NotificationReferenceId", expectedException);
    }

    private void throwExceptionWhenMandatoryFieldIsNotPresent(String field, String expectedException)
    {
        try {
            Map<String, String> fields = getFixtureFieldsAsMap();
            fields.remove(field);
            Message msg = Utilities.convertMapToMessage(fields);

            new IpnNotificationMetadata(msg, null);
            fail("Expected exception not thrown");
        } catch (NotificationsException e) {
            assertEquals(expectedException, e.getMessage());
        }
    }
    
    private static Message _createNotificationReferenceMessage(final String expectedReleaseEnvironment,
            final String expectedNotificationReferenceId) throws NotificationsException {
        return createNotificationReferenceMessage(expectedReleaseEnvironment, expectedNotificationReferenceId, "2013-05-03T10:45:27Z");
    }

    private static Message createNotificationReferenceMessage(final String expectedReleaseEnvironment,
            final String expectedNotificationReferenceId, final String expectedTimestamp) throws NotificationsException {
        Map<String, String> values = getFieldsAsMap(expectedReleaseEnvironment, expectedNotificationReferenceId, expectedTimestamp);
        return Utilities.convertMapToMessage(values);
    }

    private static Map<String, String> getFixtureFieldsAsMap() {
        return getFieldsAsMap("sandbox", "3dfsdf83434-34248390-3423", "2013-05-03T10:45:27Z");
    }

    private static Map<String, String> getFieldsAsMap(final String expectedReleaseEnvironment, final String expectedNotificationReferenceId, final String expectedTimestamp) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("Timestamp", expectedTimestamp);
        values.put("ReleaseEnvironment", expectedReleaseEnvironment);
        values.put("NotificationReferenceId", expectedNotificationReferenceId);
        return values;
    }
}
