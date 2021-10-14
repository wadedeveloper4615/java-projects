/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type User defined constructor instantiator.
 */
class UserDefinedConstructorInstantiator extends AbstractObjectInstantiator {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(BestConstructorInstantiator.class);

    /**
     * Instantiates a new User defined constructor instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    UserDefinedConstructorInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	return userDefinedConstructorParameters() && !qualifiesForProxy(clazz);
    }

    /**
     * Create object instantiation exception object instantiation exception.
     *
     * @return the object instantiation exception
     */
    private ObjectInstantiationException createObjectInstantiationException() {
	return new ObjectInstantiationException(clazz, "Could not instantiate object by any user defined constructor types and parameters.");
    }

    /**
     * Create object using constructor parameters object.
     *
     * @param constructorParameters the constructor parameters
     * 
     * @return the object
     */
    private Object createObjectUsingConstructorParameters(ConstructorParameters constructorParameters) {
	try {
	    Class<?>[] constructorParametersTypes = constructorParameters.getParametersTypes();
	    Object[] arguments = constructorParameters.getParameters();
	    if (isInnerClass()) {
		constructorParametersTypes = putEnclosingClassAsFirstParameterType(clazz.getEnclosingClass(), constructorParametersTypes);
		Object enclosingClassInstance = instantiateEnclosingClass();
		arguments = putEnclosingClassInstanceAsFirstParameter(enclosingClassInstance, arguments);
	    }
	    Constructor<?> constructor = clazz.getDeclaredConstructor(constructorParametersTypes);
	    constructor.setAccessible(true);
	    return constructor.newInstance(arguments);
	} catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
	    LOGGER.debug("Exception:", e);
	    return null;
	}
    }

    /**
     * Instantiate object.
     *
     * @return the object
     */
    @Override
    public Object instantiate() {
	return constructorParameters.get(clazz).stream().map(this::createObjectUsingConstructorParameters).filter(Objects::nonNull).findAny().orElseThrow(this::createObjectInstantiationException);
    }

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
     * Is inner class boolean.
     *
     * @return the boolean
     */
    private boolean isInnerClass() {
	return clazz.getEnclosingClass() != null && !Modifier.isStatic(clazz.getModifiers());
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
     * Qualifies for proxy boolean.
     *
     * @param clazz the clazz
     * 
     * @return the boolean
     */
    private boolean qualifiesForProxy(Class<?> clazz) {
	return clazz.isInterface() || clazz.isAnnotation() || Modifier.isAbstract(clazz.getModifiers());
    }

    /**
     * User defined constructor parameters boolean.
     *
     * @return the boolean
     */
    private boolean userDefinedConstructorParameters() {
	return constructorParameters.containsKey(clazz);
    }
}
