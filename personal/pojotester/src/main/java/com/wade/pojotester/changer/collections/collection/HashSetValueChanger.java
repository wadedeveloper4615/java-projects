/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.HashSet;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Hash set value changer.
 */
class HashSetValueChanger extends AbstractCollectionFieldValueChanger<HashSet<?>> {
    /**
     * Increase value hash set.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the hash set
     */
    @Override
    protected HashSet<?> increaseValue(HashSet<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new HashSet<>(CollectionUtils.asList(new Object()));
    }
}
