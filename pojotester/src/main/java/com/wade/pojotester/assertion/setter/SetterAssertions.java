/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.setter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import com.wade.pojotester.exception.GetOrSetValueException;
import com.wade.pojotester.util.FieldUtils;

import lombok.Getter;

/**
 * The type Setter assertions.
 */
@Getter
// @Setter
public class SetterAssertions {
    /**
     * The Object under assert.
     */
    private Object objectUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new Setter assertions.
     *
     * @param objectUnderAssert the object under assert
     */
    public SetterAssertions(Object objectUnderAssert) {
	this.objectUnderAssert = objectUnderAssert;
	this.classUnderTest = objectUnderAssert.getClass();
    }

    /**
     * Check result.
     *
     * @param pass         the pass
     * @param errorToThrow the error to throw
     */
    protected void checkResult(boolean pass, SetterAssertionError errorToThrow) {
	if (!pass) {
	    throw errorToThrow;
	}
    }

    /**
     * Will set value on field.
     *
     * @param setter        the setter
     * @param field         the field
     * @param expectedValue the expected value
     */
    public void willSetValueOnField(Method setter, Field field, Object expectedValue) {
	try {
	    setter.setAccessible(true);
	    setter.invoke(objectUnderAssert, expectedValue);
	    Object value = FieldUtils.getValue(objectUnderAssert, field);
	    boolean result = Objects.deepEquals(value, expectedValue);
	    checkResult(result, new SetterAssertionError(classUnderTest, field, expectedValue, value));
	} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
	    throw new GetOrSetValueException(field.getName(), classUnderTest, e);
	}
    }
}
