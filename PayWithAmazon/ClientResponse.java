package PayWithAmazon;

import org.jsoup.nodes.Document;
/**
 *
 * @author nehaa
 */
public class ClientResponse {
    
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
    public String getXmlAsString() {
        return xmlString;
    }
}

