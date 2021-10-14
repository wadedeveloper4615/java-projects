/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

import java.util.Arrays;

/**
 * The type Object instantiation exception.
 */
public class ObjectInstantiationException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 4427684952522983892L;

    /**
     * Instantiates a new Object instantiation exception.
     *
     * @param clazz   the clazz
     * @param message the message
     */
    public ObjectInstantiationException(Class<?> clazz, String message) {
	this(clazz, message, null);
    }

    /**
     * Instantiates a new Object instantiation exception.
     *
     * @param clazz          the clazz
     * @param message        the message
     * @param parameterTypes the parameter types
     * @param parameters     the parameters
     * @param cause          the cause
     */
    public ObjectInstantiationException(Class<?> clazz, String message, Class<?>[] parameterTypes, Object[] parameters, Throwable cause) {
	this(clazz, message + " " + createMessage(parameterTypes, parameters), cause);
    }

    /**
     * Instantiates a new Object instantiation exception.
     *
     * @param clazz   the clazz
     * @param message the message
     * @param cause   the cause
     */
    public ObjectInstantiationException(Class<?> clazz, String message, Throwable cause) {
	super(createMessage(clazz) + " " + message, cause);
    }

    /**
     * Create message string.
     *
     * @param clazz the clazz
     *
     * @return the string
     */
    private static String createMessage(Class<?> clazz) {
	return "Unable to create object for class: " + clazz;
    }

    /**
     * Create message string.
     *
     * @param parameterTypes the parameter types
     * @param parameters     the parameters
     *
     * @return the string
     */
    private static String createMessage(Class<?>[] parameterTypes, Object[] parameters) {
	return "Parameter types are " + Arrays.toString(parameterTypes) + " and parameters are " + Arrays.toString(parameters);
    }
}
