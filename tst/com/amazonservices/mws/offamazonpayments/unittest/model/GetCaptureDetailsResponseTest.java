package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetCaptureDetailsResponse;

import static junit.framework.Assert.assertNotNull;

public class GetCaptureDetailsResponseTest extends ModelTest<GetCaptureDetailsResponse>{

    @Override
    protected String getXMLTestFile(){
        return "GetCaptureDetailsResponse.xml";
    }

    @Override
    protected Class<GetCaptureDetailsResponse> getTestClassType() {
        return GetCaptureDetailsResponse.class;
    }

    @Test
    public void testObjectToXML() throws Exception{
        testForNull();
    }

    @Test
    public void testXMLToObject() throws Exception {
        testSchema();
    }

    @Test
    public void toXMLShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String xmlFragment = getTestClassObject().toXML();

        assertNotNull(xmlFragment);
    }

    @Test
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSON();

        assertNotNull(jsonFragment);
    }
}
