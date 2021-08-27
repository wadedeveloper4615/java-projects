/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.iterators;

import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.collections4.IteratorUtils;

/**
 * The type Iterable value changer.
 */
class IterableValueChanger extends AbstractIteratorsFieldValueChanger<Iterable<?>> {
    /**
     * Are different values boolean.
     *
     * @param sourceValue the source value
     * @param targetValue the target value
     * 
     * @return the boolean
     */
    @Override
    public boolean areDifferentValues(Iterable<?> sourceValue, Iterable<?> targetValue) {
	if (sourceValue == targetValue) {
	    return false;
	}
	if (sourceValue == null || targetValue == null) {
	    return true;
	} else {
	    Object[] sourceValuesArray = IteratorUtils.toArray(sourceValue.iterator());
	    Object[] targetValuesArray = IteratorUtils.toArray(targetValue.iterator());
	    return !Arrays.deepEquals(sourceValuesArray, targetValuesArray);
	}
    }

    /**
     * Increase value iterable.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the iterable
     */
    @Override
    protected Iterable<?> increaseValue(Iterable<?> value, Class<?> type) {
	return value == null ? Collections.emptyList() : null;
    }
}
