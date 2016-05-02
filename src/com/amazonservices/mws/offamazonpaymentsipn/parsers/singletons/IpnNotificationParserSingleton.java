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

import com.amazonservices.mws.offamazonpaymentsipn.parsers.IpnNotificationParser;

/*
 * Return an instance of the IpnNotificationParser
 *
 * This class should not be directly used and is included
 * to support a deprecated use case.  Will be removed once
 * the use case is deprecated.
 */
@Deprecated
public class IpnNotificationParserSingleton {

    private static volatile IpnNotificationParser instance = null;

    private IpnNotificationParserSingleton() {
        // noop on purpose
    }

    public static IpnNotificationParser getInstance() {
        if (instance == null) {
            synchronized (IpnNotificationParserSingleton.class) {
                if (instance == null) {
                    instance = new IpnNotificationParser();
                }
            }
        }

        return instance;
    }
}
