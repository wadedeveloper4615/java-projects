/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.commons.collections4.MultiValuedMap;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Default constructor instantiator.
 */
public class DefaultConstructorInstantiator extends AbstractObjectInstantiator {
    /**
     * Instantiates a new Default constructor instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    public DefaultConstructorInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	Constructor<?>[] constructors = clazz.getConstructors();
	return !qualifiesForProxy(clazz) && Arrays.stream(constructors).filter(this::isNoArgs).anyMatch(this::isPublic);
    }

    /**
     * Instantiate object.
     *
     * @return the object
     */
    @Override
    public Object instantiate() {
	try {
	    Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
	    defaultConstructor.setAccessible(true);
	    return defaultConstructor.newInstance();
	} catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
	    throw new ObjectInstantiationException(clazz, e.getMessage(), e);
	}
    }

    /**
     * Is no args boolean.
     *
     * @param constructor the constructor
     *
     * @return the boolean
     */
    protected boolean isNoArgs(Constructor<?> constructor) {
	return constructor.getParameterCount() == 0;
    }

    /**
     * Is public boolean.
     *
     * @param constructor the constructor
     *
     * @return the boolean
     */
    protected boolean isPublic(Constructor<?> constructor) {
	return (constructor.getModifiers() & Modifier.PUBLIC) != 0;
    }

    /**
     * Qualifies for proxy boolean.
     *
     * @param clazz the clazz
     *
     * @return the boolean
     */
    protected boolean qualifiesForProxy(Class<?> clazz) {
	return clazz.isInterface() || clazz.isAnnotation() || Modifier.isAbstract(clazz.getModifiers());
    }
}
