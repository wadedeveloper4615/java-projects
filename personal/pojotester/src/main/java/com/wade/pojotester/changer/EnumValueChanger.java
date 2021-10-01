/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer;

import com.wade.pojotester.exception.ImpossibleEnumValueChangeException;

/**
 * The type Enum value changer.
 */
@SuppressWarnings("rawtypes")
class EnumValueChanger extends AbstractFieldValueChanger<Enum> {
    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return type.isEnum();
    }

    /**
     * Find different value enum.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the enum
     */
    private Enum findDifferentValue(Enum value, Class<?> type) {
	Enum[] enumConstants = (Enum[]) type.getEnumConstants();
	for (Enum enumConstant : enumConstants) {
	    if (areDifferentValues(value, enumConstant)) {
		return enumConstant;
	    }
	}
	return null;
    }

    /**
     * First value enum.
     *
     * @param type the type
     * 
     * @return the enum
     */
    private Enum firstValue(Class<?> type) {
	Object[] enumConstants = type.getEnumConstants();
	if (enumConstants.length == 0) {
	    throw new ImpossibleEnumValueChangeException(type);
	}
	return (Enum) enumConstants[0];
    }

    /**
     * Increase value enum.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the enum
     */
    @Override
    protected Enum increaseValue(Enum value, Class<?> type) {
	if (value == null) {
	    return firstValue(type);
	} else {
	    return findDifferentValue(value, type);
	}
    }
}
