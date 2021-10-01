/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.sql.Date;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Sql date field value changer.
 */
class SqlDateFieldValueChanger extends AbstractFieldValueChanger<Date> {
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
	return new Date(value.getTime() + 1000);
    }
}
