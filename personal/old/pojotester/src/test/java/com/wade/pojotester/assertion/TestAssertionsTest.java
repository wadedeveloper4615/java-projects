/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.assertion.constructor.ConstructorAssertions;
import com.wade.pojotester.assertion.equals.EqualAssertions;
import com.wade.pojotester.assertion.getter.GetterAssertions;
import com.wade.pojotester.assertion.hashcode.HashCodeAssertions;
import com.wade.pojotester.assertion.setter.SetterAssertions;
import com.wade.pojotester.assertion.tostring.ToStringAssertions;
import com.wade.pojotester.testfiles.SimpleClass;

class TestAssertionsTest {
    @Test
    void testAssertThatConstructor() {
	Class<SimpleClass> clazz = SimpleClass.class;
	Constructor<?>[] constructors = clazz.getConstructors();
	Constructor<?> constructorUnderAssert = constructors[0];
	TestAssertions objectUnderTest = new TestAssertions();
	ConstructorAssertions result = objectUnderTest.assertThatConstructor(constructorUnderAssert);
	assertThat(result).isNotNull();
    }

    @Test
    void testAssertThatEqualsMethodFor() {
	Object objectUnderAssert = mock(Object.class);
	TestAssertions objectUnderTest = new TestAssertions();
	EqualAssertions result = objectUnderTest.assertThatEqualsMethodFor(objectUnderAssert);
	assertThat(result).isNotNull();
    }

    @Test
    void testAssertThatGetMethodFor() {
	Object objectUnderAssert = mock(Object.class);
	TestAssertions objectUnderTest = new TestAssertions();
	GetterAssertions result = objectUnderTest.assertThatGetMethodFor(objectUnderAssert);
	assertThat(result).isNotNull();
    }

    @Test
    void testAssertThatHashCodeMethodFor() {
	Object objectUnderAssert = mock(Object.class);
	TestAssertions objectUnderTest = new TestAssertions();
	HashCodeAssertions result = objectUnderTest.assertThatHashCodeMethodFor(objectUnderAssert);
	assertThat(result).isNotNull();
    }

    @Test
    void testAssertThatSetMethodFor() {
	Object objectUnderAssert = mock(Object.class);
	TestAssertions objectUnderTest = new TestAssertions();
	SetterAssertions result = objectUnderTest.assertThatSetMethodFor(objectUnderAssert);
	assertThat(result).isNotNull();
    }

    @Test
    void testAssertThatToStringMethodFor() {
	Object objectUnderAssert = mock(Object.class);
	TestAssertions objectUnderTest = new TestAssertions();
	ToStringAssertions result = objectUnderTest.assertThatToStringMethodFor(objectUnderAssert);
	assertThat(result).isNotNull();
    }
}
