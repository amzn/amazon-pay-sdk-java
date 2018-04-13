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

import com.amazon.pay.impl.PayLogUtil;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;

public class ResponseData {
    private final int statusCode;
    private final String responseXml;

    private final PayLogUtil payUtil = new PayLogUtil();

    public ResponseData(int responseCode , String rawXmlString) {
        this.statusCode = responseCode;
        this.responseXml = rawXmlString;
    }

    public ResponseData(ResponseData response) {
        this.responseXml = response.responseXml;
        this.statusCode = response.statusCode;
        payUtil.logMessage("\n\nResponse Data: \n" + payUtil.sanitizeString(responseXml));
    }

    /**
     * Returns the status code of Pay API call
     *
     * @return
     *       The status code of Pay API call
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * Returns the raw XML response as returned by Amazon Service API
     *
     * @return
     *          The raw XML response as returned by Amazon Service API
     */
    public String toXML() {
        return this.responseXml;
    }

    /**
     * Converts the raw XML response to JSON format
     *
     * @throws JSONException
     *          If the XML response cannot be converted into JSON
     * @return
     *          JSON representation of response returned by Amazon Service API
     */
    public String toJSON() throws JSONException {
        JSONObject jsonObj = XML.toJSONObject(this.responseXml);
        return jsonObj.toString();
    }


}
