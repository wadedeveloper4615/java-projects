package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class LinkedHashSetValueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final LinkedHashSet<String> value = new LinkedHashSet<>();
	final Class<LinkedHashSet> type = LinkedHashSet.class;
	final LinkedHashSetValueChanger valueChanger = new LinkedHashSetValueChanger();
	// when
	final LinkedHashSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final LinkedHashSet<String> value = null;
	final Class<LinkedHashSet> type = LinkedHashSet.class;
	final LinkedHashSetValueChanger valueChanger = new LinkedHashSetValueChanger();
	// when
	final LinkedHashSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final LinkedHashSet<String> value = new LinkedHashSet<>();
	value.add("test");
	final Class<? extends LinkedHashSet> type = value.getClass();
	final LinkedHashSetValueChanger valueChanger = new LinkedHashSetValueChanger();
	// when
	final LinkedHashSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
