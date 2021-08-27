/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.LinkedHashMap;

/**
 * The type Linked hash map value changer.
 */
class LinkedHashMapValueChanger extends AbstractMapFieldValueChanger<LinkedHashMap<?, ?>> {
    /**
     * Increase value linked hash map.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the linked hash map
     */
    @Override
    protected LinkedHashMap<?, ?> increaseValue(LinkedHashMap<?, ?> value, Class<?> type) {
	return value == null ? new LinkedHashMap<>() : null;
    }
}
