package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.TreeSet;

import org.junit.jupiter.api.Test;

@SuppressWarnings("rawtypes")
class TreeSetChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final TreeSet<String> value = new TreeSet<>();
	final Class<TreeSet> type = TreeSet.class;
	final TreeSetValueChanger valueChanger = new TreeSetValueChanger();
	// when
	final TreeSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final TreeSet<String> value = null;
	final Class<TreeSet> type = TreeSet.class;
	final TreeSetValueChanger valueChanger = new TreeSetValueChanger();
	// when
	final TreeSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final TreeSet<String> value = new TreeSet<>();
	value.add("test");
	final Class<? extends TreeSet> type = value.getClass();
	final TreeSetValueChanger valueChanger = new TreeSetValueChanger();
	// when
	final TreeSet<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
