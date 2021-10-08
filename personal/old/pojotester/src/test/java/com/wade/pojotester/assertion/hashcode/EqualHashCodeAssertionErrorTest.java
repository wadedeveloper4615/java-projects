/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class EqualHashCodeAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	Integer e = 1;
	Integer d = 2;
	Object c = new Object();
	Object b = new Object();
	EqualHashCodeAssertionError objectUnderTest = new EqualHashCodeAssertionError(a, b, c, d, e);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getTestedObject()).isNotNull();
	assertThat(objectUnderTest.getSecondObject()).isNotNull();
	assertThat(objectUnderTest.getFirstHashCode()).isNotNull();
	assertThat(objectUnderTest.getSecondHashCode()).isNotNull();
    }
}
