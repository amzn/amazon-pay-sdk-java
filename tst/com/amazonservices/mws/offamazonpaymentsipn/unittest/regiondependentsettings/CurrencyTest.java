package com.amazonservices.mws.offamazonpaymentsipn.unittest.regiondependentsettings;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Properties;

import com.amazonservices.mws.offamazonpayments.common.PropertiesBuilder;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.Environment;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.Region;

public class CurrencyTest {
	
	@Test
	public void shouldReturnCorrectCurrencyForRegion() {
		assertThatCurrencyIsCorrectFor(Region.US, "USD");
		assertThatCurrencyIsCorrectFor(Region.DE, "EUR");
		assertThatCurrencyIsCorrectFor(Region.UK, "GBP");
		assertThatCurrencyIsCorrectFor(Region.NA, "USD");
	}

	private void assertThatCurrencyIsCorrectFor(Region region, String expectedCurrencyCode) {
		// given
		Properties properties = new PropertiesBuilder()
				.withDefaults()
				.withRegion(region)
				.withEnvironment(Environment.SANDBOX).build();

		// when
		OffAmazonPaymentsServiceConfig config = new OffAmazonPaymentsServiceConfig(properties);
		
		// then
		assertThat(expectedCurrencyCode, is(equalTo(config.getCurrencyCode())));
	}

}
