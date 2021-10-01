/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Best constructor instantiator.
 */
public class BestConstructorInstantiator extends AbstractMultiConstructorInstantiator {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(BestConstructorInstantiator.class);

    /**
     * Instantiates a new Best constructor instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    public BestConstructorInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	return true;
    }

    /**
     * Create object from args constructor object.
     *
     * @param parameterTypes the parameter types
     * @param parameters     the parameters
     *
     * @return the object
     */
    @Override
    protected Object createObjectFromArgsConstructor(Class<?>[] parameterTypes, Object[] parameters) {
	try {
	    Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(parameterTypes);
	    declaredConstructor.setAccessible(true);
	    return declaredConstructor.newInstance(parameters);
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
	    throw new ObjectInstantiationException(clazz, "Could not create object from args constructor", parameterTypes, parameters, e);
	}
    }

    /**
     * Create object from no args constructor object.
     *
     * @param constructor the constructor
     *
     * @return the object
     */
    @Override
    protected Object createObjectFromNoArgsConstructor(Constructor<?> constructor) {
	try {
	    return constructor.newInstance();
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	    LOGGER.debug("Exception:", e);
	    // ignore, we want to try all constructors
	    // if all constructors fail, it will be handled by caller
	    return null;
	}
    }

    /**
     * Create object instantiation exception object instantiation exception.
     *
     * @return the object instantiation exception
     */
    @Override
    protected ObjectInstantiationException createObjectInstantiationException() {
	return new ObjectInstantiationException(clazz, "Class could not be created by any constructor (using BestConstructorInstantiator).");
    }

    /**
     * Instantiate object.
     *
     * @return the object
     */
    @Override
    public Object instantiate() {
	Object result = instantiateUsingUserParameters();
	if (result == null) {
	    result = createFindingBestConstructor();
	}
	return result;
    }
}
