package com.amazon.payments.paywithamazon.impl;

import com.amazon.payments.paywithamazon.request.RequestHelper;
import com.amazon.payments.paywithamazon.TestConstants;
import com.amazon.payments.paywithamazon.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.request.SetOrderReferenceDetailsRequest;
import com.amazon.payments.paywithamazon.response.model.Environment;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import com.amazon.payments.paywithamazon.types.Region;
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
    
    PaymentsConfig config;
    String mcokTimeStamp = "2015-01-01";
    RequestHelper helper;
    
    @Before
    public void setUp() throws Exception {
        config = new PaymentsConfig().withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withRegion(Region.US)
                .withSandboxMode(true);
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class , "getTimestamp")).toReturn(mcokTimeStamp);
    }

    @Test 
    public void testRequestUrlAndSignature() throws Exception{
        this.helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class , "getTimestamp")).toReturn(mcokTimeStamp);
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId);
        String action = "GetOrderReferenceDetails";
        String signature = "f5nzn7c4GBTiiDQC9N2uSFSmOLgOsP3ReAKTmGlNpE4%3D";
        String expectedURL = "AWSAccessKeyId="+TestConstants.accessKey+"&Action="+action+"&AmazonOrderReferenceId="+TestConstants.amazonOrderReferenceId+"&SellerId="+TestConstants.merchantId+"&Signature="+signature+"&SignatureMethod=HmacSHA256&SignatureVersion=2&Timestamp="+mcokTimeStamp+"&Version=2013-01-01";
        Assert.assertEquals(expectedURL, this.helper.getPostURL(request));
    }


    @Test
    public void testRequestParameterConstructorSignature_2() throws Exception{
        helper = new RequestHelper(config);
        PowerMockito.stub(PowerMockito.method(Util.class , "getTimestamp")).toReturn(mcokTimeStamp);
        String orderAmount = "2";
        SetOrderReferenceDetailsRequest request = new SetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId , orderAmount);
        String action = "SetOrderReferenceDetails";
        String signature  = "SAz7bebEm8G63ycFtygCiAI8L4jUoK5katCaU6wlXUI%3D";
        String expectedURL = "AWSAccessKeyId="+TestConstants.accessKey+"&Action="+action+"&AmazonOrderReferenceId="+TestConstants.amazonOrderReferenceId+"&OrderReferenceAttributes.OrderTotal.Amount="+orderAmount+"&OrderReferenceAttributes.OrderTotal.CurrencyCode=USD&SellerId="+TestConstants.merchantId+"&Signature="+signature+"&SignatureMethod=HmacSHA256&SignatureVersion=2&Timestamp="+mcokTimeStamp+"&Version=2013-01-01";
        Assert.assertEquals(expectedURL,  this.helper.getPostURL(request));
    }



}
