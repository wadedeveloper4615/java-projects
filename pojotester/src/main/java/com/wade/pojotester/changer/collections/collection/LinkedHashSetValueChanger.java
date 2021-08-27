/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.LinkedHashSet;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Linked hash set value changer.
 */
class LinkedHashSetValueChanger extends AbstractCollectionFieldValueChanger<LinkedHashSet<?>> {
    /**
     * Increase value linked hash set.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the linked hash set
     */
    @Override
    protected LinkedHashSet<?> increaseValue(LinkedHashSet<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new LinkedHashSet<>(CollectionUtils.asList(new Object()));
    }
}
