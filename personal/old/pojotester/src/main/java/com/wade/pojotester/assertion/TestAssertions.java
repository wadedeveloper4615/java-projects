/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion;

import java.lang.reflect.Constructor;

import com.wade.pojotester.assertion.constructor.ConstructorAssertions;
import com.wade.pojotester.assertion.equals.EqualAssertions;
import com.wade.pojotester.assertion.getter.GetterAssertions;
import com.wade.pojotester.assertion.hashcode.HashCodeAssertions;
import com.wade.pojotester.assertion.setter.SetterAssertions;
import com.wade.pojotester.assertion.tostring.ToStringAssertions;

/**
 * The type Test assertions.
 */
public class TestAssertions {
    /**
     * Assert that constructor constructor assertions.
     *
     * @param constructorUnderAssert the constructor under assert
     *
     * @return the constructor assertions
     */
    public ConstructorAssertions assertThatConstructor(Constructor<?> constructorUnderAssert) {
	return new ConstructorAssertions(constructorUnderAssert);
    }

    /**
     * Assert that equals method for equal assertions.
     *
     * @param objectUnderAssert the object under assert
     *
     * @return the equal assertions
     */
    public EqualAssertions assertThatEqualsMethodFor(Object objectUnderAssert) {
	return new EqualAssertions(objectUnderAssert);
    }

    /**
     * Assert that get method for getter assertions.
     *
     * @param objectUnderAssert the object under assert
     *
     * @return the getter assertions
     */
    public GetterAssertions assertThatGetMethodFor(Object objectUnderAssert) {
	return new GetterAssertions(objectUnderAssert);
    }

    /**
     * Assert that hash code method for hash code assertions.
     *
     * @param objectUnderAssert the object under assert
     *
     * @return the hash code assertions
     */
    public HashCodeAssertions assertThatHashCodeMethodFor(Object objectUnderAssert) {
	return new HashCodeAssertions(objectUnderAssert);
    }

    /**
     * Assert that set method for setter assertions.
     *
     * @param objectUnderAssert the object under assert
     *
     * @return the setter assertions
     */
    public SetterAssertions assertThatSetMethodFor(Object objectUnderAssert) {
	return new SetterAssertions(objectUnderAssert);
    }

    /**
     * Assert that to string method for to string assertions.
     *
     * @param objectUnderAssert the object under assert
     *
     * @return the to string assertions
     */
    public ToStringAssertions assertThatToStringMethodFor(Object objectUnderAssert) {
	return new ToStringAssertions(objectUnderAssert);
    }
}
