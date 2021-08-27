/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The Class NullEqualsAssertionError.
 */
@Getter
// @Setter
public class NullEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -6540510185583860734L;
    /**
     * The constant CONSTRAINT_NULL.
     */
    private static String CONSTRAINT_NULL = "The equals method should return false if object is comparing to null.\n" + "Current implementation returns true.";

    /**
     * Instantiates a new Null equals assertion error.
     *
     * @param testedCass the tested cass
     */
    public NullEqualsAssertionError(Class<?> testedCass) {
	super(testedCass);
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return CONSTRAINT_NULL;
    }
}
