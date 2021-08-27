/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.iterators;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Abstract iterators field value changer.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractIteratorsFieldValueChanger<T> extends AbstractFieldValueChanger<T> {
    /**
     * The constant INSTANCE.
     */
    public static AbstractFieldValueChanger<?> INSTANCE = new IteratorValueChanger().attachNext(new IterableValueChanger());

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
