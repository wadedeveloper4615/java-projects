/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections;

import java.util.Arrays;
import java.util.stream.Stream;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Stream value changer.
 */
public class StreamValueChanger extends AbstractFieldValueChanger<Stream<?>> {
    /**
     * Are different values boolean.
     *
     * @param sourceValue the source value
     * @param targetValue the target value
     * 
     * @return the boolean
     */
    @Override
    public boolean areDifferentValues(Stream<?> sourceValue, Stream<?> targetValue) {
	if (sourceValue == targetValue) {
	    return false;
	}
	if (sourceValue == null || targetValue == null) {
	    return true;
	} else {
	    Object[] sourceValuesArray = sourceValue.toArray();
	    Object[] targetValuesArray = targetValue.toArray();
	    return !Arrays.deepEquals(sourceValuesArray, targetValuesArray);
	}
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
	return type.isAssignableFrom(getGenericTypeClass());
    }

    /**
     * Increase value stream.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the stream
     */
    @Override
    protected Stream<?> increaseValue(Stream<?> value, Class<?> type) {
	return value == null ? Stream.empty() : null;
    }
}
