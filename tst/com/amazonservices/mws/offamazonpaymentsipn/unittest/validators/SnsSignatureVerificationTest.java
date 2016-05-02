package com.amazonservices.mws.offamazonpaymentsipn.unittest.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.certificate.X509CertificateFactory;
import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;
import com.amazonservices.mws.offamazonpaymentsipn.validators.IVerifyData;
import com.amazonservices.mws.offamazonpaymentsipn.validators.SnsSignatureVerification;



public class SnsSignatureVerificationTest {

    private IVerifyData mockValidator;
    
    private X509CertificateFactory mockCertFactory;

    private SnsSignatureVerification snsSignatureVerification;

    @Before
    public void SetUp() throws NotificationsException {
        
    	mockValidator = EasyMock.createNiceMock(IVerifyData.class);
        mockCertFactory = setupMockCertFactory();        
        snsSignatureVerification = new SnsSignatureVerification(mockValidator,mockCertFactory);
    }
    
    

    @Test
    public void testCreateUnhashedSignatureByteArrayFromSnsMessageDataWithDecodeSignatureString() throws NotificationsException, UnsupportedEncodingException {
        String expectedSignature = "WPvufNGD0meAuOf+zNdU+2KOoZE0H005/XCGobaUTgcEZ+q6ojeKrDPZ7i7EwLS9GTPGZK3Qjk9VPvsLs49svxSIhzLoebKFBTDOurZzQsxoi2Qr5rvebpNkPe4YZpDsCk+0Z2I6xXQWGgc0QRa6umhiecC7AMVnMA8wlvtX6ko=";

        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields(expectedSignature, "https://testcert", null);
        Message msg = Utilities.convertMapToMessage(snsFields);
        byte[] expectedSignatureBytes = getExpectedSignatureBytesFromMap(snsFields);
       
    	EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureWithPublicCert(EasyMock.aryEq(expectedSignatureBytes), 
                EasyMock.anyObject(byte[].class), EasyMock.anyObject(X509Certificate.class))).andReturn(true);

