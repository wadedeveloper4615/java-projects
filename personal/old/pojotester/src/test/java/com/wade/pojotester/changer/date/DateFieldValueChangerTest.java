package com.wade.pojotester.changer.date;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import lombok.AllArgsConstructor;

class DateFieldValueChangerTest {
    private final DateFieldValueChanger valueChanger = new DateFieldValueChanger();

    @Test
    void Should_Increase_Value() {
	// given
	final Date beforeChange = new Date();
	// when
	final Date result = valueChanger.increaseValue(beforeChange, beforeChange.getClass());
	// then
	assertThat(result).isNotEqualTo(beforeChange);
    }

    @Test
    void Should_Return_False_If_Can_Not_Change() {
	// given
	// when
	final boolean result = valueChanger.canChange(String.class);
	// then
	assertThat(result).isFalse();
    }

    @Test
    void Should_Return_True_If_Can_Change() {
	// given
	// when
	final boolean result = valueChanger.canChange(Date.class);
	// then
	assertThat(result).isTrue();
    }

    @TestFactory
    Stream<DynamicTest> Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not() {
	final Date date1 = new Date(123456);
	final Date date2 = new Date(654321);
	return Stream.of(new AreDifferentCase(null, null, false), new AreDifferentCase(date1, date1, false), new AreDifferentCase(null, date2, true), new AreDifferentCase(date1, null, true), new AreDifferentCase(date1, date2, true)).map(value -> dynamicTest(getDefaultDisplayName(value.value1 + " " + value.value2), Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not(value)));
    }

    private Executable Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not(final AreDifferentCase testCase) {
	return () -> {
	    // when
	    final boolean result = valueChanger.areDifferentValues(testCase.value1, testCase.value2);
	    // then
	    assertThat(result).isEqualTo(testCase.result);
	};
    }

    @AllArgsConstructor
    private class AreDifferentCase {
	private Date value1;
	private Date value2;
	private boolean result;
    }
}
