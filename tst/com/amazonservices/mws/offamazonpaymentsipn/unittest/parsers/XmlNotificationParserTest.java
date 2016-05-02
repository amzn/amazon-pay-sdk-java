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
import com.amazonservices.mws.offamazonpaymentsipn.model.AuthorizationNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.BillingAgreementNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.CaptureNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.OrderReferenceNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.ProviderCreditReversalNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.RefundNotification;
import com.amazonservices.mws.offamazonpaymentsipn.model.SolutionProviderMerchantNotification;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.INotification;
import com.amazonservices.mws.offamazonpaymentsipn.notifications.NotificationType;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.XmlNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;

public class XmlNotificationParserTest {

    private XmlNotificationParser xmlNotificationParser;

    @Before
    public void setUp() {
        this.xmlNotificationParser = new XmlNotificationParser();
    }

    @Test
    public void testMapNotificationTypeToCorrectNotificationObject() throws NotificationsException
    {
        INotification actualNotification = getNotificationObject("PaymentRefund", "RefundNotification");
        assertTrue(actualNotification instanceof RefundNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.RefundNotification);

        actualNotification = getNotificationObject("PaymentAuthorize", "AuthorizationNotification");
        assertTrue(actualNotification instanceof AuthorizationNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.AuthorizationNotification);

        actualNotification = getNotificationObject("PaymentCapture", "CaptureNotification");
        assertTrue(actualNotification instanceof CaptureNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.CaptureNotification);

        actualNotification = getNotificationObject("OrderReferenceNotification", "OrderReferenceNotification");
        assertTrue(actualNotification instanceof OrderReferenceNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.OrderReferenceNotification);

        actualNotification = getNotificationObject("BillingAgreementNotification", "BillingAgreementNotification");
        assertTrue(actualNotification instanceof BillingAgreementNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.BillingAgreementNotification);
        
        actualNotification = getNotificationObject("ProviderCredit", "ProviderCreditNotification");
        assertTrue(actualNotification instanceof ProviderCreditNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.ProviderCreditNotification);
        
        actualNotification = getNotificationObject("ProviderCreditReversal", "ProviderCreditReversalNotification");
        assertTrue(actualNotification instanceof ProviderCreditReversalNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.ProviderCreditReversalNotification);
        
        actualNotification = getNotificationObject("SolutionProviderEvent", "SolutionProviderMerchantNotification");
        assertTrue(actualNotification instanceof SolutionProviderMerchantNotification);
        assertTrue(actualNotification.getNotificationType()==NotificationType.SolutionProviderMerchantNotification);
        
        
    }

    @Test
    public void testThrowExceptionIfNotificationDataFieldIsNotXml() {
        String expectedException = "Error with ipn message - NotificationData field does not contain valid xml, contents: test";
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("NotificationType", "PaymentRefund");
        fields.put("NotificationData", "test");
        
        checkExceptionThrownWhenMessageBuiltFromMap(fields, expectedException);
    }

    @Test
    public void testThrowExceptionIfNotificationDataFieldIsNotPresentInIpnMessage() {
        String expectedException = "Error with message - mandatory field NotificationData cannot be found";
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("NotificationType", "PaymentRefund");
        
        checkExceptionThrownWhenMessageBuiltFromMap(fields, expectedException);
    }

    @Test
    public void testThrowExceptionIfNotificationTypeFieldIsNotPresentInIpnMessage() {
        String expectedException = "Error with message - mandatory field NotificationType cannot be found";
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("NotificationData", "<test></test>");
        
        checkExceptionThrownWhenMessageBuiltFromMap(fields, expectedException);
    }

    @Test
    public void testThrowExceptionIfNotificationTypeFieldIsNotKnownInIpnMessage() {
        String expectedException = "Error with ipn notification - unknown notification type: Sample";
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("NotificationType", "Sample");
        fields.put("NotificationData", "test");
        
        checkExceptionThrownWhenMessageBuiltFromMap(fields, expectedException);
    }

    public INotification getNotificationObject(String xmlNotificationType, String xmlNodeName) throws NotificationsException {
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("NotificationType", xmlNotificationType);
        fields.put("NotificationData", String.format("<%s></%s>", xmlNodeName, xmlNodeName));
        String jsonString = Utilities.convertMapToJsonString(fields);

        Message ipnMessage = new Message(jsonString);

        return this.xmlNotificationParser.parseIpnMessage(ipnMessage);
    }
    
    private void checkExceptionThrownWhenMessageBuiltFromMap(Map<String, String> fields, String expectedException)
    {
        String jsonString = Utilities.convertMapToJsonString(fields);

        try {
            Message ipnMessage = new Message(jsonString);

            this.xmlNotificationParser.parseIpnMessage(ipnMessage);
            fail("Exception expected, but not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }
}
