/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class ConsistentEqualsAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	Object b = new Object();
	boolean c = true;
	boolean d = false;
	ConsistentEqualsAssertionError objectUnderTest = new ConsistentEqualsAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getTestedObject()).isNotNull();
	assertThat(objectUnderTest.getFirstResult()).isNotNull();
	assertThat(objectUnderTest.getSecondResult()).isNotNull();
    }
}
