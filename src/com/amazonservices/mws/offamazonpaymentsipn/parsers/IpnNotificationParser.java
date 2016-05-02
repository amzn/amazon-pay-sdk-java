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
package com.amazonservices.mws.offamazonpaymentsipn.parsers;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.IpnNotificationMetadata;

/**
 * This class is responsible for parsing the input data
 * into a message the conforms to an Ipn message.
 */
public class IpnNotificationParser {

    /**
     * Extract data from a message conforming to an sns message into
     * an ipn message.
     * @param snsMessage Message conforming to sns data structure
     * @return Message conforming to ipn data structure
     * @throws NotificationsException
     */
    public Message parseSnsMessage(final Message snsMessage) throws NotificationsException {
        Message msg = new Message(snsMessage.getMandatoryField("Message"));
        msg.setMetadata(new IpnNotificationMetadata(msg, snsMessage.getMetadata()));
        return msg;
    }
}
