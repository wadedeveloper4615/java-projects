/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer;

import com.wade.pojotester.changer.collections.CollectionsFieldValueChanger;
import com.wade.pojotester.changer.date.DefaultDateAndTimeFieldValueChanger;
import com.wade.pojotester.changer.math.BigDecimalValueChanger;
import com.wade.pojotester.changer.math.BigIntegerValueChanger;
import com.wade.pojotester.changer.primitive.AbstractPrimitiveValueChanger;

/**
 * The type Default field value changer.
 */
public class DefaultFieldValueChanger {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new EnumValueChanger()
            .attachNext(AbstractPrimitiveValueChanger.INSTANCE)
            .attachNext(CollectionsFieldValueChanger.INSTANCE)
            .attachNext(DefaultDateAndTimeFieldValueChanger.INSTANCE)
            .attachNext(new StringValueChanger())
            .attachNext(new UUIDValueChanger())
            .attachNext(new BigDecimalValueChanger())
            .attachNext(new BigIntegerValueChanger());
    //@formatter:on

    /**
     * Instantiates a new Default field value changer.
     */
    private DefaultFieldValueChanger() {
    }
}
