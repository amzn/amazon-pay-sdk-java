package PayWithAmazon.test;

import PayWithAmazon.Client;
import PayWithAmazon.Request.AuthorizeRequest;
import PayWithAmazon.Request.CancelOrderReferenceRequest;
import PayWithAmazon.Request.CaptureRequest;
import PayWithAmazon.Request.CloseAuthorizationRequest;
import PayWithAmazon.Request.CloseOrderReferenceRequest;
import PayWithAmazon.Request.ConfirmOrderReferenceRequest;
import PayWithAmazon.Request.GetAuthorizationDetailsRequest;
import PayWithAmazon.Request.GetCaptureDetailsRequest;
import PayWithAmazon.Request.GetOrderReferenceDetailsRequest;
import PayWithAmazon.Request.RefundRequest;
import PayWithAmazon.Utilities.ParamConstants;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SinglePaymentAPIUnitTest {
    
    @Before
    public void setUp() throws Exception {
    }
    
    @After
    public void tearDown() {
    }
    
   @Test
    public void testAuthorizeRequest() {
        AuthorizeRequest request = new AuthorizeRequest();
        request.setAmazonOrderReferenceId(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setAuthorizationAmount("2").setAuthorizationReferenceId("Auth123").setCaptureNow("true").setSoftDescriptor(TestConstants.softDescriptor).setSellerAuthorizationNote(TestConstants.sampletext).setTransactionTimeout("10");

        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AUTHORIZATION_AMOUNT) , "2");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_AUTHORIZATION_REFERENCE_ID ) , "Auth123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CAPTURE_NOW) , "true");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.TRANSACTION_TIMEOUT) , "10");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.SELLER_AUTHORIZATION_NOTE) , TestConstants.sampletext);  
        Assert.assertEquals(request.getParamMap().size() , 8);
    }
        
   @Test public void testCancelOrderReference() {
       
        CancelOrderReferenceRequest request = new CancelOrderReferenceRequest();
        request.setAmazonOrderReferenceId(TestConstants.amazonOrderReferenceId).setCancelReason(TestConstants.sampletext).setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CANCELATION_REASON), TestConstants.sampletext);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
   
        Assert.assertEquals(request.getParamMap().size(), 3);

    }

   @Test public void testCapture() {
       
        CaptureRequest request = new CaptureRequest();
        request.setAmazonAuthorizationId(TestConstants.amazonOrderReferenceId).setCaptureReferenceId("Capt123").setMWSAuthToken(TestConstants.mwsAuthToken).setCaptureAmount("2").setSellerCaptureNote(TestConstants.sampletext).setSoftDescriptor(TestConstants.softDescriptor);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CAPTURE_REFERENCE_ID), "Capt123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CAPTURE_NOTE) , TestConstants.sampletext);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CAPTURE_AMOUNT) , "2");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        
        Assert.assertEquals(request.getParamMap().size() , 6);

    }
    
    @Test public void testCloseAuthorizationRequest() {
       
        CloseAuthorizationRequest request = new CloseAuthorizationRequest();
        request.setAmazonAuthorizationId("Auth123").setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_AUTHORIZATION_ID), "Auth123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CLOSURE_REASON), TestConstants.sampletext);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 3);

    }
       


       @Test public void testCloseOrderReferenceRequest() {
       
        CloseOrderReferenceRequest request = new CloseOrderReferenceRequest();
        request.setAmazonOrderReferenceId(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.CLOSURE_REASON), TestConstants.sampletext);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 3);

    }
       

       @Test public void testConfirmOrderReferenceRequest() {
       
        ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest();
        request.setAmazonOrderReferenceId(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 2);

    }
       
 
      
       @Test public void testGetAuthorizationDetailsRequest() {
       
        GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest();
        request.setAmazonAuthorizationId("Auth123").setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_AUTHORIZATION_ID) , "Auth123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 2);

       }

       @Test public void testGetCaptureDetailsRequest() {
       
        GetCaptureDetailsRequest request = new GetCaptureDetailsRequest();
        request.setAmazonCaptureId("Capt123").setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_CAPTURE_ID) , "Capt123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 2);

    }

       
       @Test public void testGetOrderReferenceDetailsRequest() {
       
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest();
        request.setAmazonOrderReferenceId(TestConstants.amazonOrderReferenceId).setAddressConsentToken("123").setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_ORDER_REFERENCE_ID) , TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.ADDRESS_CONSENT_TOKEN) , "123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.getParamMap().size() , 3);

    }

       
       @Test public void testRefundRequest() {
       
        RefundRequest request = new RefundRequest();
        request.setAmazonCaptureId("C1233421424").setMWSAuthToken(TestConstants.mwsAuthToken).setRefundAmount("2").setRefundReferenceId("Refund123").setSellerRefundNote(TestConstants.sampletext).setSoftDescriptor(TestConstants.softDescriptor);
        
        Assert.assertEquals(request.getParamMap().get(ParamConstants.AMAZON_CAPTURE_ID) , "C1233421424");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.REFUND_REFERENCE_ID), "Refund123");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.SELLER_REFUND_NOTE) , TestConstants.sampletext);
        Assert.assertEquals(request.getParamMap().get(ParamConstants.REFUND_AMOUNT) , "2");
        Assert.assertEquals(request.getParamMap().get(ParamConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        
        Assert.assertEquals(request.getParamMap().size() , 6);
    }
       
}
