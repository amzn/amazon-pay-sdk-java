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

/**
 * Exception class for the OffAmazonPaymentsNotification library
 */
public class NotificationsException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Create a new notifications exception instance with a 
     * descriptive error message
     * @param message Cause of the error
     */
    public NotificationsException(String message) {
        super(message);
    }
    
    /**
     * Create a new notifications exception instance that wraps an
     * inner exception with an error message
     * @param message Description of the error
     * @param innerException Exception that caused this error
     */
    public NotificationsException(String message, Exception innerException) {
        super(message, innerException);
    }
}
