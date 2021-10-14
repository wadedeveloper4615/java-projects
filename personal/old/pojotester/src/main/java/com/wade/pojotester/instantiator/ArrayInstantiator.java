/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Array;

import org.apache.commons.collections4.MultiValuedMap;

import com.wade.pojotester.util.ConstructorParameters;

import lombok.Getter;

/**
 * The type Array instantiator.
 */
@Getter
public class ArrayInstantiator extends AbstractObjectInstantiator {
    /**
     * The constant DEFAULT_ARRAY_LENGTH.
     */
    private static int DEFAULT_ARRAY_LENGTH = 0;

    /**
     * Instantiates a new Array instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    public ArrayInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	return clazz.isArray();
    }

    /**
     * Instantiate object.
     *
     * @return the object
     */
    @Override
    public Object instantiate() {
	return Array.newInstance(clazz.getComponentType(), DEFAULT_ARRAY_LENGTH);
    }
}
