package test.com.amazon.payments.paywithamazon.impl;

import com.amazon.payments.paywithamazon.impl.*;
import test.com.amazon.payments.paywithamazon.TestConstants;
import com.amazon.payments.paywithamazon.response.model.Environment;
import com.amazon.payments.paywithamazon.types.CurrencyCode;
import com.amazon.payments.paywithamazon.types.Region;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;

public class PaymentsConfigTest {

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyPaymentsConfigiration() throws Exception {
        //throws exception, if required properties don't exist
        PaymentsConfig config = new PaymentsConfig(new Properties());
        assertConfigValues(config);
    }
    
    @Test
    public void testPaymentsConfig() {
        PaymentsConfig config = new PaymentsConfig().withAccessKey(TestConstants.accessKey)
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
        PaymentsConfig config = PaymentsConfigLoaderFactory.loadConfigFromJSON(workingDir 
                + "/test/com/amazon/payments/paywithamazon/impl/config.json");
        assertConfigValues(config);
    }
    
    @Test
    public void testPaymentsPropertiesConfig() throws Exception {
        String workingDir = System.getProperty("user.dir");
        PaymentsConfig config = PaymentsConfigLoaderFactory.loadConfigFromPropertiesFile(workingDir 
                + "/test/com/amazon/payments/paywithamazon/impl/config.properties");
        assertConfigValues(config);
    }
    
    private void assertConfigValues(PaymentsConfig config) {
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
        Assert.assertEquals(config.getSellerId(), "A2K7NDRMCETORTCHANTID");
    }
    
}
