/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.Collections;
import java.util.Map;

/**
 * The type Map value changer.
 */
class MapValueChanger extends AbstractMapFieldValueChanger<Map<?, ?>> {
    /**
     * Increase value map.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the map
     */
    @Override
    protected Map<?, ?> increaseValue(Map<?, ?> value, Class<?> type) {
	return value == null ? Collections.emptyMap() : null;
    }
}
