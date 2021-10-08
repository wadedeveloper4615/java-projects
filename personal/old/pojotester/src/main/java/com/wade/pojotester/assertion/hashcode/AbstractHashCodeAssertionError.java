/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import com.wade.pojotester.assertion.AbstractAssertionError;

import lombok.Getter;

/**
 * The type Abstract hash code assertion error.
 */
@Getter
// @Setter
public abstract class AbstractHashCodeAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 8812554061837249715L;

    /**
     * Instantiates a new Abstract hash code assertion error.
     *
     * @param testedCass the tested cass
     */
    AbstractHashCodeAssertionError(Class<?> testedCass) {
	super(testedCass);
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'hashCode' method implementation.", testedCass.getCanonicalName());
    }
}
