/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.ArrayList;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Array list value changer.
 */
class ArrayListValueChanger extends AbstractCollectionFieldValueChanger<ArrayList<?>> {
    /**
     * Increase value array list.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the array list
     */
    @Override
    protected ArrayList<?> increaseValue(ArrayList<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : CollectionUtils.asList(new Object());
    }
}
