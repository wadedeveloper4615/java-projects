package com.wade.pojotester.changer.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class HashMapValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final HashMap<String, String> value = null;
	final Class<HashMap> type = HashMap.class;
	final HashMapValueChanger valueChanger = new HashMapValueChanger();
	// when
	final HashMap<?, ?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null() {
	// given
	final HashMap<String, String> value = new HashMap<>();
	final Class<? extends HashMap> type = value.getClass();
	final HashMapValueChanger valueChanger = new HashMapValueChanger();
	// when
	final HashMap<?, ?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
