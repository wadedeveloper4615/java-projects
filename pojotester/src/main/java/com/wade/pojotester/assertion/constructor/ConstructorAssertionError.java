/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.constructor;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.wade.pojotester.assertion.AbstractAssertionError;

import lombok.Getter;

/**
 * The type Constructor assertion error.
 */
@Getter
// @Setter
public class ConstructorAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -1436155669873178455L;
    /**
     * The constant INSTANTIATE_EXCEPTION.
     */
    private static String INSTANTIATE_EXCEPTION = "Constructor:\n" + "%s\n" + "of class:\n" + "%s\n" + "could not create instance with parameters:\n" + "%s\n" + "Root cause is:\n" + "%s";
    /**
     * The Constructor under assert.
     */
    private Constructor<?> constructorUnderAssert;
    /**
     * The Constructor parameters.
     */
    private Object[] constructorParameters;
    /**
     * The Cause.
     */
    private ReflectiveOperationException cause;

    /**
     * Instantiates a new Constructor assertion error.
     *
     * @param classUnderTest         the class under test
     * @param constructorUnderAssert the constructor under assert
     * @param constructorParameters  the constructor parameters
     * @param cause                  the cause
     */
    public ConstructorAssertionError(Class<?> classUnderTest, Constructor<?> constructorUnderAssert, Object[] constructorParameters, ReflectiveOperationException cause) {
	super(classUnderTest);
	this.constructorUnderAssert = constructorUnderAssert;
	this.cause = cause;
	this.constructorParameters = constructorParameters == null ? null : Arrays.copyOf(constructorParameters, constructorParameters.length);
    }

    /**
     * Create array content string string.
     *
     * @param array the array
     *
     * @return the string
     */
    private String createArrayContentString(Object... array) {
	if (array == null) {
	    return "<no parameters>";
	}
	return Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(", ", "[ ", " ]"));
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(INSTANTIATE_EXCEPTION, this.constructorUnderAssert, testedCass, this.createArrayContentString(this.constructorParameters), this.cause.getMessage());
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'constructor' method implementation.", testedCass.getCanonicalName());
    }
}
