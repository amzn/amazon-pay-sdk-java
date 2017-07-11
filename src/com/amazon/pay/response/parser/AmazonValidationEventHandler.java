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
package com.amazon.pay.response.parser;

import com.amazon.pay.exceptions.AmazonClientException;

import java.io.StringWriter;
import java.io.PrintWriter;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AmazonValidationEventHandler implements ValidationEventHandler {

    private static Log log = LogFactory.getLog(AmazonValidationEventHandler.class);

    /**
     * Rather than ignore any XML parsing events, we will log these with a
     * short message indicating where the parsing failed accompanied with
     * a corresponding stack trace.  An exception is not being thrown
     * because the events could be benign and we would not want to halt
     * execution of the process.  For example, if the Amazon Pay API's
     * started returning a new element in the XML that the SDK did not
     * know about, that's OK, and we don't want to kill the program
     * because something new is discovered.
     */
    public boolean handleEvent(ValidationEvent event) {
        try {
            String message = "XML Parse Event at "
                    + "Line " + event.getLocator().getLineNumber()
                    + ", Column " + event.getLocator().getColumnNumber()
                    + ": Message=" + event.getMessage();

            StringWriter sw = new StringWriter();
            new Exception(message).printStackTrace(new PrintWriter(sw));
            log.debug(sw.toString());

        } catch (Exception e) {
            throw new AmazonClientException("Encountered an Exception: ", e);
        }

        return true;
    }

}

