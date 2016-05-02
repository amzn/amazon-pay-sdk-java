/*******************************************************************************
 *  Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *  http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *  CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the
 *  specific language governing permissions and limitations under the
 *  License.
 * *****************************************************************************
 */
package com.amazonservices.mws.offamazonpaymentsipn;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.certificate.X509CertificateFactoryImpl;
import com.amazonservices.mws.offamazonpaymentsipn.INotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.NotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.cache.Cache;
import com.amazonservices.mws.offamazonpaymentsipn.cache.ICache;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.IpnNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.SnsNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.XmlNotificationParser;
import com.amazonservices.mws.offamazonpaymentsipn.validators.*;

public class NotificationParserFactory {

    private final ICache cache;
    private final String expectedCertCN;

    /**
     * Create a new instance of a notification parser factory, using the default
     * certificate cache
     * @param config service configuration
     */
    public NotificationParserFactory(OffAmazonPaymentsServiceConfig config) {
        this(new Cache(), config);
    }

    /**
     * Create a new instance of a notification parser factory, using a
     * custom certificate cache and service configuration
     *
     * @param cache custom cache to store certificates
     * @param config service configuration
     */
    public NotificationParserFactory(ICache cache, OffAmazonPaymentsServiceConfig config) {
        this.cache = cache;
        this.expectedCertCN = config.getCertCN();
    }

    public INotificationParser createNewInstance() {
        SnsMessageValidator snsMessageValidator = createNewSnsMessageValidator();
        SnsNotificationParser snsNotificationParser = new SnsNotificationParser();
        IpnNotificationParser ipnNotificationParser = new IpnNotificationParser();
        XmlNotificationParser xmlNotificationParser = new XmlNotificationParser();

        return new NotificationParser(snsNotificationParser,
                snsMessageValidator, ipnNotificationParser, xmlNotificationParser);
    }

    /**
     * This package is deliberately package visible to support
     * deprecated constructor calls in v1 of the API.
     * Mark as private when no longer required
     */
    SnsMessageValidator createNewSnsMessageValidator() {
        IVerifyData verifyData = new VerifyDataJavaImpl(expectedCertCN);
        ISnsSignatureVerification snsSignatureVerificationV1Impl = new SnsSignatureVerification(verifyData,
                new X509CertificateFactoryImpl(cache));
        return new SnsMessageValidator(snsSignatureVerificationV1Impl);
    }
}
