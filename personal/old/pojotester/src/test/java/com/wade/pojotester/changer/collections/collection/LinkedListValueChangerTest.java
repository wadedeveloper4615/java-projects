package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class LinkedListValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final LinkedList<String> value = new LinkedList<>();
	final Class<LinkedList> type = LinkedList.class;
	final LinkedListValueChanger valueChanger = new LinkedListValueChanger();
	// when
	final LinkedList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final LinkedList<String> value = null;
	final Class<LinkedList> type = LinkedList.class;
	final LinkedListValueChanger valueChanger = new LinkedListValueChanger();
	// when
	final LinkedList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final LinkedList<String> value = new LinkedList<>();
	value.add("test");
	final Class<? extends LinkedList> type = value.getClass();
	final LinkedListValueChanger valueChanger = new LinkedListValueChanger();
	// when
	final LinkedList<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
