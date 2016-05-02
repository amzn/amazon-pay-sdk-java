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
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.SnsNotificationMetadata;
import com.amazonservices.mws.offamazonpaymentsipn.parsers.Message;

/**
 * Class is responsible for performing SNS recommended validations.
 */
public class SnsMessageValidator {

    /**
     * Error format string for unknown signature verification message.
     */
    private final String UNKNOWN_SIGNATURE_VERIFICATION_VERSION_ERR_STR
            = "Error with sns message verification - message is signed with unknown signature specification %s";

    /**
     * Error format string for failing signature verification.
     */
    private final String SIGNATURE_VERIFICATION_FAILED_ERR_STR
            = "Error with sns message - signature verification v%s failed for message id %s, topicArn %s";

    /**
     * Instance of hte signature verification algorithm to use.
     */
    private ISnsSignatureVerification snsSignatureVerification;

    /**
     * Create a new instance of the sns message validator class using the
     * injected validation algorithm to verify the message signature.
     * @param snsSignatureVerification Instance of the signature verification algorithm
     */
    public SnsMessageValidator(final ISnsSignatureVerification snsSignatureVerification) {
        this.snsSignatureVerification = snsSignatureVerification;
    }

    /**
     * Validate this sns message by comparing the signature to
     * the one constructed on the client side to see if they match.
     * @param snsMessage Sns message with metadata
     * @throws NotificationsException if unknown signature verification algorithm
     */
    public void validateMessageIsTrusted(final Message snsMessage) throws NotificationsException {
        String signatureVersion = snsMessage.getMandatoryField("SignatureVersion");
        if (signatureVersion.equals("1")) {
            verifySnsMessageWithVersion1SignatureAlgorithm(snsMessage);
        } else {
            throw new NotificationsException(String.format(UNKNOWN_SIGNATURE_VERIFICATION_VERSION_ERR_STR, signatureVersion));
        }
    }

    /**
     * Invoke the version 1 signature algorithm and throw an exception if it fails.
     * @param snsMessage sns message to verify
     * @throws NotificationsException if signature verification fails
     */
    private void verifySnsMessageWithVersion1SignatureAlgorithm(final Message snsMessage) throws NotificationsException {
        boolean isValid = snsSignatureVerification.verifyMsgMatchesSignatureV1WithCert(snsMessage);
        if (!isValid) {
            SnsNotificationMetadata metadata = (SnsNotificationMetadata)snsMessage.getMetadata();
            throw new NotificationsException(String.format(SIGNATURE_VERIFICATION_FAILED_ERR_STR, "1", metadata.getMessageId(), metadata.getTopicArn()));
        }
    }
}
