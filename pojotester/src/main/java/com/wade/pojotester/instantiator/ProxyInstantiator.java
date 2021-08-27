/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

import javassist.util.proxy.ProxyFactory;

/**
 * The type Proxy instantiator.
 */
class ProxyInstantiator extends AbstractMultiConstructorInstantiator {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(BestConstructorInstantiator.class);
    /**
     * The Proxy factory.
     */
    private ProxyFactory proxyFactory = new ProxyFactory();

    /**
     * Instantiates a new Proxy instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     */
    ProxyInstantiator(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	super(clazz, constructorParameters);
    }

    /**
     * Can instantiate boolean.
     *
     * @return the boolean
     */
    @Override
    public boolean canInstantiate() {
	return qualifiesForProxy(clazz);
    }

    /**
     * Create invocation handler object.
     *
     * @param proxy  the proxy
     * @param method the method
     * @param args   the args
     * 
     * @return the object
     */
    private Object createInvocationHandler(Object proxy, Method method, Object[] args) {
	try {
	    method.setAccessible(true);
	    return method.invoke(proxy, args);
	} catch (IllegalAccessException | InvocationTargetException e) {
	    LOGGER.debug("Exception:", e);
	    Class<?> returnType = method.getReturnType();
	    if (returnType.equals(boolean.class) || returnType.equals(Boolean.class)) {
		return true;
	    } else if (returnType.equals(String.class)) {
		return "string";
	    } else {
		return 0;
	    }
	}
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
	    Class<?> proxyClass = proxyFactory.createClass();
	    Constructor<?> declaredConstructor = proxyClass.getDeclaredConstructor(parameterTypes);
	    declaredConstructor.setAccessible(true);
	    return declaredConstructor.newInstance(parameters);
	} catch (ReflectiveOperationException e) {
	    throw new ObjectInstantiationException(clazz, "Could not create object from args constructor", e);
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
	    return proxyFactory.create(new Class[0], new Class[0]);
	} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
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
	return new ObjectInstantiationException(clazz, "Class could not be created by any constructor (using ProxyInstantiator).");
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
	    if (clazz.isAnnotation() || clazz.isInterface()) {
		result = proxyByJava();
	    } else {
		proxyFactory.setSuperclass(clazz);
		result = createFindingBestConstructor();
	    }
	}
	return result;
    }

    /**
     * Proxy by java object.
     *
     * @return the object
     */
    private Object proxyByJava() {
	return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, this::createInvocationHandler);
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
}
