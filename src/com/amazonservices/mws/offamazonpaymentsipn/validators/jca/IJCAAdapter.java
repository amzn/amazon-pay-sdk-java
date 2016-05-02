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

package com.amazonservices.mws.offamazonpaymentsipn.validators.jca;


import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * Adapter class between a Java Cryptography Extension (JCE) provider
 * and the notification parser engine to provide required cryptography functions
 */
public interface IJCAAdapter {

    /**
     * Return the list of common name fields from a 509 certficiate subject field
     * @param certificate x509 certificate to extract the CN field from
     * @return List of CN fields
     * @throws NotificationsException
     */
    List<String> getCNNamesForCert(final X509Certificate certificate) throws NotificationsException;
}
