package com.amazonservices.mws.offamazonpaymentsipn;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpaymentsipn.NotificationParserFactory;
import com.amazonservices.mws.offamazonpaymentsipn.cache.ICache;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class NotificationParserFactoryTest {

    private OffAmazonPaymentsServiceConfig config;

    @Before
    public void setUp() {
        this.config = new OffAmazonPaymentsServiceConfig();
    }

    @Test
    public void shouldNotThrownExceptionOnCreateInstanceWithDefaultCache() {
        new NotificationParserFactory(config).createNewInstance();

        assertTrue(true); //no exception
    }

    @Test
    public void shouldNotThrowExceptionOnCreateInstanceWithCustomCache() {
        ICache cache = mock(ICache.class);
        new NotificationParserFactory(cache, config);

        assertTrue(true); //no exception
    }
}