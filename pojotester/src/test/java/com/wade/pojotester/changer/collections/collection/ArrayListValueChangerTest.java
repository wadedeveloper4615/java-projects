package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class ArrayListValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final ArrayList<String> value = new ArrayList<>();
	final Class<ArrayList> type = ArrayList.class;
	final ArrayListValueChanger valueChanger = new ArrayListValueChanger();
	// when
	final ArrayList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final ArrayList<String> value = null;
	final Class<ArrayList> type = ArrayList.class;
	final ArrayListValueChanger valueChanger = new ArrayListValueChanger();
	// when
	final ArrayList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final ArrayList<String> value = new ArrayList<>();
	value.add("test");
	final Class<? extends ArrayList> type = value.getClass();
	final ArrayListValueChanger valueChanger = new ArrayListValueChanger();
	// when
	final ArrayList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
