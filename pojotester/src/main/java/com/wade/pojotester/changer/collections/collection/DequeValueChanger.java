/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.Deque;
import java.util.LinkedList;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Deque value changer.
 */
class DequeValueChanger extends AbstractCollectionFieldValueChanger<Deque<?>> {
    /**
     * Increase value deque.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the deque
     */
    @Override
    protected Deque<?> increaseValue(Deque<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new LinkedList<>(CollectionUtils.asList(new Object()));
    }
}
