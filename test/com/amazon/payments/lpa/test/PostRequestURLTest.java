package com.amazon.payments.lpa.test;

import com.amazon.payments.lpa.Client;
import com.amazon.payments.lpa.ClientConfig;
import com.amazon.payments.lpa.types.Environment;
import com.amazon.payments.lpa.types.Region;
import com.amazon.payments.lpa.request.GetOrderReferenceDetailsRequest;
import com.amazon.payments.lpa.helper.ClientHelper;
import com.amazon.payments.lpa.helper.CommonHelper;
import com.amazon.payments.lpa.request.RequestParameters;
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
@PrepareForTest(CommonHelper.class)
public class PostRequestURLTest {
    
    Client client;
    ClientHelper clientHelper;
    String mcokTimeStamp = "2015-01-01T00-00-00Z";
    
    @Before
    public void setUp() throws Exception {
        ClientConfig config = new ClientConfig(TestConstants.merchantId, TestConstants.accessKey, TestConstants.secretKey, Region.US, Environment.SANDBOX , "USD");
        client = new Client(config);
        PowerMockito.stub(PowerMockito.method(CommonHelper.class , "getTimestamp")).toReturn(mcokTimeStamp);
        java.lang.reflect.Field privateField = Client.class.getDeclaredField("clientHelper");
        privateField.setAccessible(true);
        clientHelper = (ClientHelper) privateField.get(client);
    }

    @Test 
    public void testBuildHttpRequestUrl() throws Exception{
        GetOrderReferenceDetailsRequest request = new GetOrderReferenceDetailsRequest(TestConstants.amazonOrderReferenceId);  
        String action = "GetOrderReferenceDetails";
        String returnValue = clientHelper.buildHttpRequestUrl(RequestParameters.getParams(request));
        String stringToSign = clientHelper.constructStringForSignature(clientHelper.getAllParameters(RequestParameters.getParams(request)));
        String signature = CommonHelper.urlEncode( CommonHelper.getSignature(stringToSign, clientHelper.clientConfig.getSecretAccessKey()));
        String expectedURL = "SignatureVersion=2&Action="+action+"&Version=2013-01-01&Signature="+signature+"&SellerId="+TestConstants.merchantId+"&AWSAccessKeyId="+TestConstants.accessKey+"&SignatureMethod=HmacSHA256&Timestamp="+mcokTimeStamp+"&AmazonOrderReferenceId="+TestConstants.amazonOrderReferenceId;
        Assert.assertEquals(expectedURL,  returnValue);
    }

}
