/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class TransitiveEqualsAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	Object b = new Object();
	Object c = new Object();
	Object d = new Object();
	boolean e = false;
	boolean f = false;
	boolean g = false;
	TransitiveEqualsAssertionError objectUnderTest = new TransitiveEqualsAssertionError(a, b, c, d, e, f, g);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getA()).isNotNull();
	assertThat(objectUnderTest.getB()).isNotNull();
	assertThat(objectUnderTest.getC()).isNotNull();
	assertThat(objectUnderTest.getFirstResult()).isNotNull();
	assertThat(objectUnderTest.getSecondResult()).isNotNull();
	assertThat(objectUnderTest.getThirdResult()).isNotNull();
    }
}
