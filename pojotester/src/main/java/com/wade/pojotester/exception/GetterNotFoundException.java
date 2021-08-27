/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

import java.lang.reflect.Field;

/**
 * The type Getter not found exception.
 */
public class GetterNotFoundException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -2565642284185639808L;

    /**
     * Instantiates a new Getter not found exception.
     *
     * @param clazz the clazz
     * @param field the field
     */
    public GetterNotFoundException(Class<?> clazz, Field field) {
	super(String.format("Class %s has no getter for field %s", clazz.getCanonicalName(), field));
    }
}
