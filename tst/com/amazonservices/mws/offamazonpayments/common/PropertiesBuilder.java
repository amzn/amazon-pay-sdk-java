package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.Environment;
import com.amazonservices.mws.offamazonpayments.PropertyKey;
import com.amazonservices.mws.offamazonpayments.Region;

import java.util.Properties;

import static com.amazonservices.mws.offamazonpayments.PropertyKey.*;

public class PropertiesBuilder {

    private final Properties properties;

    public PropertiesBuilder() {
        this.properties = new Properties();
    }

    protected PropertiesBuilder(Properties properties) {
        this.properties = properties;
    }

    public PropertiesBuilder withDefaults() {
        putKeyValue(ACCESS_KEY_ID, TestConstants.DEFAULT_ACCESS_KEY_ID);
        putKeyValue(SECRET_ACCESS_KEY, TestConstants.DEFAULT_SECRET_ACCESS_KEY_ID);
        putKeyValue(APPLICATION_NAME, TestConstants.DEFAULT_APPLICATION_NAME);
        putKeyValue(APPLICATION_VERSION, TestConstants.DEFAULT_APPLICATION_VERSION);
        putKeyValue(SELLER_ID, TestConstants.DEFAULT_SELLER_ID);
        putKeyValue(CERT_CN, TestConstants.DEFAULT_CERT_CN);
        putKeyValue(ENVIRONMENT, Environment.LIVE.getValue());
        putKeyValue(REGION, Region.DE.getValue());

        return this;
    }

    public PropertiesBuilder withRegion(Region region) {
        putKeyValue(REGION, region.getValue());
        return this;
    }

    public PropertiesBuilder withEnvironment(Environment environment) {
        putKeyValue(ENVIRONMENT, environment.getValue());
        return this;
    }

    public PropertiesBuilder withWidgetUrlOverride(String widgetUrlOverride) {
        putKeyValue(WIDGET_URL, widgetUrlOverride);
        return this;
    }

    public PropertiesBuilder withServiceUrlOverride(String serviceUrlOverride) {
        putKeyValue(SERVICE_URL, serviceUrlOverride);
        return this;
    }

    public Properties build() {
        return this.properties;
    }

    private void putKeyValue(PropertyKey key, String value) {
        this.properties.put(key.toString(), value);
    }


}
