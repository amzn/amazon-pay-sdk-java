/**
 * Copyright 2016-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazon.pay.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.amazon.pay.LogUtil;
import com.amazon.pay.exceptions.AmazonClientException;

public class PayLogUtil implements LogUtil{

    private static Log log = LogFactory.getLog(PayLogUtil.class);

    @Override
    public void logMessage(String message) {
        if (log != null) {
            log.debug(message);
        }
    }

    /**
     * @param responseData - Data that contains merchant's request
     *
     * @return sanitized data not containing SellerNote, SellerAuthorizationNote, SellerCaptureNote, SellerRefundNote, Buyer, PhysicalDestination,
     * BillingAddress, AuthorizationBillingAddress
     */
    public String sanitizeString(final String responseData) {

        final List<String> restrictedDataList = new ArrayList<String>() {{
            add("SellerNote");
            add("SellerAuthorizationNote");
            add("SellerCaptureNote");
            add("SellerRefundNote");
            add("Buyer");
            add("PhysicalDestination");
            add("BillingAddress");
            add("AuthorizationBillingAddress");
        }};

        final String sanitizedData = getSanitizedData(responseData, restrictedDataList);
        return sanitizedData;
    }


    /**
     * @param data  - data to be sanitized.
     * @param removedata - List of strings to be removed from the data object.
     * @return - an XML not containing 'removedata' lists of strings.
     *
     * @throws AmazonClientException - upon issue sanitizing data
     */
    public String getSanitizedData(final String data, final List<String> removedata) throws AmazonClientException {

        try {
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // settings for XXE: External Entity Prevention
            // see https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.md
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);

            final DocumentBuilder db = dbf.newDocumentBuilder();
            final InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(data));

            final Document doc = db.parse(is);

            final NodeList list = doc.getElementsByTagName("*");
            for (int i = 0; i < list.getLength(); i++) {
                //Get Node
                final Node node = (Node) list.item(i);

                final Iterator<String> j = removedata.iterator();
                while (j.hasNext()) {
                    final String item = j.next();
                    if (node.getNodeName().equalsIgnoreCase(item)) {
                        node.setTextContent("*** Removed ***");
                    }
                }
            }

            final StringWriter sw = new StringWriter();
            final Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.transform(new DOMSource(list.item(0)), new StreamResult(sw));

            final String result = sw.toString();
            return result;
        } catch (ParserConfigurationException e) {
            throw new AmazonClientException("Encountered UnsupportedEncodingException:", e);
        } catch (SAXException e) {
            throw new AmazonClientException("Encountered SAXException:", e);
        } catch (IOException e) {
            throw new AmazonClientException("Encountered IOException:", e);
        } catch (TransformerConfigurationException e) {
            throw new AmazonClientException("Encountered a Transformer Configuration Exception:", e);
        } catch (TransformerException e) {
            throw new AmazonClientException("Encountered a Transformer Exception:", e);
        }
    }

}
