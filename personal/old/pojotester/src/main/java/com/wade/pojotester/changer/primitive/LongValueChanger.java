/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Long value changer.
 */
class LongValueChanger extends AbstractPrimitiveValueChanger<Long> {
    /**
     * Increase long.
     *
     * @param value the value
     * 
     * @return the long
     */
    @Override
    protected Long increase(Long value) {
	return value + 1;
    }
}
