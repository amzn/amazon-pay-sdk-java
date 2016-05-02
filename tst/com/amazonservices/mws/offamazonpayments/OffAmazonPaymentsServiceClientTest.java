package com.amazonservices.mws.offamazonpayments;

import com.amazonservices.mws.offamazonpayments.utilities.ClientOperationParamaterMappingTestBuilder;
import com.amazonservices.mws.offamazonpayments.utilities.Operation;
import org.junit.Test;

import static com.amazonservices.mws.offamazonpayments.utilities.ParameterInformation.*;

public class OffAmazonPaymentsServiceClientTest {

    private static final String MWS_AUTH_TOKEN_VALUE = "testMWSAuthToken";
    private static final String SELLER_ID_VALUE = "testSellerId";

    @Test
    public void ParametersForAllOperationsShouldIncludeMWSAuthTokenFieldIfSetInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .validateMappingOfFieldWithValue(MWS_AUTH_TOKEN, MWS_AUTH_TOKEN_VALUE)
                    .performAssertion();
        }
    }

    @Test
    public void ParametersForAllOperationsShouldNotIncludeMWSAuthTokenFieldIfNotSetInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .expectAbsenseOfParameter(MWS_AUTH_TOKEN)
                    .performAssertion();
        }
    }

    @Test
    public void ParametersForAllOperationsShouldNotIncludeMWSAuthTokenFieldIfSetToNullInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .validateMappingOfFieldWithValue(MWS_AUTH_TOKEN, null)
                    .performAssertion();
        }
    }

    @Test
    public void ParametersForAllOperationsShouldIncludeSellerIDFieldIfSetInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .validateMappingOfFieldWithValue(SELLER_ID, SELLER_ID_VALUE)
                    .performAssertion();
        }
    }

    @Test
    public void ParametersForAllOperationsShouldNotIncludeSellerIDFieldIfNotSetInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .expectAbsenseOfParameter(SELLER_ID)
                    .performAssertion();
        }
    }

    @Test
    public void ParametersForAllOperationsShouldNotIncludeSellerIDFieldIfSetToNullInRequestObject() throws Exception {
        for (Operation operation : Operation.values()) {
            new ClientOperationParamaterMappingTestBuilder(operation.toString())
                    .validateMappingOfFieldWithValue(SELLER_ID, null)
                    .performAssertion();
        }
    }
}
