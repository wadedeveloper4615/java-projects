/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import com.wade.pojotester.assertion.AbstractAssertionError;

// TODO: Auto-generated Javadoc
/**
 * The type Abstract equals assertion error.
 */
public abstract class AbstractEqualsAssertionError extends AbstractAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 2074111960051208101L;

    /**
     * Instantiates a new Abstract equals assertion error.
     *
     * @param testedCass the tested cass
     */
    AbstractEqualsAssertionError(Class<?> testedCass) {
	super(testedCass);
    }

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    @Override
    protected String getErrorPrefix() {
	return String.format("Class %s has bad 'equals' method implementation.", testedCass.getCanonicalName());
    }
}
