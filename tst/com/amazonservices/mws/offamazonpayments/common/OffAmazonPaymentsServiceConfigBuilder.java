package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class OffAmazonPaymentsServiceConfigBuilder {

    private final OffAmazonPaymentsServiceConfig mockOffAmazonPaymentConfig;

    public OffAmazonPaymentsServiceConfigBuilder() {
        this.mockOffAmazonPaymentConfig = Mockito.mock(OffAmazonPaymentsServiceConfig.class);
    }

    public OffAmazonPaymentsServiceConfigBuilder withDefaults() {
        return this;
    }

    public OffAmazonPaymentsServiceConfig build() {
        given(this.mockOffAmazonPaymentConfig.getCertCN()).willReturn(TestConstants.DEFAULT_CERT_CN);
        return this.mockOffAmazonPaymentConfig;
    }
}
