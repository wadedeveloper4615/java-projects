/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.time.LocalTime;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Local time field value changer.
 */
class LocalTimeFieldValueChanger extends AbstractFieldValueChanger<LocalTime> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(LocalTime.class);
    }

    /**
     * Increase value local time.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the local time
     */
    @Override
    protected LocalTime increaseValue(LocalTime value, Class<?> type) {
	return value.plusHours(1);
    }
}
