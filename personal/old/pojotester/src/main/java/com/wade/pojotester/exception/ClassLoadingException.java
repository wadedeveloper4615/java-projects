/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

/**
 * The type Class loading exception.
 */
public class ClassLoadingException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -4827517490194492249L;

    /**
     * Instantiates a new Class loading exception.
     */
    public ClassLoadingException() {
    }

    /**
     * Instantiates a new Class loading exception.
     *
     * @param message the message
     */
    public ClassLoadingException(String message) {
	super(message);
    }

    /**
     * Instantiates a new Class loading exception.
     *
     * @param qualifiedClassName the qualified class name
     * @param cause              the cause
     */
    public ClassLoadingException(String qualifiedClassName, ClassNotFoundException cause) {
	super(createMessage(qualifiedClassName), cause);
    }

    /**
     * Instantiates a new Class loading exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ClassLoadingException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Instantiates a new Class loading exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ClassLoadingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Class loading exception.
     *
     * @param cause the cause
     */
    public ClassLoadingException(Throwable cause) {
	super(cause);
    }

    /**
     * Create message string.
     *
     * @param qualifiedClassName the qualified class name
     *
     * @return the string
     */
    private static String createMessage(String qualifiedClassName) {
	return String.format("Unable to load class %s", qualifiedClassName);
    }
}
