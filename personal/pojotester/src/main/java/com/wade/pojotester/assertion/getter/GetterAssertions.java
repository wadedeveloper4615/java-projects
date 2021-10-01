/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.getter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import com.wade.pojotester.exception.GetOrSetValueException;
import com.wade.pojotester.util.FieldUtils;

import lombok.Getter;

/**
 * The type Getter assertions.
 */
@Getter
// @Setter
public class GetterAssertions {
    /**
     * The Object under assert.
     */
    private Object objectUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new Getter assertions.
     *
     * @param objectUnderAssert the object under assert
     */
    public GetterAssertions(Object objectUnderAssert) {
	this.objectUnderAssert = objectUnderAssert;
	this.classUnderTest = objectUnderAssert.getClass();
    }

    /**
     * Check result.
     *
     * @param pass         the pass
     * @param errorToThrow the error to throw
     */
    protected void checkResult(boolean pass, GetterAssertionError errorToThrow) {
	if (!pass) {
	    throw errorToThrow;
	}
    }

    /**
     * Will get value from field.
     *
     * @param getter the getter
     * @param field  the field
     */
    public void willGetValueFromField(Method getter, Field field) {
	try {
	    getter.setAccessible(true);
	    Object valueFromGetter = getter.invoke(objectUnderAssert);
	    Object value = FieldUtils.getValue(objectUnderAssert, field);
	    boolean result = Objects.deepEquals(value, valueFromGetter);
	    checkResult(result, new GetterAssertionError(classUnderTest, field, valueFromGetter, value));
	} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
	    throw new GetOrSetValueException(field.getName(), classUnderTest, e);
	}
    }
}
