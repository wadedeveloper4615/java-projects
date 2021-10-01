/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Consistent equals assertion error.
 */
@Getter
// @Setter
class ConsistentEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -3212411475274738678L;
    /**
     * The constant CONSTRAINT_CONSISTENT.
     */
    private static String CONSTRAINT_CONSISTENT = "The equals method should be consistent when comparing same objects multiple " + "times.\n" + "Current implementation returns different results.\n" + "When comparing object:\n" + "%s\n" + "to itself, first result was '%s' and second time was '%s'.";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The First result.
     */
    private Boolean firstResult;
    /**
     * The Second result.
     */
    private Boolean secondResult;

    /**
     * Instantiates a new Consistent equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param testedObject the tested object
     * @param firstResult  the first result
     * @param secondResult the second result
     */
    public ConsistentEqualsAssertionError(Class<?> testedCass, Object testedObject, boolean firstResult, boolean secondResult) {
	super(testedCass);
	this.testedObject = testedObject;
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
	return String.format(CONSTRAINT_CONSISTENT, testedObject, firstResult, secondResult);
    }
}
