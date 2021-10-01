package com.wade.pojotester.instantiator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.exception.ObjectInstantiationException;

@SuppressWarnings({ "unused" })
class DefaultConstructorInstantiatorTest {
    @Test
    void Should_Create_Object_Using_Default_Constructor() {
	// given
	Class<String> classToInstantiate = String.class;
	DefaultConstructorInstantiator instantiator = new DefaultConstructorInstantiator(classToInstantiate, new ArrayListValuedHashMap<>());
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(classToInstantiate);
    }

    @Test
    void Should_Throw_Exception_When_Cannot_Instantiate_Object() {
	// given
	Class<?> classToInstantiate = No_Args_Constructor_Throws_IllegalAccessException.class;
	DefaultConstructorInstantiator instantiator = new DefaultConstructorInstantiator(classToInstantiate, new ArrayListValuedHashMap<>());
	// when
	Throwable result = catchThrowable(instantiator::instantiate);
	// then
	assertThat(result).isInstanceOf(ObjectInstantiationException.class);
    }

    private class No_Args_Constructor_Throws_IllegalAccessException {
	No_Args_Constructor_Throws_IllegalAccessException() throws IllegalAccessException {
	    throw new IllegalAccessException("test");
	}
    }
}
