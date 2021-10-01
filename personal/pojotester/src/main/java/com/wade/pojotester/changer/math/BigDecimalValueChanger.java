/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.math;

import java.math.BigDecimal;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Big decimal value changer.
 */
public class BigDecimalValueChanger extends AbstractFieldValueChanger<BigDecimal> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(BigDecimal.class);
    }

    /**
     * Increase value big decimal.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the big decimal
     */
    @Override
    protected BigDecimal increaseValue(BigDecimal value, Class<?> type) {
	return value.add(BigDecimal.ONE);
    }
}
