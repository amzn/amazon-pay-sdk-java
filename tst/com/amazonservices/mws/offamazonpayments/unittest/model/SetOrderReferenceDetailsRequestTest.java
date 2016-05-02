package com.amazonservices.mws.offamazonpayments.unittest.model;


import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.SetOrderReferenceDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class SetOrderReferenceDetailsRequestTest extends ModelTest<SetOrderReferenceDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "SetOrderReferenceDetailsRequest.xml";
    }

    @Override
    protected Class<SetOrderReferenceDetailsRequest> getTestClassType() {
        return SetOrderReferenceDetailsRequest.class;
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
