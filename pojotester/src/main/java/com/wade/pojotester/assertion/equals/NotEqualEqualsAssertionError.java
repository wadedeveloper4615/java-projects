/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Not equal equals assertion error.
 */
@Getter
// @Setter
public class NotEqualEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 5358413034706717917L;
    /**
     * The constant CONSTRAINT_NOT_EQUAL.
     */
    private static String CONSTRAINT_NOT_EQUAL = "The equals method should return false if objects should not be equal.\n" + "Current implementation returns true.\n" + "Object:\n" + "%s\n" + "should not be equal to:\n" + "%s";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The Other object.
     */
    private Object otherObject;

    /**
     * Instantiates a new Not equal equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param testedObject the tested object
     * @param otherObject  the other object
     */
    public NotEqualEqualsAssertionError(Class<?> testedCass, Object testedObject, Object otherObject) {
	super(testedCass);
	this.testedObject = testedObject;
	this.otherObject = otherObject;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_NOT_EQUAL, testedObject, otherObject);
    }
}
