package com.amazon.payments.paywithamazon.request;

import com.amazon.payments.paywithamazon.TestConstants;
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
        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getAuthorizationReferenceId() , TestConstants.authorizationReferenceId);
        Assert.assertEquals(request.getAuthorizationAmount() , "2");
        Assert.assertEquals(request.getAuthorizationCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getCaptureNow() , true);
        Assert.assertEquals(request.getSoftDescriptor() , TestConstants.softDescriptor);
        Assert.assertEquals(request.getTransactionTimeout() , "10");
        Assert.assertEquals(request.getSellerAuthorizationNote() , TestConstants.sampletext);
        Assert.assertEquals(request.getProviderCredit() , pcList);

    }


    @Test public void testCancelOrderReferenceRequest() {

        CancelOrderReferenceRequest request = new CancelOrderReferenceRequest(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setCancelReason(TestConstants.sampletext);
        Assert.assertEquals(request.getAmazonOrderReferenceId() ,TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getCancelationReason(), TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);

    }

    @Test public void testCapture() {
        ProviderCredit pc = new ProviderCredit("ProviderId" , new Price("1" , "USD"));
        List<ProviderCredit> pcList = new ArrayList<ProviderCredit>();
        pcList.add(pc);
        CaptureRequest request = new CaptureRequest(TestConstants.amazonOrderReferenceId , "Capt123" , "2" )
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerCaptureNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setCaptureCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(pcList);

        Assert.assertEquals(request.getAmazonAuthorizationId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getCaptureReferenceId(), "Capt123");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getSellerCaptureNote() , TestConstants.sampletext);
        Assert.assertEquals(request.getCaptureAmount() , "2");
        Assert.assertEquals(request.getSoftDescriptor() , TestConstants.softDescriptor);
        Assert.assertEquals(request.getCaptureCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(request.getProviderCredit() , pcList);


    }

    @Test public void testCloseAuthorizationRequest() {

        CloseAuthorizationRequest request = new CloseAuthorizationRequest("Auth123").setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonAuthorizationId() , "Auth123");
        Assert.assertEquals(request.getClosureReason() , TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);

    }



    @Test public void testCloseOrderReferenceRequest() {

        CloseOrderReferenceRequest request = new CloseOrderReferenceRequest(TestConstants.amazonOrderReferenceId).setMWSAuthToken(TestConstants.mwsAuthToken).setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonOrderReferenceId() ,TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getClosureReason(), TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);


    }


    @Test public void testConfirmOrderReferenceRequest() {

        ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonOrderReferenceId() ,TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);


    }



    @Test public void testGetAuthorizationDetailsRequest() {

        GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getAmazonAuthorizationId() , "Auth123");
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);


    }

    @Test public void testGetCaptureDetailsRequest() {

        GetCaptureDetailsRequest request = new GetCaptureDetailsRequest("Capt123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonCaptureId() , "Capt123");
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);


    }


    @Test public void testGetOrderReferenceDetailsRequest() {

        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId)
                .setAddressConsentToken("123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonOrderReferenceId() , TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getAddressConsentToken() , "123");
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);


    }

    @Test public void testGetRefundDetailsRequest() {

        GetRefundDetailsRequest request = new GetRefundDetailsRequest("Ref123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonRefundId() , "Ref123");
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);


    }
    @Test public void testRefundRequest() {
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

        Assert.assertEquals(request.getAmazonCaptureId() , "C1233421424");
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getRefundReferenceId(), "Ref123");
        Assert.assertEquals(request.getSellerRefundNote() , TestConstants.sampletext);
        Assert.assertEquals(request.getRefundAmount() , "2");
        Assert.assertEquals(request.getRefundCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(request.getSoftDescriptor() , TestConstants.softDescriptor);
        Assert.assertEquals(request.getProviderCredit(), pcList);
        Assert.assertEquals(request.getProviderCredit().get(0), pc);
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount(), testPrice);
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount().getAmount(), "1");
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(request.getProviderCredit().get(0).getProviderId(), "ProviderId");

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

        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getOrderAmount() , "2");
        Assert.assertEquals(request.getOrderCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getSellerOrderId() ,"sellerOrderId");
        Assert.assertEquals(request.getStoreName() , "testStore");
        Assert.assertEquals(request.getPlatformId() , "platformId");
        Assert.assertEquals(request.getCustomInformation() , "customInfo");
        Assert.assertEquals(request.getSellerNote() , "sampleText");

    }

    @Test public void testAuthorizeOnBillingAgreement() {

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

        Assert.assertEquals(TestConstants.billingAgreementId, request.getAmazonBillingAgreementId());
        Assert.assertEquals(TestConstants.authorizationReferenceId, request.getAuthorizationReferenceId());
        Assert.assertEquals("2", request.getAuthorizationAmount());
        Assert.assertEquals(request.getAuthorizationCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());
        Assert.assertEquals(true, request.getCaptureNow());
        Assert.assertEquals("customInformation", request.getCustomInformation());
        Assert.assertEquals("10", request.getTransactionTimeout());
        Assert.assertEquals("true", request.getInheritShippingAddress());
        Assert.assertEquals("platformId", request.getPlatformId());
        Assert.assertEquals("note", request.getSellerAuthorizationNote());
        Assert.assertEquals("sampletex", request.getSellerNote());
        Assert.assertEquals("Order123", request.getSellerOrderId());
        Assert.assertEquals("Store", request.getStoreName());
        Assert.assertEquals("AMZN*Test", request.getSoftDescriptor());

    }


    @Test public void testCloseBillingAgreement() {

        CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getClosureReason(), TestConstants.sampletext);

    }

    @Test public void testConfirmBillingAgreement() {

        ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);


    }

    @Test public void testGetBillingAgreementDetails() {

        GetBillingAgreementDetailsRequest request = new GetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setAddressConsentToken("AddrToken");

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getAddressConsentToken(), "AddrToken");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);


    }

    @Test public void testSetBillingAgreementDetails() {

        SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCustomInformation("custom")
                .setPlatformId("platformId")
                .setSellerBillingAgreementId("B12")
                .setSellerNote("note12")
                .setStoreName("store");

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken() , TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getCustomInformation(), "custom");
        Assert.assertEquals(request.getPlatformId(), "platformId");
        Assert.assertEquals(request.getSellerBillingAgreementId(), "B12");
        Assert.assertEquals(request.getSellerNote(), "note12");
        Assert.assertEquals(request.getStoreName(), "store");


    }

    @Test public void testValidateBillingAgreement() {

        ValidateBillingAgreementRequest request = new ValidateBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);


    }

    @Test public void testGetProviderCreditDetails() {
        GetProviderCreditDetailsRequest request = new GetProviderCreditDetailsRequest(TestConstants.providerCreditId, TestConstants.providerSellerId)
                .setMwsAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonProviderCreditId(), TestConstants.providerCreditId);
        Assert.assertEquals(request.getSellerId() , TestConstants.providerSellerId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test public void testGetProviderCreditReversalDetails() {
        GetProviderCreditReversalDetailsRequest request = new GetProviderCreditReversalDetailsRequest(TestConstants.reversalProviderCreditId , TestConstants.providerSellerId)
                .setMwsAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(TestConstants.reversalProviderCreditId, request.getAmazonProviderCreditReversalId());
        Assert.assertEquals(TestConstants.providerSellerId, request.getSellerId());
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());

    }

    @Test public void testReverseProviderCreditDetails() {
        ReverseProviderCreditRequest request = new ReverseProviderCreditRequest(TestConstants.reversalProviderCreditId
                , TestConstants.reversalProviderCreditReferenceId
                , TestConstants.providerSellerId
                , TestConstants.reversalProviderAmount)
                .setMwsAuthToken(TestConstants.mwsAuthToken)
                .setCreditReversalNote(TestConstants.sampletext)
                .setCreditReversalCurrencyCode(CurrencyCode.USD);

        Assert.assertEquals(request.getCreditReversalReferenceId(), TestConstants.reversalProviderCreditReferenceId);
        Assert.assertEquals(request.getAmazonProviderCreditId(), TestConstants.reversalProviderCreditId);
        Assert.assertEquals(request.getSellerId(), TestConstants.providerSellerId);
        Assert.assertEquals(request.getCreditReversalAmount(), TestConstants.reversalProviderAmount);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getCreditReversalAmountCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getCreditReversalNote(), TestConstants.sampletext);
    }


    @Test public void testCharge() {

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


        Assert.assertEquals(TestConstants.billingAgreementId, request.getAmazonReferenceId());
        Assert.assertEquals(TestConstants.authorizationReferenceId, request.getChargeReferenceId());
        Assert.assertEquals("5", request.getAmount());
        Assert.assertEquals(request.getCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());
        Assert.assertEquals(true, request.getCaptureNow());
        Assert.assertEquals("customInformation", request.getCustomInformation());
        Assert.assertEquals("10", request.getTransactionTimeout());
        Assert.assertEquals("true", request.getInheritShippingAddress());
        Assert.assertEquals(TestConstants.platformId, request.getPlatformId());
        Assert.assertEquals("note", request.getSellerNote());
        Assert.assertEquals("Order123", request.getChargeOrderId());
        Assert.assertEquals("Store", request.getStoreName());
        Assert.assertEquals("AMZN*Test", request.getSoftDescriptor());
        Assert.assertEquals(pcl, request.getProviderCredit());

    }
}
