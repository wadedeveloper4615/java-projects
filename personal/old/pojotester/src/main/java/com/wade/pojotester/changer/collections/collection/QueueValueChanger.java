/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.LinkedList;
import java.util.Queue;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Queue value changer.
 */
class QueueValueChanger extends AbstractCollectionFieldValueChanger<Queue<?>> {
    /**
     * Increase value queue.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the queue
     */
    @Override
    protected Queue<?> increaseValue(Queue<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new LinkedList<>(CollectionUtils.asList(new Object()));
    }
}
