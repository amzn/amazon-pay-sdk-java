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
package com.amazon.pay.types;

/**
 * Represents the currency code supported by Amazon Pay API,
 * see: ISO-4217 current codes
 */
public enum CurrencyCode {
    USD,  // US Dollar     (default for US region)
    EUR,  // Euro          (default for DE region)
    GBP,  // British Pound (default for UK region)
    JPY,  // Japanese Yen  (default for JP region)

    /* Following currencies are available as alternate
     * "PresentmentCurrencies" for DE/UK merchants when
     * whitelisted for the "Multi-currency" feature
     */

    AUD,  // Australian Dollar
    ZAR,  // South African Rand
    CHF,  // Swiss Franc
    NOK,  // Norwegian Krone
    DKK,  // Danish Krone
    SEK,  // Swedish Krone
    NZD,  // New Zealand Dollar
    HKD;  // Hong Kong Dollar
}
