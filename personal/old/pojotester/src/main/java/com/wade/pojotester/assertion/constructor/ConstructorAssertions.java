/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import lombok.Getter;
import lombok.ToString;

/**
 * The type Constructor assertions.
 */
@Getter
// @Setter
@ToString
public class ConstructorAssertions {
    /**
     * The Constructor under assert.
     */
    private Constructor<?> constructorUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new Constructor assertions.
     *
     * @param constructorUnderAssert the constructor under assert
     */
    public ConstructorAssertions(Constructor<?> constructorUnderAssert) {
	this.constructorUnderAssert = constructorUnderAssert;
	classUnderTest = constructorUnderAssert.getDeclaringClass();
    }

    /**
     * Will instantiate class using.
     *
     * @param constructorParameters the constructor parameters
     */
    public void willInstantiateClassUsing(Object... constructorParameters) {
	constructorUnderAssert.setAccessible(true);
	try {
	    constructorUnderAssert.newInstance(constructorParameters);
	} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
	    throw new ConstructorAssertionError(this.classUnderTest, this.constructorUnderAssert, constructorParameters, e);
	}
    }
}
