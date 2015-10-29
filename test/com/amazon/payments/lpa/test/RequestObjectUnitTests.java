package com.amazon.payments.lpa.test;

import com.amazon.payments.lpa.helper.ServiceConstants;
import com.amazon.payments.lpa.request.AuthorizeOnBillingAgreementRequest;
import com.amazon.payments.lpa.request.AuthorizeRequest;
import com.amazon.payments.lpa.request.CancelOrderReferenceRequest;
import com.amazon.payments.lpa.request.CaptureRequest;
import com.amazon.payments.lpa.request.CloseAuthorizationRequest;
import com.amazon.payments.lpa.request.CloseBillingAgreementRequest;
import com.amazon.payments.lpa.request.CloseOrderReferenceRequest;
import com.amazon.payments.lpa.request.ConfirmBillingAgreementRequest;
import com.amazon.payments.lpa.request.ConfirmOrderReferenceRequest;
import com.amazon.payments.lpa.request.GetAuthorizationDetailsRequest;
import com.amazon.payments.lpa.request.GetBillingAgreementDetailsRequest;
import com.amazon.payments.lpa.request.GetCaptureDetailsRequest;
import com.amazon.payments.lpa.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.lpa.request.GetProviderCreditDetailsRequest;
import com.amazon.payments.lpa.request.GetProviderCreditReversalDetailsRequest;
import com.amazon.payments.lpa.request.GetRefundDetailsRequest;
import com.amazon.payments.lpa.request.RefundRequest;
import com.amazon.payments.lpa.request.RequestParameters;
import com.amazon.payments.lpa.request.ReverseProviderCreditRequest;
import com.amazon.payments.lpa.request.SetBillingAgreementDetailsRequest;
import com.amazon.payments.lpa.request.SetOrderReferenceDetailsRequest;
import com.amazon.payments.lpa.request.ValidateBillingAgreementRequest;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class RequestObjectUnitTests {
    

   @Test
    public void testAuthorizeRequest() {
        AuthorizeRequest request = new AuthorizeRequest(TestConstants.amazonOrderReferenceId , TestConstants.authorizationReferenceId, "2" )
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow("true")
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setSellerAuthorizationNote(TestConstants.sampletext)
                .setTransactionTimeout("10")
                .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);
        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_AUTHORIZATION_REFERENCE_ID ) , TestConstants.authorizationReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.AUTHORIZATION_AMOUNT) , "2");
        Assert.assertEquals(paramMap.get(ServiceConstants.AUTHORIZATION_CURRENCEYCODE) , "USD");  
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.CAPTURE_NOW) , "true");
        Assert.assertEquals(paramMap.get(ServiceConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        Assert.assertEquals(paramMap.get(ServiceConstants.TRANSACTION_TIMEOUT) , "10");
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_AUTHORIZATION_NOTE) , TestConstants.sampletext);  
        Assert.assertEquals(paramMap.size() , 10);
    }
    
    
    @Test public void testCancelOrderReferenceRequest() {
       
        CancelOrderReferenceRequest request = new CancelOrderReferenceRequest(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setCancelReason(TestConstants.sampletext);
        Map<String,String> paramMap = RequestParameters.getParams(request);
        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.CANCELATION_REASON), TestConstants.sampletext);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 4);

    }
   @Test public void testCapture() {
       
        CaptureRequest request = new CaptureRequest(TestConstants.amazonOrderReferenceId , "Capt123" , "2" )
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerCaptureNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_AUTHORIZATION_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.CAPTURE_REFERENCE_ID), "Capt123");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.CAPTURE_NOTE) , TestConstants.sampletext);
        Assert.assertEquals(paramMap.get(ServiceConstants.CAPTURE_AMOUNT) , "2");
        Assert.assertEquals(paramMap.get(ServiceConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        
        Assert.assertEquals(paramMap.size() , 8);

    }
    
    @Test public void testCloseAuthorizationRequest() {
       
        CloseAuthorizationRequest request = new CloseAuthorizationRequest("Auth123").setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_AUTHORIZATION_ID), "Auth123");
        Assert.assertEquals(paramMap.get(ServiceConstants.CLOSURE_REASON), TestConstants.sampletext);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 4);

    }
       


       @Test public void testCloseOrderReferenceRequest() {
       
        CloseOrderReferenceRequest request = new CloseOrderReferenceRequest(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.CLOSURE_REASON), TestConstants.sampletext);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 4);

    }
       

       @Test public void testConfirmOrderReferenceRequest() {
       
        ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }
       
 
      
       @Test public void testGetAuthorizationDetailsRequest() {
       
        GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);
        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_AUTHORIZATION_ID) , "Auth123");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

       }

       @Test public void testGetCaptureDetailsRequest() {
       
        GetCaptureDetailsRequest request = new GetCaptureDetailsRequest("Capt123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_CAPTURE_ID) , "Capt123");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }

       
       @Test public void testGetOrderReferenceDetailsRequest() {
       
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId)
                .setAddressConsentToken("123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID) , TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.ADDRESS_CONSENT_TOKEN) , "123");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 4);

    }

       @Test public void testGetRefundDetailsRequest() {
       
        GetRefundDetailsRequest request = new GetRefundDetailsRequest("Ref123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_REFUND_ID) , "Ref123");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }
       @Test public void testRefundRequest() {
       
        RefundRequest request = new RefundRequest("C1233421424" ,"Ref123" , "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerRefundNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_CAPTURE_ID) , "C1233421424");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN) , TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.REFUND_REFERENCE_ID), "Ref123");
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_REFUND_NOTE) , TestConstants.sampletext);
        Assert.assertEquals(paramMap.get(ServiceConstants.REFUND_AMOUNT) , "2");
        Assert.assertEquals(paramMap.get(ServiceConstants.REFUND_AMOUNT_CURRENCY_CODE) , "USD");   
        Assert.assertEquals(paramMap.get(ServiceConstants.SOFT_DESCRIPTOR) , TestConstants.softDescriptor);
        
        Assert.assertEquals(paramMap.size() , 8);
    }
       
       
    
   @Test
    public void testSetOrderReferenceDetailsRequest() {
        SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId , "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setPlatformId("platformId")
                .setSellerOrderId("sellerOrderId")
                .setStoreName("testStore")
                .setCustomInformation("customInfo")
                .setSellerNote("sampleText")
                .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_ORDER_REFERENCE_ID), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.ORDER_AMOUNT) , "2");
        Assert.assertEquals(paramMap.get(ServiceConstants.CURRENCY_CODE) , "USD");  
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_ORDER_ID) ,"sellerOrderId");
        Assert.assertEquals(paramMap.get(ServiceConstants.STORE_NAME) , "testStore");
        Assert.assertEquals(paramMap.get(ServiceConstants.PLATFORM_ID) , "platformId");  
        Assert.assertEquals(paramMap.get(ServiceConstants.CUSTOM_INFORMATION) , "customInfo");  
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_NOTE) , "sampleText");  
        
        Assert.assertEquals(paramMap.size() , 10);
    }
    
       @Test public void testAuthorizeOnBillingAgreement() {
       
        AuthorizeOnBillingAgreementRequest request = new AuthorizeOnBillingAgreementRequest(TestConstants.billingAgreementId , TestConstants.authorizationReferenceId, "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow("true")
                .setCustomInformation("customInformation")
                .setInheritShippingAddress("true")
                .setPlatformId("platformId")
                .setSellerAuthorizationNote("note")
                .setSellerNote("sampletex")
                .setSellerOrderId("Order123")
                .setStoreName("Store")
                .setTransactionTimeout("10")
                .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_AUTHORIZATION_REFERENCE_ID ) , TestConstants.authorizationReferenceId);
        Assert.assertEquals(paramMap.get(ServiceConstants.AUTHORIZATION_AMOUNT) , "2");
        Assert.assertEquals(paramMap.get(ServiceConstants.AUTHORIZATION_CURRENCEYCODE) , "USD");  
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.CAPTURE_NOW) , "true");
        Assert.assertEquals(paramMap.get(ServiceConstants.BA_CUSTOM_INFORMATION) , "customInformation");
        Assert.assertEquals(paramMap.get(ServiceConstants.TRANSACTION_TIMEOUT) , "10");
        Assert.assertEquals(paramMap.get(ServiceConstants.INHERIT_SHIPPING_ADDRESS) , "true");
        Assert.assertEquals(paramMap.get(ServiceConstants.PLATFORM_ID) , "platformId");
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_AUTHORIZATION_NOTE) , "note");  
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_NOTE) , "sampletex");
        Assert.assertEquals(paramMap.get(ServiceConstants.BA_SELLER_ORDER_ID) , "Order123");
        Assert.assertEquals(paramMap.get(ServiceConstants.BA_STORE_NAME) , "Store");

        Assert.assertEquals(paramMap.size() , 15);
    }
        

       @Test public void testCloseBillingAgreement() {
       
        CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }
       
       @Test public void testConfirmBillingAgreement() {
       
        ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }
       
       @Test public void testGetBillingAgreementDetails() {
       
        GetBillingAgreementDetailsRequest request = new GetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setAddressConsentToken("AddrToken");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.ADDRESS_CONSENT_TOKEN), "AddrToken");
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 4);

    }
       
       @Test public void testSetBillingAgreementDetails() {
       
        SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCustomInformation("custom")
                .setPlatformId("platformId")
                .setSellerBillingAgreementId("B12")
                .setSellerNote("note12")
                .setStoreName("store");
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        Assert.assertEquals(paramMap.get(ServiceConstants.BILLING_AGREEMENT_SELLER_CUSTOM_INFORMATION), "custom");
        Assert.assertEquals(paramMap.get(ServiceConstants.BILLING_AGREEMENT_PLATFORM_ID), "platformId");
        Assert.assertEquals(paramMap.get(ServiceConstants.BILLING_AGREEMENT_SELLER_BILLING_AGREEMENT_ID), "B12");
        Assert.assertEquals(paramMap.get(ServiceConstants.BILLING_AGREEMENT_SELLER_NOTE), "note12");
        Assert.assertEquals(paramMap.get(ServiceConstants.BILLING_AGREEMENT_SELLER_STORE_NAME), "store");

        Assert.assertEquals(paramMap.size() , 8);

    }
       
      @Test public void testValidateBillingAgreement() {
       
        ValidateBillingAgreementRequest request = new ValidateBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_BILLING_AGREEMENT_ID), TestConstants.billingAgreementId);
        Assert.assertEquals(paramMap.get(ServiceConstants.MWS_AUTH_TOKEN), TestConstants.mwsAuthToken);
        
        Assert.assertEquals(paramMap.size() , 3);

    }
      
      @Test public void testGetProviderCreditDetails() {
        GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest(TestConstants.providerCreditId, TestConstants.providerSellerId);
        Map<String,String> paramMap = RequestParameters.getParams(request);

        Assert.assertEquals(paramMap.get(ServiceConstants.AMAZON_PROVIDER_CREDIT_ID), TestConstants.providerCreditId);
        Assert.assertEquals(paramMap.get(ServiceConstants.SELLER_ID) , TestConstants.providerSellerId);
          
        Assert.assertEquals(paramMap.size() , 3);
      }
      
      @Test public void testGetProviderCreditReversalDetails() {
          GetProviderCreditReversalDetailsRequest request = new GetProviderCreditReversalDetailsRequest(TestConstants.reversalProviderCreditId , TestConstants.providerSellerId)
                  .setMwsAuthToken(TestConstants.mwsAuthToken);
        Map<String,String> paramMap = RequestParameters.getParams(request);

          Assert.assertEquals(paramMap.get((ServiceConstants.AMAZON_PROVIDER_CREDIT_REVERSAL_ID)), TestConstants.reversalProviderCreditId);
          Assert.assertEquals(paramMap.get((ServiceConstants.SELLER_ID)), TestConstants.providerSellerId);
          Assert.assertEquals(paramMap.get((ServiceConstants.MWS_AUTH_TOKEN)), TestConstants.mwsAuthToken);
          
          Assert.assertEquals(paramMap.size() , 4);
      }
      
      @Test public void testReverseProviderCreditDetails() {
          ReverseProviderCreditRequest request = new ReverseProviderCreditRequest(TestConstants.reversalProviderCreditId 
                  , TestConstants.reversalProviderCreditReferenceId 
                  , TestConstants.providerSellerId 
                  , TestConstants.reversalProviderAmount)
                  .setMwsAuthToken(TestConstants.mwsAuthToken)
                  .setCurrencyCode("USD");
        Map<String,String> paramMap = RequestParameters.getParams(request);

          Assert.assertEquals(paramMap.get((ServiceConstants.CREDIT_REVERSAL_REFERENCE_ID)), TestConstants.reversalProviderCreditReferenceId);
          Assert.assertEquals(paramMap.get((ServiceConstants.AMAZON_PROVIDER_CREDIT_ID)), TestConstants.reversalProviderCreditId);          
          Assert.assertEquals(paramMap.get((ServiceConstants.SELLER_ID)), TestConstants.providerSellerId);
          Assert.assertEquals(paramMap.get((ServiceConstants.CREDIT_REVERSAL_AMOUNT)), TestConstants.reversalProviderAmount);          
          Assert.assertEquals(paramMap.get((ServiceConstants.MWS_AUTH_TOKEN)), TestConstants.mwsAuthToken);
          Assert.assertEquals(paramMap.get((ServiceConstants.CREDIT_REVERSAL_AMOUNT_CURRENCY_CODE )), "USD");

          Assert.assertEquals(paramMap.size() , 7);
      }
}
