/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Float value changer.
 */
class FloatValueChanger extends AbstractPrimitiveValueChanger<Float> {
    /**
     * Increase float.
     *
     * @param value the value
     * 
     * @return the float
     */
    @Override
    protected Float increase(Float value) {
	return 2 * (value + 1);
    }
}
