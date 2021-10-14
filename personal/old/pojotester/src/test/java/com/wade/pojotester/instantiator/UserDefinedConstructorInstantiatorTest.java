package com.wade.pojotester.instantiator;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.wade.pojotester.exception.ObjectInstantiationException;
import com.wade.pojotester.util.ConstructorParameters;

import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings({ "unused" })
class UserDefinedConstructorInstantiatorTest {
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
    {
	constructorParameters.put(UserDefinedClass.class, new ConstructorParameters(new Object[] { 1, 2 }, new Class<?>[] { int.class, int.class }));
	constructorParameters.put(ClassWithPrivateConstructor.class, new ConstructorParameters(new Object[] { 1 }, new Class<?>[] { int.class }));
	constructorParameters.put(One_Arg_Constructor_Throws_NPE.class, new ConstructorParameters(new Object[] { 1 }, new Class<?>[] { Object.class }));
	constructorParameters.put(No_Args_Constructor_Throws_NPE.class, new ConstructorParameters(new Object[0], new Class<?>[0]));
	constructorParameters.put(InnerClass.class, new ConstructorParameters(new Object[] { 1 }, new Class<?>[] { int.class }));
	constructorParameters.put(NestedClass.class, new ConstructorParameters(new Object[] { 1 }, new Class<?>[] { int.class }));
    }

    @Test
    void Should_Create_Object_For_Inner_Class() {
	// given
	Class<InnerClass> classToInstantiate = InnerClass.class;
	UserDefinedConstructorInstantiator instantiator = new UserDefinedConstructorInstantiator(classToInstantiate, constructorParameters);
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @Test
    void Should_Create_Object_For_Nested_Class() {
	// given
	Class<NestedClass> classToInstantiate = NestedClass.class;
	UserDefinedConstructorInstantiator instantiator = new UserDefinedConstructorInstantiator(classToInstantiate, constructorParameters);
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @Test
    void Should_Create_Object_Using_Private_Constructor() {
	// given
	Class<ClassWithPrivateConstructor> classToInstantiate = ClassWithPrivateConstructor.class;
	UserDefinedConstructorInstantiator instantiator = new UserDefinedConstructorInstantiator(classToInstantiate, constructorParameters);
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @TestFactory
    Stream<DynamicTest> Should_Throw_Exception_When_Cannot_Instantiate_Class() {
	return Stream.of(One_Arg_Constructor_Throws_NPE.class, No_Args_Constructor_Throws_NPE.class).map(value -> dynamicTest(getDefaultDisplayName(value.getName()), Should_Throw_Exception_When_Cannot_Instantiate_Class(value)));
    }

    private Executable Should_Throw_Exception_When_Cannot_Instantiate_Class(Class<?> classToInstantiate) {
	return () -> {
	    // given
	    UserDefinedConstructorInstantiator instantiator = new UserDefinedConstructorInstantiator(classToInstantiate, constructorParameters);
	    // when
	    Throwable result = catchThrowable(instantiator::instantiate);
	    // then
	    assertThat(result).isInstanceOf(ObjectInstantiationException.class);
	};
    }

    private class ClassWithPrivateConstructor {
	private ClassWithPrivateConstructor(int a) {
	}
    }

    @Data
    @AllArgsConstructor
    private class InnerClass {
	private int a;
    }

    @Data
    @AllArgsConstructor
    private static class NestedClass {
	private int a;
    }

    private class No_Args_Constructor_Throws_NPE {
	No_Args_Constructor_Throws_NPE() {
	    throw new NullPointerException("test");
	}
    }

    private class One_Arg_Constructor_Throws_NPE {
	One_Arg_Constructor_Throws_NPE(Object o) {
	    throw new NullPointerException("test");
	}
    }

    private class UserDefinedClass {
	private int a;
	private int b;

	UserDefinedClass(int a) {
	    throw new RuntimeException("test");
	}

	UserDefinedClass(int a, int b) {
	    this.a = a;
	    this.b = b;
	}
    }
}
