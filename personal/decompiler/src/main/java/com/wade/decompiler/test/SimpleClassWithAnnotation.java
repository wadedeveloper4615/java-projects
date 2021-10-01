package com.wade.decompiler.test;

/**
 * The Class SimpleClassWithAnnotation.
 */
@MyCustomAnnotation1(books = { "book1" }, count = 1)
@MyCustomAnnotation2(books = { "book2" }, count = 1)
public class SimpleClassWithAnnotation {

    /**
     * Func 1.
     *
     * @param var the var
     */
    public void func1(@MyCustomAnnotation1 Integer var) {
    }

    /**
     * Func 2.
     *
     * @param var the var
     */
    public void func2(@MyCustomAnnotation2 Integer var) {
    }
}
