/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.FullPojo;

class ToStringAssertionsTest {
    @Test
    void test1() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	ToStringAssertions objectUnderTest = new ToStringAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	objectUnderTest.contains("", "");
    }

    @Test
    void test2() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	ToStringAssertions objectUnderTest = new ToStringAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	objectUnderTest.doestNotContain("", "2");
    }

    @Test
    void test3() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	ToStringAssertions objectUnderTest = new ToStringAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Assertions.assertThrows(ContainsToStringAssertionError.class, () -> {
	    objectUnderTest.contains("", "2");
	});
    }

    @Test
    void test4() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	ToStringAssertions objectUnderTest = new ToStringAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Assertions.assertThrows(NotContainToStringAssertionError.class, () -> {
	    objectUnderTest.doestNotContain("", "");
	});
    }
}
