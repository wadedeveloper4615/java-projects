package com.wade.decompiler.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * The Class SimpleClassWithSimpleLambda.
 */
public class SimpleClassWithSimpleLambda {
    /** The value. */
    List<String> value = new ArrayList<>();

    /**
     * Number of long color names.
     */
    public void numberOfLongColorNames() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<? super Integer> action = n -> System.out.println(n);
        numbers.forEach(action);
    }
}
