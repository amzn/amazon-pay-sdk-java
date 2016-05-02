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
package com.amazonservices.mws.offamazonpaymentsipn.validators;

import java.security.cert.X509Certificate;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;

/**
 * Provides signature verification functions that are dependent on
 * the runtime environment configuration.
 */
public interface IVerifyData {

    /**
     * Perform the comparison of the message data with the signature,
     * as described on http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.verify.signature.html,
     * for version 1 of the signature algorithm
     * @param data Byte data to compare using SHA1 hash
     * @param signature decoded signature byte array
     * @param certPath URI path to public key certificate to hash the constructed data
     * @return true if verified
     * @throws NotificationsException 
     */
    boolean verifyMsgMatchesSignatureWithPublicCert(byte[] data, byte[] signature, X509Certificate cert) throws NotificationsException;
        
    /**
     * Verify that the certificate is valid and issued by Amazon     
     * @param cert Certificate to verify
     * @return true if verified 
     */
    boolean verifyCertIsIssuedByAmazon(final X509Certificate cert) throws NotificationsException;
}
