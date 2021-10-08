/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.collections4.IteratorUtils;

/**
 * The type Iterator value changer.
 */
class IteratorValueChanger extends AbstractIteratorsFieldValueChanger<Iterator<?>> {
    /**
     * Are different values boolean.
     *
     * @param sourceValue the source value
     * @param targetValue the target value
     * 
     * @return the boolean
     */
    @Override
    public boolean areDifferentValues(Iterator<?> sourceValue, Iterator<?> targetValue) {
	if (sourceValue == targetValue) {
	    return false;
	}
	if (sourceValue == null || targetValue == null) {
	    return true;
	} else {
	    Object[] sourceValuesArray = IteratorUtils.toArray(sourceValue);
	    Object[] targetValuesArray = IteratorUtils.toArray(targetValue);
	    return !Arrays.deepEquals(sourceValuesArray, targetValuesArray);
	}
    }

    /**
     * Increase value iterator.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the iterator
     */
    @Override
    protected Iterator<?> increaseValue(Iterator<?> value, Class<?> type) {
	return value == null ? Collections.emptyList().iterator() : null;
    }
}
