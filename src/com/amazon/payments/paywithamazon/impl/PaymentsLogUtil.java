package com.amazon.payments.paywithamazon.impl;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.amazon.payments.paywithamazon.LogUtil;
import com.amazon.payments.paywithamazon.exceptions.AmazonClientException;

public class PaymentsLogUtil implements LogUtil{

    private static Log log = LogFactory.getLog(PaymentsLogUtil.class);

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
    public String sanitizeString(String responseData) {

        List<String> restrictedDataList = new ArrayList<String>() {{
            add("SellerNote");
            add("SellerAuthorizationNote");
            add("SellerCaptureNote");
            add("SellerRefundNote");
            add("Buyer");
            add("PhysicalDestination");
            add("BillingAddress");
            add("AuthorizationBillingAddress");}};

        String sanitizedData;
        sanitizedData = getSanitizedData(responseData,restrictedDataList);
        return sanitizedData;
    }


    /**
     *
     * @param data  - data to be sanitized.
     * @param removedata - List of strings to be removed from the data object.
     * @return - an XML not containing 'removedata' lists of strings.
     *
     * @throws TransformerFactoryConfigurationError - Thrown when a problem with configuration with the Transformer Factories exists. This error will typically be thrown when the class of a transformation factory specified in the system properties cannot be found or instantiated.
     */
    public String getSanitizedData(String data, List<String> removedata) throws AmazonClientException{

        try{
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(data));

            Document doc = db.parse(is);

            NodeList list = doc.getElementsByTagName("*");
            for (int i = 0; i < list.getLength(); i++) {
                //Get Node
                Node node = (Node) list.item(i);

                for(Iterator<String> j = removedata.iterator(); j.hasNext(); ) {
                    String item = j.next();
                    if (node.getNodeName().equalsIgnoreCase(item)) {
                        node.setTextContent("*** Removed ***");
                    }
                }
            }

            StringWriter sw = new StringWriter();
            Transformer serializer = TransformerFactory.newInstance().newTransformer();
            serializer.transform(new DOMSource(list.item(0)), new StreamResult(sw));

            String result = sw.toString();

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
