/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.math;

import java.math.BigInteger;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Big integer value changer.
 */
public class BigIntegerValueChanger extends AbstractFieldValueChanger<BigInteger> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(BigInteger.class);
    }

    /**
     * Increase value big integer.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the big integer
     */
    @Override
    protected BigInteger increaseValue(BigInteger value, Class<?> type) {
	return value.add(BigInteger.ONE);
    }
}
