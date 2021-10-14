/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class ConsistentHashCodeAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	Integer d = 2;
	Integer c = 3;
	Object b = new Object();
	ConsistentHashCodeAssertionError objectUnderTest = new ConsistentHashCodeAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getTestedObject()).isNotNull();
	assertThat(objectUnderTest.getFirstHashCode()).isNotNull();
	assertThat(objectUnderTest.getSecondHashCode()).isNotNull();
    }
}
