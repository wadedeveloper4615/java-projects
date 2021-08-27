/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.date;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Default date and time field value changer.
 */
public class DefaultDateAndTimeFieldValueChanger {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new ZonedDateTimeFieldValueChanger()
	    .attachNext(new DateFieldValueChanger())
            .attachNext(new LocalDateFieldValueChanger())
            .attachNext(new LocalDateTimeFieldValueChanger())
            .attachNext(new LocalTimeFieldValueChanger())
            .attachNext(new SqlDateFieldValueChanger())
            .attachNext(new InstantFieldValueChanger());
    //@formatter:on

    /**
     * Instantiates a new Default date and time field value changer.
     */
    private DefaultDateAndTimeFieldValueChanger() {
    }
}
