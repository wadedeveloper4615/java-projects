/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.collections.collection;

import java.util.Vector;

import com.wade.pojotester.util.CollectionUtils;

/**
 * The type Vector value changer.
 */
class VectorValueChanger extends AbstractCollectionFieldValueChanger<Vector<?>> {
    /**
     * Increase value vector.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the vector
     */
    @Override
    protected Vector<?> increaseValue(Vector<?> value, Class<?> type) {
	return CollectionUtils.isNotEmpty(value) ? null : new Vector<>(CollectionUtils.asList(new Object()));
    }
}
