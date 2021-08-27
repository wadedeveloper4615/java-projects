/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections;

import java.lang.reflect.Array;
import java.util.Arrays;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Array value changer.
 */
class ArrayValueChanger extends AbstractFieldValueChanger<Object> {
    /**
     * Are different values boolean.
     *
     * @param sourceValue the source value
     * @param targetValue the target value
     * 
     * @return the boolean
     */
    @Override
    public boolean areDifferentValues(Object sourceValue, Object targetValue) {
	return !Arrays.deepEquals(new Object[] { sourceValue }, new Object[] { targetValue });
    }

    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.isArray();
    }

    /**
     * Increase value object.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the object
     */
    @Override
    protected Object increaseValue(Object value, Class<?> type) {
	return value == null ? Array.newInstance(type.getComponentType(), 0) : null;
    }
}
