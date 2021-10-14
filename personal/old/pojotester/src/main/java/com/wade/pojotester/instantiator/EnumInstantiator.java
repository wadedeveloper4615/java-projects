/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.util.Random;

import org.apache.commons.collections4.MultiValuedMap;

import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Enum instantiator.
 */
public class EnumInstantiator extends AbstractObjectInstantiator {
    /**
     * Instantiates a new Enum instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    public EnumInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	return clazz.isEnum();
    }

    /**
     * Instantiate object.
     *
     * @return the object
     */
    @Override
    public Object instantiate() {
	Object[] enumConstants = clazz.getEnumConstants();
	int length = enumConstants.length;
	if (length != 0) {
	    int random = new Random().nextInt(length);
	    return enumConstants[random];
	}
	return null;
    }
}
