/**
 * Copyright 2018-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl;

import com.amazon.pay.request.RequestHelper;
import com.amazon.pay.TestConstants;
import com.amazon.pay.request.ConfirmOrderReferenceRequest;
import com.amazon.pay.request.GetOrderReferenceDetailsRequest;
import com.amazon.pay.request.SetOrderReferenceDetailsRequest;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.crypto.*" })
@PrepareForTest(Util.class)
public class SignatureAndURLTest {

    private PayConfig config;
    private RequestHelper helper;

    @Before
    public void setUp() throws Exception {
        config = new PayConfig().withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withRegion(Region.US)
                .withSandboxMode(true);
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class , "getTimestamp")).toReturn(TestConstants.timeStamp);
    }

    @Test
    public void testRequestUrlAndSignature() throws Exception {
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class, "getTimestamp")).toReturn(TestConstants.timeStamp);
        final GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId);
        final String action = "GetOrderReferenceDetails";
        final String signature = "cpkDC72d5lMIbo5ET2dvERTw4F2cGQJL3eQPzUe2pAE%3D";
        final String expectedURL =
                "AWSAccessKeyId=" + TestConstants.accessKey
                + "&Action=" + action
                + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
                + "&SellerId=" + TestConstants.merchantId
                + "&Signature=" + signature
                + "&SignatureMethod=HmacSHA256"
                + "&SignatureVersion=2"
                + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
                + "&Version=2013-01-01";
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));
    }

    @Test
    public void testRequestUrlAndSignatureWithMwsDelegation() throws Exception {
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class, "getTimestamp")).toReturn(TestConstants.timeStamp);
        final GetOrderReferenceDetailsRequest request =
               new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId)
               .setSellerId(TestConstants.overrideSellerId)
               .setMWSAuthToken(TestConstants.mwsAuthToken);
        final String action = "GetOrderReferenceDetails";
        final String signature = "MelQJXDdQJ85Z7aB85s7eYWm5TdGv6xYAQt%2FjoOhXCo%3D";
        final String expectedURL =
                "AWSAccessKeyId=" + TestConstants.accessKey
                + "&Action=" + action
                + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
                + "&MWSAuthToken=" + TestConstants.mwsAuthToken
                + "&SellerId=" + TestConstants.overrideSellerId
                + "&Signature=" + signature
                + "&SignatureMethod=HmacSHA256"
                + "&SignatureVersion=2"
                + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
                + "&Version=2013-01-01";
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));
    }

    @Test
    public void testRequestParameterConstructorSignature_2() throws Exception {
        helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class, "getTimestamp")).toReturn(TestConstants.timeStamp);
        final String orderAmount = "2";
        final SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId, orderAmount);
        final String action = "SetOrderReferenceDetails";
        final String signature  = "i51MSGv9O2G2LHIlhCXLigA3ZKaZRoc7Mb5A1VX2QTA%3D";
        final String expectedURL =
               "AWSAccessKeyId=" + TestConstants.accessKey
               + "&Action=" + action
               + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
               + "&OrderReferenceAttributes.OrderTotal.Amount=" + orderAmount
               + "&OrderReferenceAttributes.OrderTotal.CurrencyCode=USD"
               + "&SellerId=" + TestConstants.merchantId
               + "&Signature=" + signature
               + "&SignatureMethod=HmacSHA256"
               + "&SignatureVersion=2"
               + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
               + "&Version=2013-01-01";
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));
    }

    @Test
    public void testRequestUrlAndSignatureForConfirmOrderReference() throws Exception {
        // Non-MFA Confirm request
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class, "getTimestamp")).toReturn(TestConstants.timeStamp);
        final ConfirmOrderReferenceRequest request =
               new ConfirmOrderReferenceRequest(TestConstants.amazonOrderReferenceId)
               .setSellerId(TestConstants.overrideSellerId)
               .setMWSAuthToken(TestConstants.mwsAuthToken);
        final String action = "ConfirmOrderReference";
        final String signature = "mbJBrZKC4Jz8J%2BrhRqyfYsY6TkSapWOvCTlC%2BUDUTok%3D";
        final String expectedURL =
                "AWSAccessKeyId=" + TestConstants.accessKey
                + "&Action=" + action
                + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
                + "&MWSAuthToken=" + TestConstants.mwsAuthToken
                + "&SellerId=" + TestConstants.overrideSellerId
                + "&Signature=" + signature
                + "&SignatureMethod=HmacSHA256"
                + "&SignatureVersion=2"
                + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
                + "&Version=2013-01-01";
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));

        // Adding a curency code without an amount should result in same request
        request.setAuthorizationCurrencyCode(CurrencyCode.EUR);
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));

        // Full MFA parameter set
        final String mfaSignature = "KeZbecFqPMxhR4g35iFWsdLmq1rAgwdn4B2WTIFMTHg%3D";
        request.setSuccessUrl(TestConstants.SUCCESS_URL);
        request.setFailureUrl(TestConstants.FAILURE_URL);
        request.setAuthorizationAmount(TestConstants.AUTHORIZE_AMOUNT);
        final String expectedURLforMFA =
                "AWSAccessKeyId=" + TestConstants.accessKey
                + "&Action=" + action
                + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
                + "&AuthorizationAmount.Amount=" + TestConstants.AUTHORIZE_AMOUNT
                + "&AuthorizationAmount.CurrencyCode=" + CurrencyCode.EUR
                + "&FailureUrl=" +  Util.urlEncode(TestConstants.FAILURE_URL)
                + "&MWSAuthToken=" + TestConstants.mwsAuthToken
                + "&SellerId=" + TestConstants.overrideSellerId
                + "&Signature=" + mfaSignature
                + "&SignatureMethod=HmacSHA256"
                + "&SignatureVersion=2"
                + "&SuccessUrl=" +  Util.urlEncode(TestConstants.SUCCESS_URL)
                + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
                + "&Version=2013-01-01";
        Assert.assertEquals(expectedURLforMFA, this.helper.getPostURL(request));

        // Partial MFA parameter set - not including FailureURL or CurrencyCode
        // Should default to the Config object currency code in this scenario (USD instead of EUR)
        final String partialMfaSignature = "vGiWtNsdtNKx3QGB%2BcNNq8tLisqwOeg2a5aIy3p6exw%3D";
        request.setAuthorizationCurrencyCode(null);
        request.setFailureUrl(null);
        final String expectedURLforPartialMFA =
                "AWSAccessKeyId=" + TestConstants.accessKey
                + "&Action=" + action
                + "&AmazonOrderReferenceId=" + TestConstants.amazonOrderReferenceId
                + "&AuthorizationAmount.Amount=" + TestConstants.AUTHORIZE_AMOUNT
                + "&AuthorizationAmount.CurrencyCode=" + CurrencyCode.USD
                + "&MWSAuthToken=" + TestConstants.mwsAuthToken
                + "&SellerId=" + TestConstants.overrideSellerId
                + "&Signature=" + partialMfaSignature
                + "&SignatureMethod=HmacSHA256"
                + "&SignatureVersion=2"
                + "&SuccessUrl=" +  Util.urlEncode(TestConstants.SUCCESS_URL)
                + "&Timestamp=" + TestConstants.urlEncoded_TimeStamp
                + "&Version=2013-01-01";
        Assert.assertEquals(expectedURLforPartialMFA, this.helper.getPostURL(request));
    }

}
