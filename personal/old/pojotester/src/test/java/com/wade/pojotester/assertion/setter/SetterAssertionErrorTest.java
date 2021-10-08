/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.setter;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.FullPojo;

class SetterAssertionErrorTest {
    @Test
    void test() {
	Class<?> a = FullPojo.class;
	Field b = a.getDeclaredFields()[0];
	Object c = new Object();
	Object d = new Object();
	SetterAssertionError objectUnderTest = new SetterAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getField()).isNotNull();
	assertThat(objectUnderTest.getExpectedValue()).isNotNull();
	assertThat(objectUnderTest.getCurrentValue()).isNotNull();
	assertThat(objectUnderTest.getTestedCass()).isNotNull();
    }
}
