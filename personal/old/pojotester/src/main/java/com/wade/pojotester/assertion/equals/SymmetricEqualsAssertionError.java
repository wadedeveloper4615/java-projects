/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Symmetric equals assertion error.
 */
@Getter
// @Setter
public class SymmetricEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 1818438535751131021L;
    /**
     * The constant CONSTRAINT_SYMMETRIC.
     */
    private static String CONSTRAINT_SYMMETRIC = "The equals method should return true for both a.equals(b) and b.equals(a).\n" + "Current implementation returns:\n" + "%s for a.equals(b),\n" + "%s for b.equals(a),\n" + "where 'a' is:\n" + "%s\n" + "and 'b' is:\n" + "%s";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The Other object.
     */
    private Object otherObject;
    /**
     * The First result.
     */
    private Boolean firstResult;
    /**
     * The Second result.
     */
    private Boolean secondResult;

    /**
     * Instantiates a new Symmetric equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param testedObject the tested object
     * @param otherObject  the other object
     * @param firstResult  the first result
     * @param secondResult the second result
     */
    public SymmetricEqualsAssertionError(Class<?> testedCass, Object testedObject, Object otherObject, boolean firstResult, boolean secondResult) {
	super(testedCass);
	this.testedObject = testedObject;
	this.otherObject = otherObject;
	this.firstResult = firstResult;
	this.secondResult = secondResult;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_SYMMETRIC, firstResult, secondResult, testedObject, otherObject);
    }
}
