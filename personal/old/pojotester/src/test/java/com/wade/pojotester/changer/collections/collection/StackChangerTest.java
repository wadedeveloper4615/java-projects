package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class StackChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final Stack<String> value = new Stack<>();
	final Class<Stack> type = Stack.class;
	final StackValueChanger valueChanger = new StackValueChanger();
	// when
	final Stack<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final Stack<String> value = null;
	final Class<Stack> type = Stack.class;
	final StackValueChanger valueChanger = new StackValueChanger();
	// when
	final Stack<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final Stack<String> value = new Stack<>();
	value.add("test");
	final Class<? extends Stack> type = value.getClass();
	final StackValueChanger valueChanger = new StackValueChanger();
	// when
	final Stack<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
