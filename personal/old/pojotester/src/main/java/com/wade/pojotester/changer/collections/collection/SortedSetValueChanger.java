/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.SortedSet;
import java.util.TreeSet;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Sorted set value changer.
 */
class SortedSetValueChanger extends AbstractCollectionFieldValueChanger<SortedSet<?>> {
    /**
     * Create tree set tree set.
     *
     * @return the tree set
     */
    private TreeSet<Object> createTreeSet() {
	TreeSet<Object> objects = new TreeSet<>();
	objects.add((Comparable<Object>) o -> 0);
	return objects;
    }

    /**
     * Increase value sorted set.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the sorted set
     */
    @Override
    protected SortedSet<?> increaseValue(SortedSet<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : createTreeSet();
    }
}
