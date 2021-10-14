/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.FullPojo;
import com.wade.pojotester.testfiles.SimpleClass;

class HashCodeAssertionsTest {
    @Test
    void test1() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	HashCodeAssertions objectUnderTest = new HashCodeAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	objectUnderTest.isConsistent();
    }

    @Test
    void test2() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	HashCodeAssertions objectUnderTest = new HashCodeAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Class<?> clazz2 = SimpleClass.class;
	Object b = clazz2.getDeclaredConstructor().newInstance();
	objectUnderTest.returnsDifferentValueFor(b);
    }

    @Test
    void test3() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	HashCodeAssertions objectUnderTest = new HashCodeAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Class<?> clazz2 = FullPojo.class;
	Object b = clazz2.getDeclaredConstructor().newInstance();
	Assertions.assertThrows(NotEqualHashCodeAssertionError.class, () -> {
	    objectUnderTest.returnsDifferentValueFor(b);
	});
    }

    @Test
    void test4() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	HashCodeAssertions objectUnderTest = new HashCodeAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Class<?> clazz2 = SimpleClass.class;
	Object b = clazz2.getDeclaredConstructor().newInstance();
	Assertions.assertThrows(EqualHashCodeAssertionError.class, () -> {
	    objectUnderTest.returnsSameValueFor(b);
	});
    }

    @Test
    void test5() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	HashCodeAssertions objectUnderTest = new HashCodeAssertions(a);
	assertThat(objectUnderTest).isNotNull();
	Class<?> clazz2 = FullPojo.class;
	Object b = clazz2.getDeclaredConstructor().newInstance();
	objectUnderTest.returnsSameValueFor(b);
    }
}
