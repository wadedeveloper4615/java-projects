/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.setter;

import java.lang.reflect.Field;

import com.wade.pojotester.assertion.AbstractAssertionError;

import lombok.Getter;

/**
 * The type Setter assertion error.
 */
@Getter
// @Setter
public class SetterAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -4911555145961581871L;
    /**
     * The constant CONSTRAINT_SETTER.
     */
    private static String CONSTRAINT_SETTER = "The setter method for field '%s' should set field value.\n" + "Current implementation does not set the value.\n" + "Expected value:\n" + "%s\n" + "but was:\n" + "%s";
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
     * Instantiates a new Setter assertion error.
     *
     * @param testedCass    the tested cass
     * @param field         the field
     * @param expectedValue the expected value
     * @param currentValue  the current value
     */
    public SetterAssertionError(Class<?> testedCass, Field field, Object expectedValue, Object currentValue) {
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
	return String.format(CONSTRAINT_SETTER, field, expectedValue, currentValue);
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'setter' method implementation.", testedCass.getCanonicalName());
    }
}
