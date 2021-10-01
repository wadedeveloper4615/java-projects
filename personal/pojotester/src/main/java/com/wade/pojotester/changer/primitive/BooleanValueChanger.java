/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Boolean value changer.
 */
class BooleanValueChanger extends AbstractPrimitiveValueChanger<Boolean> {
    /**
     * Increase boolean.
     *
     * @param value the value
     * 
     * @return the boolean
     */
    @Override
    protected Boolean increase(Boolean value) {
	return !value;
    }
}
