/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.time.Instant;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Instant field value changer.
 */
class InstantFieldValueChanger extends AbstractFieldValueChanger<Instant> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(Instant.class);
    }

    /**
     * Increase value instant.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the instant
     */
    @Override
    protected Instant increaseValue(Instant value, Class<?> type) {
	return value.plusSeconds(3600);
    }
}
