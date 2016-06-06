package test.com.amazon.payments.paywithamazon.request;

import test.com.amazon.payments.paywithamazon.TestConstants;
import com.amazon.payments.paywithamazon.request.*;
import com.amazon.payments.paywithamazon.response.model.Price;
import com.amazon.payments.paywithamazon.response.model.ProviderCredit;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PaymentsAPIRequestTest {
    
  @Test 
  public void testAuthorizeRequest() {
        ProviderCredit pc = new ProviderCredit("ProviderId" , new Price("1" , "USD"));
        List<ProviderCredit> pcList = new ArrayList<ProviderCredit>();
        pcList.add(pc);
        AuthorizeRequest request = new AuthorizeRequest(TestConstants.amazonOrderReferenceId , TestConstants.authorizationReferenceId, "2" )
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow(true)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setSellerAuthorizationNote(TestConstants.sampletext)
                .setTransactionTimeout("10")
                .setAuthorizationCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(pcList);
        
        Assert.assertEquals(request.toString(), "AuthorizeRequest{amazonOrderReferenceId=S01-1230123123, authorizationReferenceId=AuthReferenceId, authorizationAmount=2, authorizationCurrencyCode=USD, sellerAuthorizationNote=testNote, transactionTimeout=10, captureNow=true, softDescriptor=AMZNTestTest, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589, providerCredit=[ProviderCredit{providerId=ProviderId, creditAmount=Price{amount=1, currencyCode=USD}}]}");
  }
    
  @Test 
  public void testCancelOrderReferenceRequest() {
        CancelOrderReferenceRequest request = new CancelOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCancelReason(TestConstants.sampletext);
        
        Assert.assertEquals(request.toString(), "CancelOrderReferenceRequest{amazonOrderReferenceId=S01-1230123123, cancelationReason=testNote, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
    
  @Test 
  public void testCapture() {
        ProviderCredit pc = new ProviderCredit("ProviderId" , new Price("1" , "USD"));
        List<ProviderCredit> pcList = new ArrayList<ProviderCredit>();
        pcList.add(pc);
        CaptureRequest request = new CaptureRequest(TestConstants.amazonOrderReferenceId , "Capt123" , "2" )
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerCaptureNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setCaptureCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(pcList);

        Assert.assertEquals(request.toString(), "CaptureRequest{amazonAuthorizationId=S01-1230123123, captureReferenceId=Capt123, captureAmount=2, captureCurrencyCode=USD, sellerCaptureNote=testNote, softDescriptor=AMZNTestTest, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589, providerCredit=[ProviderCredit{providerId=ProviderId, creditAmount=Price{amount=1, currencyCode=USD}}]}");
  }
    
  @Test 
  public void testCloseAuthorizationRequest() {
        CloseAuthorizationRequest request = new CloseAuthorizationRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.toString() , "CloseAuthorizationRequest{amazonAuthorizationId=Auth123, closureReason=testNote, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testCloseOrderReferenceRequest() {
        CloseOrderReferenceRequest request = new CloseOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.toString(), "CloseOrderReferenceRequest{amazonOrderReferenceId=S01-1230123123, closureReason=testNote, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testConfirmOrderReferenceRequest() {
        ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "ConfirmOrderReferenceRequest{amazonOrderReferenceId=S01-1230123123, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
      
  @Test 
  public void testGetAuthorizationDetailsRequest() {    
        GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        
        Assert.assertEquals(request.toString(), "GetAuthorizationDetailsRequest{amazonAuthorizationId=Auth123, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testGetCaptureDetailsRequest() {     
        GetCaptureDetailsRequest request = new GetCaptureDetailsRequest("Capt123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "GetCaptureDetailsRequest{amazonCaptureId=Capt123, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
   
  @Test 
  public void testGetOrderReferenceDetailsRequest() {
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId)
                .setAddressConsentToken("123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "GetOrderReferenceDetailsRequest{amazonOrderReferenceId=S01-1230123123, addressConsentToken=123, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testGetRefundDetailsRequest() {
        GetRefundDetailsRequest request = new GetRefundDetailsRequest("Ref123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "GetRefundDetailsRequest{amazonRefundId=Ref123, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
  
  @Test 
  public void testRefundRequest() {
        Price testPrice = new Price("1" , "USD");
        ProviderCredit pc = new ProviderCredit("ProviderId" , testPrice);
        List<ProviderCredit> pcList = new ArrayList<ProviderCredit>();
        pcList.add(pc);
        RefundRequest request = new RefundRequest("C1233421424" ,"Ref123" , "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerRefundNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setRefundCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(pcList);

        Assert.assertEquals(request.toString(), "RefundRequest{amazonCaptureId=C1233421424, refundReferenceId=Ref123, refundAmount=2, refundCurrencyCode=USD, sellerRefundNote=testNote, softDescriptor=AMZNTestTest, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589, providerCredit=[ProviderCredit{providerId=ProviderId, creditAmount=Price{amount=1, currencyCode=USD}}]}");
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
                .setOrderCurrencyCode(CurrencyCode.USD);

        Assert.assertEquals(request.toString(), "SetOrderReferenceDetailsRequest{amazonOrderReferenceId=S01-1230123123, orderAmount=2, orderCurrencyCode=USD, platformId=platformId, sellerNote=sampleText, sellerOrderId=sellerOrderId, storeName=testStore, customInformation=customInfo, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
    
  @Test 
  public void testAuthorizeOnBillingAgreement() {
        AuthorizeOnBillingAgreementRequest request = new AuthorizeOnBillingAgreementRequest(TestConstants.billingAgreementId , TestConstants.authorizationReferenceId, "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow(true)
                .setCustomInformation("customInformation")
                .setInheritShippingAddress("true")
                .setPlatformId("platformId")
                .setSellerAuthorizationNote("note")
                .setSellerNote("sampletex")
                .setSellerOrderId("Order123")
                .setStoreName("Store")
                .setTransactionTimeout("10")
                .setAuthorizationCurrencyCode(CurrencyCode.USD)
                .setSoftDescriptor("AMZN*Test");

        Assert.assertEquals(request.toString(), "AuthorizeOnBillingAgreementRequest{amazonBillingAgreementId=C01-2603200-6123270, authorizationReferenceId=AuthReferenceId, authorizationAmount=2, authorizationCurrencyCode=USD, sellerAuthorizationNote=note, transactionTimeout=10, captureNow=true, softDescriptor=AMZN*Test, platformId=platformId, sellerNote=sampletex, InheritShippingAddress=true, sellerOrderId=Order123, storeName=Store, customInformation=customInformation, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testCloseBillingAgreement() {     
        CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.toString(), "CloseBillingAgreementRequest{amazonBillingAgreementId=C01-2603200-6123270, closureReason=testNote, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
  
  @Test 
  public void testConfirmBillingAgreement() {     
        ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "ConfirmBillingAgreementRequest{amazonBillingAgreementId=C01-2603200-6123270, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
       
  @Test 
  public void testGetBillingAgreementDetails() {     
        GetBillingAgreementDetailsRequest request = new GetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setAddressConsentToken("AddrToken");

        Assert.assertEquals(request.toString(), "GetBillingAgreementDetailsRequest{amazonBillingAgreementId=C01-2603200-6123270, addressConsentToken=AddrToken, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
       
  @Test 
  public void testSetBillingAgreementDetails() {     
        SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCustomInformation("custom")
                .setPlatformId("platformId")
                .setSellerBillingAgreementId("B12")
                .setSellerNote("note12")
                .setStoreName("store");

        Assert.assertEquals(request.toString(), "SetBillingAgreementDetailsRequest{amazonBillingAgreementId=C01-2603200-6123270, platformId=platformId, sellerNote=note12, sellerBillingAgreementId=B12, storeName=store, customInformation=custom, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
       
  @Test 
  public void testValidateBillingAgreement() {
        ValidateBillingAgreementRequest request = new ValidateBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "ValidateBillingAgreementRequest{amazonBillingAgreementId=C01-2603200-6123270, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
      
  @Test 
  public void testGetProviderCreditDetails() {
        GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest(TestConstants.providerCreditId, TestConstants.providerSellerId)
                .setMwsAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.toString(), "GetProviderCreditDetailsRequest{amazonProviderCreditId=ADSVproviderCreditId, sellerId=SVSDFproviderSellerId, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
      
  @Test public void testGetProviderCreditReversalDetails() {
          GetProviderCreditReversalDetailsRequest request = new GetProviderCreditReversalDetailsRequest(TestConstants.reversalProviderCreditId , TestConstants.providerSellerId)
                  .setMwsAuthToken(TestConstants.mwsAuthToken);

          Assert.assertEquals(request.toString(), "GetProviderCreditReversalDetailsRequest{amazonProviderCreditReversalId=ADSVproviderReversalCreditId, sellerId=SVSDFproviderSellerId, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }
      
  @Test 
  public void testReverseProviderCreditDetails() {
          ReverseProviderCreditRequest request = new ReverseProviderCreditRequest(TestConstants.reversalProviderCreditId 
                  , TestConstants.reversalProviderCreditReferenceId 
                  , TestConstants.providerSellerId 
                  , TestConstants.reversalProviderAmount)
                  .setMwsAuthToken(TestConstants.mwsAuthToken)
                  .setCreditReversalNote(TestConstants.sampletext)
                  .setCreditReversalCurrencyCode(CurrencyCode.USD);

          Assert.assertEquals(request.toString(), "ReverseProviderCreditRequest{amazonProviderCreditId=ADSVproviderReversalCreditId, creditReversalReferenceId=ADSVproviderReversalCreditId, creditReversalAmount=5, creditReversalAmountCurrencyCode=USD, sellerId=SVSDFproviderSellerId, creditReversalNote=testNote, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589}");
  }

  @Test 
  public void testCharge() {     
        ProviderCredit pc = new ProviderCredit("providerId" , new Price("1" ,"USD"));
        List<ProviderCredit> pcl = new ArrayList<ProviderCredit>();
        pcl.add(pc);
        
        ChargeRequest request = new ChargeRequest()
                .withMWSAuthToken(TestConstants.mwsAuthToken)
                .withCaptureNow(true)
                .withCustomInformation("customInformation")
                .withInheritShippingAddress("true")
                .withChargeNote("note")
                .withChargeOrderId("Order123")
                .withStoreName("Store")
                .withTransactionTimeout("10")
                .withCurrencyCode(CurrencyCode.USD)
                .withSoftDescriptor("AMZN*Test")
                .withAmazonReferenceId(TestConstants.billingAgreementId)
                .withPlatformId(TestConstants.platformId)
                .withAmount("5")
                .withChargeReferenceId(TestConstants.authorizationReferenceId)
                .withProviderCreditDetails(pcl);

        
        Assert.assertEquals(request.toString(), "ChargeRequest{amazonReferenceId=C01-2603200-6123270, type=BILLING_AGREEMENT_ID, chargeReferenceId=AuthReferenceId, amount=5, currencyCode=USD, transactionTimeout=10, captureNow=true, chargeOrderId=Order123, storeName=Store, customInformation=customInformation, platformId=A11WKBU7ADWTAU, sellerNote=note, softDescriptor=AMZN*Test, mwsAuthToken=amzn.mws.d0e-4e99-9bdb2b381589, inheritShippingAddress=true, providerCredit=[ProviderCredit{providerId=providerId, creditAmount=Price{amount=1, currencyCode=USD}}]}");
    }
}
