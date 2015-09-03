package PayWithAmazon.test;

import PayWithAmazon.IPNHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPNHandlerTest {
     
   private IPNHandler ipnHandler;
    
    @Before
    public void setUp() {
       ipnHandler = new IPNHandler(TestConstants.sampleIPNNotification);
    }

   @Test
    public void testIPNHandler() {
        Assert.assertEquals(ipnHandler.getEnvironment() , "Sandbox");
        Assert.assertEquals(ipnHandler.getMessageId() , "33bd40e3-6a9a-58cf-b6be-0eb9ca6bc4e9");
        Assert.assertEquals(ipnHandler.getMessageTimeStamp() , "2015-08-28T17:47:29.215Z");
        Assert.assertEquals(ipnHandler.getNotificationData() , TestConstants.sampleCaptureNotification);
        Assert.assertEquals(ipnHandler.getNotificationType() , "PaymentCapture");
        Assert.assertEquals(ipnHandler.getSellerId() , "A2K7NDRCTOTPW9");
        Assert.assertEquals(ipnHandler.getSignature() , "eUInUlaydzV4eoOcSKHSyNqt9yFAa1r0kFQz2PxXlNV4Ik04pYRyZlgbXy5NdhzdRzGKwIlPG8QcL2HlNe7nFkKecQapQZYmI7cWpvEslO/xrJgP6jTH5j18Xkk7/lmhV79wgwIWjT7LtbMrc3jC7QNDqwiNcRT694WKpFx1+PFa4BdUd0cUCyPLQrWFcNpS0z8fcaERqO98BUZkkPVfwWA7bQhIwQnxJNVzL9dFxWAhs98W7N89/8yEEg7nz/OK0hr9vfaT0P7ZGCYNsrDlwooGbhtJlhj2aLjfFwR91P7h5cK20nx3eBgN3Nen6BXU1jqnz7plA3QVuygzRIUJmA==");
        Assert.assertEquals(ipnHandler.getSignatureVersion() , "1");
        Assert.assertEquals(ipnHandler.getSigningCertURL() , "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem");
        Assert.assertEquals(ipnHandler.getTimestamp() , "2015-08-28T17:47:29.280Z");
        Assert.assertEquals(ipnHandler.getTopicArn() , "arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9");
        Assert.assertEquals(ipnHandler.getType() , "Notification");
        Assert.assertEquals(ipnHandler.getUnsubscribeURL() , "https://sns.us-east-1.amazonaws.com/?Action=Unsubscribe&SubscriptionArn=arn:aws:sns:us-east-1:291180941288:A3BXB0YN3XH17HA2K7NDRCTOTPW9:05542723-375e-4609-98f1-8abcf427d95f");
        Assert.assertEquals(ipnHandler.isNotificationValid() , true);
    }
}
