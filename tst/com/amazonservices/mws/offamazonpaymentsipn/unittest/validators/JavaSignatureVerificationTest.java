package com.amazonservices.mws.offamazonpaymentsipn.unittest.validators;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.certificate.X509CertificateFactory;
import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.SnsNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;
import com.amazonservices.mws.offamazonpaymentsipn.validators.ISnsSignatureVerification;
import com.amazonservices.mws.offamazonpaymentsipn.validators.IVerifyData;
import com.amazonservices.mws.offamazonpaymentsipn.validators.SnsMessageValidator;
import com.amazonservices.mws.offamazonpaymentsipn.validators.SnsSignatureVerification;
import com.amazonservices.mws.offamazonpaymentsipn.validators.VerifyDataJavaImpl;

public class JavaSignatureVerificationTest {

    /**
     * Mock signature verification
     */
    private IVerifyData mockVerifySignature= null;
    
    /**
     * Mock signature factory
     */
    private X509CertificateFactory mockCertFactory;

    /**
     * Set of default values for a valid.
     */
    private Map<String, String> defaultSnsMsgFields = null;

    /**
     * Mock signature validator.
     */
    private ISnsSignatureVerification mockValidator  = null;

    private SnsNotificationParser snsNotificationParser;

    @Before
    public void setUp()throws Exception {
        mockVerifySignature = EasyMock.createNiceMock(VerifyDataJavaImpl.class);
        mockValidator = EasyMock.createNiceMock(SnsSignatureVerification.class);
        mockCertFactory = setupMockCertFactory();

        this.snsNotificationParser = new SnsNotificationParser();

        defaultSnsMsgFields = new LinkedHashMap<String, String>();
        defaultSnsMsgFields.put("Type", "Notification");
        defaultSnsMsgFields.put("MessageId", "cf5543af-dd65-5f74-8ccf-0a41094ab4b8");
        defaultSnsMsgFields.put("TopicArn", "arn:aws:sns:us-east-1:598607868003:TestTopic");
        defaultSnsMsgFields.put("Message", "{\"NotificationReferenceId\":\"632a26c4-b2a4-4978-95a1-308a92e99e99\",\"NotificationType\":\"PaymentAuthorize\",\"SellerId\":\"A08439021T39K6DTX4JS9\",\"ReleaseEnvironment\":\"Sandbox\",\"Version\":\"2013-01-01\",\"NotificationData\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><AuthorizationNotification xmlns=\\\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\\\">\\n                                 <AuthorizationDetails>\\n        <AmazonAuthorizationId>S0R-XYXjZtv-lg9tOGD-A056754<\\/AmazonAuthorizationId>\\n        <AuthorizationReferenceId>9bbe88cd5ab4435b85d717fd811cefe3<\\/AuthorizationReferenceId>\\n        <AuthorizationAmount>\\n            <Amount>5.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationAmount>\\n        <CapturedAmount>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/CapturedAmount>\\n                       <AuthorizationFee>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationFee>\\n        <IdList/>\\n        <CreationTimestamp>2013-04-22T05:59:38.186Z<\\/CreationTimestamp>\\n        <ExpirationTimestamp>2013-05-22T05:59:38.186Z<\\/ExpirationTimestamp>\\n        <AuthorizationStatus>\\n            <State>Open<\\/State>\\n            <LastUpdateTimestamp>2013-04-22T06:00:11.473Z<\\/LastUpdateTimestamp>\\n        <\\/AuthorizationStatus>\\n        <OrderItemCategories/>\\n        <CaptureNow>false<\\/CaptureNow>\\n        <SoftDescriptor/>\\n    <\\/AuthorizationDetails>\\n<\\/AuthorizationNotification>\",\"Timestamp\":\"2013-04-22T06:00:14Z\"}");
        defaultSnsMsgFields.put("Timestamp", "2013-04-22T06:00:15.108Z");
        defaultSnsMsgFields.put("SignatureVersion", "1");
        defaultSnsMsgFields.put("Signature", "W/cfaDzCi35LiTpa71Hc7wuBFtCHP27jO3uUMVjWsmk0Q8XN8URl2qFM7KMKPt8pqyKbSrIJhY0qnejQJ/r98b/UIS1rq5ti0X6RgT8zv63I9k18AxWNZ42VflU0VSByhpCME+MIpsUigbA41pe/lgsWq6+CV4Y8yTST5glwqJk=");
        defaultSnsMsgFields.put("SigningCertURL", "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-f3ecfb7224c7233fe7bb5f59f96de52f.pem");
        defaultSnsMsgFields.put("UnsubscribeURL", "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:598607868003:TestTopic:cb4d2e18-ace5-466c-8755-fe8bf294501f");
    }
    
