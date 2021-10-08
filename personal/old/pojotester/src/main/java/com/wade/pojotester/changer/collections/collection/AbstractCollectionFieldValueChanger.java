/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.Collection;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Abstract collection field value changer.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractCollectionFieldValueChanger<T extends Collection<?>> extends AbstractFieldValueChanger<T> {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new ArrayListValueChanger()
	                                                                                .attachNext(new DequeValueChanger())
                                                                                        .attachNext(new HashSetValueChanger())
                                                                                        .attachNext(new LinkedHashSetValueChanger())
                                                                                        .attachNext(new LinkedListValueChanger())
                                                                                        .attachNext(new ListValueChanger())
                                                                                        .attachNext(new QueueValueChanger())
                                                                                        .attachNext(new SetValueChanger())
                                                                                        .attachNext(new SortedSetValueChanger())
                                                                                        .attachNext(new StackValueChanger())
                                                                                        .attachNext(new TreeSetValueChanger())
                                                                                        .attachNext(new VectorValueChanger());
    //@formatter:on

    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.isAssignableFrom(getGenericTypeClass());
    }
}
