/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.map;

import java.util.Hashtable;

/**
 * The type Hashtable value changer.
 */
class HashtableValueChanger extends AbstractMapFieldValueChanger<Hashtable<?, ?>> {
    /**
     * Increase value hashtable.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the hashtable
     */
    @Override
    protected Hashtable<?, ?> increaseValue(Hashtable<?, ?> value, Class<?> type) {
	return value == null ? new Hashtable<>() : null;
    }
}
