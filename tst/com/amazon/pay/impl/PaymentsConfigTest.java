package com.amazon.pay.impl;

import com.amazon.pay.TestConstants;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Region;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;

public class PaymentsConfigTest {

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyPaymentsConfiguration() throws Exception {
        //throws exception, if required properties don't exist
        PayConfig config = new PayConfig(new Properties());
        assertConfigValues(config);
    }
    
    @Test
    public void testPaymentsConfig() {
        PayConfig config = new PayConfig().withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withSandboxMode(false)
                .withRegion(Region.US)
                .withProxyHost("host").withProxyPort(80).withApplicationName("myApp")
                .withApplicationVersion("1.0").withProxyUsername("test").withProxyPassword("crypto");
        assertConfigValues(config);
    }
    
    @Test
    public void testPaymentsJSONConfig() throws Exception {
        String workingDir = System.getProperty("user.dir");
        PayConfig config = PayConfigLoaderFactory.loadConfigFromJSON(workingDir
                + "/tst/com/amazon/pay/impl/config.json");
        assertConfigValues(config);
    }
    
    @Test
    public void testPaymentsPropertiesConfig() throws Exception {
        String workingDir = System.getProperty("user.dir");
        PayConfig config = PayConfigLoaderFactory.loadConfigFromPropertiesFile(workingDir
                + "/tst/com/amazon/pay/impl/config.properties");
        assertConfigValues(config);
    }
    
    private void assertConfigValues(PayConfig config) {
        Assert.assertEquals(config.getAccessKey() , TestConstants.accessKey);
        Assert.assertEquals(config.getSecretKey() , TestConstants.secretKey);
        Assert.assertEquals(config.getRegion(), Region.US);
        Assert.assertEquals(config.getRegion().toString().toLowerCase(), "us");
        Assert.assertEquals(Region.valueOf("US"), Region.US);
        Assert.assertEquals(config.getEnvironment() , Environment.LIVE);
        Assert.assertEquals(config.getCurrencyCode() , CurrencyCode.USD);
        Assert.assertEquals(config.getApplicationName() , "myApp");
        Assert.assertEquals(config.getApplicationVersion(), "1.0");
        Assert.assertEquals(config.getProxyHost(), "host");
        Assert.assertEquals(config.getProxyPort(), 80);
        Assert.assertEquals(config.getProxyUsername(), "test");
        Assert.assertEquals(config.getProxyPassword(), "crypto");
        Assert.assertEquals(config.getSellerId(), "TEST_MERCHANT_ID");
    }
    
}
