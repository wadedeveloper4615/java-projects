/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.constructor;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.Abstract;
import com.wade.pojotester.testfiles.Annotation;
import com.wade.pojotester.testfiles.Interface;

import net.bytebuddy.description.type.PackageDescription.Simple;

class ConstructorAssertionsTest {
    @Test
    void test1() {
	Class<Simple> clazz = Simple.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	ConstructorAssertions objectUnderTest = new ConstructorAssertions(constrs[0]);
	objectUnderTest.willInstantiateClassUsing((Object) null);
	assertThat(objectUnderTest.toString()).isNotNull();
	assertThat(objectUnderTest.getClassUnderTest()).isNotNull();
	assertThat(objectUnderTest.getConstructorUnderAssert()).isNotNull();
    }

    @Test
    void test2() {
	Class<Abstract> clazz = Abstract.class;
	Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	ConstructorAssertions objectUnderTest = new ConstructorAssertions(constrs[0]);
	Assertions.assertThrows(ConstructorAssertionError.class, () -> {
	    objectUnderTest.willInstantiateClassUsing((Object) null);
	});
    }

    @Test
    void test3() {
	Class<Interface> clazz = Interface.class;
	Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	    Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	    ConstructorAssertions objectUnderTest = new ConstructorAssertions(constrs[0]);
	    objectUnderTest.willInstantiateClassUsing((Object) null);
	});
    }

    @Test
    void test4() {
	Class<Annotation> clazz = Annotation.class;
	Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	    Constructor<?>[] constrs = clazz.getDeclaredConstructors();
	    ConstructorAssertions objectUnderTest = new ConstructorAssertions(constrs[0]);
	    objectUnderTest.willInstantiateClassUsing((Object) null);
	});
    }
}
