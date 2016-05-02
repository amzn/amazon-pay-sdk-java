package com.amazonservices.mws.offamazonpayments.utilities;

import com.amazonservices.mws.offamazonpayments.requestclient.HttpRequestClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceClient;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceConfig;
import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.Matcher;
import org.hamcrest.collection.IsMapContaining;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static com.amazonservices.mws.offamazonpayments.utilities.ClassMatcher.isClass;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientOperationParamaterMappingTestBuilder {

    private final Class<?> requestClass;
    private final Class<?> responseClass;

    private final Object request;
    private final Object response;
    private final String operation;

    @Mock
    private OffAmazonPaymentsServiceConfig mockConfig;

    @Mock
    private HttpRequestClient mockHttpClient;

    private OffAmazonPaymentsServiceClient client;

    public ClientOperationParamaterMappingTestBuilder(String operation) throws Exception {
        initMocks(this);

        this.requestClass = Class.forName("com.amazonservices.mws.offamazonpayments.model." + operation + "Request");
        this.responseClass = Class.forName("com.amazonservices.mws.offamazonpayments.model." + operation + "Response");
        this.request = requestClass.newInstance();
        this.response = responseClass.newInstance();
        this.operation = operation;

        this.client = new OffAmazonPaymentsServiceClient(mockConfig, mockHttpClient);
    }

    public ClientOperationParamaterMappingTestBuilder validateMappingOfFieldWithValue(ParameterInformation parameterInformation, String value) throws Exception {
        requestClass.getMethod("set" + parameterInformation.getFieldName(), parameterInformation.getFieldType())
                .invoke(this.request, value);

        if (value == null) {
            expectAbsenseOfParameter(parameterInformation);
        } else {
            doReturn(response)
                    .when(mockHttpClient)
                    .invoke(argThat(isClass(this.responseClass)), argThat(hasEntry(parameterInformation.getFieldName(), value)));
        }
        return this;
    }

    public ClientOperationParamaterMappingTestBuilder expectAbsenseOfParameter(ParameterInformation parameterInformation) throws Exception {
        doReturn(response)
                .when(mockHttpClient)
                .invoke(argThat(isClass(this.responseClass)), argThat(not(hasKey(parameterInformation.getFieldName()))));
        return this;
    }

    public void performAssertion() throws Exception {

        Object actualResponse = null;
        try {
            actualResponse = this.client.getClass()
                    .getMethod(StringUtils.uncapitalize(operation), requestClass)
                    .invoke(this.client, request);
        } catch (InvocationTargetException ex) {
            throwOffAmazonPaymentsExceptionIfUnderlyingException(ex);
        }

        assertEquals("Test for operation " + this.operation + " failed", response, actualResponse);
    }

    private void throwOffAmazonPaymentsExceptionIfUnderlyingException(InvocationTargetException ex) throws Exception {
        if (ex.getCause() != null && ex.getCause() instanceof OffAmazonPaymentsServiceException) {
            throw (OffAmazonPaymentsServiceException)ex.getCause();
        }
    }

    /*
     * Use a helper for the key matcher to avoid a compile error on when trying
     * to set expectations for arguments.
     * Value argument needs to be forced to the specific type as hamcrest has a
     * any() matcher for value, causing compile errors.
     */
    private static Matcher<Map<String, String>> hasKey(String expectedKeyName) {
        return IsMapContaining.<String, String>hasKey(expectedKeyName);
    }
}
