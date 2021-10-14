/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Double value changer.
 */
class DoubleValueChanger extends AbstractPrimitiveValueChanger<Double> {
    /**
     * Increase double.
     *
     * @param value the value
     * 
     * @return the double
     */
    @Override
    protected Double increase(Double value) {
	return 2 * (value + 1);
    }
}
