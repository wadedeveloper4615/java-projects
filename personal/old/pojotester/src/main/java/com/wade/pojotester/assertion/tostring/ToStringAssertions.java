/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import org.apache.commons.lang3.ObjectUtils;

/**
 * The type To string assertions.
 */
public class ToStringAssertions {
    /**
     * The Object under assert.
     */
    private Object objectUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new To string assertions.
     *
     * @param objectUnderAssert the object under assert
     */
    public ToStringAssertions(Object objectUnderAssert) {
	this.objectUnderAssert = objectUnderAssert;
	classUnderTest = objectUnderAssert.getClass();
    }

    /**
     * Check result.
     *
     * @param pass         the pass
     * @param errorToThrow the error to throw
     */
    private void checkResult(boolean pass, AbstractToStringAssertionError errorToThrow) {
	if (!pass) {
	    throw errorToThrow;
	}
    }

    /**
     * Contains.
     *
     * @param fieldName the field name
     * @param value     the value
     */
    public void contains(String fieldName, Object value) {
	String stringValue = fieldName + "=" + getStringOf(value);
	String toString = objectUnderAssert.toString();
	boolean result = toString.contains(stringValue);
	checkResult(result, new ContainsToStringAssertionError(classUnderTest, stringValue, toString));
    }

    /**
     * Doest not contain.
     *
     * @param fieldName the field name
     * @param value     the value
     */
    public void doestNotContain(String fieldName, Object value) {
	String stringValue = fieldName + "=" + getStringOf(value);
	String toString = objectUnderAssert.toString();
	boolean result = toString.contains(stringValue);
	checkResult(!result, new NotContainToStringAssertionError(classUnderTest, stringValue, toString));
    }

    /**
     * Gets string of.
     *
     * @param value the value
     * 
     * @return the string of
     */
    private String getStringOf(Object value) {
	Object notNullObject = ObjectUtils.defaultIfNull(value, "");
	return notNullObject.toString();
    }
}
