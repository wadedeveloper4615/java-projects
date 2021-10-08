/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Short value changer.
 */
class ShortValueChanger extends AbstractPrimitiveValueChanger<Short> {
    /**
     * Increase short.
     *
     * @param value the value
     * 
     * @return the short
     */
    @Override
    protected Short increase(Short value) {
	return (short) (value + 1);
    }
}
