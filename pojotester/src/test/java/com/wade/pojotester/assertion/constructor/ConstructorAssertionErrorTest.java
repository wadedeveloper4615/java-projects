/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.constructor;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class ConstructorAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	Constructor<?> b = a.getDeclaredConstructors()[0];
	Object[] c = b.getParameters();
	ReflectiveOperationException d = new ReflectiveOperationException();
	ConstructorAssertionError objectUnderTest = new ConstructorAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getConstructorUnderAssert()).isNotNull();
	assertThat(objectUnderTest.getConstructorParameters()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNotNull();
    }

    @Test
    void test2() {
	Class<?> a = SimpleClass.class;
	Constructor<?> b = a.getDeclaredConstructors()[0];
	Object[] c = null;
	ReflectiveOperationException d = new ReflectiveOperationException();
	ConstructorAssertionError objectUnderTest = new ConstructorAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
    }
}
