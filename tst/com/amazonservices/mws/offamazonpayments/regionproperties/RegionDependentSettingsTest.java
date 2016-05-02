package com.amazonservices.mws.offamazonpayments.regionproperties;

import junit.framework.Assert;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.Environment;
import com.amazonservices.mws.offamazonpayments.Region;

public class RegionDependentSettingsTest {
    
    @Test
    public void testUSLiveRegion() throws Exception {
        new TestRunner()
                .setInput(Region.US, Environment.LIVE)
                .setExpectations("https://mws.amazonservices.com/OffAmazonPayments/2013-01-01",
                        "https://static-na.payments-amazon.com/OffAmazonPayments/us/js/Widgets.js", "USD", "us")
                .runTestAndVerify();
    }
    
    @Test
    public void testUKSandboxRegion() throws Exception {
        new TestRunner()
                .setInput(Region.UK, Environment.SANDBOX)
                .setExpectations("https://mws-eu.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01",
                        "https://static-eu.payments-amazon.com/OffAmazonPayments/uk/sandbox/lpa/js/Widgets.js", "GBP", "uk")
                .runTestAndVerify();
    }
    
    @Test
    public void testDELiveRegion() throws Exception {
        new TestRunner()
                .setInput(Region.DE, Environment.LIVE)
                .setExpectations("https://mws-eu.amazonservices.com/OffAmazonPayments/2013-01-01",
                        "https://static-eu.payments-amazon.com/OffAmazonPayments/de/lpa/js/Widgets.js", "EUR", "de")
                .runTestAndVerify();
    }
    
    @Test
    public void testJPSandboxRegion() throws Exception {
        new TestRunner()
                .setInput(Region.JP, Environment.SANDBOX)
                .setExpectations("https://mws.amazonservices.jp/OffAmazonPayments_Sandbox/2013-01-01",
                        "https://static-fe.payments-amazon.com/OffAmazonPayments/jp/sandbox/lpa/js/Widgets.js", "JPY", "jp")
                .runTestAndVerify();
    }
    
    class TestRunner {
        
        private Region inputRegion;
        private Environment inputEnvironment;
        private String expectedMwsUrl;
        private String expectedWidgetUrl;
        private String expectedCurrencyCode;
        private String expectedLocale;
        
        private TestRunner setInput(Region region, Environment environment) {
            this.inputRegion = region;
            this.inputEnvironment = environment;
            return this;
        }
        
        private TestRunner setExpectations(String mwsUrl, String widgetUrl, String currencyCode, String locale) {
            this.expectedMwsUrl = mwsUrl;
            this.expectedWidgetUrl = widgetUrl;
            this.expectedCurrencyCode = currencyCode;
            this.expectedLocale = locale;
            return this;
        }
        
        private void runTestAndVerify() throws Exception{
            RegionDependentSettings rds = new RegionDependentSettings(inputRegion);
            Assert.assertEquals(expectedMwsUrl, rds.getMwsUrlForEnvironment(inputEnvironment));
            Assert.assertEquals(expectedWidgetUrl, rds.getWidgetUrlForEnvironment(inputEnvironment));
            Assert.assertEquals(expectedCurrencyCode, rds.getCurrencyCode());
            Assert.assertEquals(expectedLocale, rds.getLocale());
        }
    }
    
}
