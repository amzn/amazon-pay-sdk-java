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

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;

/**
 * Interface to provide an implementation of the sns
 * signature verification algorithm.
 */
public interface ISnsSignatureVerification {
    /**
     * Perform the comparision of the message data with the signature 
     * as described on http://docs.aws.amazon.com/sns/latest/dg/SendMessageToHttp.verify.signature.html,
     * for version 1 of the signature algorithm
     * @param snsMessage Sns Message with metadata
     * @return true if signate matches
     * @throws NotificationsException
     */
    boolean verifyMsgMatchesSignatureV1WithCert(Message snsMessage) throws NotificationsException;
}
