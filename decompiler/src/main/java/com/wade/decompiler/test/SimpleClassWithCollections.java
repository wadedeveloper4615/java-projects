/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class SimpleClassWithCollections.
 */
@SuppressWarnings("unused")
public class SimpleClassWithCollections implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -4923246191464764029L;

    /** The list. */
    private List<String> list = new ArrayList<>();

    /** The list 2. */
    private Map<Integer, String> list2 = new HashMap<>();

    /**
     * Instantiates a new simple class with collections.
     *
     * @param list the list
     */
    public SimpleClassWithCollections(List<String> list) {
        this.list = list;
    }

    /**
     * Test 0.
     *
     * @param list the list
     */
    public void test0(List<Map<String, String>> list) {
    }

    /**
     * Test 1.
     *
     * @param list the list
     */
    public void test1(List<? extends String> list) {
    }

    /**
     * Test 2.
     *
     * @param list the list
     */
    public void test2(List<? super String> list) {
    }

    /**
     * Test 3.
     *
     * @param list the list
     */
    public void test3(List<?> list) {
    }
}