   private X509CertificateFactory setupMockCertFactory() throws NotificationsException {

        X509Certificate cert = EasyMock.createNiceMock(X509Certificate.class);
    	X509CertificateFactory mockCertFactory = EasyMock.createNiceMock(X509CertificateFactory.class);
    	expect(mockCertFactory.getCertificate(anyObject(String.class))).andReturn(cert);
    	return mockCertFactory;
    }

    /**
     * Test that the signature string is constructed correctly,
     * with the optional Subject field present.
     * @throws NotificationsException 
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testShouldConstructSignatureStringCorrectlyWithSubjectField() throws UnsupportedEncodingException, NotificationsException {
        StringBuilder builder = new StringBuilder();
        builder.append("Message\n");
        builder.append("{\"NotificationReferenceId\":\"632a26c4-b2a4-4978-95a1-308a92e99e99\",\"NotificationType\":\"PaymentAuthorize\",\"SellerId\":\"A08439021T39K6DTX4JS9\",\"ReleaseEnvironment\":\"Sandbox\",\"Version\":\"2013-01-01\",\"NotificationData\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><AuthorizationNotification xmlns=\\\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\\\">\\n                                 <AuthorizationDetails>\\n        <AmazonAuthorizationId>S0R-XYXjZtv-lg9tOGD-A056754<\\/AmazonAuthorizationId>\\n        <AuthorizationReferenceId>9bbe88cd5ab4435b85d717fd811cefe3<\\/AuthorizationReferenceId>\\n        <AuthorizationAmount>\\n            <Amount>5.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationAmount>\\n        <CapturedAmount>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/CapturedAmount>\\n                       <AuthorizationFee>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationFee>\\n        <IdList/>\\n        <CreationTimestamp>2013-04-22T05:59:38.186Z<\\/CreationTimestamp>\\n        <ExpirationTimestamp>2013-05-22T05:59:38.186Z<\\/ExpirationTimestamp>\\n        <AuthorizationStatus>\\n            <State>Open<\\/State>\\n            <LastUpdateTimestamp>2013-04-22T06:00:11.473Z<\\/LastUpdateTimestamp>\\n        <\\/AuthorizationStatus>\\n        <OrderItemCategories/>\\n        <CaptureNow>false<\\/CaptureNow>\\n        <SoftDescriptor/>\\n    <\\/AuthorizationDetails>\\n<\\/AuthorizationNotification>\",\"Timestamp\":\"2013-04-22T06:00:14Z\"}\n");
        builder.append("MessageId\n");
        builder.append("cf5543af-dd65-5f74-8ccf-0a41094ab4b8\n");
        builder.append("Subject\n");
        builder.append("Tests\n");
        builder.append("Timestamp\n");
        builder.append("2013-04-22T06:00:15.108Z\n");
        builder.append("TopicArn\n");
        builder.append("arn:aws:sns:us-east-1:598607868003:TestTopic\n");
        builder.append("Type\n");
        builder.append("Notification\n");
        String expectedSignature = builder.toString();

        shouldValidateSignatureConstructionWithFields("Subject", "Tests", expectedSignature);
    }

    /**
     * Test that the signature string is constructed correctly,
     * with the optional Subject field not present.
     * @throws NotificationsException 
     * @throws UnsupportedEncodingException 
     */
    @Test
    public void testShouldConstructSignatureStringCorrectlyWithoutSubjectField() throws UnsupportedEncodingException, NotificationsException {
        StringBuilder b = new StringBuilder();
        b.append("Message\n");
        b.append("{\"NotificationReferenceId\":\"632a26c4-b2a4-4978-95a1-308a92e99e99\",\"NotificationType\":\"PaymentAuthorize\",\"SellerId\":\"A08439021T39K6DTX4JS9\",\"ReleaseEnvironment\":\"Sandbox\",\"Version\":\"2013-01-01\",\"NotificationData\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><AuthorizationNotification xmlns=\\\"https://mws.amazonservices.com/ipn/OffAmazonPayments/2013-01-01\\\">\\n                                 <AuthorizationDetails>\\n        <AmazonAuthorizationId>S0R-XYXjZtv-lg9tOGD-A056754<\\/AmazonAuthorizationId>\\n        <AuthorizationReferenceId>9bbe88cd5ab4435b85d717fd811cefe3<\\/AuthorizationReferenceId>\\n        <AuthorizationAmount>\\n            <Amount>5.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationAmount>\\n        <CapturedAmount>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/CapturedAmount>\\n                       <AuthorizationFee>\\n            <Amount>0.0<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/AuthorizationFee>\\n        <IdList/>\\n        <CreationTimestamp>2013-04-22T05:59:38.186Z<\\/CreationTimestamp>\\n        <ExpirationTimestamp>2013-05-22T05:59:38.186Z<\\/ExpirationTimestamp>\\n        <AuthorizationStatus>\\n            <State>Open<\\/State>\\n            <LastUpdateTimestamp>2013-04-22T06:00:11.473Z<\\/LastUpdateTimestamp>\\n        <\\/AuthorizationStatus>\\n        <OrderItemCategories/>\\n        <CaptureNow>false<\\/CaptureNow>\\n        <SoftDescriptor/>\\n    <\\/AuthorizationDetails>\\n<\\/AuthorizationNotification>\",\"Timestamp\":\"2013-04-22T06:00:14Z\"}\n");
        b.append("MessageId\n");
        b.append("cf5543af-dd65-5f74-8ccf-0a41094ab4b8\n");
        b.append("Timestamp\n");
        b.append("2013-04-22T06:00:15.108Z\n");
        b.append("TopicArn\n");
        b.append("arn:aws:sns:us-east-1:598607868003:TestTopic\n");
        b.append("Type\n");
        b.append("Notification\n");
        String expectedSignature = b.toString();

        shouldValidateSignatureConstructionWithFields(null, null, expectedSignature);
    }

