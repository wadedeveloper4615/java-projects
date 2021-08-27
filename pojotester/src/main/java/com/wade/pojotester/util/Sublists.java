/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Sublists.
 */
public class Sublists {
    /**
     * Given a list of objects, return a list of sublists, i-th sublist includes i-th element of the original list and all elements that follow it in the original list. All returned lists are read-only and backed by a copy of the original list, so later changes in the original list will not affect the returned sublists.
     *
     * @param <T>  the type of list element
     * @param list list of objects
     *
     * @return sublists of list
     */
    public static <T> List<List<T>> subsequences(List<T> list) {
	List<T> copyOfList = new ArrayList<>(list);
	List<List<T>> result = new ArrayList<>();
	for (int i = 0; i < copyOfList.size(); i++) {
	    result.add(Collections.unmodifiableList(copyOfList.subList(i, copyOfList.size())));
	}
	return Collections.unmodifiableList(result);
    }

    /**
     * Instantiates a new sublists.
     */
    private Sublists() {
    }
}
