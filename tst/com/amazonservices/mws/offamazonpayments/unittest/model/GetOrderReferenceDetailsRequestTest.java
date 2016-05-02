package com.amazonservices.mws.offamazonpayments.unittest.model;


import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetOrderReferenceDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetOrderReferenceDetailsRequestTest extends ModelTest<GetOrderReferenceDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetOrderReferenceDetailsRequest.xml";
    }

    @Override
    protected Class<GetOrderReferenceDetailsRequest> getTestClassType() {
        return GetOrderReferenceDetailsRequest.class;
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
