/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import org.apache.commons.collections4.MultiValuedMap;

import com.wade.pojotester.util.ConstructorParameters;

import lombok.Getter;

/**
 * The type Abstract object instantiator.
 */
@Getter
public abstract class AbstractObjectInstantiator {
    /**
     * The Clazz.
     */
    protected Class<?> clazz;
    /**
     * The Constructor parameters.
     */
    protected MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters;

    /**
     * Instantiates a new Abstract object instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    public AbstractObjectInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	this.clazz = clazz;
	this.constructorParameters = constructorParameters;
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    public abstract boolean canInstantiate();

    /**
     * Instantiate object.
     *
     * @return the object
     */
    public abstract Object instantiate();
}
