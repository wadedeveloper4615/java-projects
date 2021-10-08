/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

/**
 * The type Get or set value exception.
 */
public class GetOrSetValueException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 712688195522534181L;

    /**
     * Instantiates a new Get or set value exception.
     */
    public GetOrSetValueException() {
    }

    /**
     * Instantiates a new Get or set value exception.
     *
     * @param message the message
     */
    public GetOrSetValueException(String message) {
	super(message);
    }

    /**
     * Instantiates a new Get or set value exception.
     *
     * @param fieldName the field name
     * @param clazz     the clazz
     * @param cause     the cause
     */
    public GetOrSetValueException(String fieldName, Class<?> clazz, Exception cause) {
	super(createMessage(fieldName, clazz, cause.getMessage()), cause);
    }

    /**
     * Instantiates a new Get or set value exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public GetOrSetValueException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Instantiates a new Get or set value exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public GetOrSetValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Get or set value exception.
     *
     * @param cause the cause
     */
    public GetOrSetValueException(Throwable cause) {
	super(cause);
    }

    /**
     * Create message string.
     *
     * @param fieldName    the field name
     * @param clazz        the clazz
     * @param causeMessage the cause message
     *
     * @return the string
     */
    private static String createMessage(String fieldName, Class<?> clazz, String causeMessage) {
	return "Unable to get or set value for field '" + fieldName + "' in class '" + clazz + "'." + "\n Cause message: " + causeMessage;
    }
}
