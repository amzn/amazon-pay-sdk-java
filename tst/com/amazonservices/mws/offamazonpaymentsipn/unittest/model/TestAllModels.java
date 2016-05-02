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
package com.amazonservices.mws.offamazonpaymentsipn.unittest.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    AuthorizationNotificationValidTest.class,
    AuthorizationNotificationWithAdditionalElementsValidTest.class,
    AuthorizationNotificationWithMissingMandatoryFieldsTest.class,
    BillingAgreementNotificationValidTest.class,
    BillingAgreementNotificationWithAdditionalElementsValidTest.class,
    BillingAgreementNotificationWithMissingMandatoryFieldsTest.class,
    CaptureNotificationValidTest.class,
    CaptureNotificationWithAdditionalElementsValidTest.class,
    CaptureNotificationWithMissingMandatoryFieldsTest.class,
    OrderReferenceNotificationValidTest.class,
    OrderReferenceNotificationWithAdditionalElementsValidTest.class,
    OrderReferenceNotificationWithMissingMandatoryFieldsTest.class,
    RefundNotificationValidTest.class,
    RefundNotificationWithAdditionalElementsValidTest.class,
    RefundNotificationWithMissingMandatoryFieldsTest.class,
    ProviderCreditNotificationValidTest.class,
    ProviderCreditNotificationWithAdditionalElementsValidTest.class,
    ProviderCreditNotificationWithMissingMandatoryFieldsTest.class,
    ProviderCreditReversalNotificationValidTest.class,
    ProviderCreditReversalNotificationWithAdditionalElementsValidTest.class,
    ProviderCreditReversalNotificationWithMissingMandatoryFieldsTest.class,
    SolutionProviderMerchantNotificationValidTest.class,
    SolutionProviderMerchantNotificationWithAdditionalElementsValidTest.class,
    SolutionProviderMerchantNotificationWithMissingMandatoryFieldsTest.class
})
public class TestAllModels {

}
