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
package com.amazon.pay.impl;

import com.amazon.pay.request.RequestHelper;
import com.amazon.pay.TestConstants;
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

}
