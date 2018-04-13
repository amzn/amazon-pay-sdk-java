/**
 * Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl.ipn;

import com.amazon.pay.response.ipn.model.ProviderCreditNotification;
import com.amazon.pay.response.ipn.model.RefundNotification;
import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.ipn.model.AuthorizationNotification;
import com.amazon.pay.response.ipn.model.BillingAgreementNotification;
import com.amazon.pay.response.ipn.model.CaptureNotification;
import com.amazon.pay.response.ipn.model.ChargebackNotification;
import com.amazon.pay.response.ipn.model.EventType;
import com.amazon.pay.response.ipn.model.IPNMessageMetaData;
import com.amazon.pay.response.ipn.model.Notification;
import com.amazon.pay.response.ipn.model.NotificationMetaData;
import com.amazon.pay.response.ipn.model.NotificationType;
import com.amazon.pay.response.ipn.model.OrderReferenceNotification;
import com.amazon.pay.response.ipn.model.ProviderCreditReversalNotification;
import com.amazon.pay.response.ipn.model.SolutionProviderMerchantNotification;
import com.amazon.pay.response.model.ChargebackDetails;
import com.amazon.pay.response.model.RefundType;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = { NotificationVerification.class })
public class NotificationFactoryTest {

        private Map<String,String> ipnHeader;
        @Mock private InputStream is;
        @Mock private CertificateFactory mockCertificateFactory;
        @Mock private X509Certificate mockX509Certificate;
        @Mock private Signature signatureC;
        @Mock private PublicKey publicKey;
        @Mock private URL url;

    @Before
    public void setUp() throws Exception {
        ipnHeader = new HashMap<String,String>();
        ipnHeader.put("x-amz-sns-message-type", "Notification");
        PowerMockito.when(url.getHost()).thenReturn("sns.us-1.amazonaws.com");
        PowerMockito.when(url.getPath()).thenReturn("SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem");
        PowerMockito.when(url.getProtocol()).thenReturn("https");
        PowerMockito.whenNew(URL.class).withParameterTypes(String.class).withArguments(Mockito.anyString()).thenReturn(url);
        PowerMockito.when(url.openStream()).thenReturn(is);
        PowerMockito.mockStatic(CertificateFactory.class);
        PowerMockito.when(CertificateFactory.getInstance("X.509")).thenReturn(mockCertificateFactory);
        PowerMockito.when(mockCertificateFactory.generateCertificate(is)).thenReturn((X509Certificate)mockX509Certificate);
        PowerMockito.mockStatic(Signature.class);
        PowerMockito.when(Signature.getInstance("SHA1withRSA")).thenReturn(signatureC);
        PowerMockito.when(mockX509Certificate.getPublicKey()).thenReturn(publicKey);
        PowerMockito.when(signatureC.verify(toByteArray(Mockito.any()))).thenReturn(true);
    }

    /**
     * Incorrect signature in IPN
     */
    @Test
    public void testInvalidSignatureIPN() throws SignatureException, IOException {
        try {
            PowerMockito.when(signatureC.verify(toByteArray(Mockito.any()))).thenReturn(false);
            NotificationFactory.parseNotification(ipnHeader, loadTestFile("AuthorizeNotification.json"));
            Assert.fail();
        } catch (SecurityException e) {
            Assert.assertEquals("Message signature calculation failed", e.getMessage());
        }
    }


    /**
     * Incorrect notification type
     */
    @Test
    public void testUnrecognizedNotificationTypeIPN() throws IOException {
        try {
            NotificationFactory.parseNotification(ipnHeader, loadTestFile("BadNotification.json"));
            Assert.fail();
        } catch (AmazonClientException e) {
            Assert.assertEquals("Unknown notification type: BlahBlah", e.getMessage());
        }
    }


    /**
     * Test Authorization Notification
     */
    @Test
    public void testAuthorizationIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("AuthorizeNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test Capture Notification
     */
    @Test
    public void testCaptureIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("CaptureNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test Order Reference Notification
     */
    @Test
    public void testOrderReferenceIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("OrderReferenceNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test Refund Notification
     */
    @Test
    public void testRefundIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("RefundNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test ProviderCredit Notification
     */
    @Test
    public void testProviderCreditIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("ProviderCreditNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test ProviderCredit Notification
     */
    @Test
    public void testProviderReversalCreditIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("ProviderReversalCredit.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Test BillingAgreement Notification
     */
    @Test
    public void testBillingAgreementIPN() throws IOException, DatatypeConfigurationException {
        // Tests EventType of BillingAgreeementStatusUpdated
        final String notificationPayload = loadTestFile("BillingAgreementNotification.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification, notificationPayload);
    }


    /**
     * Helper method to test IPN Notification values
     * @param notification
     * @param payLoad
     */
    private void testIPNValues(Notification notification, String payLoad) throws DatatypeConfigurationException {
        final NotificationType type = notification.getNotificationType();
        switch (type) {
            case CaptureNotification:
                final CaptureNotification cp = (CaptureNotification)notification;
                testCaptureIPNDetails(cp);
                testIPNMetaData(notification);
                break;
            case AuthorizationNotification:
                final AuthorizationNotification an = (AuthorizationNotification)notification;
                testAuthorizeIPNDetails(an);
                break;
            case BillingAgreementNotification:
                final BillingAgreementNotification bn = (BillingAgreementNotification)notification;
                testBillingAgreementIPNDetails(bn);
                break;
            case OrderReferenceNotification:
                final OrderReferenceNotification on = (OrderReferenceNotification)notification;
                testOrderReferenceIPNDetails(on);
                break;
            case ProviderCreditNotification:
                final ProviderCreditNotification pc = (ProviderCreditNotification)notification;
                testProviderCreditIPNDetails(pc);
                break;
            case ProviderCreditReversalNotification:
                final ProviderCreditReversalNotification pcrn = (ProviderCreditReversalNotification)notification;
                testReverseProviderCreditIPNDetails(pcrn);
                break;
            case RefundNotification:
                final RefundNotification rn = (RefundNotification)notification;
                testRefundIPNDetails(rn);
                break;
            case SolutionProviderMerchantNotification:
                final SolutionProviderMerchantNotification sp = (SolutionProviderMerchantNotification)notification;
                //TODO: add SolutionProviderMerchantNotification IPN
                break;

        }
    }


    /**
     * Test Capture Notification with Multi-currency attributes
     */
    @Test
    public void testMulticurrencyCaptureIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("CaptureNotification_Multicurrency.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        final NotificationType type = notification.getNotificationType();
        Assert.assertEquals(type, NotificationType.CaptureNotification);
        final CaptureNotification cp = (CaptureNotification)notification;

        Assert.assertEquals(cp.getCaptureDetails().getAmazonCaptureId(), "S02-6112897-1842302-C042768");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureAmount().getAmount(), "19.95");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureAmount().getCurrencyCode(), "GBP");
        Assert.assertEquals(cp.getCaptureDetails().getRefundedAmount().getAmount(), "0.0");
        Assert.assertEquals(cp.getCaptureDetails().getRefundedAmount().getCurrencyCode(), "GBP");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureFee().getAmount(), "0.0");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureFee().getCurrencyCode(), "GBP");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureReferenceId(), "KWUFWoFZ0WiZRrMKJ0g");
        Assert.assertEquals(cp.getCaptureDetails().getIdList().getMember(), new ArrayList() );
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-27T22:42:56.430Z");
        Assert.assertEquals(cp.getCaptureDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-27T22:42:56.430Z");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getReasonCode(), null);
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getReasonDescription(), null);
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getState(), "Completed");
        Assert.assertEquals(cp.getCaptureDetails().getSoftDescriptor(), "AMZ*Matt's Test Stor");

        // The three new multi-currency specific fields
        Assert.assertEquals(cp.getCaptureDetails().getConvertedAmount().getAmount(), "21.84");
        Assert.assertEquals(cp.getCaptureDetails().getConvertedAmount().getCurrencyCode(), "EUR");
        Assert.assertEquals(cp.getCaptureDetails().getConversionRate(), "0.913362644");
    }


    /**
     * Test Billing Agreement Notification with EventType of PaymentMethodUpdated
     */
    @Test
    public void testBillingAgreementIPN_PaymentMethodUpdated() throws DatatypeConfigurationException, IOException {
        final String notificationPayload = loadTestFile("BA_PaymentMethodUpdated.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        final NotificationType type = notification.getNotificationType();
        Assert.assertEquals(type, NotificationType.BillingAgreementNotification);
        final BillingAgreementNotification bn = (BillingAgreementNotification)notification;

        Assert.assertEquals(bn.getBillingAgreement().getAmazonBillingAgreementId(), "B01-7746179-0109340");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-07-06T03:09:25.613Z");
        Assert.assertEquals(bn.getBillingAgreement().getCreationTimestamp(), xgc);
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getAmount(), "500.0");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-07-01T00:00:00.000Z");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getTimePeriodStartDate(), xgc2);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-08-01T00:00:00.000Z");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getTimePeriodEndDate(), xgc3);
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getCurrentRemainingBalance().getAmount(), "500.0");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getCurrentRemainingBalance().getCurrencyCode(), "USD");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getState(), "Open");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getReasonCode(), null);
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getReasonDescription(), null);
        Assert.assertEquals(bn.getBillingAgreement().getSellerBillingAgreementAttributes().getSellerId(), "A2UOU742KT49DA");
        Assert.assertEquals(bn.getBillingAgreement().getSellerBillingAgreementAttributes().getSellerBillingAgreementId(), "seller billing agreement id");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAddress(), null);
        Assert.assertEquals(bn.getBillingAgreement().getBuyer(), null);
        Assert.assertEquals(bn.getBillingAgreement().getConstraints(), null);
        Assert.assertEquals(bn.getBillingAgreement().getDestination(), null);
        Assert.assertEquals(bn.getBillingAgreement().getOrderLanguage(), null);
        Assert.assertEquals(bn.getBillingAgreement().getPlatformId(), null);
        Assert.assertEquals(bn.getBillingAgreement().getSellerNote(), null);

        Assert.assertEquals(bn.getNotificationMetadata().getType(), "Notification");
        Assert.assertEquals(bn.getNotificationMetadata().getMessageId(), "72fd219f-d2d6-5fea-afff-70487e01d695");
        Assert.assertEquals(bn.getNotificationMetadata().getSignatureVersion(), "1");

        Assert.assertEquals(bn.getMessageMetadata().getReleaseEnvironment(), "Live");
        Assert.assertEquals(bn.getMessageMetadata().getNotificationReferenceId(), "f0336c8f-3d94-44d2-9326-c213fb4bc6a3");
        Assert.assertEquals(bn.getMessageMetadata().getVersion(), "2013-01-01");
        Assert.assertEquals(bn.getMessageMetadata().getSellerId(), "A2UOU742KT49DA");
        Assert.assertEquals(bn.getMessageMetadata().getTimeStamp(), "2017-07-06T03:12:23.271Z");

        Assert.assertEquals(bn.getMessageMetadata().getEventType(), EventType.PaymentMethodUpdated);
        Assert.assertEquals(bn.getMessageMetadata().getNotificationType(), "BillingAgreementNotification");
    }


    /**
     * Test Capture Notification with Multi-currency attributes
     */
    @Test
    public void testMulticurrencyRefundIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("RefundNotification_Multicurrency.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        final NotificationType type = notification.getNotificationType();
        Assert.assertEquals(type, NotificationType.RefundNotification);
        final RefundNotification rn = (RefundNotification)notification;

        Assert.assertEquals(rn.getRefundDetails().getAmazonRefundId(), "S02-8274313-3487267-R019346");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-28T18:14:34.752Z");
        Assert.assertEquals(rn.getRefundDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(rn.getRefundDetails().getFeeRefunded().getAmount(), "0.0");
        Assert.assertEquals(rn.getRefundDetails().getFeeRefunded().getCurrencyCode(), "NOK");
        Assert.assertEquals(rn.getRefundDetails().getProviderCreditReversalSummaryList(), null);
        Assert.assertEquals(rn.getRefundDetails().getRefundAmount().getAmount(), "0.33");
        Assert.assertEquals(rn.getRefundDetails().getRefundAmount().getCurrencyCode(), "NOK");
        Assert.assertEquals(rn.getRefundDetails().getRefundReferenceId(), "aed9ba8bee564c8cb943bd6481633ad1");
        Assert.assertEquals(rn.getRefundDetails().getRefundStatus().getState(), "Completed");
        Assert.assertEquals(rn.getRefundDetails().getRefundType(), RefundType.SELLER_INITIATED);
        Assert.assertEquals(rn.getRefundDetails().getSellerRefundNote(), null);
        Assert.assertEquals(rn.getRefundDetails().getSoftDescriptor(), "AMZ*Matt's Test Stor");

        // The three new multi-currency specific fields
        Assert.assertEquals(rn.getRefundDetails().getConvertedAmount().getAmount(), "0.03");
        Assert.assertEquals(rn.getRefundDetails().getConvertedAmount().getCurrencyCode(), "EUR");
        Assert.assertEquals(rn.getRefundDetails().getConversionRate(), "9.9248293483");
    }

    /**
     * Test Chargeback Notification for Unauthorized Transaction reason
     */
    @Test
    public void testChargebackUnauthorizedIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("ChargebackNotification_Unauthorized.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        final NotificationType type = notification.getNotificationType();
        Assert.assertEquals(type, NotificationType.ChargebackNotification);

        final NotificationMetaData nm = notification.getNotificationMetadata();
        Assert.assertEquals(nm.getType(), "Notification");
        Assert.assertEquals(nm.getMessageId(), "22ed5c15-c3c8-5e74-aceb-0e350c4a2620");
        Assert.assertEquals(nm.getTopicArn(), "arn:aws:sns:us-east-1:598607868003:A35A4JO734ER04A08593053M41F7TQ7YR7W");
        Assert.assertEquals(nm.getTimeStamp(), "2017-08-30T14:35:46.358Z");
        Assert.assertEquals(nm.getSignatureVersion(), "1");
        Assert.assertEquals(nm.getSignature(), "K/5+GqaPsk9UDcVNlxgj7Lw6EkJJOKhIejfJ4z0ZbdsCAuTSFPWlU5Msq7MkdWtO2bwmvyJGmEJDsb/Z3xBPBpQExI7/76aPMWIX2zRaoef1rFbZYTis808p/G7ih5Mmn5nSNw8+LKSxfPSiGULItQGOtBVf/7MohYP5IjK68oJwuXp7qXM5y7zXJntABDWdsdj2TrzYRozUsLpUb44HcfKNtW4sivZvJ6LUa04Y0h0DDIY5BVjmlTGeFcvjQ9yimK41zLEnnrPmSLBls0B4MJRrpTkpgiQzYqRmL5T3c04BHs/+tiXB8YlrHgLw0GgrS0weIcEbEPjwk4CB0JkwEw==");
        Assert.assertEquals(nm.getSigningCertUrl(), "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-433026a4050d206028891664da859041.pem");
        Assert.assertEquals(nm.getUnsubscribeUrl(), "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:598607868003:A35A4JO734ER04A08593053M41F7TQ7YR7W:413d945a-6cc4-4c6f-a45a-c5c0918b03b9");

        final IPNMessageMetaData mm = notification.getMessageMetadata();
        Assert.assertEquals(mm.getReleaseEnvironment(), "Live");
        Assert.assertEquals(mm.getMarketplaceId(), "165570");
        Assert.assertEquals(mm.getVersion(), "2013-01-01");
        Assert.assertEquals(mm.getNotificationReferenceId(), "73658979-2175-4306-a305-9fbdf442423e");
        Assert.assertEquals(mm.getSellerId(), "A08593053M41F7TQ7YR7W");
        Assert.assertEquals(mm.getTimeStamp(), "2017-08-30T14:35:46.278Z");

        final ChargebackNotification cn = (ChargebackNotification)notification;
        final ChargebackDetails cd = cn.getChargebackDetails();
        Assert.assertEquals(cd.getAmazonChargebackId(), "C9KORZRXQ655G");
        Assert.assertEquals(cd.getAmazonOrderReferenceId(), "P01-7128087-7259534");
        Assert.assertEquals(cd.getAmazonCaptureReferenceId(), "CaptureReference6282176");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-08-23T12:20:56.061Z");
        Assert.assertEquals(cd.getCreationTimestamp(), xgc);
        Assert.assertEquals(cd.getChargebackAmount().getAmount(), "100.0");
        Assert.assertEquals(cd.getChargebackAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(cd.getChargebackState(), "RECEIVED");
        Assert.assertEquals(cd.getChargebackReason(), "Unauthorized Transaction Chargeback");
    }

    /**
     * Test Chargeback Notification for Generic Service reason
     */
    @Test
    public void testChargebackServiceIPN() throws IOException, DatatypeConfigurationException {
        final String notificationPayload = loadTestFile("ChargebackNotification_Service.json");
        final Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        final NotificationType type = notification.getNotificationType();
        Assert.assertEquals(type, NotificationType.ChargebackNotification);

        final NotificationMetaData nm = notification.getNotificationMetadata();
        Assert.assertEquals(nm.getType(), "Notification");
        Assert.assertEquals(nm.getMessageId(), "83d848c9-7376-56f8-b5a7-1ae9be88a82a");
        Assert.assertEquals(nm.getTopicArn(), "arn:aws:sns:us-east-1:598607868003:A35A4JO734ER04A08593053M41F7TQ7YR7W");
        Assert.assertEquals(nm.getTimeStamp(), "2017-08-30T14:29:18.908Z");
        Assert.assertEquals(nm.getSignatureVersion(), "1");
        Assert.assertEquals(nm.getSignature(), "XOYWtZKrjKXws8V2Ulx4GMUoMa3e10dok4cHlz6vs/BwFiQkC6KqhP0KIaOzIMu3V1WK7+0Kp7wC6F5MuxnumdcDIFFrL/hCLHHeDRWKzogcTCXjstNjoA0tWqsN0OHmIiP0VWTtXYswRL2+FFMd5q2JBkmlAONv/cbOcsWR++2Aa6K2Nf2VWxjW3iykJmnmruAtGctM68xjBv2Q6F3uBaHLKgsD02er+sU5rUWXYSr0qzHMx5AK+lrHuTbvZ7scHGWWGRufAmmq94D8wXXiWlL3h8TK5Abes5upfJiAaG6NikppD+wzBQ0NhDczJhmodCh+aVIcA8NAol/hOclX9A==");
        Assert.assertEquals(nm.getSigningCertUrl(), "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-433026a4050d206028891664da859041.pem");
        Assert.assertEquals(nm.getUnsubscribeUrl(), "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:598607868003:A35A4JO734ER04A08593053M41F7TQ7YR7W:413d945a-6cc4-4c6f-a45a-c5c0918b03b9");

        final IPNMessageMetaData mm = notification.getMessageMetadata();
        Assert.assertEquals(mm.getReleaseEnvironment(), "Live");
        Assert.assertEquals(mm.getMarketplaceId(), "165570");
        Assert.assertEquals(mm.getVersion(), "2013-01-01");
        Assert.assertEquals(mm.getNotificationReferenceId(), "9bc8ec61-da88-4b63-b201-dc7afeaae764");
        Assert.assertEquals(mm.getSellerId(), "A08593053M41F7TQ7YR7W");
        Assert.assertEquals(mm.getTimeStamp(), "2017-08-30T14:29:18.833Z");

        final ChargebackNotification cn = (ChargebackNotification)notification;
        final ChargebackDetails cd = cn.getChargebackDetails();
        Assert.assertEquals(cd.getAmazonChargebackId(), "C9KORZRXQ655G");
        Assert.assertEquals(cd.getAmazonOrderReferenceId(), "P01-7128087-7259534");
        Assert.assertEquals(cd.getAmazonCaptureReferenceId(), "CaptureReference6282176");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-08-23T12:20:56.061Z");
        Assert.assertEquals(cd.getCreationTimestamp(), xgc);
        Assert.assertEquals(cd.getChargebackAmount().getAmount(), "100.0");
        Assert.assertEquals(cd.getChargebackAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(cd.getChargebackState(), "RECEIVED");
        Assert.assertEquals(cd.getChargebackReason(), "Generic Service Chargeback");
    }

    /**
     * Helper method to test notification values
     * @param notification
     */
    private void testIPNMetaData(Notification notification) {
         Assert.assertEquals(notification.getNotificationMetadata().getSigningCertUrl(), "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem");
         Assert.assertEquals(notification.getNotificationMetadata().getMessageId(), "33bd40e3-6a9a-58cf-b6be-0eb9ca6bc4e9");
         Assert.assertEquals(notification.getNotificationMetadata().getSignature(), "eUInUlaydzV4eoOcSKHSyNqt9yFAa1r0kFQz2PxXlNV4Ik04pYRyZlgbXy5NdhzdRzGKwIlPG8QcL2HlNe7nFkKecQapQZYmI7cWpvEslO/xrJgP6jTH5j18Xkk7/lmhV79wgwIWjT7LtbMrc3jC7QNDqwiNcRT694WKpFx1+PFa4BdUd0cUCyPLQrWFcNpS0z8fcaERqO98BUZkkPVfwWA7bQhIwQnxJNVzL9dFxWAhs98W7N89/8yEEg7nz/OK0hr9vfaT0P7ZGCYNsrDlwooGbhtJlhj2aLjfFwR91P7h5cK20nx3eBgN3Nen6BXU1jqnz7plA3QVuygzRIUJmA==");
         Assert.assertEquals(notification.getNotificationMetadata().getSignatureVersion(), "1");
         Assert.assertEquals(notification.getNotificationMetadata().getTimeStamp(), "2015-08-28T17:47:29.280Z");
         Assert.assertEquals(notification.getNotificationMetadata().getTopicArn(), "arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9");
         Assert.assertEquals(notification.getNotificationMetadata().getType(), "Notification");
         Assert.assertEquals(notification.getNotificationMetadata().getUnsubscribeUrl(), "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9:05542723-375e-4609-98f1-8abcf427d95f");

         Assert.assertEquals(notification.getMessageMetadata().getNotificationReferenceId(), "1111111-1111-11111-1111-11111EXAMPLE");
         Assert.assertEquals(notification.getMessageMetadata().getVersion(), "2013-01-01");
         Assert.assertEquals(notification.getMessageMetadata().getSellerId(), "A2K7NDRCTOTPW9");
         Assert.assertEquals(notification.getMessageMetadata().getTimeStamp(), "2015-08-28T17:47:29.215Z");
         Assert.assertEquals(notification.getMessageMetadata().getReleaseEnvironment(), "Sandbox");
    }

    private void testOrderReferenceIPNDetails(OrderReferenceNotification or) throws DatatypeConfigurationException {
        Assert.assertEquals(or.getOrderReference().getAmazonOrderReferenceId(), "P01-0000000-0000000-000000");
        Assert.assertEquals(or.getOrderReference().getBillingAddress(), null);
        Assert.assertEquals(or.getOrderReference().getBuyer(), null);
        Assert.assertEquals(or.getOrderReference().getConstraints(), null);
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(or.getOrderReference().getCreationTimestamp(), xgc);
        Assert.assertEquals(or.getOrderReference().getDestination(), null);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(or.getOrderReference().getExpirationTimestamp(), xgc2);
        Assert.assertEquals(or.getOrderReference().getIdList(), null);
        Assert.assertEquals(or.getOrderReference().getOrderLanguage(), null);
        Assert.assertEquals(or.getOrderReference().getOrderReferenceStatus().getReasonCode(), "AmazonClosed");
        Assert.assertEquals(or.getOrderReference().getOrderTotal().getAmount(), "0.0");
        Assert.assertEquals(or.getOrderReference().getParentDetails(), null);
        Assert.assertEquals(or.getOrderReference().getPlatformId(), null);
        Assert.assertEquals(or.getOrderReference().getReleaseEnvironment(), null);
        Assert.assertEquals(or.getOrderReference().getSellerNote(), null);
        Assert.assertEquals(or.getOrderReference().getSellerOrderAttributes().getCustomInformation(), null);
    }

    private void testBillingAgreementIPNDetails(BillingAgreementNotification bn) throws DatatypeConfigurationException {
        Assert.assertEquals(bn.getBillingAgreement().getAmazonBillingAgreementId(), "C01-4249881-9140092");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-28T21:36:38.779Z");
        Assert.assertEquals(bn.getBillingAgreement().getCreationTimestamp(), xgc);
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getAmount(), "500.0");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getAmountLimitPerTimePeriod().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-06-01T00:00:00.000Z");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getTimePeriodStartDate(), xgc2);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-07-01T00:00:00.000Z");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getTimePeriodEndDate(), xgc3);
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getCurrentRemainingBalance().getAmount(), "500.0");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits().getCurrentRemainingBalance().getCurrencyCode(), "USD");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getState(), "Closed");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getReasonCode(), "SellerClosed");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus().getReasonDescription(), "Closing BA for Test");
        Assert.assertEquals(bn.getBillingAgreement().getSellerBillingAgreementAttributes().getSellerId(), "A3URCZVLDMDI45");
        Assert.assertEquals(bn.getBillingAgreement().getSellerBillingAgreementAttributes().getSellerBillingAgreementId(), "seller billing agreement id");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAddress(), null);
        Assert.assertEquals(bn.getBillingAgreement().getBuyer(), null);
        Assert.assertEquals(bn.getBillingAgreement().getConstraints(), null);
        Assert.assertEquals(bn.getBillingAgreement().getDestination(), null);
        Assert.assertEquals(bn.getBillingAgreement().getOrderLanguage(), null);
        Assert.assertEquals(bn.getBillingAgreement().getPlatformId(), null);
        Assert.assertEquals(bn.getBillingAgreement().getSellerNote(), null);

        Assert.assertEquals(bn.getNotificationMetadata().getType(), "Notification");
        Assert.assertEquals(bn.getNotificationMetadata().getMessageId(), "5dd8ff8c-2710-530d-bfa5-ae420328663b");
        Assert.assertEquals(bn.getNotificationMetadata().getSignatureVersion(), "1");

        Assert.assertEquals(bn.getMessageMetadata().getReleaseEnvironment(), "Sandbox");
        Assert.assertEquals(bn.getMessageMetadata().getNotificationReferenceId(), "f20c383d-6070-4906-975e-61830737575f");
        Assert.assertEquals(bn.getMessageMetadata().getVersion(), "2013-01-01");
        Assert.assertEquals(bn.getMessageMetadata().getSellerId(), "A3URCZVLDMDI45");
        Assert.assertEquals(bn.getMessageMetadata().getTimeStamp(), "2017-06-28T21:39:04.368Z");

        Assert.assertEquals(bn.getMessageMetadata().getEventType(), EventType.BillingAgreementStatusUpdated);
        Assert.assertEquals(bn.getMessageMetadata().getNotificationType(), "BillingAgreementNotification");
    }

    private void testProviderCreditIPNDetails(ProviderCreditNotification pc) throws DatatypeConfigurationException {
        Assert.assertEquals(pc.getProviderCreditDetails().getAmazonProviderCreditId(), "S01-0458164-4040121-P098523");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-29T16:48:59.040Z");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditAmount().getAmount(), "1.0");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditReferenceId(), null);
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditReversalAmount().getAmount(), "1.0");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditReversalAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditReversalIdList().getId().get(0), "S01-0458164-4040121-Q021623");
        Assert.assertEquals(pc.getProviderCreditDetails().getCreditReversalIdList().getId().get(1), "S01-0458164-4040121-Q001949");
        Assert.assertEquals(pc.getProviderCreditDetails().getSellerId(), "A37GX652OWOXVH");
        Assert.assertEquals(pc.getProviderCreditDetails().getProviderSellerId(), "A2K7NDRCTOTPW9");
    }

    private void testRefundIPNDetails(RefundNotification rn) throws DatatypeConfigurationException {
        Assert.assertEquals(rn.getRefundDetails().getAmazonRefundId(), "P01-0000000-0000000-000000");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(rn.getRefundDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(rn.getRefundDetails().getFeeRefunded().getAmount(), "2.0");
        Assert.assertEquals(rn.getRefundDetails().getFeeRefunded().getCurrencyCode(), "USD");
        Assert.assertEquals(rn.getRefundDetails().getProviderCreditReversalSummaryList(), null);
        Assert.assertEquals(rn.getRefundDetails().getRefundAmount().getAmount(), "3.0");
        Assert.assertEquals(rn.getRefundDetails().getRefundAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(rn.getRefundDetails().getRefundReferenceId(), "P01-0000000-0000000-Ref");
        Assert.assertEquals(rn.getRefundDetails().getRefundStatus().getState(), "Completed");
        Assert.assertEquals(rn.getRefundDetails().getRefundType(), RefundType.SELLER_INITIATED);
        Assert.assertEquals(rn.getRefundDetails().getSellerRefundNote(), null);
        Assert.assertEquals(rn.getRefundDetails().getSoftDescriptor(), "AMZ*softDescriptor");
    }

    private void testReverseProviderCreditIPNDetails(ProviderCreditReversalNotification pcr) throws DatatypeConfigurationException {
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getAmazonProviderCreditReversalId(), "S01-3154248-3064261-Q087635");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-16T01:42:43.941Z");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreditReversalAmount().getAmount(), "0.5");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreditReversalAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreditReversalNote(), null);
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreditReversalReferenceId(), "rcMzEdsAprId");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getCreditReversalStatus().getState(), "Completed");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getProviderSellerId(), "A2K7NDRCTOTPW9");
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getSellerId(), "A37GX652OWOXVH");

    }

    /**
     * Helper method to test the capture notification
     * @param cp
     */
    private void testCaptureIPNDetails(CaptureNotification cp) throws DatatypeConfigurationException {
        Assert.assertEquals(cp.getCaptureDetails().getAmazonCaptureId(), "P01-0000000-0000000-000000");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureAmount().getAmount(), "5.0");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(cp.getCaptureDetails().getRefundedAmount().getAmount(), "1.0");
        Assert.assertEquals(cp.getCaptureDetails().getRefundedAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureFee().getAmount(), "0.5");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureFee().getCurrencyCode(), "USD");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureReferenceId(), "P01-0000000-0000000-Ref");
        Assert.assertEquals(cp.getCaptureDetails().getIdList().getMember(), new ArrayList() );
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(cp.getCaptureDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-01-01T01:01:01.001Z");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getLastUpdateTimestamp(), xgc2);
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getReasonCode(), "None");
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getReasonDescription(), null);
        Assert.assertEquals(cp.getCaptureDetails().getCaptureStatus().getState(), "Completed");
        Assert.assertEquals(cp.getCaptureDetails().getSoftDescriptor(), "AMZ*softDescriptor");
    }

    private void testAuthorizeIPNDetails(AuthorizationNotification an) throws DatatypeConfigurationException {
        Assert.assertEquals(an.getAuthorizationDetails().getAmazonAuthorizationId(), "P01-0000000-0000000-000000");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationAmount().getAmount(), "5.0");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationFee().getAmount(), "0.4");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationFee().getCurrencyCode(), "USD");
        Assert.assertEquals(an.getAuthorizationDetails().getCapturedAmount().getAmount(), "4.0");
        Assert.assertEquals(an.getAuthorizationDetails().getCapturedAmount().getCurrencyCode(), "USD");
        final XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(an.getAuthorizationDetails().getCreationTimestamp(), xgc);
        final XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-03-01T01:01:01.001Z");
        Assert.assertEquals(an.getAuthorizationDetails().getExpirationTimestamp(), xgc2);
        final XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-01-01T01:01:01.001Z");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationStatus().getLastUpdateTimestamp(), xgc3);
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationStatus().getState(), "Closed");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationStatus().getReasonCode(), "MaxCapturesProcessed");
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationStatus().getReasonDescription(), null);
        Assert.assertEquals(an.getAuthorizationDetails().isCaptureNow(), true);
        Assert.assertEquals(an.getAuthorizationDetails().getOrderItemCategories().getOrderItemCategory(), new ArrayList());
        Assert.assertEquals(an.getAuthorizationDetails().getAuthorizationReferenceId(), "P01-0000000-0000000-Ref");
        Assert.assertEquals(an.getAuthorizationDetails().getSoftDescriptor(), "AMZ*softDescriptor");
    }

    /**
     * Helper method to load test files
     */
    public String loadTestFile(String fileName) throws UnsupportedEncodingException, IOException {
        final InputStream is = new FileInputStream(System.getProperty("user.dir") +"/tst/com/amazon/pay/impl/ipn/json/" + fileName);
        if (is != null) {
            final Writer writer = new StringWriter();

            final char[] buffer = new char[1024];
            try {
                final Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

    public static byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
        } finally {
            if (oos != null) {
                oos.close();
            }
            if (bos != null) {
                bos.close();
            }
        }
        return bytes;
    }
}
