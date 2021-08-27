/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.LinkedList;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Linked list value changer.
 */
class LinkedListValueChanger extends AbstractCollectionFieldValueChanger<LinkedList<?>> {
    /**
     * Increase value linked list.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the linked list
     */
    @Override
    protected LinkedList<?> increaseValue(LinkedList<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new LinkedList<>(CollectionUtils.asList(new Object()));
    }
}
