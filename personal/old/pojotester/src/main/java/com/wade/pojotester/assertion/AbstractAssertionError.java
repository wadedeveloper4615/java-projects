/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion;

import lombok.Getter;

/**
 * The type Abstract assertion error.
 */
@Getter
// @Setter
public abstract class AbstractAssertionError extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -5897168367474148416L;
    /**
     * The Tested cass.
     */
    protected Class<?> testedCass;

    /**
     * Instantiates a new Abstract assertion error.
     *
     * @param testedCass the tested cass
     */
    public AbstractAssertionError(Class<?> testedCass) {
	super();
	this.testedCass = testedCass;
	this.setStackTrace(new StackTraceElement[] {});
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    protected abstract String getDetailedMessage();

    /**
     * Gets error prefix.
     *
     * @return the error prefix
     */
    protected abstract String getErrorPrefix();

    /**
     * Gets message.
     *
     * @return the message
     */
    @Override
    public String getMessage() {
	return "\n\n\n" + this.getErrorPrefix() + "\n" + this.getDetailedMessage();
    }
}
