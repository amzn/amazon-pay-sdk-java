package com.amazonservices.mws.offamazonpayments.utilities;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class ClassMatcher<T> extends BaseMatcher<Class<T>> {

    private final Class<T> targetClass;

    public ClassMatcher(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean matches(Object obj) {
        if (obj != null) {
            if (obj instanceof Class) {
                return targetClass.equals(obj);
            }
        }

        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Matches a class");
    }

    public static <T> ClassMatcher<T> isClass(Class<T> targetClass) {
        return new ClassMatcher<T>(targetClass);
    }
}
