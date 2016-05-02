package com.amazonservices.mws.offamazonpayments.unittest.model;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import junit.framework.Assert;
import org.junit.Test;

import com.amazonservices.mws.offamazonpayments.model.AuthorizeOnBillingAgreementRequest;

import static junit.framework.Assert.assertNotNull;

public class AuthorizeOnBillingAgreementRequestTest extends ModelTest<AuthorizeOnBillingAgreementRequest>{

    @Override
    protected String getXMLTestFile(){
        return "AuthorizeOnBillingAgreementRequest.xml";
    }

    @Override
    protected Class<AuthorizeOnBillingAgreementRequest> getTestClassType() {
        return AuthorizeOnBillingAgreementRequest.class;
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
    public void toJsonFragmentShouldNotReturnNullForObjectWithAllFieldsPopulated() throws OffAmazonPaymentsServiceException {
        String jsonFragment = getTestClassObject().toJSONFragment();

        assertNotNull(jsonFragment);
    }
}