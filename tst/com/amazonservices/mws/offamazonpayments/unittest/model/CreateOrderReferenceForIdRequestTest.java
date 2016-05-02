package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.CreateOrderReferenceForIdRequest;

import static junit.framework.Assert.assertNotNull;

public class CreateOrderReferenceForIdRequestTest extends ModelTest<CreateOrderReferenceForIdRequest>{

    @Override
    protected String getXMLTestFile(){
        return "CreateOrderReferenceForIdRequest.xml";
    }

    @Override
    protected Class<CreateOrderReferenceForIdRequest> getTestClassType() {
        return CreateOrderReferenceForIdRequest.class;
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
    public void toJSONShouldNotReturnNullForObjectWithAllFieldsPopulated() throws Exception {
        String jsonFragment = getTestClassObject().toJSONFragment();

        assertNotNull(jsonFragment);
    }
}