        EasyMock.replay(mockValidator);
        boolean result = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);

        assertTrue(result);
        EasyMock.verify(mockValidator);
    }

    @Test
    public void testCreateUnhashedSignatureByteArrayFromSnsMessageDataThatContainsOptionalSubjectField() throws NotificationsException, UnsupportedEncodingException {
        String expectedSignature = "WPvufNGD0meAuOf+zNdU+2KOoZE0H005/XCGobaUTgcEZ+q6ojeKrDPZ7i7EwLS9GTPGZK3Qjk9VPvsLs49svxSIhzLoebKFBTDOurZzQsxoi2Qr5rvebpNkPe4YZpDsCk+0Z2I6xXQWGgc0QRa6umhiecC7AMVnMA8wlvtX6ko=";

        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields(expectedSignature, "https://testcert", "Value");
        Message msg = Utilities.convertMapToMessage(snsFields);

        byte[] expectedSignatureBytes = getExpectedSignatureBytesFromMap(snsFields);
       
        EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureWithPublicCert(EasyMock.aryEq(expectedSignatureBytes), 
                EasyMock.anyObject(byte[].class), EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.replay(mockValidator);
        boolean result = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);

        assertTrue(result);
        EasyMock.verify(mockValidator);
    }

    @Test
    public void testDecodeBase64SignatureString() throws NotificationsException {
        String expectedSignatureValue = "WPvufNGD0meAuOf+zNdU+2KOoZE0H005/XCGobaUTgcEZ+q6ojeKrDPZ7i7EwLS9GTPGZK3Qjk9VPvsLs49svxSIhzLoebKFBTDOurZzQsxoi2Qr5rvebpNkPe4YZpDsCk+0Z2I6xXQWGgc0QRa6umhiecC7AMVnMA8wlvtX6ko=";
        byte[] expectedByteArray = DatatypeConverter.parseBase64Binary(expectedSignatureValue);

        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields(expectedSignatureValue, "https://testcert", "Value");
        Message msg = Utilities.convertMapToMessage(snsFields);
        
        EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureWithPublicCert(EasyMock.anyObject(byte[].class), 
                EasyMock.aryEq(expectedByteArray), EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.replay(mockValidator);
        boolean result = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);

        assertTrue(result);
        EasyMock.verify(mockValidator);
    }

    @Test
    public void testExtractAndPassThroughSignCertUrlProperty() throws NotificationsException {
        String expectedSignatureValue = "WPvufNGD0meAuOf+zNdU+2KOoZE0H005/XCGobaUTgcEZ+q6ojeKrDPZ7i7EwLS9GTPGZK3Qjk9VPvsLs49svxSIhzLoebKFBTDOurZzQsxoi2Qr5rvebpNkPe4YZpDsCk+0Z2I6xXQWGgc0QRa6umhiecC7AMVnMA8wlvtX6ko=";
        String expectedSignCertUrl = "https://testcert";

        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields(expectedSignatureValue, expectedSignCertUrl, "Value");
        Message msg = Utilities.convertMapToMessage(snsFields);
        
        EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureWithPublicCert(EasyMock.anyObject(byte[].class), 
                EasyMock.anyObject(byte[].class), EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.replay(mockValidator);
        boolean result = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);

        assertTrue(result);
        EasyMock.verify(mockValidator);
    }

    @Test
    public void testReturnFalseWhenSignatureVerificationFails() throws NotificationsException, UnsupportedEncodingException {
        String expectedSignatureValue = "WPvufNGD0meAuOf+zNdU+2KOoZE0H005/XCGobaUTgcEZ+q6ojeKrDPZ7i7EwLS9GTPGZK3Qjk9VPvsLs49svxSIhzLoebKFBTDOurZzQsxoi2Qr5rvebpNkPe4YZpDsCk+0Z2I6xXQWGgc0QRa6umhiecC7AMVnMA8wlvtX6ko=";

        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields(expectedSignatureValue, "https://testcert", "Value");
        Message msg = Utilities.convertMapToMessage(snsFields);
        
        EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(true);
        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureWithPublicCert(EasyMock.anyObject(byte[].class), 
                EasyMock.anyObject(byte[].class), EasyMock.anyObject(X509Certificate.class))).andReturn(false);
        EasyMock.replay(mockValidator);
        boolean result = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);

        assertFalse(result);
        EasyMock.verify(mockValidator);
    }

    @Test
    public void testThrowExceptionTypeIsNotNotification() throws NotificationsException {
        String expectedException = "Error with sns message verification - message is not of type Notification, no implementation of signing algorithm is present for other notification types";
        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields("dfsdf", "https://testcert", "Value");
        snsFields.remove("Type");
        snsFields.put("Type", "SubscriptionConfirmation");
        Message msg = Utilities.convertMapToMessage(snsFields);
        
        try {
            snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }
    
    @Test
    public void testThrowExceptionCertIsNotValid() throws NotificationsException {
        String expectedException = "Error with sns message verification - certificate in notification is not a valid certificate issued by Amazon";
        LinkedHashMap<String, String> snsFields = getDefaultSnsSignatureVerificationFields("dfsdf", "https://testcert", "Value");        
        Message msg = Utilities.convertMapToMessage(snsFields);
        EasyMock.expect(mockValidator.verifyCertIsIssuedByAmazon(EasyMock.anyObject(X509Certificate.class))).andReturn(false);
        try {
            snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(msg);
            fail();
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    private static LinkedHashMap<String,String> getDefaultSnsSignatureVerificationFields(final String signature, final String signCertUrl, final String subject) {
        LinkedHashMap<String, String> snsFields = new LinkedHashMap<String, String>();
        snsFields.put("Message", "{\"NotificationReferenceId\":\"32d195c3-a829-4222-b1e2-14ab28909513\",\"NotificationType\":\"OrderReferenceNotification\",\"SellerId\":\"A08439021T39K6DTX4JS9\",\"ReleaseEnvironment\":\"Sandbox\",\"Version\":\"2012-12-25\",\"NotificationData\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?><OrderReferenceNotification xmlns=\\\"http://payments.amazon.com/ipn/2012-12-25/\\\">\\n    <OrderReference>\\n        <AmazonOrderReferenceId>P0R-T9jl5tI-qryuG17<\\/AmazonOrderReferenceId>\\n        <OrderTotal>\\n            <Amount>5.00<\\/Amount>\\n            <CurrencyCode>USD<\\/CurrencyCode>\\n        <\\/OrderTotal>\\n        <SellerNote>APPROVE HEAVY APPROVE LITE<\\/SellerNote>\\n        <OrderReferenceStatus>\\n            <State>CLOSED<\\/State>\\n            <ReasonCode>SellerClosed<\\/ReasonCode>\\n            <LastUpdateTimestamp>2013-04-01T10:49:59.532Z<\\/LastUpdateTimestamp>\\n        <\\/OrderReferenceStatus>\\n        <CreationTimestamp>2013-03-30T09:58:51.234Z<\\/CreationTimestamp>\\n        <ExpirationTimestamp>2013-04-06T09:58:51.234Z<\\/ExpirationTimestamp>\\n    <\\/OrderReference>\\n<\\/OrderReferenceNotification>\",\"Timestamp\":\"2013-04-01T10:49:59Z\"}");
        snsFields.put("MessageId", "432f33bf-9f84-5004-815f-7a6cf72595bf");
        if (subject != null) {
            snsFields.put("Subject", subject);
        }
        snsFields.put("Timestamp", "2013-04-01T10:50:09.831Z");
        snsFields.put("TopicArn", "arn:aws:sns:us-east-1:598607868003:TestTopic");
        snsFields.put("Type", "Notification");
        snsFields.put("Signature", signature);
        snsFields.put("SigningCertURL", signCertUrl);

        return snsFields;
    }

    private byte[] getExpectedSignatureBytesFromMap(final LinkedHashMap<String, String> snsFields) throws UnsupportedEncodingException {
        StringBuilder expectedString = new StringBuilder();
        Set<String> keys = snsFields.keySet();

        for (String key : keys) {
            if (!key.equals("Signature") && !key.equals("SigningCertURL")) {
                expectedString.append(String.format("%s\n%s\n", key, snsFields.get(key)));
            }
        }

        return expectedString.toString().getBytes("UTF8");
    }
    
    private X509CertificateFactory setupMockCertFactory() throws NotificationsException {

        X509Certificate cert = EasyMock.createNiceMock(X509Certificate.class);
    	
    	X509CertificateFactory mockCertFactory = EasyMock.createNiceMock(X509CertificateFactory.class);
    	EasyMock.expect(mockCertFactory.getCertificate(EasyMock.anyObject(String.class))).andReturn(cert);
    	
    	return mockCertFactory;
    }
    
}
