/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.TreeMap;

/**
 * The type Tree map value changer.
 */
class TreeMapValueChanger extends AbstractMapFieldValueChanger<TreeMap<?, ?>> {
    /**
     * Increase value tree map.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the tree map
     */
    @Override
    protected TreeMap<?, ?> increaseValue(TreeMap<?, ?> value, Class<?> type) {
	return value == null ? new TreeMap<>() : null;
    }
}
