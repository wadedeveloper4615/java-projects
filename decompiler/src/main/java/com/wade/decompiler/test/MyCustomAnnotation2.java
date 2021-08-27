package com.wade.decompiler.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The Interface MyCustomAnnotation1.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation2 {
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