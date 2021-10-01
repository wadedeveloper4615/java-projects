package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class ListValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final List<String> value = new ArrayList<>();
	final Class<List> type = List.class;
	final ListValueChanger valueChanger = new ListValueChanger();
	// when
	final List<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final List<String> value = null;
	final Class<List> type = List.class;
	final ListValueChanger valueChanger = new ListValueChanger();
	// when
	final List<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final List<String> value = new ArrayList<>();
	value.add("test");
	final Class<? extends List> type = value.getClass();
	final ListValueChanger valueChanger = new ListValueChanger();
	// when
	final List<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
