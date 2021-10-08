/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.getter;

import java.lang.reflect.Field;

import com.wade.pojotester.assertion.AbstractAssertionError;

import lombok.Getter;

/**
 * The type Getter assertion error.
 */
@Getter
// @Setter
public class GetterAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 6648116051195548425L;
    /**
     * The constant CONSTRAINT_GETTER.
     */
    private static String CONSTRAINT_GETTER = "The getter method for field '%s' should return field value.\n" + "Current implementation returns different value.\n" + "Expected value:\n" + "%s\n" + "but was:\n" + "%s";
    /**
     * The Field.
     */
    private Field field;
    /**
     * The Expected value.
     */
    private Object expectedValue;
    /**
     * The Current value.
     */
    private Object currentValue;

    /**
     * Instantiates a new Getter assertion error.
     *
     * @param testedCass    the tested cass
     * @param field         the field
     * @param expectedValue the expected value
     * @param currentValue  the current value
     */
    public GetterAssertionError(Class<?> testedCass, Field field, Object expectedValue, Object currentValue) {
	super(testedCass);
	this.field = field;
	this.expectedValue = expectedValue;
	this.currentValue = currentValue;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_GETTER, field, expectedValue, currentValue);
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'getter' method implementation.", testedCass.getCanonicalName());
    }
}
