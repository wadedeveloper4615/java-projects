/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.Map;

import com.wade.pojotester.changer.AbstractFieldValueChanger;

/**
 * The type Abstract map field value changer.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractMapFieldValueChanger<T extends Map<?, ?>> extends AbstractFieldValueChanger<T> {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new HashMapValueChanger()
	    .attachNext(new HashtableValueChanger())
	    .attachNext(new LinkedHashMapValueChanger())
	    .attachNext(new MapValueChanger())
	    .attachNext(new SortedMapValueChanger())
	    .attachNext(new TreeMapValueChanger());
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
