/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import lombok.Getter;

/**
 * The type Not equal hash code assertion error.
 */
@Getter
// @Setter
public class NotEqualHashCodeAssertionError extends AbstractHashCodeAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -6156500185218454454L;
    /**
     * The constant CONSTRAINT_NOT_EQUAL.
     */
    private static String CONSTRAINT_NOT_EQUAL = "The hashCode method should return different hash codes for non equal objects.\n" + "Current implementation returns same hash codes.\n" + "Object:\n" + "%s\n" + "and\n" + "%s\n" + "should have different hash codes:\n" + "%s\n" + "and\n" + "%s";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The Second object.
     */
    private Object secondObject;
    /**
     * The First hash code.
     */
    private Integer firstHashCode;
    /**
     * The Second hash code.
     */
    private Integer secondHashCode;

    /**
     * Instantiates a new Not equal hash code assertion error.
     *
     * @param testedCass     the tested cass
     * @param testedObject   the tested object
     * @param secondObject   the second object
     * @param firstHashCode  the first hash code
     * @param secondHashCode the second hash code
     */
    public NotEqualHashCodeAssertionError(Class<?> testedCass, Object testedObject, Object secondObject, int firstHashCode, int secondHashCode) {
	super(testedCass);
	this.testedObject = testedObject;
	this.secondObject = secondObject;
	this.firstHashCode = firstHashCode;
	this.secondHashCode = secondHashCode;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_NOT_EQUAL, testedObject, secondObject, firstHashCode, secondHashCode);
    }
}
