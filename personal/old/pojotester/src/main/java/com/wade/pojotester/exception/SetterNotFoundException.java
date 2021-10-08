/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.exception;

import java.lang.reflect.Field;

/**
 * The type Setter not found exception.
 */
public class SetterNotFoundException extends RuntimeException {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -8469208332648887179L;

    /**
     * Instantiates a new Setter not found exception.
     *
     * @param clazz the clazz
     * @param field the field
     */
    public SetterNotFoundException(Class<?> clazz, Field field) {
	super(String.format("Class %s has no setter for field %s", clazz.getCanonicalName(), field));
    }
}
