package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import com.wade.pojotester.assertion.Assertions;
import com.wade.pojotester.assertion.constructor.ConstructorAssertionError;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.changer.collections.CollectionsFieldValueChanger;
import com.wade.pojotester.changer.date.DefaultDateAndTimeFieldValueChanger;
import com.wade.pojotester.instantiator.Instantiable;
import com.wade.pojotester.preconditions.ParameterPreconditions;
import com.wade.pojotester.testfiles.ClassWithSyntheticConstructor;
import com.wade.pojotester.util.CollectionUtils;
import com.wade.pojotester.util.ConstructorParameters;
import com.wade.pojotester.util.Sublists;

@SuppressWarnings({ "rawtypes", "unused" })
class ConstructorTesterTest {
    @Test
    void Should_Create_Constructor_Parameters_When_Could_Not_Find_Matching_Constructor_Parameters_Types() {
	// given
	Class[] classesToTest = { ClassWithSyntheticConstructor.class };
	ConstructorParameters parameters = spy(new ConstructorParameters(new Object[] { "to", "many", "parameters" }, new Class[] { String.class, String.class, String.class }));
	MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = spy(new ArrayListValuedHashMap<>());
	constructorParameters.put(ClassWithSyntheticConstructor.class, parameters);
	ConstructorTester constructorTester = new ConstructorTester();
	constructorTester.setUserDefinedConstructors(constructorParameters);
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
	verify(parameters, never()).getParameters();
    }

    @Test
    void Should_Create_Constructor_Parameters_When_Parameters_Are_Not_Provided() {
	// given
	Class[] classesToTest = { ClassWithSyntheticConstructor.class };
	MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = spy(new ArrayListValuedHashMap<>());
	ConstructorTester constructorTester = new ConstructorTester();
	constructorTester.setUserDefinedConstructors(constructorParameters);
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
	verify(constructorParameters, never()).get(ClassWithSyntheticConstructor.class);
    }

    @Test
    void Should_Fail_Constructor_Tests() {
	// given
	Class[] classesToTest = { BadConstructorPojo.class };
	ConstructorTester constructorTester = new ConstructorTester();
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isInstanceOf(ConstructorAssertionError.class);
    }

    @Test
    void Should_Pass_All_Constructor_Tests() {
	// given
	Class[] classesToTest = { Pojo.class, ParameterPreconditions.class, CollectionsFieldValueChanger.class, DefaultFieldValueChanger.class, Assertions.class, Instantiable.class, Sublists.class, ReflectionUtils.class, DefaultDateAndTimeFieldValueChanger.class, CollectionUtils.class, ClassLoader.class };
	ConstructorTester constructorTester = new ConstructorTester(DefaultFieldValueChanger.INSTANCE);
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Skip_Constructor_Tests_If_Class_Is_Abstract() {
	// given
	Class[] classesToTest = { AbstractBadConstructorPojo.class };
	ConstructorTester constructorTester = new ConstructorTester();
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Use_User_Constructor_Parameters() {
	// given
	Class[] classesToTest = { ClassWithSyntheticConstructor.class };
	ConstructorParameters parameters = new ConstructorParameters(new Object[] { "string" }, new Class[] { String.class });
	MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = spy(new ArrayListValuedHashMap<>());
	constructorParameters.put(ClassWithSyntheticConstructor.class, parameters);
	ConstructorTester constructorTester = new ConstructorTester();
	constructorTester.setUserDefinedConstructors(constructorParameters);
	// when
	Throwable result = catchThrowable(() -> constructorTester.testAll(classesToTest));
	// then
	assertThat(result).isNull();
	verify(constructorParameters).get(ClassWithSyntheticConstructor.class);
    }

    private abstract static class AbstractBadConstructorPojo {
	AbstractBadConstructorPojo() {
	    throw new RuntimeException("test");
	}
    }

    private static class BadConstructorPojo {
	BadConstructorPojo() {
	    throw new RuntimeException("test");
	}
    }

    private static class Pojo {
	Pojo() {
	}

	Pojo(int y) {
	}

	Pojo(String x) {
	}
    }
}