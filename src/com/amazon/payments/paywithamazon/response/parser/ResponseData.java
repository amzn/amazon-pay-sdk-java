package com.amazon.payments.paywithamazon.response.parser;

import com.amazon.payments.paywithamazon.impl.PaymentsLogUtil;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;

public class ResponseData {
    private final int statusCode;
    private final String responseXml;

    private final PaymentsLogUtil payUtil = new PaymentsLogUtil();

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
     * Returns the status code of payments API call
     *
     * @return
     *       The status code of payments API call
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
     * @return
     *          JSON representation of response returned by Amazon Service API
     */
    public String toJSON() throws JSONException {
        JSONObject jsonObj = XML.toJSONObject(this.responseXml);
        return jsonObj.toString();
    }


}
