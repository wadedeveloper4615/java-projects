/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.List;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type List value changer.
 */
class ListValueChanger extends AbstractCollectionFieldValueChanger<List<?>> {
    /**
     * Increase value list.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the list
     */
    @Override
    protected List<?> increaseValue(List<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : CollectionUtils.asList(new Object());
    }
}
