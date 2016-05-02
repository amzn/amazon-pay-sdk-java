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
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class MessageTest {

    @Test
    public void testCreateNewInstanceOfClassForValidJson() throws NotificationsException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("field", "value");
        String jsonString = Utilities.convertMapToJsonString(map);

        Message msg = new Message(jsonString);

        assertNotNull(msg);
    }

    @Test
    public void testThrowAnExceptionIfTheStringIsNotJson() {
        String expectedMessage = "Error with message - content is not in json format";
        String invalidJson = "test:value";

        try {
            new Message(invalidJson);
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedMessage);
        }
    }

    @Test
    public void testReturnedStringIfFieldValueIfMandatoryFieldExists() throws NotificationsException {
        String expectedValue = "\"test\'\"\\n";
        Map<String, String> map = new HashMap<String, String>();
        map.put("Field", expectedValue);
        String jsonString = Utilities.convertMapToJsonString(map);

        Message msg = new Message(jsonString);
        String actualValue = msg.getMandatoryField("Field");

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testThrowExceptionIfMandatoryFieldCannotBeFound() {
        String expectedMessage = "Error with message - mandatory field Field cannot be found";
        Map<String, String> map = new HashMap<String, String>();
        map.put("Test", "field");
        String jsonString = Utilities.convertMapToJsonString(map);

        try {
            Message msg = new Message(jsonString);
            msg.getMandatoryField("Field");
            fail("Exception expected but not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedMessage);
        }
    }

    @Test
    public void testReturnFieldAsDateTimeObject() throws NotificationsException {
        String expectedTimestamp = "2013-05-03T10:45:27.342Z";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Map<String, String> map = new HashMap<String, String>();
        map.put("Timestamp", expectedTimestamp);
        String jsonString = Utilities.convertMapToJsonString(map);

        Message msg = new Message(jsonString);
        Date val = msg.getMandatoryFieldAsDate("Timestamp");

        assertEquals(expectedTimestamp, dateFormatter.format(val));
    }

    @Test
    public void testThrowExceptionIfDateTimeFieldCannotBeCast() {
        String expectedMessage = "Error with message - expected field Timestamp to be Date object";
        String expectedTimestamp = "value";

        Map<String, String> map = new HashMap<String, String>();
        map.put("Timestamp", expectedTimestamp);
        String jsonString = Utilities.convertMapToJsonString(map);

        Message msg;
        try {
            msg = new Message(jsonString);
            msg.getMandatoryFieldAsDate("Timestamp");
            fail("Exception expected but not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedMessage);
        }
    }
}
