package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CreateOrderReferenceForIdResponse;

import static junit.framework.Assert.assertNotNull;

public class CreateOrderReferenceForIdResponseTest extends ModelTest<CreateOrderReferenceForIdResponse>{

    @Override
    protected String getXMLTestFile(){
        return "CreateOrderReferenceForIdResponse.xml";
    }

    @Override
    protected Class<CreateOrderReferenceForIdResponse> getTestClassType() {
        return CreateOrderReferenceForIdResponse.class;
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