/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.bytebuddy.description.type.PackageDescription.Simple;

class EqualAssertionsTest {
    @Test
    void test1() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	objectUnderTest.isEqualTo(value);
	assertThat(objectUnderTest.getClassUnderTest()).isNotNull();
	assertThat(objectUnderTest.getObjectUnderAssert()).isNotNull();
    }

    @Test
    void test10() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.isSymmetric(value);
    }

    @Test
    void test11() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value1 = "";
	String value2 = "";
	objectUnderTest.setObjectUnderAssert("");
	objectUnderTest.isTransitive(value1, value2);
    }

    @Test
    void test12() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value1 = "";
	String value2 = "";
	objectUnderTest.setObjectUnderAssert(2);
	Assertions.assertThrows(TransitiveEqualsAssertionError.class, () -> {
	    objectUnderTest.isTransitive(value1, value2);
	});
    }

    @Test
    void test13() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value1 = "";
	Integer value2 = 2;
	objectUnderTest.setObjectUnderAssert("");
	Assertions.assertThrows(TransitiveEqualsAssertionError.class, () -> {
	    objectUnderTest.isTransitive(value1, value2);
	});
    }

    @Test
    void test14() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	Integer value1 = 2;
	String value2 = "";
	objectUnderTest.setObjectUnderAssert("");
	Assertions.assertThrows(TransitiveEqualsAssertionError.class, () -> {
	    objectUnderTest.isTransitive(value1, value2);
	});
    }

    @Test
    void test2() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	Assertions.assertThrows(EqualEqualsAssertionError.class, () -> {
	    objectUnderTest.isEqualTo(new ArrayList<Object>());
	});
    }

    @Test
    void test3() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
    }

    @Test
    void test4() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	objectUnderTest.isNotEqualTo(new ArrayList<Object>());
    }

    @Test
    void test5() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = null;
	objectUnderTest.setObjectUnderAssert(value);
	Assertions.assertThrows(NullEqualsAssertionError.class, () -> {
	    objectUnderTest.isNotEqualToNull();
	});
    }

    @Test
    void test6() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	objectUnderTest.isNotEqualToNull();
    }

    @Test
    void test7() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	objectUnderTest.isReflexive();
    }

    @Test
    void test8() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
    }

    @Test
    void test9() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	EqualAssertions objectUnderTest = new EqualAssertions(constrs[0]);
	String value = "";
	objectUnderTest.setObjectUnderAssert(value);
	Assertions.assertThrows(OtherTypeEqualsAssertionError.class, () -> {
	    objectUnderTest.isNotEqualToObjectWithDifferentType(value);
	});
    }
}
