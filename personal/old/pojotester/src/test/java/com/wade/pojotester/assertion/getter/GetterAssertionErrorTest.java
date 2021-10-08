/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.getter;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.FullPojo;

class GetterAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = FullPojo.class;
	Field b = a.getDeclaredFields()[0];
	Object c = new Object();
	Object d = new Object();
	GetterAssertionError objectUnderTest = new GetterAssertionError(a, b, c, d);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getField()).isNotNull();
	assertThat(objectUnderTest.getExpectedValue()).isNotNull();
	assertThat(objectUnderTest.getCurrentValue()).isNotNull();
    }
}
