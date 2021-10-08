/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import lombok.Getter;

/**
 * The type Consistent hash code assertion error.
 */
@Getter
// @Setter
public class ConsistentHashCodeAssertionError extends AbstractHashCodeAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 7563377338473071153L;
    /**
     * The constant CONSTRAINT_CONSISTENT.
     */
    private static String CONSTRAINT_CONSISTENT = "The hashCode method should return same hash code for same object.\n" + "Current implementation returns different values.\n" + "Object:\n" + "%s\n" + "has two different hash codes:\n" + "%s\n" + "and" + "\n%s";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The First hash code.
     */
    private Integer firstHashCode;
    /**
     * The Second hash code.
     */
    private Integer secondHashCode;

    /**
     * Instantiates a new Consistent hash code assertion error.
     *
     * @param testedCass     the tested cass
     * @param testedObject   the tested object
     * @param firstHashCode  the first hash code
     * @param secondHashCode the second hash code
     */
    public ConsistentHashCodeAssertionError(Class<?> testedCass, Object testedObject, int firstHashCode, int secondHashCode) {
	super(testedCass);
	this.testedObject = testedObject;
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
	return String.format(CONSTRAINT_CONSISTENT, testedObject, firstHashCode, secondHashCode);
    }
}
