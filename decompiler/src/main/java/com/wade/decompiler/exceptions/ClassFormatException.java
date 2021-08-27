/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.exceptions;

/**
 * The Class ClassFormatException.
 */
public class ClassFormatException extends RuntimeException {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3569097343160139969L;

    /**
     * Instantiates a new class format exception.
     *
     * @param s the s
     */
    public ClassFormatException(String s) {
        super(s);
    }

    /**
     * Instantiates a new class format exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ClassFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new class format exception.
     *
     * @param cause the cause
     */
    public ClassFormatException(Throwable cause) {
        super(cause);
    }
}
