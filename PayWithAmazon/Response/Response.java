/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PayWithAmazon.Response;

import org.jsoup.nodes.Document;
/**
 *
 * @author nehaa
 */
public class Response {
    
    private int statusCode;
    private String xmlString;
    private Document documentResponse;

    public void setXmlString(String xmlString) {
        this.xmlString = xmlString;
    }
    
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public void setDocumentResponse(Document document) {
        this.documentResponse = document;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    public String getString() {
        return xmlString;
    }
}

