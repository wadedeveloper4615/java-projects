/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import com.wade.pojotester.assertion.AbstractAssertionError;

import lombok.Getter;

/**
 * The type Abstract to string assertion error.
 */
@Getter
// @Setter
public abstract class AbstractToStringAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -1430389650581654527L;

    /**
     * Instantiates a new Abstract to string assertion error.
     *
     * @param testedCass the tested cass
     */
    public AbstractToStringAssertionError(Class<?> testedCass) {
	super(testedCass);
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'toString' method implementation.", testedCass.getCanonicalName());
    }
}
