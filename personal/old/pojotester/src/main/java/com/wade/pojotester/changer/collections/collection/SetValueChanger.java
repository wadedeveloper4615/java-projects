/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.HashSet;
import java.util.Set;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Set value changer.
 */
class SetValueChanger extends AbstractCollectionFieldValueChanger<Set<?>> {
    /**
     * Increase value set.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the set
     */
    @Override
    protected Set<?> increaseValue(Set<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new HashSet<>(CollectionUtils.asList(new Object()));
    }
}
