package com.amazonservices.mws.offamazonpayments.common;

import com.amazonservices.mws.offamazonpayments.OffAmazonPaymentsServiceException;
import com.amazonservices.mws.offamazonpayments.model.Address;
import com.amazonservices.mws.offamazonpayments.model.Destination;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class ReflectionFragmentBuilderTest {

    private FragmentBuilder mockFragmentBuilder;

    @Before
    public void setUp() {
        mockFragmentBuilder = Mockito.mock(FragmentBuilder.class);
    }

    @Test
    public void shouldReturnStringForObjectWithProperties() throws Exception {
        TestObj testObj = new TestObj("value1");
        assertObjectIsMarshelledForString(testObj);
    }

    @Test
    public void shouldReturnStringForObjectWithBlankProperties() throws Exception {
        ClassWithNoProperties testObj = new ClassWithNoProperties();
        assertObjectIsMarshelledForString(testObj);
    }

    @Test
    public void shouldCallAddHeadersIfHeaderModifierIsUsed() throws Exception {
        TestObj testObj = new TestObj("value1");
        String expectedValue = "Test string";

        given(mockFragmentBuilder.build()).willReturn(expectedValue);

        String value = new ReflectionFragmentBuilder(testObj, mockFragmentBuilder).withHeaders().build();

        verify(mockFragmentBuilder).addHeaderFieldWith(TestObj.class.getSimpleName());
    }

    @Test
    public void shouldConvertClassWithListField() throws Exception {
        TestWithArray testObj = new TestWithArray();
        String expectedValue = "Test string";

        given(mockFragmentBuilder.build()).willReturn(expectedValue);

        String value = new ReflectionFragmentBuilder(testObj, mockFragmentBuilder).build();

        verify(mockFragmentBuilder).addCollectionHeader("Arr");
        verify(mockFragmentBuilder, Mockito.times(2))
                .addCollectionValue(Mockito.eq("Arr"), Mockito.any(TestObjWithBoolean.class));
        verify(mockFragmentBuilder).closeCollectionHeader("Arr");
    }

    @Test
    public void shouldUseIsInsteadOfGetForBooleanType() throws Exception {
        TestObjWithBoolean testObj = new TestObjWithBoolean(Boolean.TRUE, true);
        assertObjectIsMarshelledForString(testObj);
    }

    @Test(expected = OffAmazonPaymentsServiceException.class)
    public void shouldThrowExceptionIfAnnotationCannotBeFound() throws Exception {
        Integer intg = Integer.valueOf(12);

        new ReflectionFragmentBuilder(intg, null).build();
    }

    @Test(expected = OffAmazonPaymentsServiceException.class)
    public void shouldThrowExceptionIfObjectDoesNotHaveGetterProperty() throws Exception {
        MissingPropertyObj missingPropertyObj = new MissingPropertyObj();

        new ReflectionFragmentBuilder(missingPropertyObj, mockFragmentBuilder).build();
    }

    @Test(expected = OffAmazonPaymentsServiceException.class)
    public void shouldThrowExceptionIfObjectGetterIsPrivate() throws Exception {
        IllegalAccessObj illegalAccessObj = new IllegalAccessObj();

        new ReflectionFragmentBuilder(illegalAccessObj, mockFragmentBuilder).build();
    }

    @Test(expected = OffAmazonPaymentsServiceException.class)
    public void shouldThrowExceptionIfObjectGetterThrowsException() throws Exception {
        GetterExceptionObj getterExceptionObj = new GetterExceptionObj();

        new ReflectionFragmentBuilder(getterExceptionObj, mockFragmentBuilder).build();
    }

    private void assertObjectIsMarshelledForString(Object testObj) throws OffAmazonPaymentsServiceException {
        String expectedValue = "Test string";

        given(mockFragmentBuilder.build()).willReturn(expectedValue);

        String value = new ReflectionFragmentBuilder(testObj, mockFragmentBuilder).build();

        assertEquals(value, expectedValue);
    }

    @XmlType(name = "TestObj", propOrder = {
            "field1"
    })
    private class TestObj {

        private String field1;

        public TestObj(String field1) {
            this.field1 = field1;
        }

        public String getField1() {
            return this.field1;
        }
    }

    @XmlType(name = "SubObj", propOrder = {
            "field1"
    })
    private class MissingPropertyObj {

    }

    @XmlType(name = "SubObj", propOrder= {
            "fieldb",
            "fieldc"
    })
    private class TestObjWithBoolean {

        private Boolean fieldb;
        private boolean fieldc;

        public TestObjWithBoolean(Boolean fieldb, boolean fieldc) {
            this.fieldb = fieldb;
            this.fieldc = fieldc;
        }

        public Boolean isFieldb() {
            return fieldb;
        }

        public boolean isFieldc() {
            return fieldc;
        }
    }

    @XmlType(name = "test", propOrder = {
            "arr"
    })
    private class TestWithArray {
        private List<TestObjWithBoolean> arr;

        public TestWithArray() {
            arr = new ArrayList<TestObjWithBoolean>();
            arr.add(new TestObjWithBoolean(Boolean.TRUE, false));
            arr.add(new TestObjWithBoolean(Boolean.FALSE, true));
        }

        public List<TestObjWithBoolean> getArr() {
            return arr;
        }
    }

    @XmlType(name = "SubObj", propOrder= {
            "field3"
    })
    private class IllegalAccessObj {
        private String getField3() {
            return "test";
        }
    }

    @XmlType(name = "SubObj", propOrder= {
            "field3"
    })
    private class GetterExceptionObj {
        private String getField3() {
            throw new IllegalArgumentException();
        }
    }

    @XmlType(name = "", propOrder = {""})
    private class ClassWithNoProperties {

    }
}