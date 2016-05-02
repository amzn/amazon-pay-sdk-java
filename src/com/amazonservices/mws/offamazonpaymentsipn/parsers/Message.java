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

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.amazonservices.mws.offamazonpaymentsipn.NotificationsException;
import com.amazonservices.mws.offamazonpaymentsipn.notificationmetadata.INotificationMetadata;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents an internal wrapper for a message that is protocol independent
 * Format is key/value pairs.
 */
public class Message {

    /**
     * Parsed json message.
     */
    private HashMap<String,String> parsedMessage;
    /**
     * Metadata associated with this message
     */
    private INotificationMetadata metadata;
    
    /**
     * Error message for invalid json string.
     */
    private final static String InvalidJsonErrMsg = "Error with message - content is not in json format";
    
    /**
     * Error message for a missing mandatory field.
     */
    private final static String MissingMandatoryFieldErrMsg = "Error with message - mandatory field %s cannot be found";
    
    /**
     * Error message for invalid cast to a date object for a field value.
     */
    private final static String FieldNotDateErrMsgFormatString = "Error with message - expected field %s to be Date object";
    
    /**
     * Gson class instance, used to parse json.
     */
    private final static Gson gson = new Gson();
    
    /**
     * Target for the gson parser to parse it's json into.
     */
    private final static Type type = new TypeToken<Map<String, String>>() { } .getType();
    
    /**
     * SimpleDateFormat object for parsing timestamps with milliseconds
     */
    private final static SimpleDateFormat UtcDateTimeWithMillisecondsFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    
    /**
     * SimpleDateFormat object for parsing timestamps without milliseconds
     */
    private final static SimpleDateFormat UtcDateTimeWithoutMillisecondsFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    /**
     * Create a new message that acts as a wrapper around the json string.
     * @param json A valid json string
     * @throws NotificationsException if the string is not valid json
     */
    public Message(final String json) throws NotificationsException {
        try {
            parsedMessage = gson.fromJson(json, type);
        } catch (Exception ex) {
            throw new NotificationsException(InvalidJsonErrMsg, ex);
        }
    }

    /**
     * Get the metadata associated with this message.
     * @return the metadata
     */
    public INotificationMetadata getMetadata() {
        return metadata;
    }

    /**
     * Set the metadata associated with this message
     * @param metadata
     */
    public void setMetadata(INotificationMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * Return the value associated with the field name.
     * @param fieldName Name of the field to retrieve
     * @return the value of the field
     * @throws NotificationsException throws exception if field cannot be found
     */
    public String getMandatoryField(final String fieldName) throws NotificationsException {
        String value = getField(fieldName);

        if (value == null) {
            throw new NotificationsException(String.format(MissingMandatoryFieldErrMsg, fieldName));
        }

        return value;
    }

    /**
     * Returns the value associated with the field name.
     * @param fieldName Field name containing date data
     * @return Date representation of the object
     * @throws NotificationsException if value is not a date
     */
    public Date getMandatoryFieldAsDate(final String fieldName) throws NotificationsException {
        String field = getField(fieldName);
        
        if(field==null)
        {
            throw new NotificationsException(String.format(MissingMandatoryFieldErrMsg, fieldName));
        }
        
        // Handle a timestamp with or without the ms field
        try {
            return UtcDateTimeWithMillisecondsFormatter.parse(field);
        } catch (ParseException pe) {
            try {
                return UtcDateTimeWithoutMillisecondsFormatter.parse(field);
            } catch (ParseException e) {
                throw new NotificationsException(String.format(FieldNotDateErrMsgFormatString, fieldName), pe);
            }
        }
    }

    /**
     * Return the value associated with this field.
     * @param fieldName Name of the field to retrieve
     * @return the fields value
     * @throws NotificationsException if field does not exist
     */
    public String getField(final String fieldName) throws NotificationsException {
        return parsedMessage.get(fieldName);
    }
}
