package com.amazonservices.mws.offamazonpayments.unittest.model;

import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.GetBillingAgreementDetailsRequest;

import static junit.framework.Assert.assertNotNull;

public class GetBillingAgreementDetailsRequestTest extends ModelTest<GetBillingAgreementDetailsRequest>{

    @Override
    protected String getXMLTestFile(){
        return "GetBillingAgreementDetailsRequest.xml";
    }

    @Override
    protected Class<GetBillingAgreementDetailsRequest> getTestClassType() {
        return GetBillingAgreementDetailsRequest.class;
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