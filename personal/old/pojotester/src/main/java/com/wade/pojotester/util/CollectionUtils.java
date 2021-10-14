/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The type Collection utils.
 */
@SuppressWarnings("unchecked")
public class CollectionUtils {
    /**
     * Instantiates a new Collection utils.
     */
    private CollectionUtils() {
    }

    /**
     * As list array list.
     *
     * @param <T>      the type parameter
     * @param elements the elements
     *
     * @return the array list
     */
    public static <T> ArrayList<T> asList(T... elements) {
	ArrayList<T> list = new ArrayList<>(elements.length);
	Collections.addAll(list, elements);
	return list;
    }

    /**
     * As set set.
     *
     * @param <T>      the type parameter
     * @param elements the elements
     *
     * @return the set
     */
    public static <T> Set<T> asSet(T... elements) {
	HashSet<T> list = new HashSet<>(elements.length);
	Collections.addAll(list, elements);
	return list;
    }

    /**
     * Is empty boolean.
     *
     * @param collection the collection
     *
     * @return the boolean
     */
    public static boolean isEmpty(Collection<?> collection) {
	return collection == null || collection.isEmpty();
    }

    /**
     * Is not empty boolean.
     *
     * @param collection the collection
     *
     * @return the boolean
     */
    public static boolean isNotEmpty(Collection<?> collection) {
	return !isEmpty(collection);
    }
}
