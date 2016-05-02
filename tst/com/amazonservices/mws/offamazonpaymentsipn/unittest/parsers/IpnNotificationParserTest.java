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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.INotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.IpnNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class IpnNotificationParserTest {

    private IpnNotificationParser ipnNotificationParser;

    @Before
    public void setUp() {
        this.ipnNotificationParser = new IpnNotificationParser();
    }

    @Test
    public void testReturnMessageFromIpnJsonString() throws NotificationsException {
        String expectedReleaseEnvironmentProperty = "sandbox";
        String expectedTimestamp = "2013-05-03T10:45:27.123Z";
        String expectedNotificationReferenceId = "dfdfd343434ddsfs";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Message snsMessage = createValidSnsMessage(expectedReleaseEnvironmentProperty, expectedTimestamp, expectedNotificationReferenceId);

        Message message = null;
        message = this.ipnNotificationParser.parseSnsMessage(snsMessage);

        assertEquals(expectedReleaseEnvironmentProperty, message.getMandatoryField("ReleaseEnvironment"));
        assertEquals(expectedTimestamp, dateFormatter.format(message.getMandatoryFieldAsDate("Timestamp")));
        assertEquals(expectedNotificationReferenceId, message.getMandatoryField("NotificationReferenceId"));
    }

    @Test
    public void testSetMetadataNotificationParentToSnsMetadataObject() throws NotificationsException {
        INotificationMetadata expectedMetadata = Utilities.createTestSnsNotificationMetadata();
        Message snsMessage = createValidSnsMessage("release", "2013-05-03T10:45:27.123Z", "dfsfdsfdsfdfd");
        snsMessage.setMetadata(expectedMetadata);
       
        Message message = this.ipnNotificationParser.parseSnsMessage(snsMessage);

        assertSame(expectedMetadata, message.getMetadata().getParentNotificationMetadata());
    }

    private static Message createValidSnsMessage(final String expectedReleaseEnvironmentProperty, final String expectedTimestamp,
            final String expectedNotificationReferenceId) throws NotificationsException {
        Map<String, String> ipnProperties = new HashMap<String, String>();
        ipnProperties.put("ReleaseEnvironment", expectedReleaseEnvironmentProperty);
        ipnProperties.put("Timestamp", expectedTimestamp);
        ipnProperties.put("NotificationReferenceId", expectedNotificationReferenceId);
        ipnProperties.put("NotificationData", "Test");

        Map<String, String> snsProperties = new HashMap<String, String>();
        snsProperties.put("Message", Utilities.convertMapToJsonString(ipnProperties));
        Message snsMessage = Utilities.convertMapToMessage(snsProperties);
        return snsMessage;
    }
}
