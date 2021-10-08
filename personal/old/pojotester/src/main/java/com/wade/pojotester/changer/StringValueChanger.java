/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer;

/**
 * The type String value changer.
 */
class StringValueChanger extends AbstractFieldValueChanger<String> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.equals(String.class);
    }

    /**
     * Increase value string.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the string
     */
    @Override
    protected String increaseValue(String value, Class<?> type) {
	return value + "++increased";
    }
}
