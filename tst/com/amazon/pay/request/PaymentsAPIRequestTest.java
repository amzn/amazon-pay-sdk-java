/**
 * Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.pay.request;

import com.amazon.pay.response.model.Price;
import com.amazon.pay.response.model.ProviderCredit;
import com.amazon.pay.types.AmazonReferenceIdType;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.OrderReferenceStatus;
import com.amazon.pay.types.SortOrder;
import com.amazon.pay.TestConstants;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PaymentsAPIRequestTest {

    private final List<ProviderCredit> PCL = Collections.singletonList(
                new ProviderCredit("providerId", new Price("1", "USD")));

    @Test
    public void testAuthorizeRequest() {
        final AuthorizeRequest request = new AuthorizeRequest(TestConstants.amazonOrderReferenceId, TestConstants.authorizationReferenceId, "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow(true)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setSellerAuthorizationNote(TestConstants.sampletext)
                .setTransactionTimeout("10")
                .setAuthorizationCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(PCL);
        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getAuthorizationReferenceId(), TestConstants.authorizationReferenceId);
        Assert.assertEquals(request.getAuthorizationAmount(), "2");
        Assert.assertEquals(request.getAuthorizationCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getCaptureNow(), true);
        Assert.assertEquals(request.getSoftDescriptor(), TestConstants.softDescriptor);
        Assert.assertEquals(request.getTransactionTimeout(), "10");
        Assert.assertEquals(request.getSellerAuthorizationNote(), TestConstants.sampletext);
        Assert.assertEquals(request.getProviderCredit(), PCL);
    }

    @Test
    public void testCancelOrderReferenceRequest() {
        final CancelOrderReferenceRequest request =
                new CancelOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCancelReason(TestConstants.sampletext);
        Assert.assertEquals(request.getAmazonOrderReferenceId(),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getCancelationReason(), TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testCapture() {
        final CaptureRequest request = new CaptureRequest(TestConstants.amazonOrderReferenceId, "Capt123", "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerCaptureNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setCaptureCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(PCL);

        Assert.assertEquals(request.getAmazonAuthorizationId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getCaptureReferenceId(), "Capt123");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getSellerCaptureNote(), TestConstants.sampletext);
        Assert.assertEquals(request.getCaptureAmount(), "2");
        Assert.assertEquals(request.getSoftDescriptor(), TestConstants.softDescriptor);
        Assert.assertEquals(request.getCaptureCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getProviderCredit(), PCL);
    }

    @Test
    public void testCloseAuthorizationRequest() {
        final CloseAuthorizationRequest request =
                new CloseAuthorizationRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonAuthorizationId(), "Auth123");
        Assert.assertEquals(request.getClosureReason(), TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testCloseOrderReferenceRequest() {
        final CloseOrderReferenceRequest request =
                new CloseOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonOrderReferenceId(),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getClosureReason(), TestConstants.sampletext);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testConfirmOrderReferenceRequest() {
        final ConfirmOrderReferenceRequest request = new ConfirmOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonOrderReferenceId(),TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetAuthorizationDetailsRequest() {
        final GetAuthorizationDetailsRequest request = new GetAuthorizationDetailsRequest("Auth123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getAmazonAuthorizationId(), "Auth123");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetCaptureDetailsRequest() {
        final GetCaptureDetailsRequest request = new GetCaptureDetailsRequest("Capt123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonCaptureId(), "Capt123");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetOrderReferenceDetailsRequest() {
         final GetOrderReferenceDetailsRequest request =
                new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId)
                .setAddressConsentToken("Atza|IwEBIDcwh13A-nf8EuZahCu")
                .setAccessToken("Atza|oVsmstLsCYekhCdyR1Hu6FFveZC")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getAddressConsentToken(), "Atza|IwEBIDcwh13A-nf8EuZahCu");
        Assert.assertEquals(request.getAccessToken(), "Atza|oVsmstLsCYekhCdyR1Hu6FFveZC");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetRefundDetailsRequest() {
        final GetRefundDetailsRequest request = new GetRefundDetailsRequest("Ref123")
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonRefundId(), "Ref123");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testRefundRequest() {
        final RefundRequest request = new RefundRequest("C1233421424","Ref123", "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerRefundNote(TestConstants.sampletext)
                .setSoftDescriptor(TestConstants.softDescriptor)
                .setRefundCurrencyCode(CurrencyCode.USD)
                .setProviderCredit(PCL);

        Assert.assertEquals(request.getAmazonCaptureId(), "C1233421424");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getRefundReferenceId(), "Ref123");
        Assert.assertEquals(request.getSellerRefundNote(), TestConstants.sampletext);
        Assert.assertEquals(request.getRefundAmount(), "2");
        Assert.assertEquals(request.getRefundCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getSoftDescriptor(), TestConstants.softDescriptor);
        Assert.assertEquals(request.getProviderCredit(), PCL);
        Assert.assertEquals(request.getProviderCredit().get(0), PCL.get(0));
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount(), PCL.get(0).getCreditAmount());
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount().getAmount(), "1");
        Assert.assertEquals(request.getProviderCredit().get(0).getCreditAmount().getCurrencyCode(), "USD");
        Assert.assertEquals(request.getProviderCredit().get(0).getProviderId(), PCL.get(0).getProviderId());
    }

    @Test
    public void testSetOrderReferenceDetailsRequest() {
        final SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId, "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setPlatformId("platformId")
                .setSellerOrderId("sellerOrderId")
                .setStoreName("testStore")
                .setSupplementaryData(TestConstants.SUPPLEMENTARY_DATA)
                .setCustomInformation("customInfo")
                .setSellerNote("sampleText")
                .setOrderCurrencyCode(CurrencyCode.USD)
                .setRequestPaymentAuthorization(true);

        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getOrderAmount(), "2");
        Assert.assertEquals(request.getOrderCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getSellerOrderId(), "sellerOrderId");
        Assert.assertEquals(request.getStoreName(), "testStore");
        Assert.assertEquals(request.getSupplementaryData(), TestConstants.SUPPLEMENTARY_DATA);
        Assert.assertEquals(request.getPlatformId(), "platformId");
        Assert.assertEquals(request.getCustomInformation(), "customInfo");
        Assert.assertEquals(request.getSellerNote(), "sampleText");
        Assert.assertEquals(request.getRequestPaymentAuthorization(), true);
    }

    private AuthorizeOnBillingAgreementRequest testAuthorizeOnBillingAgreementSetup() {
        return new AuthorizeOnBillingAgreementRequest(
                TestConstants.billingAgreementId, TestConstants.authorizationReferenceId, "2")
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCaptureNow(true)
                .setCustomInformation("customInformation")
                .setPlatformId("platformId")
                .setSellerAuthorizationNote("note")
                .setSellerNote("sampletex")
                .setSellerOrderId("Order123")
                .setStoreName("Store")
                .setSupplementaryData(TestConstants.SUPPLEMENTARY_DATA)
                .setTransactionTimeout("10")
                .setAuthorizationCurrencyCode(CurrencyCode.USD)
                .setSoftDescriptor("AMZN*Test");
    }

    private void testAuthorizeOnBillingAgreementAssert(final AuthorizeOnBillingAgreementRequest request) {
        Assert.assertEquals(TestConstants.billingAgreementId, request.getAmazonBillingAgreementId());
        Assert.assertEquals(TestConstants.authorizationReferenceId, request.getAuthorizationReferenceId());
        Assert.assertEquals("2", request.getAuthorizationAmount());
        Assert.assertEquals(request.getAuthorizationCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());
        Assert.assertEquals(true, request.getCaptureNow());
        Assert.assertEquals("customInformation", request.getCustomInformation());
        Assert.assertEquals("10", request.getTransactionTimeout());
        Assert.assertEquals(true, request.getInheritShippingAddress());
        Assert.assertEquals("platformId", request.getPlatformId());
        Assert.assertEquals("note", request.getSellerAuthorizationNote());
        Assert.assertEquals("sampletex", request.getSellerNote());
        Assert.assertEquals("Order123", request.getSellerOrderId());
        Assert.assertEquals("Store", request.getStoreName());
        Assert.assertEquals(TestConstants.SUPPLEMENTARY_DATA, request.getSupplementaryData());
        Assert.assertEquals("AMZN*Test", request.getSoftDescriptor());
    }

    @Test
    public void testAuthorizeOnBillingAgreementBoolean() {
        testAuthorizeOnBillingAgreementAssert(
                testAuthorizeOnBillingAgreementSetup().setInheritShippingAddress(true));
    }

    @Test
    public void testAuthorizeOnBillingAgreementString() {
        // Backwards compatibility check for deprecated method
        testAuthorizeOnBillingAgreementAssert(
                testAuthorizeOnBillingAgreementSetup().setInheritShippingAddress("true"));
    }

    @Test
    public void testCloseBillingAgreement() {
        CloseBillingAgreementRequest request = new CloseBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setClosureReason(TestConstants.sampletext);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getClosureReason(), TestConstants.sampletext);
    }

    @Test
    public void testConfirmBillingAgreement() {
        ConfirmBillingAgreementRequest request = new ConfirmBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetBillingAgreementDetails() {
        GetBillingAgreementDetailsRequest request = new GetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setAddressConsentToken("AddrToken");
        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getAddressConsentToken(), "AddrToken");
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testSetBillingAgreementDetails() {
        final SetBillingAgreementDetailsRequest request = new SetBillingAgreementDetailsRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setCustomInformation("custom")
                .setPlatformId("platformId")
                .setSellerBillingAgreementId("B12")
                .setSellerNote("note12")
                .setStoreName("store");

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
        Assert.assertEquals(request.getCustomInformation(), "custom");
        Assert.assertEquals(request.getPlatformId(), "platformId");
        Assert.assertEquals(request.getSellerBillingAgreementId(), "B12");
        Assert.assertEquals(request.getSellerNote(), "note12");
        Assert.assertEquals(request.getStoreName(), "store");
    }

    @Test
    public void testValidateBillingAgreement() {
        final ValidateBillingAgreementRequest request =
                new ValidateBillingAgreementRequest(TestConstants.billingAgreementId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonBillingAgreementId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetProviderCreditDetails() {
        final GetProviderCreditDetailsRequest request =
                new GetProviderCreditDetailsRequest(TestConstants.providerCreditId, TestConstants.providerSellerId)
                .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(request.getAmazonProviderCreditId(), TestConstants.providerCreditId);
        Assert.assertEquals(request.getSellerId(), TestConstants.providerSellerId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

    @Test
    public void testGetProviderCreditReversalDetails() {
        final GetProviderCreditReversalDetailsRequest request =
                  new GetProviderCreditReversalDetailsRequest(
                  TestConstants.reversalProviderCreditId, TestConstants.providerSellerId)
                  .setMWSAuthToken(TestConstants.mwsAuthToken);

        Assert.assertEquals(TestConstants.reversalProviderCreditId, request.getAmazonProviderCreditReversalId());
        Assert.assertEquals(TestConstants.providerSellerId, request.getSellerId());
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());
    }

    @Test
    public void testReverseProviderCreditDetails() {
        final ReverseProviderCreditRequest request = new ReverseProviderCreditRequest(TestConstants.reversalProviderCreditId,
                TestConstants.reversalProviderCreditReferenceId,
                TestConstants.providerSellerId,
                TestConstants.reversalProviderAmount)
                .setMWSAuthToken(TestConstants.mwsAuthToken)
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

    private ChargeRequest testChargeSetup() {
        return new ChargeRequest()
                .withMWSAuthToken(TestConstants.mwsAuthToken)
                .withCaptureNow(true)
                .withCustomInformation("customInformation")
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
                .withProviderCreditDetails(PCL);
    }

    private void testChargeAssert(final ChargeRequest request) {
        Assert.assertEquals(TestConstants.billingAgreementId, request.getAmazonReferenceId());
        Assert.assertEquals(TestConstants.authorizationReferenceId, request.getChargeReferenceId());
        Assert.assertEquals("5", request.getAmount());
        Assert.assertEquals(request.getCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(TestConstants.mwsAuthToken, request.getMwsAuthToken());
        Assert.assertEquals(true, request.getCaptureNow());
        Assert.assertEquals("customInformation", request.getCustomInformation());
        Assert.assertEquals("10", request.getTransactionTimeout());
        Assert.assertEquals(true, request.getInheritShippingAddress());
        Assert.assertEquals(TestConstants.platformId, request.getPlatformId());
        Assert.assertEquals("note", request.getSellerNote());
        Assert.assertEquals("Order123", request.getChargeOrderId());
        Assert.assertEquals("Store", request.getStoreName());
        Assert.assertEquals("AMZN*Test", request.getSoftDescriptor());
        Assert.assertEquals(PCL, request.getProviderCredit());
    }

    @Test
    public void testChargeBoolean() {
        testChargeAssert(testChargeSetup().withInheritShippingAddress(true));
    }

    @Test
    public void testChargeString() {
        // Backwards compatibility check for deprecated method
        testChargeAssert(testChargeSetup().withInheritShippingAddress("true"));
    }

    @Test
    public void testCreateOrderReferenceForId() {
        final CreateOrderReferenceForIdRequest request =
                new CreateOrderReferenceForIdRequest(
                TestConstants.billingAgreementId, AmazonReferenceIdType.BILLING_AGREEMENT_ID)
                .setInheritShippingAddress(false)
                .setConfirmNow(true)
                .setOrderTotalCurrencyCode(CurrencyCode.USD)
                .setSellerNote("Test Seller Note")
                .setSellerOrderId("Test Order ID")
                .setStoreName(TestConstants.storeName)
                .setSupplementaryData(TestConstants.SUPPLEMENTARY_DATA)
                .setCustomInformation("Test Custom Information")
                .setOrderTotalAmount("567.89")
                .setPlatformId(TestConstants.platformId);

        Assert.assertEquals(request.getId(), TestConstants.billingAgreementId);
        Assert.assertEquals(request.getIdType(), AmazonReferenceIdType.BILLING_AGREEMENT_ID);
        Assert.assertEquals(request.getInheritShippingAddress(), false);
        Assert.assertEquals(request.getConfirmNow(), true);
        Assert.assertEquals(request.getOrderTotalCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getSellerNote(), "Test Seller Note");
        Assert.assertEquals(request.getSellerOrderId(), "Test Order ID");
        Assert.assertEquals(request.getStoreName(), TestConstants.storeName);
        Assert.assertEquals(request.getSupplementaryData(), TestConstants.SUPPLEMENTARY_DATA);
        Assert.assertEquals(request.getCustomInformation(), "Test Custom Information");
        Assert.assertEquals(request.getOrderTotalAmount(), "567.89");
        Assert.assertEquals(request.getPlatformId(), TestConstants.platformId);
    }

    @Test
    public void testListOrderReference() throws Exception {
        final EnumSet<OrderReferenceStatus> filter = EnumSet.of(OrderReferenceStatus.OPEN, OrderReferenceStatus.CANCELED);
        final XMLGregorianCalendar startTime =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-05-27T03:23:21.923Z");
        final XMLGregorianCalendar endTime =
                DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-09-30T07:00:00Z");

        final ListOrderReferenceRequest request =
                new ListOrderReferenceRequest(
                        TestConstants.queryId, TestConstants.queryIdType)
                        .setStartTime(startTime)
                        .setEndTime(endTime)
                        .setPageSize(TestConstants.pageSize)
                        .setSortOrder(SortOrder.Ascending)
                        .setOrderReferenceStatusListFilter(filter);
        Assert.assertEquals(request.getStartTime(), startTime);
        Assert.assertEquals(request.getEndTime(), endTime);
        Assert.assertEquals(TestConstants.pageSize, request.getPageSize().intValue());
        Assert.assertEquals(request.getSortOrder(), SortOrder.Ascending);
        Assert.assertEquals(request.getQueryId(), TestConstants.queryId);
        Assert.assertEquals(request.getQueryIdType(), TestConstants.queryIdType);
        Assert.assertEquals(request.getOrderReferenceStatusListFilter().size(),2);
    }

    @Test
    public void testListOrderReferenceByNextToken() {
        final ListOrderReferenceByNextTokenRequest request = new ListOrderReferenceByNextTokenRequest(
                TestConstants.nextPageToken);
        Assert.assertEquals(request.getNextPageToken(), TestConstants.nextPageToken);
    }

    @Test
    public void testSetOrderAttributes() {
        final Set<String> orderItemCategories = new HashSet<String>();
        orderItemCategories.add("Antiques");
        orderItemCategories.add("Apparel");
        final SetOrderAttributesRequest request =
                new SetOrderAttributesRequest(
                        TestConstants.amazonOrderReferenceId, "2", CurrencyCode.USD)
                        .setCustomInformation("customInfo")
                        .setSellerNote("sellerNote")
                        .setPlatformId("platformId")
                        .setSellerOrderId("sellerOrderId")
                        .setStoreName("storeName")
                        .setSupplementaryData(TestConstants.SUPPLEMENTARY_DATA)
                        .setRequestPaymentAuthorization(true)
                        .setPaymentServiceProviderId("paymentServiceProviderId")
                        .setPaymentServiceProviderOrderId("paymentServiceProviderOrderId")
                        .setOrderItemCategories(orderItemCategories);
        Assert.assertEquals(request.getAmazonOrderReferenceId(), TestConstants.amazonOrderReferenceId);
        Assert.assertEquals(request.getAmount(), "2");
        Assert.assertEquals(request.getCurrencyCode(), CurrencyCode.USD);
        Assert.assertEquals(request.getCustomInformation(), "customInfo");
        Assert.assertEquals(request.getSellerNote(), "sellerNote");
        Assert.assertEquals(request.getPlatformId(), "platformId");
        Assert.assertEquals(request.getSellerOrderId(), "sellerOrderId");
        Assert.assertEquals(request.getStoreName(), "storeName");
        Assert.assertEquals(request.getSupplementaryData(), TestConstants.SUPPLEMENTARY_DATA);
        Assert.assertEquals(request.getRequestPaymentAuthorization(),true);
        Assert.assertEquals(request.getPaymentServiceProviderId(),"paymentServiceProviderId");
        Assert.assertEquals(request.getPaymentServiceProviderOrderId(),"paymentServiceProviderOrderId");
        Assert.assertTrue(request.getOrderItemCategories().contains("Antiques"));
        Assert.assertTrue(request.getOrderItemCategories().contains("Apparel"));
    }

    @Test
    public void testGetMerchantAccountStatus() {
        final GetMerchantAccountStatusRequest request = new GetMerchantAccountStatusRequest()
                .setMWSAuthToken(TestConstants.mwsAuthToken)
                .setSellerId(TestConstants.providerSellerId);
        Assert.assertEquals(request.getSellerId(), TestConstants.providerSellerId);
        Assert.assertEquals(request.getMwsAuthToken(), TestConstants.mwsAuthToken);
    }

}
