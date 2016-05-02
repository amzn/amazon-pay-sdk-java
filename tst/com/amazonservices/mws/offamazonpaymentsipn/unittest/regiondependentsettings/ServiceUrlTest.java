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

public class ServiceUrlTest {

	@Test
	public void shouldReturnCorrectServiceUrlForRegion() {
		assertServiceUrlIsCorrect(Region.DE, Environment.SANDBOX, "https://mws-eu.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01");
		assertServiceUrlIsCorrect(Region.DE, Environment.LIVE, "https://mws-eu.amazonservices.com/OffAmazonPayments/2013-01-01");

		assertServiceUrlIsCorrect(Region.US, Environment.SANDBOX, "https://mws.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01");
		assertServiceUrlIsCorrect(Region.US, Environment.LIVE, "https://mws.amazonservices.com/OffAmazonPayments/2013-01-01");

		assertServiceUrlIsCorrect(Region.UK, Environment.SANDBOX, "https://mws-eu.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01");
		assertServiceUrlIsCorrect(Region.UK, Environment.LIVE, "https://mws-eu.amazonservices.com/OffAmazonPayments/2013-01-01");

		assertServiceUrlIsCorrect(Region.NA, Environment.SANDBOX, "https://mws.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01");
		assertServiceUrlIsCorrect(Region.NA, Environment.LIVE, "https://mws.amazonservices.com/OffAmazonPayments/2013-01-01");
	}
	
	@Test
	public void shouldUseOverrideUrlForServiceUrlIfDefined() {
		Properties properties = new PropertiesBuilder()
				.withDefaults()
				.withRegion(Region.DE)
				.withEnvironment(Environment.SANDBOX)
				.withServiceUrlOverride("http://mws-eu-beta.amazonservices.com/")
				.build();

		assertServiceUrlIsCorrect(properties, "http://mws-eu-beta.amazonservices.com/OffAmazonPayments_Sandbox/2013-01-01");
	}

	private void assertServiceUrlIsCorrect(Region region, Environment environment, String expectedUrl) {

		// given
		Properties properties = new PropertiesBuilder()
				.withDefaults()
				.withRegion(region)
				.withEnvironment(environment)
				.build();

		assertServiceUrlIsCorrect(properties, expectedUrl);
	}

	private void assertServiceUrlIsCorrect(Properties properties, String expectedUrl) {
		OffAmazonPaymentsServiceConfig clientConfig = new OffAmazonPaymentsServiceConfig(properties);
		
		// when
		String actualUrl = clientConfig.getServiceURL();

		assertThat(actualUrl, is(equalTo(expectedUrl)));
	}
}