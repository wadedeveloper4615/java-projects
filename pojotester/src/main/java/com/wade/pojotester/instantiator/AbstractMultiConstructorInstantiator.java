/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Abstract multi constructor instantiator.
 */
abstract class AbstractMultiConstructorInstantiator extends AbstractObjectInstantiator {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(AbstractMultiConstructorInstantiator.class);

    /**
     * Instantiates a new Abstract multi constructor instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    AbstractMultiConstructorInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Create finding best constructor object.
     *
     * @return the object
     */
    protected Object createFindingBestConstructor() {
	Constructor<?>[] constructors = clazz.getDeclaredConstructors();
	return Arrays.stream(constructors).map(this::createObjectFromConstructor).filter(Objects::nonNull).findAny().orElseThrow(this::createObjectInstantiationException);
    }

    /**
     * Create object from args constructor object.
     *
     * @param parameterTypes the parameter types
     * @param parameters     the parameters
     *
     * @return the object
     */
    protected abstract Object createObjectFromArgsConstructor(Class<?>[] parameterTypes, Object[] parameters);

    /**
     * Create object from constructor object.
     *
     * @param constructor the constructor
     *
     * @return the object
     */
    private Object createObjectFromConstructor(Constructor<?> constructor) {
	makeAccessible(constructor);
	if (constructor.getParameterCount() == 0) {
	    return createObjectFromNoArgsConstructor(constructor);
	} else {
	    try {
		Object[] parameters = Instantiable.instantiateClasses(constructor.getParameterTypes(), constructorParameters);
		return createObjectFromArgsConstructor(constructor.getParameterTypes(), parameters);
	    } catch (Exception e) {
		LOGGER.debug("Exception:", e);
		// ignore, we want to try all constructors
		// if all constructors fail, it will be handled by caller
		return null;
	    }
	}
    }

    /**
     * Create object from no args constructor object.
     *
     * @param constructor the constructor
     *
     * @return the object
     */
    protected abstract Object createObjectFromNoArgsConstructor(Constructor<?> constructor);

    /**
     * Create object instantiation exception object instantiation exception.
     *
     * @return the object instantiation exception
     */
    protected abstract ObjectInstantiationException createObjectInstantiationException();

    /**
     * Instantiate enclosing class object.
     *
     * @return the object
     */
    private Object instantiateEnclosingClass() {
	Class<?> enclosingClass = clazz.getEnclosingClass();
	return Instantiable.forClass(enclosingClass, constructorParameters).instantiate();
    }

    /**
     * Instantiate using user parameters object.
     *
     * @return the object
     */
    protected Object instantiateUsingUserParameters() {
	Collection<ConstructorParameters> userConstructorParameters = constructorParameters.get(clazz);
	if (userDefinedOwnParametersForThisClass(userConstructorParameters)) {
	    Object result = tryToInstantiateUsing(userConstructorParameters);
	    if (result != null) {
		return result;
	    }
	    LOGGER.warn(String.format("Could not instantiate class %s with user defined parameters. Trying create instance finding best constructor", clazz));
	}
	return null;
    }

    /**
     * Is inner class boolean.
     *
     * @return the boolean
     */
    private boolean isInnerClass() {
	return clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers());
    }

    /**
     * Make accessible.
     *
     * @param constructor the constructor
     */
    private void makeAccessible(Constructor<?> constructor) {
	constructor.setAccessible(true);
    }

    /**
     * Put enclosing class as first parameter type class [ ].
     *
     * @param enclosingClass             the enclosing class
     * @param constructorParametersTypes the constructor parameters types
     *
     * @return the class [ ]
     */
    private Class<?>[] putEnclosingClassAsFirstParameterType(Class<?> enclosingClass, Class<?>[] constructorParametersTypes) {
	return Stream.concat(Stream.of(enclosingClass), Arrays.stream(constructorParametersTypes)).toArray(Class[]::new);
    }

    /**
     * Put enclosing class instance as first parameter object [ ].
     *
     * @param enclosingClassInstance the enclosing class instance
     * @param arguments              the arguments
     *
     * @return the object [ ]
     */
    private Object[] putEnclosingClassInstanceAsFirstParameter(Object enclosingClassInstance, Object[] arguments) {
	return Stream.concat(Stream.of(enclosingClassInstance), Arrays.stream(arguments)).toArray(Object[]::new);
    }

    /**
     * Try to instantiate using object.
     *
     * @param userConstructorParameters the user constructor parameters
     *
     * @return the object
     */
    private Object tryToInstantiateUsing(Collection<ConstructorParameters> userConstructorParameters) {
	for (ConstructorParameters param : userConstructorParameters) {
	    Class<?>[] parameterTypes = param.getParametersTypes();
	    try {
		Object[] parameters = param.getParameters();
		if (isInnerClass()) {
		    parameterTypes = putEnclosingClassAsFirstParameterType(clazz.getEnclosingClass(), parameterTypes);
		    Object enclosingClassInstance = instantiateEnclosingClass();
		    parameters = putEnclosingClassInstanceAsFirstParameter(enclosingClassInstance, parameters);
		}
		return createObjectFromArgsConstructor(parameterTypes, parameters);
	    } catch (ObjectInstantiationException e) {
		LOGGER.debug("ObjectInstantiationException:", e);
		// ignore, try all user defined constructor parameters and types
	    }
	}
	return null;
    }

    /**
     * User defined own parameters for this class boolean.
     *
     * @param userConstructorParameters the user constructor parameters
     *
     * @return the boolean
     */
    private boolean userDefinedOwnParametersForThisClass(Collection<ConstructorParameters> userConstructorParameters) {
	return CollectionUtils.isNotEmpty(userConstructorParameters);
    }
}
