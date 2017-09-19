/**
 * Copyright 2016-2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import com.amazon.pay.TestConstants;
import com.amazon.pay.response.model.Environment;
import com.amazon.pay.types.CurrencyCode;
import com.amazon.pay.types.Region;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;

public class PaymentsConfigTest {

    private static final boolean WITH_OVERRIDES = true;
    private static final boolean WITHOUT_OVERRIDES = false;

    @Test(expected=IllegalArgumentException.class)
    public void testEmptyPaymentsConfiguration() throws Exception {
        //throws exception, if required properties don't exist
        final PayConfig config = new PayConfig(new Properties());
        assertConfigValues(config, WITHOUT_OVERRIDES);
    }

    @Test
    public void testPaymentsConfig() {
        final PayConfig config = new PayConfig().withAccessKey(TestConstants.accessKey)
                .withSecretKey(TestConstants.secretKey)
                .withSellerId(TestConstants.merchantId)
                .withCurrencyCode(CurrencyCode.USD)
                .withSandboxMode(false)
                .withRegion(Region.US)
                .withProxyHost("host").withProxyPort(80).withApplicationName("myApp")
                .withApplicationVersion("1.0").withProxyUsername("test").withProxyPassword("crypto");
        assertConfigValues(config, WITHOUT_OVERRIDES);

        // Test URL override "with" methods
        config.withOverrideServiceURL(TestConstants.OVERRIDE_SERVICE_URL)
                .withOverrideProfileURL(TestConstants.OVERRIDE_PROFILE_URL);
        assertConfigValues(config, WITH_OVERRIDES);

        // Test URL override "set" methods
        config.setOverrideServiceURL(null);
        config.setOverrideProfileURL(null);
        assertConfigValues(config, WITHOUT_OVERRIDES);
    }

    @Test
    public void testPaymentsJSONConfig() throws Exception {
        final String workingDir = System.getProperty("user.dir");
        final PayConfig config = PayConfigLoaderFactory.loadConfigFromJSON(workingDir
                + "/tst/com/amazon/pay/impl/config.json");
        assertConfigValues(config, WITHOUT_OVERRIDES);
    }

    @Test
    public void testPaymentsPropertiesConfig() throws Exception {
        final String workingDir = System.getProperty("user.dir");
        final PayConfig config = PayConfigLoaderFactory.loadConfigFromPropertiesFile(workingDir
                + "/tst/com/amazon/pay/impl/config.properties");
        assertConfigValues(config, WITHOUT_OVERRIDES);
    }

    @Test
    public void testPaymentsJSONConfigOverride() throws Exception {
        final String workingDir = System.getProperty("user.dir");
        final PayConfig config = PayConfigLoaderFactory.loadConfigFromJSON(workingDir
                + "/tst/com/amazon/pay/impl/config_override.json");
        assertConfigValues(config, WITH_OVERRIDES);
    }

    @Test
    public void testPaymentsPropertiesConfigOverride() throws Exception {
        final String workingDir = System.getProperty("user.dir");
        final PayConfig config = PayConfigLoaderFactory.loadConfigFromPropertiesFile(workingDir
                + "/tst/com/amazon/pay/impl/config_override.properties");
        assertConfigValues(config, WITH_OVERRIDES);
    }

    private void assertConfigValues(PayConfig config, boolean usingOverride) {
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
        if (usingOverride) {
            Assert.assertEquals(config.getOverrideServiceURL(), TestConstants.OVERRIDE_SERVICE_URL);
            Assert.assertEquals(config.getOverrideProfileURL(), TestConstants.OVERRIDE_PROFILE_URL);
        } else {
            Assert.assertNull(config.getOverrideServiceURL());
            Assert.assertNull(config.getOverrideProfileURL());
        }
    }

}
