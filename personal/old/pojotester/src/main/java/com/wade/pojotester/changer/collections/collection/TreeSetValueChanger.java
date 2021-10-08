/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.TreeSet;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Tree set value changer.
 */
class TreeSetValueChanger extends AbstractCollectionFieldValueChanger<TreeSet<?>> {
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
     * Increase value tree set.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the tree set
     */
    @Override
    protected TreeSet<?> increaseValue(TreeSet<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : createTreeSet();
    }
}
