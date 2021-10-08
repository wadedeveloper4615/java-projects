/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.changer.collections.collection.AbstractCollectionFieldValueChanger;
import com.wade.pojotester.changer.collections.iterators.AbstractIteratorsFieldValueChanger;
import com.wade.pojotester.changer.collections.map.AbstractMapFieldValueChanger;

/**
 * The type Collections field value changer.
 */
public class CollectionsFieldValueChanger {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new ArrayValueChanger()
            .attachNext(new StreamValueChanger())
            .attachNext(AbstractCollectionFieldValueChanger.INSTANCE)
            .attachNext(AbstractMapFieldValueChanger.INSTANCE)
            .attachNext(AbstractIteratorsFieldValueChanger.INSTANCE);
    //@formatter:off

    /**
     * Instantiates a new Collections field value changer.
     */
    private CollectionsFieldValueChanger() {}
}
