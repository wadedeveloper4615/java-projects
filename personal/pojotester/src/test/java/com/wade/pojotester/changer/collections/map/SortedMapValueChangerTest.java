package com.wade.pojotester.changer.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class SortedMapValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final SortedMap<String, String> value = null;
	final Class<SortedMap> type = SortedMap.class;
	final SortedMapValueChanger valueChanger = new SortedMapValueChanger();
	// when
	final SortedMap<?, ?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null() {
	// given
	final SortedMap<String, String> value = new TreeMap<>();
	final Class<? extends SortedMap> type = value.getClass();
	final SortedMapValueChanger valueChanger = new SortedMapValueChanger();
	// when
	final SortedMap<?, ?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
