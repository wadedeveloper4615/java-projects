/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

/**
 * The type Byte value changer.
 */
class ByteValueChanger extends AbstractPrimitiveValueChanger<Byte> {
    /**
     * Increase byte.
     *
     * @param value the value
     * 
     * @return the byte
     */
    @Override
    protected Byte increase(Byte value) {
	return (byte) (value + 1);
    }
}
