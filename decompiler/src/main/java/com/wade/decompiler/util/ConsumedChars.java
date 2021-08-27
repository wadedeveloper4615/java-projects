/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.util;

/**
 * The Class ConsumedChars.
 */
public class ConsumedChars extends ThreadLocal<Integer> {

    /**
     * Initial value.
     *
     * @return the integer
     */
    @Override
    protected Integer initialValue() {
        return Integer.valueOf(0);
    }
}
