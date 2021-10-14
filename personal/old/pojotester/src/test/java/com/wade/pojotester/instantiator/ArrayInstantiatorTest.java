package com.wade.pojotester.instantiator;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

class ArrayInstantiatorTest {
    private Executable Should_Create_Array(Class<?> classToInstantiate) {
	return () -> {
	    // given
	    ArrayInstantiator instantiator = new ArrayInstantiator(classToInstantiate, new ArrayListValuedHashMap<>());
	    // when
	    Object result = instantiator.instantiate();
	    // then
	    assertThat(result).isInstanceOf(classToInstantiate);
	};
    }

    @TestFactory
    Stream<DynamicTest> Should_Create_Array_By_Class() {
	return Stream.of(Integer[].class, Byte[].class, Character[].class, Double[].class, Float[].class, Integer[].class, Long[].class, Short[].class, boolean[].class, byte[].class, char[].class, double[].class, float[].class, int[].class, long[].class, short[].class).map(value -> dynamicTest(getDefaultDisplayName(value), Should_Create_Array(value)));
    }
}
