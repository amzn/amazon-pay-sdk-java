package com.amazonservices.mws.offamazonpaymentsipn.unittest.regiondependentsettings;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Properties;

import com.amazonservices.mws.offamazonpayments.common.PropertiesBuilder;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.Environment;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.Region;

public class WidgetUrlTest {

	@Test
	public void shouldReturnCorrectWidgetUrlForRegion() {
		assertWidgetUrlIsCorrect(Region.DE, Environment.SANDBOX, "https://static-eu.payments-amazon.com/OffAmazonPayments/de/sandbox/lpa/js/Widgets.js");
        assertWidgetUrlIsCorrect(Region.DE, Environment.LIVE, "https://static-eu.payments-amazon.com/OffAmazonPayments/de/lpa/js/Widgets.js");

        assertWidgetUrlIsCorrect(Region.UK, Environment.SANDBOX, "https://static-eu.payments-amazon.com/OffAmazonPayments/uk/sandbox/lpa/js/Widgets.js");
        assertWidgetUrlIsCorrect(Region.UK, Environment.LIVE, "https://static-eu.payments-amazon.com/OffAmazonPayments/uk/lpa/js/Widgets.js");

        assertWidgetUrlIsCorrect(Region.US, Environment.SANDBOX, "https://static-na.payments-amazon.com/OffAmazonPayments/us/sandbox/js/Widgets.js");
        assertWidgetUrlIsCorrect(Region.US, Environment.LIVE, "https://static-na.payments-amazon.com/OffAmazonPayments/us/js/Widgets.js");

        // NA and EU are deprecated, however since it was included in one public release we need to maintain a mapping
        // NA map to US widget
        assertWidgetUrlIsCorrect(Region.NA, Environment.SANDBOX, "https://static-na.payments-amazon.com/OffAmazonPayments/us/sandbox/js/Widgets.js");
        assertWidgetUrlIsCorrect(Region.NA, Environment.LIVE, "https://static-na.payments-amazon.com/OffAmazonPayments/us/js/Widgets.js");
	}
	
	@Test
	public void shouldUseWidgetUrlOverrideIfDefined() {
		Properties properties = new PropertiesBuilder()
				.withDefaults()
				.withRegion(Region.US)
				.withEnvironment(Environment.SANDBOX)
				.withWidgetUrlOverride("http://static-test-widget-url")
				.build();

		assertWidgetUrlIsCorrect(properties, "http://static-test-widget-url/OffAmazonPayments/us/sandbox/js/Widgets.js");
	}
	
	private void assertWidgetUrlIsCorrect(Region region, Environment environment, String expectedUrl) {

		// given
		Properties properties = new PropertiesBuilder()
				.withDefaults()
				.withRegion(region)
				.withEnvironment(environment)
				.build();

		assertWidgetUrlIsCorrect(properties, expectedUrl);
	}

	private void assertWidgetUrlIsCorrect(Properties properties, String expectedUrl) {
		// when
		OffAmazonPaymentsServiceConfig clientConfig = new OffAmazonPaymentsServiceConfig(properties);
		String actualUrl = clientConfig.getWidgetURL();

		assertThat(actualUrl, is(equalTo(expectedUrl)));
	}
}
