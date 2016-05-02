package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CloseOrderReferenceResponse;

import static junit.framework.Assert.assertNotNull;

public class CloseOrderReferenceResponseTest extends ModelTest<CloseOrderReferenceResponse>{

    @Override
    protected String getXMLTestFile() {
        return "CloseOrderReferenceResponse.xml";
    }
    @Override
    protected Class<CloseOrderReferenceResponse> getTestClassType() {

        return CloseOrderReferenceResponse.class;
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