package com.amazonservices.mws.offamazonpayments;

import com.amazonservices.mws.offamazonpayments.common.PropertiesBuilder;
import com.amazonservices.mws.offamazonpayments.common.TestConstants;
import junit.framework.Assert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OffAmazonPaymentsServiceConfigTest {

    private Properties properties;

    @Before
    public void setUp() {
        properties = new PropertiesBuilder()
                .withDefaults()
                .withRegion(Region.UK)
                .withEnvironment(Environment.LIVE)
                .build();
    }

    @Test
    public void shouldCreateClassIfAllMandatoryFieldsArePopulated() {
        OffAmazonPaymentsServiceConfig config = new OffAmazonPaymentsServiceConfig(properties);

        assertThat(config.getAccessKeyId(), is(equalTo(TestConstants.DEFAULT_ACCESS_KEY_ID)));
        assertThat(config.getSecretAccessKey(), is(equalTo(TestConstants.DEFAULT_SECRET_ACCESS_KEY_ID)));
        assertThat(config.getApplicationName(), is(equalTo(TestConstants.DEFAULT_APPLICATION_NAME)));
        assertThat(config.getApplicationVersion(), is(equalTo(TestConstants.DEFAULT_APPLICATION_VERSION)));
        assertThat(config.getSellerId(), is(equalTo(TestConstants.DEFAULT_SELLER_ID)));
        assertThat(config.getCertCN(), is(equalTo(TestConstants.DEFAULT_CERT_CN)));
        assertThat(config.getRegion(), is(equalTo(Region.UK)));
        assertThat(config.getEnvironment(), is(equalTo(Environment.LIVE)));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfPropertiesAreEmpty() {
        new OffAmazonPaymentsServiceConfig(new Properties());
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfAccessKeyIdPropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.ACCESS_KEY_ID);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfAccessKeyIdPropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.ACCESS_KEY_ID);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfSecretAccessKeyPropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.SECRET_ACCESS_KEY);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfSecretAccessKeyIdPropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.SECRET_ACCESS_KEY);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfApplicationNamePropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.APPLICATION_NAME);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfApplicationNamePropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.APPLICATION_NAME);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfApplicationVersionPropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.APPLICATION_VERSION);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfApplicationVersionPropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.APPLICATION_VERSION);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfSellerIdPropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.SELLER_ID);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfSellerIdPropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.SELLER_ID);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfCertCNPropertyIsMissing() {
        assertNullPointerExceptionIfPropertyIsMissing(PropertyKey.CERT_CN);
    }

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerExceptionIfCertCNPropertyIsNull() {
        assertNullPointerExceptionIfPropertyIsNull(PropertyKey.CERT_CN);
    }

    private void assertNullPointerExceptionIfPropertyIsMissing(PropertyKey propertyKey) {
        properties.remove(propertyKey.toString());

        new OffAmazonPaymentsServiceConfig(properties);
    }

    private void assertNullPointerExceptionIfPropertyIsNull(PropertyKey propertyKey) {
        properties.put(propertyKey.toString(), null);

        new OffAmazonPaymentsServiceConfig(properties);
    }

}