/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.time.LocalDateTime;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Local date time field value changer.
 */
class LocalDateTimeFieldValueChanger extends AbstractFieldValueChanger<LocalDateTime> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(LocalDateTime.class);
    }

    /**
     * Increase value local date time.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the local date time
     */
    @Override
    protected LocalDateTime increaseValue(LocalDateTime value, Class<?> type) {
	return value.plusDays(1);
    }
}
