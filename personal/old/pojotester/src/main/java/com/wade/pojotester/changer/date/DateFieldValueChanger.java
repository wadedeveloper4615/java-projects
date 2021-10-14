/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.util.Date;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Date field value changer.
 */
class DateFieldValueChanger extends AbstractFieldValueChanger<Date> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(Date.class);
    }

    /**
     * Increase value date.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the date
     */
    @Override
    protected Date increaseValue(Date value, Class<?> type) {
	return Date.from(value.toInstant().plusSeconds(100));
    }
}
