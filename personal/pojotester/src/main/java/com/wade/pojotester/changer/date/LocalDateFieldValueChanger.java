/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.time.LocalDate;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Local date field value changer.
 */
class LocalDateFieldValueChanger extends AbstractFieldValueChanger<LocalDate> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(LocalDate.class);
    }

    /**
     * Increase value local date.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the local date
     */
    @Override
    protected LocalDate increaseValue(LocalDate value, Class<?> type) {
	return value.plusDays(1);
    }
}
