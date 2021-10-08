/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

/**
 * The type Tester instantiation exception.
 */
public class TesterInstantiationException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -3644415748800881211L;

    /**
     * Instantiates a new Tester instantiation exception.
     */
    public TesterInstantiationException() {
    }

    /**
     * Instantiates a new Tester instantiation exception.
     *
     * @param message the message
     */
    public TesterInstantiationException(String message) {
	super(message);
    }

    /**
     * Instantiates a new Tester instantiation exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public TesterInstantiationException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Instantiates a new Tester instantiation exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public TesterInstantiationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Tester instantiation exception.
     *
     * @param cause the cause
     */
    public TesterInstantiationException(Throwable cause) {
	super(cause);
    }
}
