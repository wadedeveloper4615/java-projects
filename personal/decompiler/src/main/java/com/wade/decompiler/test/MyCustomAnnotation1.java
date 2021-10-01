package com.wade.decompiler.test;

/**
 * The Interface MyCustomAnnotation1.
 */
public @interface MyCustomAnnotation1 {
    /**
     * Books.
     *
     * @return the string[]
     */
    String[] books() default {};

    /**
     * Count.
     *
     * @return the int
     */
    int count() default 0;
}