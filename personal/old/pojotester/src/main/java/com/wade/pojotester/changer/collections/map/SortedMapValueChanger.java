/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The type Sorted map value changer.
 */
class SortedMapValueChanger extends AbstractMapFieldValueChanger<SortedMap<?, ?>> {
    /**
     * Increase value sorted map.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the sorted map
     */
    @Override
    protected SortedMap<?, ?> increaseValue(SortedMap<?, ?> value, Class<?> type) {
	return value == null ? new TreeMap<>() : null;
    }
}
