/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.SimpleClass;

class ContainsToStringAssertionErrorTest {
    @Test
    void test1() {
	Class<?> a = SimpleClass.class;
	String c = "";
	String b = "";
	ContainsToStringAssertionError objectUnderTest = new ContainsToStringAssertionError(a, b, c);
	assertThat(objectUnderTest.getDetailedMessage()).isNotNull();
	assertThat(objectUnderTest.getErrorPrefix()).isNotNull();
	assertThat(objectUnderTest.getCause()).isNull();
	assertThat(objectUnderTest.getMessage()).isNotNull();
	assertThat(objectUnderTest.getValue()).isNotNull();
	assertThat(objectUnderTest.getToString()).isNotNull();
    }
}
