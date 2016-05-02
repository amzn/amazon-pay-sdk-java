package com.amazonservices.mws.offamazonpaymentsipn.unittest.validators;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;
import com.amazonservices.mws.offamazonpaymentsipn.unittest.Utilities;
import com.amazonservices.mws.offamazonpaymentsipn.validators.ISnsSignatureVerification;
import com.amazonservices.mws.offamazonpaymentsipn.validators.SnsMessageValidator;


public class SnsMessageValidatorTest {

    private SnsMessageValidator messageValidator;

    private ISnsSignatureVerification mockValidator;

    @Before
    public void SetUp() {
        mockValidator = EasyMock.createNiceMock(ISnsSignatureVerification.class);
        messageValidator = new SnsMessageValidator(mockValidator);
    }

    @Test
    public void testValidateMessageIfSignaturVersionIsOne() throws NotificationsException {
        Map<String, String> snsMsgFields = new HashMap<String, String>();
        snsMsgFields.put("SignatureVersion", "1");
        Message snsMessage = Utilities.convertMapToMessage(snsMsgFields);

        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureV1WithCert(snsMessage)).andReturn(true);
        EasyMock.replay(mockValidator);
        this.messageValidator.validateMessageIsTrusted(snsMessage);

        EasyMock.verify(mockValidator);
    }

    @Test
    public void ShouldThrowExceptionIfSignatureVersionIsNotV1() throws NotificationsException {
        String expectedException = "Error with sns message verification - message is signed with unknown signature specification 2";
        Map<String, String> snsMsgFields = new HashMap<String, String>();
        snsMsgFields.put("SignatureVersion", "2");
        Message snsMessage = Utilities.convertMapToMessage(snsMsgFields);

        try {
            this.messageValidator.validateMessageIsTrusted(snsMessage);
            fail("Expected exception not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    @Test
    public void ShouldThrowExceptionIfSignatureVersionFieldIsMissing() throws NotificationsException {
        String expectedException = "Error with message - mandatory field SignatureVersion cannot be found";
        Map<String, String> snsMsgFields = new HashMap<String, String>();
        Message snsMessage = Utilities.convertMapToMessage(snsMsgFields);

        try {
            this.messageValidator.validateMessageIsTrusted(snsMessage);
            fail("Expected exception not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
    }

    @Test
    public void ShouldThrowExceptionWhenSignatureVerificationVersion1Fails() throws NotificationsException {
        String expectedException = "Error with sns message - signature verification v1 failed for message id test, topicArn 223";
        Map<String, String> snsMsgFields = new HashMap<String, String>();
        snsMsgFields.put("SignatureVersion", "1");
        Message snsMessage = Utilities.convertMapToMessage(snsMsgFields);
        snsMessage.setMetadata(Utilities.createTestSnsNotificationMetadata("test", "223"));

        EasyMock.expect(mockValidator.verifyMsgMatchesSignatureV1WithCert(snsMessage)).andReturn(false);
        EasyMock.replay(mockValidator);

        try {
            this.messageValidator.validateMessageIsTrusted(snsMessage);
            fail("Expected exception not thrown");
        } catch (NotificationsException e) {
            Utilities.verifyExceptionThrownWithMessage(e, expectedException);
        }
        EasyMock.verify(mockValidator);
    }
}
