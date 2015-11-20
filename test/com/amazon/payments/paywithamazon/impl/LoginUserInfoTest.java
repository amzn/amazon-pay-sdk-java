package com.amazon.payments.paywithamazon.impl;

import com.amazon.payments.paywithamazon.TestConstants;
import com.amazon.payments.paywithamazon.exceptions.AmazonServiceException;
import com.amazon.payments.paywithamazon.response.parser.ResponseData;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import com.amazon.payments.paywithamazon.types.Region;
import com.amazon.payments.paywithamazon.types.User;
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
    
    private String accessToken =  TestConstants.addressConsentToken;
    private String clientId = TestConstants.clientId;
    private PaymentsConfig config;
    private PaymentsClient client;
    
    @Before
    public void setUp() throws Exception {
        PowerMockito.spy(Util.class);
        config = new PaymentsConfig().withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withSandboxMode(true)
                .withRegion(Region.US);
        
        client = new PaymentsClient(config);
    }
    
    @Test 
    public void testGetUserInfo() throws Exception {
       
        ResponseData tokenInfoResponse = new ResponseData(200 , TestConstants.tokenInfoResponse);
        String tokenInfoURL = TestConstants.tokenInfoURL + URLDecoder.decode(accessToken); 
        PowerMockito.doReturn(tokenInfoResponse).when(Util.class, "httpSendRequest" , "GET", tokenInfoURL , null , new HashMap<String,String>(), null);
        
        ResponseData userInfoResponse = new ResponseData(200 , TestConstants.userInfoResponse);
        Map<String,String> headerValues = new HashMap<String,String>();
        headerValues.put("Authorization" , "bearer " + URLDecoder.decode(accessToken));
        PowerMockito.doReturn(userInfoResponse).when(Util.class, "httpSendRequest" , "GET", TestConstants.userProfileURL , null , headerValues, null);

        User user = client.getUserInfo( accessToken, clientId );

        Assert.assertEquals(user.getEmail(), "testbuyer2@amazon.com");
        Assert.assertEquals(user.getName(), "Test Buyer");
        Assert.assertEquals(user.getUserId(), "amzn1.account.AF5W6J2OG52NKFJGEN52GEZ5CWFQ");
               
    }
    
    @Test(expected=AmazonServiceException.class)
    public void testInvalidAccessToken () throws Exception{
        ResponseData userProfileErrorResponse = new ResponseData(200 , TestConstants.userProfileErrorResponse);
        String tokenInfoURL = TestConstants.tokenInfoURL + URLDecoder.decode(accessToken);
        PowerMockito.doReturn(userProfileErrorResponse).when(Util.class, "httpSendRequest" , "GET", tokenInfoURL , null , new HashMap<String,String>());
        User user = client.getUserInfo(accessToken, clientId );
                    
    }
}
