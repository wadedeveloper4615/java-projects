/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

/**
 * The type Impossible enum value change exception.
 */
public class ImpossibleEnumValueChangeException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 3198399120380044793L;

    /**
     * Instantiates a new Impossible enum value change exception.
     */
    public ImpossibleEnumValueChangeException() {
    }

    /**
     * Instantiates a new Impossible enum value change exception.
     *
     * @param type the type
     */
    public ImpossibleEnumValueChangeException(Class<?> type) {
	super("Enum with type '" + type.getName() + "' has no enum constants. The only value of field with this type is null.");
    }

    /**
     * Instantiates a new Impossible enum value change exception.
     *
     * @param message the message
     */
    public ImpossibleEnumValueChangeException(String message) {
	super(message);
    }

    /**
     * Instantiates a new Impossible enum value change exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ImpossibleEnumValueChangeException(String message, Throwable cause) {
	super(message, cause);
    }

    /**
     * Instantiates a new Impossible enum value change exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public ImpossibleEnumValueChangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new Impossible enum value change exception.
     *
     * @param cause the cause
     */
    public ImpossibleEnumValueChangeException(Throwable cause) {
	super(cause);
    }
}
