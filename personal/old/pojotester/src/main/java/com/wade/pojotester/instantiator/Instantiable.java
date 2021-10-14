/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.MultiValuedMap;

import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Instantiable.
 */
public class Instantiable {
    /**
     * The constant INSTANTIATORS.
     */
    protected static List<Class<? extends AbstractObjectInstantiator>> INSTANTIATORS;
    static {
	INSTANTIATORS = new LinkedList<>();
	INSTANTIATORS.add(UserDefinedConstructorInstantiator.class);
	INSTANTIATORS.add(JavaTypeInstantiator.class);
	INSTANTIATORS.add(CollectionInstantiator.class);
	INSTANTIATORS.add(DefaultConstructorInstantiator.class);
	INSTANTIATORS.add(EnumInstantiator.class);
	INSTANTIATORS.add(ArrayInstantiator.class);
	INSTANTIATORS.add(ProxyInstantiator.class);
	INSTANTIATORS.add(BestConstructorInstantiator.class);
    }

    /**
     * For class abstract object instantiator.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     *
     * @return the abstract object instantiator
     */
    public static AbstractObjectInstantiator forClass(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	return instantiateInstantiators(clazz, constructorParameters).stream().filter(AbstractObjectInstantiator::canInstantiate).findAny().get();
    }

    /**
     * Instantiate classes object [ ].
     *
     * @param classes               the classes
     * @param constructorParameters the constructor parameters
     *
     * @return the object [ ]
     */
    static Object[] instantiateClasses(Class<?>[] classes, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	return Arrays.stream(classes).map(clazz -> Instantiable.forClass(clazz, constructorParameters)).map(AbstractObjectInstantiator::instantiate).toArray();
    }

    /**
     * Instantiate instantiators list.
     *
     * @param clazz                 the clazz
     * @param constructorParameters the constructor parameters
     *
     * @return the list
     */
    private static List<AbstractObjectInstantiator> instantiateInstantiators(Class<?> clazz, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	List<AbstractObjectInstantiator> instantiators = new ArrayList<>();
	try {
	    for (Class<? extends AbstractObjectInstantiator> instantiator : INSTANTIATORS) {
		Constructor<? extends AbstractObjectInstantiator> constructor;
		constructor = instantiator.getDeclaredConstructor(Class.class, MultiValuedMap.class);
		constructor.setAccessible(true);
		AbstractObjectInstantiator abstractObjectInstantiator = constructor.newInstance(clazz, constructorParameters);
		instantiators.add(abstractObjectInstantiator);
	    }
	} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
	    throw new RuntimeException("Cannot load instantiators form pl.pojo.tester.internal.instantiator package.", e);
	}
	return instantiators;
    }

    /**
     * Instantiates a new Instantiable.
     */
    private Instantiable() {
    }
}
