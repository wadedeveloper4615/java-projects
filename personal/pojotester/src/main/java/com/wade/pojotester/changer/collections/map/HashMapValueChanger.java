/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.HashMap;

/**
 * The type Hash map value changer.
 */
class HashMapValueChanger extends AbstractMapFieldValueChanger<HashMap<?, ?>> {
    /**
     * Increase value hash map.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the hash map
     */
    @Override
    protected HashMap<?, ?> increaseValue(HashMap<?, ?> value, Class<?> type) {
	return value == null ? new HashMap<>() : null;
    }
}
