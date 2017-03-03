package com.amazon.pay.impl.ipn;

import com.amazon.pay.response.ipn.model.ProviderCreditNotification;
import com.amazon.pay.response.ipn.model.RefundNotification;
import com.amazon.pay.exceptions.AmazonClientException;
import com.amazon.pay.response.ipn.model.AuthorizationNotification;
import com.amazon.pay.response.ipn.model.BillingAgreementNotification;
import com.amazon.pay.response.ipn.model.CaptureNotification;
import com.amazon.pay.response.ipn.model.Notification;
import com.amazon.pay.response.ipn.model.NotificationType;
import com.amazon.pay.response.ipn.model.OrderReferenceNotification;
import com.amazon.pay.response.ipn.model.ProviderCreditReversalNotification;
import com.amazon.pay.response.ipn.model.SolutionProviderMerchantNotification;
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
@PrepareForTest(value = { NotificationVerification.class})
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
        ipnHeader.put("x-amz-sns-message-type" , "Notification");
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
            Assert.assertEquals("Message signature calculation failed" , e.getMessage());
        }
    }

    
    /**
     * Incorrect notification type
     */
    @Test
    public void testUnrecognizedNotificationTypeIPN() throws IOException {
        try { 
            NotificationFactory.parseNotification(ipnHeader,loadTestFile("BadNotification.json"));
            Assert.fail();
        } catch (AmazonClientException e) {
            Assert.assertEquals("Unknown notification type: BlahBlah" , e.getMessage());
        }
    }
    
    

    /**
     * Test Authorization Notification
     */
    @Test
    public void testAuthorizationIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("AuthorizeNotification.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    /**
     * Test Capture Notification 
     */
    @Test
    public void testCaptureIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("CaptureNotification.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    
    /**
     * Test Order Reference Notification 
     */
    @Test
    public void testOrderReferenceIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("OrderReferenceNotification.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    
    /**
     * Test Refund Notification 
     */
    @Test
    public void testRefundIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("RefundNotification.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    
    /**
     * Test ProviderCredit Notification
     */
    @Test
    public void testProviderCreditIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("ProviderCreditNotification.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    /**
     * Test ProviderCredit Notification
     */
    @Test
    public void testProviderReversalCreditIPN() throws IOException, DatatypeConfigurationException {
        String notificationPayload = loadTestFile("ProviderReversalCredit.json");
        Notification notification = NotificationFactory.parseNotification(ipnHeader, notificationPayload);
        testIPNValues(notification , notificationPayload);
    }
    
    /**
     * Helper method to test IPN Notification values
     * @param notification
     * @param payLoad 
     */
    private void testIPNValues(Notification notification , String payLoad) throws DatatypeConfigurationException {
        NotificationType type = notification.getNotificationType();
        switch (type) {
            case CaptureNotification:
                CaptureNotification cp = (CaptureNotification)notification;
                testCaptureIPNDetails(cp);
                testIPNMetaData(notification);
                break;
            case AuthorizationNotification:
                AuthorizationNotification an = (AuthorizationNotification)notification;
                testAuthorizeIPNDetails(an);
                break;
            case BillingAgreementNotification:
                BillingAgreementNotification bn = (BillingAgreementNotification)notification;
                testBillingAgreementIPNDetails(bn);
                break;
            case OrderReferenceNotification:
                OrderReferenceNotification on = (OrderReferenceNotification)notification;
                testOrderReferenceIPNDetails(on);
                break;
            case ProviderCreditNotification:
                ProviderCreditNotification pc = (ProviderCreditNotification)notification;
                testProviderCreditIPNDetails(pc);
                break;
            case ProviderCreditReversalNotification:
                ProviderCreditReversalNotification pcrn = (ProviderCreditReversalNotification)notification;
                testReverseProviderCreditIPNDetails(pcrn);
                break;
            case RefundNotification:
                RefundNotification rn = (RefundNotification)notification;
                testRefundIPNDetails(rn);
                break;
            case SolutionProviderMerchantNotification:
                SolutionProviderMerchantNotification sp = (SolutionProviderMerchantNotification)notification;
                //TO:DO add SolutionProviderMerchantNotification IPN
                break;

        }
    }
    
    
    /**
     * Helper method to test notification values
     * @param notification 
     */
    private void testIPNMetaData(Notification notification) {
         Assert.assertEquals(notification.getNotificationMetadata().getSigningCertUrl() , "https://sns.us-east-1.amazonaws.com/SimpleNotificationService-bb750dd426d95ee9390147a5624348ee.pem");
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
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(or.getOrderReference().getCreationTimestamp(), xgc);
        Assert.assertEquals(or.getOrderReference().getDestination(), null);
        XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
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
        Assert.assertEquals(bn.getBillingAgreement().getAmazonBillingAgreementId() , "");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAddress(), "");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementLimits(), "");
        Assert.assertEquals(bn.getBillingAgreement().getBillingAgreementStatus(), "");
        Assert.assertEquals(bn.getBillingAgreement().getBuyer(), "");
        Assert.assertEquals(bn.getBillingAgreement().getConstraints(), "");
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(bn.getBillingAgreement().getCreationTimestamp(), xgc);
        Assert.assertEquals(bn.getBillingAgreement().getDestination(), "");
        XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(bn.getBillingAgreement().getExpirationTimestamp(), xgc2);
        Assert.assertEquals(bn.getBillingAgreement().getOrderLanguage(), null);
        Assert.assertEquals(bn.getBillingAgreement().getPlatformId(), "");
        Assert.assertEquals(bn.getBillingAgreement().getReleaseEnvironment(), "");
        Assert.assertEquals(bn.getBillingAgreement().getSellerBillingAgreementAttributes(), "");
        Assert.assertEquals(bn.getBillingAgreement().getSellerNote(), "");
    }
    
    private void testProviderCreditIPNDetails(ProviderCreditNotification pc) throws DatatypeConfigurationException {
        Assert.assertEquals(pc.getProviderCreditDetails().getAmazonProviderCreditId(), "S01-0458164-4040121-P098523");
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-10-29T16:48:59.040Z");
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
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(rn.getRefundDetails().getCreationTimestamp(), xgc);
        Assert.assertEquals(rn.getRefundDetails().getFeeRefunded().getAmount(), "2.0");
        Assert.assertEquals(rn.getRefundDetails().getProviderCreditReversalSummaryList(), null);
        Assert.assertEquals(rn.getRefundDetails().getRefundAmount().getAmount(), "3.0");
        Assert.assertEquals(rn.getRefundDetails().getRefundReferenceId(), "P01-0000000-0000000-Ref");
        Assert.assertEquals(rn.getRefundDetails().getRefundStatus().getState(), "Completed");
        Assert.assertEquals(rn.getRefundDetails().getRefundType(), RefundType.SELLER_INITIATED);
        Assert.assertEquals(rn.getRefundDetails().getSellerRefundNote(), null);
        Assert.assertEquals(rn.getRefundDetails().getSoftDescriptor(), "AMZ*softDescriptor");


    }
    private void testReverseProviderCreditIPNDetails(ProviderCreditReversalNotification pcr) throws DatatypeConfigurationException {
        Assert.assertEquals(pcr.getProviderCreditReversalDetails().getAmazonProviderCreditReversalId(), "S01-3154248-3064261-Q087635");
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-16T01:42:43.941Z");
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
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(cp.getCaptureDetails().getCreationTimestamp(), xgc);
        XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-01-01T01:01:01.001Z");
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
        XMLGregorianCalendar xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-01-01T01:01:01.001Z");
        Assert.assertEquals(an.getAuthorizationDetails().getCreationTimestamp(), xgc);
        XMLGregorianCalendar xgc2 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2013-03-01T01:01:01.001Z");
        Assert.assertEquals(an.getAuthorizationDetails().getExpirationTimestamp(), xgc2);
        XMLGregorianCalendar xgc3 = DatatypeFactory.newInstance().newXMLGregorianCalendar("2014-01-01T01:01:01.001Z");
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
        InputStream is = new FileInputStream(System.getProperty("user.dir") +"/tst/com/amazon/pay/impl/ipn/json/" + fileName);
        if (is != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
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