    /**
     * Validate that the given sns message with overriden default fields
     * will result in the expected signature.
     *
     * @param overrideField field to override
     * @param overrideValue value to give the field
     * @param expectedSignatureString expected signature
     * @throws NotificationsException 
     * @throws UnsupportedEncodingException 
     */
    private void shouldValidateSignatureConstructionWithFields(String overrideField, String overrideValue, String expectedSignatureString) throws NotificationsException, UnsupportedEncodingException {
        byte[] expectedSignature = null;
        Message validSnsMessage = null;

        if (overrideField != null) {
            defaultSnsMsgFields.put(overrideField, overrideValue);
        }

        validSnsMessage = Utilities.convertMapToMessage(defaultSnsMsgFields);

        SnsSignatureVerification validator = new SnsSignatureVerification(mockVerifySignature,mockCertFactory);
        expectedSignature = expectedSignatureString.getBytes("UTF-8");
        
        expect(mockVerifySignature.verifyCertIsIssuedByAmazon(anyObject(X509Certificate.class))).andReturn(true);
        expect(mockVerifySignature.verifyMsgMatchesSignatureWithPublicCert(EasyMock.aryEq(expectedSignature),
                EasyMock.aryEq(DatatypeConverter.parseBase64Binary("W/cfaDzCi35LiTpa71Hc7wuBFtCHP27jO3uUMVjWsmk0Q8XN8URl2qFM7KMKPt8pqyKbSrIJhY0qnejQJ/r98b/UIS1rq5ti0X6RgT8zv63I9k18AxWNZ42VflU0VSByhpCME+MIpsUigbA41pe/lgsWq6+CV4Y8yTST5glwqJk=")),
                anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.replay(mockVerifySignature);
        validator.verifyMsgMatchesSignatureV1WithCert(validSnsMessage);

        EasyMock.verify(mockVerifySignature);
    }

    /**
     * Throw an error if the Type field is not found in the sns message.
     *
     */
    @Test
    public void testShouldThrowExceptionIfTypeFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field Type cannot be found";
        try {
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("Type");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the Message field is not found in the sns message.
     */
    @Test
    public void testShouldThrowExceptionIfMessageFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field Message cannot be found";
        try {        	
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("Message");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the Timestamp field is not found in the sns message.
     */
    @Test
    public void testShouldThrowExceptionIfTimestampFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field Timestamp cannot be found";
        try {
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("Timestamp");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the TopicArn field is not found in the sns message.
     */
    @Test
    public void testShouldThrowExceptionIfTopicArnFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field TopicArn cannot be found";
        try {
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("TopicArn");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the Signature field is not found in the sns message.
     */
    @Test
    public void testShouldThrowExceptionIfSignatureFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field Signature cannot be found";        
        try {        	
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("Signature");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the SignatureVersion field is not found in the sns message.
     */
    @Test
    public void testShouldThrowExceptionIfSignatureVersionFieldIsNotDefinedInSnsMessage() {
        String expectedException = "Error with message - mandatory field SignatureVersion cannot be found";
        try {
            assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined("SignatureVersion");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the SignatureVersion field is not equal to 1.
     */
    @Test
    public void testShouldThrowExceptionIfSignatureVersionFieldIsNotEqualToOne() {
        String expectedException = "Error with sns message verification - message is signed with unknown signature specification 2";
        try {
            assertExceptionIsThrownWhenInvalidValueIsSuppliedForSnsField("SignatureVersion", "2");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Throw an error if the Type field is not equal to Notification
     */
    @Test
    public void testShouldThrowExceptionIfTypeFieldIsNotEqualToNotification() throws NotificationsException {
        String expectedException = "Error with sns notification - unexpected message with Type of SubscriptionConfirmation";
        try {
            assertExceptionIsThrownWhenInvalidValueIsSuppliedForSnsField("Type", "SubscriptionConfirmation");
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    /**
     * Assert that an error is thrown if the key value pair is added to the default
     * sns message.
     *
     * @param array $keyvalues value to set
     *
     * @throws NotificationsException
     */
    private void assertExceptionIsThrownWhenInvalidValueIsSuppliedForSnsField(String field, String value) throws NotificationsException {
        defaultSnsMsgFields.put(field, value);
        String invalidSnsMessage = Utilities.convertMapToJsonString(defaultSnsMsgFields);
        Map<String, String> map = Utilities.getSnsHeaderFields();
        SnsMessageValidator validator = new SnsMessageValidator(mockValidator);
        validator.validateMessageIsTrusted(this.snsNotificationParser.parseNotification(map, invalidSnsMessage));
    }

    /**
     * Assert that an exception is thrown if the given field is removed from the
     * valid field set.
     *
     * @param string $fieldName name of field to remove
     * @throws NotificationsException 
     */
    private void assertThatInvalidMessageExceptionIsThrownWhenFieldIsNotDefined(String fieldName) throws NotificationsException {
        defaultSnsMsgFields.remove(fieldName);

        Map<String, String> map = Utilities.getSnsHeaderFields();

        String invalidSnsMessage = Utilities.convertMapToJsonString(defaultSnsMsgFields);
        expect(mockVerifySignature.verifyCertIsIssuedByAmazon(anyObject(X509Certificate.class))).andReturn(true);
        SnsMessageValidator validator = new SnsMessageValidator( new SnsSignatureVerification(mockVerifySignature,mockCertFactory));
        EasyMock.replay(mockVerifySignature);       
        validator.validateMessageIsTrusted(this.snsNotificationParser.parseNotification(map, invalidSnsMessage));
    }
}
