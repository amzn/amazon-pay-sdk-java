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
package com.amazonservices.mws.offamazonpaymentsipn.parsers.singletons;

import com.amazonservices.mws.offamazonpaymentsipn.parsers.SnsNotificationParser;

/*
 * Return an instance of the SnsNotificationParser
 *
 * This class should not be directly used and is included
 * to support a deprecated use case.  Will be removed once
 * the use case is deprecated.
 */
@Deprecated
public final class SnsNotificationParserSingleton {

    private static volatile SnsNotificationParser instance = null;

    private SnsNotificationParserSingleton() {
        // noop on purpose
    }

    public static SnsNotificationParser getInstance() {
        if (instance == null) {
            synchronized (SnsNotificationParserSingleton.class) {
                if (instance == null) {
                    instance = new SnsNotificationParser();
                }
            }
        }

        return instance;
    }
}
