/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import java.time.ZonedDateTime;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Zoned date time field value changer.
 */
class ZonedDateTimeFieldValueChanger extends AbstractFieldValueChanger<ZonedDateTime> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(ZonedDateTime.class);
    }

    /**
     * Increase value zoned date time.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the zoned date time
     */
    @Override
    protected ZonedDateTime increaseValue(ZonedDateTime value, Class<?> type) {
	return value.plusDays(1);
    }
}
