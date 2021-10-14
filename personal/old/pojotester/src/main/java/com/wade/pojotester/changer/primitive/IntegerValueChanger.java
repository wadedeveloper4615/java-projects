/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Integer value changer.
 */
class IntegerValueChanger extends AbstractPrimitiveValueChanger<Integer> {
    /**
     * Increase integer.
     *
     * @param value the value
     * 
     * @return the integer
     */
    @Override
    protected Integer increase(Integer value) {
	return value + 1;
    }
}
