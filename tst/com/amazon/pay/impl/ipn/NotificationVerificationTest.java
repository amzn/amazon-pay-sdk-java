package com.amazon.pay.impl.ipn;

import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.ipn.model.Notification;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = { NotificationVerification.class})
public class NotificationVerificationTest {
         
    private Map<String,String> ipnHeader = new HashMap<String,String>();
    private String sampleNotification;
        
    @Before
    public void setUp() throws Exception {
        ipnHeader.put("x-amz-sns-message-type" , "Notification");
        sampleNotification = new NotificationFactoryTest().loadTestFile("AuthorizeNotification.json");
    }
    
    /**
     * Empty payload and empty header 
     */
    @Test(expected=AmazonClientException.class)
    public void testNullHeaderPayloadIPN() {
        NotificationFactory.parseNotification(null, null);
        Assert.fail();
    }

    /**
     * Empty header
     */
    @Test(expected=AmazonClientException.class)
    public void testEmptyHeaderIPN() {
        Map<String,String> emptyheader = new HashMap<String,String>();
        NotificationFactory.parseNotification(emptyheader, sampleNotification);
        Assert.fail();
    }
    
    /**
     * Null header
     */
    @Test(expected=AmazonClientException.class)
    public void testNullHeaderIPN() {
        NotificationFactory.parseNotification(null, sampleNotification);
        Assert.fail();
    }
    
    /**
     * Incorrect header
     */
    @Test(expected=AmazonClientException.class)
    public void testBadHeaderIPN() {
        Map<String,String> badHeader = new HashMap<String,String>();
        badHeader.put("x-amz-sns-message-type" , "Otherr");
        NotificationFactory.parseNotification(badHeader, sampleNotification);
        Assert.fail();
    }
    
    /**
     * Null Payload
     */
    @Test(expected=AmazonClientException.class)
    public void testNullPayloadIPN() {
        Notification notification = NotificationFactory.parseNotification(ipnHeader, null);
        Assert.fail();
    }
    
    /**
     * Empty Payload
     */
    @Test(expected=AmazonClientException.class)
    public void testEmptyPayloadIPN() {
        String payload = "";
        Notification notification = NotificationFactory.parseNotification(ipnHeader, payload);
        Assert.fail();
    }

}
