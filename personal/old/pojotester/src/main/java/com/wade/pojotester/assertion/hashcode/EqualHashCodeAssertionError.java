/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import lombok.Getter;

/**
 * The type Equal hash code assertion error.
 */
@Getter
// @Setter
public class EqualHashCodeAssertionError extends AbstractHashCodeAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -2686737608793321829L;
    /**
     * The constant CONSTRAINT_EQUAL.
     */
    private static String CONSTRAINT_EQUAL = "The hashCode method should return same hash code for equal objects.\n" + "Current implementation returns different values.\n" + "Object:\n" + "%s\n" + "and\n" + "%s\n" + "have two different hash codes:\n" + "%s\n" + "and\n" + "%s";
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
     * Instantiates a new Equal hash code assertion error.
     *
     * @param testedCass     the tested cass
     * @param testedObject   the tested object
     * @param secondObject   the second object
     * @param firstHashCode  the first hash code
     * @param secondHashCode the second hash code
     */
    public EqualHashCodeAssertionError(Class<?> testedCass, Object testedObject, Object secondObject, int firstHashCode, int secondHashCode) {
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
	return String.format(CONSTRAINT_EQUAL, testedObject, secondObject, firstHashCode, secondHashCode);
    }
}
