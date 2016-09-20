package com.amazon.payments.paywithamazon.impl.ipn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import org.junit.Test;

public class SigningCertURLTest {

    private static final String VALID_CERT_URL = "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String VALID_CERT_CN_URL = "https://sns.us-east-1.amazonaws.com.cn/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String INVALID_PROTOCOL_CERT_URL = "http://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String INVALID_FILE_CERT_URL = "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.exe";
    private static final String INVALID_DOMAIN1_CERT_URL = "https://sns.us-east-1.fakecert.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String INVALID_DOMAIN2_CERT_URL = "https://sni.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String INVALID_DOMAIN3_CERT_URL = "https://sns.us.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";
    private static final String INVALID_DOMAIN4_CERT_URL = "https://sns.us-east-1.amazonaws.com.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem";

    /**
     * SigningCertURL parameter with invalid protocol
     */
    @Test(expected=SecurityException.class)
    public void testIllegalProtocolSigningCertURL() throws Throwable {
        testSigningCertURL(INVALID_PROTOCOL_CERT_URL);
    }

    /**
     * SigningCertURL parameter with invalid file type
     */
    @Test(expected=SecurityException.class)
    public void testInvalidFileSigningCertURL() throws Throwable {
        testSigningCertURL(INVALID_FILE_CERT_URL);
    }

    /**
     * SigningCertURL parameter with invalid host name
     */
    @Test(expected=SecurityException.class)
    public void testInvalidDomain1SigningCertURL() throws Throwable {
        String testURL = INVALID_DOMAIN1_CERT_URL;
        testSigningCertURL(testURL);
    }

    /**
     * SigningCertURL parameter with invalid host name
     */
    @Test(expected=SecurityException.class)
    public void testInvalidDomain2SigningCertURL() throws Throwable {
        String testURL = INVALID_DOMAIN2_CERT_URL;
        testSigningCertURL(testURL);
    }

    /**
     * SigningCertURL parameter with invalid host name
     */
    @Test(expected=SecurityException.class)
    public void testInvalidDomain3SigningCertURL() throws Throwable {
        String testURL = INVALID_DOMAIN3_CERT_URL;
        testSigningCertURL(testURL);
    }

    /**
     * SigningCertURL parameter with invalid host name
     */
    @Test(expected=SecurityException.class)
    public void testInvalidDomain4SigningCertURL() throws Throwable {
        String testURL = INVALID_DOMAIN4_CERT_URL;
        testSigningCertURL(testURL);
    }

    /**
     * SigningCertURL parameter with valid URL
     */
    @Test
    public void testValidSigningCertURL() throws Throwable {
        String testURL = VALID_CERT_URL;
        testSigningCertURL(testURL);
    }

    /**
     * SigningCertURL parameter with valid CN URL
     */
    @Test
    public void testValid2SigningCertURL() throws Throwable {
        String testURL = VALID_CERT_CN_URL;
        testSigningCertURL(testURL);
    }

    private void testSigningCertURL(String testURL) throws Throwable {
        NotificationVerification nv = new NotificationVerification();
        Method m = nv.getClass().getDeclaredMethod("isValidSigningCertURL", URL.class);
        m.setAccessible(true);
        try {
            m.invoke(nv , new URL(testURL) );
        } catch(InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if(targetException instanceof SecurityException ) {
                throw targetException;
            }
        }
    }



}
