package com.wade.pojotester.changer.collections.collection;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

@SuppressWarnings({ "rawtypes" })
class QueueChangerTest {
    @Test
    void Should_Return_Any_Instance_When_Value_Is_Empty() {
	// given
	final Queue<String> value = new LinkedList<>();
	final Class<Queue> type = Queue.class;
	final QueueValueChanger valueChanger = new QueueValueChanger();
	// when
	final Queue<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Any_Instance_When_Value_Is_Null() {
	// given
	final Queue<String> value = null;
	final Class<Queue> type = Queue.class;
	final QueueValueChanger valueChanger = new QueueValueChanger();
	// when
	final Queue<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isInstanceOf(type);
    }

    @Test
    void Should_Return_Null_When_Value_Is_Not_Null_And_Not_Empty() {
	// given
	final Queue<String> value = new LinkedList<>();
	value.add("test");
	final Class<? extends Queue> type = value.getClass();
	final QueueValueChanger valueChanger = new QueueValueChanger();
	// when
	final Queue<?> result = valueChanger.increaseValue(value, type);
	// then
	assertThat(result).isNull();
    }
}
