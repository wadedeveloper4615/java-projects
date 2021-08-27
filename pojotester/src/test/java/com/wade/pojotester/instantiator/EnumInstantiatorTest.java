package com.wade.pojotester.instantiator;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.testfiles.EmptyEnum;

public class EnumInstantiatorTest {
    enum DoubleEnum {
	FIRST, SECOND
    }

    enum OneEnum {
	FIRST
    }

    @Test
    void Should_Return_Any_Enum_Value() {
	// given
	Class<?> doubleEnumClass = DoubleEnum.class;
	EnumInstantiator instantiator = new EnumInstantiator(doubleEnumClass, new ArrayListValuedHashMap<>());
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(doubleEnumClass);
    }

    @Test
    void Should_Return_Null_When_Enum_Is_Empty() {
	// given
	EnumInstantiator instantiator = new EnumInstantiator(EmptyEnum.class, new ArrayListValuedHashMap<>());
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isNull();
    }

    @Test
    void Should_Return_One_Enum_Value() {
	// given
	Class<?> oneEnumClass = OneEnum.class;
	EnumInstantiator instantiator = new EnumInstantiator(oneEnumClass, new ArrayListValuedHashMap<>());
	// when
	Object result = instantiator.instantiate();
	// then
	assertThat(result).isInstanceOf(oneEnumClass);
    }
}
