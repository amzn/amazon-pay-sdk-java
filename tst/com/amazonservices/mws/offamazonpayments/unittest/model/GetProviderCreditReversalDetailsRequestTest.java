package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetProviderCreditReversalDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetProviderCreditReversalDetailsRequestTest extends ModelTest<GetProviderCreditReversalDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetProviderCreditReversalDetailsRequest.xml";
    }

    @Override
    protected Class<GetProviderCreditReversalDetailsRequest> getTestClassType() {
        return GetProviderCreditReversalDetailsRequest.class;
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
