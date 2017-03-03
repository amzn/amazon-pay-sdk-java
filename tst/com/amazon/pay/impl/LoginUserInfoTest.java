package com.amazon.pay.impl;

import com.amazon.pay.TestConstants;
import com.amazon.pay.exceptions.AmazonServiceException;
import com.amazon.pay.response.parser.ResponseData;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Region;
import com.amazon.pay.types.User;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(Util.class)
public class LoginUserInfoTest {
    
    private final String accessToken =  TestConstants.addressConsentToken;
    private final String clientId = TestConstants.clientId;
    private PayConfig config;
    private PayClient client;
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.spy(Util.class);
        config = new PayConfig()
                .withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withSandboxMode(true)
                .withRegion(Region.US);
        
        client = new PayClient(config);
    }
    
    @Test 
    public void testGetUserInfo() throws Exception {
       
        ResponseData tokenInfoResponse = new ResponseData(200 , TestConstants.tokenInfoResponse);
        String tokenInfoURL = TestConstants.tokenInfoURL + URLDecoder.decode(accessToken, "UTF-8");
        PowerMockito.doReturn(tokenInfoResponse).when(Util.class, "httpSendRequest" , "GET", tokenInfoURL , null , new HashMap<String,String>(), null);
        
        ResponseData userInfoResponse = new ResponseData(200 , TestConstants.userInfoResponse);
        Map<String,String> headerValues = new HashMap<String,String>();
        headerValues.put("Authorization" , "bearer " + URLDecoder.decode(accessToken, "UTF-8"));
        PowerMockito.doReturn(userInfoResponse).when(Util.class, "httpSendRequest" ,
                "GET", TestConstants.userProfileURL , null , headerValues);

        User user = client.getUserInfo(accessToken, clientId);

        Assert.assertEquals("testbuyer2@amazon.com", user.getEmail());
        Assert.assertEquals("Test Buyer", user.getName());
        Assert.assertEquals("amzn1.account.AF5W6J2OG52NKFJGEN52GEZ5CWFQ", user.getUserId());
               
    }
    
    @Test(expected=AmazonServiceException.class)
    public void testInvalidAccessToken () throws Exception{
        ResponseData userProfileErrorResponse = new ResponseData(200 , TestConstants.userProfileErrorResponse);
        String tokenInfoURL = TestConstants.tokenInfoURL + URLDecoder.decode(accessToken, "UTF-8");
        PowerMockito.doReturn(userProfileErrorResponse).when(Util.class, "httpSendRequest" , "GET", tokenInfoURL , null , new HashMap<String,String>());
        User user = client.getUserInfo(accessToken, clientId);
    }
}
