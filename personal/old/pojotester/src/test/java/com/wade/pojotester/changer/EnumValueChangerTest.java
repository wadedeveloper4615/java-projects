package com.wade.pojotester.changer;

import static helpers.TestHelper.getDefaultDisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.powermock.reflect.Whitebox.getInternalState;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

import com.wade.pojotester.exception.ImpossibleEnumValueChangeException;
import com.wade.pojotester.testfiles.fields.AllFiledTypes;
import com.wade.pojotester.testfiles.fields.AllFiledTypes_Wrapped;
import com.wade.pojotester.testfiles.fields.EnumFields;
import com.wade.pojotester.testfiles.fields.EnumWithoutConstants;
import com.wade.pojotester.testfiles.fields.SingleEnum;
import com.wade.pojotester.testfiles.fields.TestEnum1;

import lombok.AllArgsConstructor;

@SuppressWarnings({ "rawtypes", "unchecked" })
class EnumValueChangerTest {
    private final AbstractFieldValueChanger<Enum> valueChanger = new EnumValueChanger();

    @TestFactory
    Stream<DynamicTest> Should_Change_Enum_Value() {
	return Stream.of(TestEnum1.ENUM1, TestEnum1.ENUM2).map(value -> dynamicTest(getDefaultDisplayName(value), Should_Change_Enum_Value(value)));
    }

    private Executable Should_Change_Enum_Value(final TestEnum1 value) {
	return () -> {
	    // given
	    final EnumFields helpClass1 = new EnumFields(value);
	    final EnumFields helpClass2 = new EnumFields(value);
	    // when
	    valueChanger.changeFieldsValues(helpClass1, helpClass2, newArrayList(EnumFields.class.getDeclaredFields()));
	    final TestEnum1 result1 = getInternalState(helpClass1, "testEnum1");
	    final TestEnum1 result2 = getInternalState(helpClass2, "testEnum1");
	    // then
	    assertThat(result1).isNotEqualTo(result2);
	};
    }

    @Test
    void Should_Return_Null_For_Single_Enum_Constant() {
	// given
	// when
	final Enum result = valueChanger.increaseValue(SingleEnum.ENUM1, SingleEnum.class);
	// then
	assertThat(result).isNull();
    }

    @TestFactory
    Stream<DynamicTest> Should_Return_True_Or_False_Whether_Can_Change_Or_Not() throws NoSuchFieldException {
	return Stream.of(new CanChangeCase(EnumFields.class.getDeclaredField("nullEnum"), true), new CanChangeCase(EnumFields.class.getDeclaredField("testEnum1"), true), new CanChangeCase(EnumFields.class.getDeclaredField("singleEnum1"), true), new CanChangeCase(AllFiledTypes.class.getDeclaredField("intType"), false), new CanChangeCase(AllFiledTypes_Wrapped.class.getDeclaredField("intType"), false), new CanChangeCase(EnumFields.class.getDeclaredField("object"), false))
		.map(value -> dynamicTest(getDefaultDisplayName(value.field.getName()), Should_Return_True_Or_False_Whether_Can_Change_Or_Not(value)));
    }

    private Executable Should_Return_True_Or_False_Whether_Can_Change_Or_Not(final CanChangeCase testCase) {
	return () -> {
	    // when
	    final boolean result = valueChanger.canChange(testCase.field.getType());
	    // then
	    assertThat(result).isEqualTo(testCase.result);
	};
    }

    @TestFactory
    Stream<DynamicTest> Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not() {
	return Stream.of(new AreDifferentCase(null, null, false), new AreDifferentCase(TestEnum1.ENUM1, TestEnum1.ENUM1, false), new AreDifferentCase(TestEnum1.ENUM2, TestEnum1.ENUM2, false), new AreDifferentCase(TestEnum1.ENUM2, TestEnum1.ENUM2, false), new AreDifferentCase(TestEnum1.ENUM2, null, true), new AreDifferentCase(null, TestEnum1.ENUM2, true), new AreDifferentCase(TestEnum1.ENUM2, null, true), new AreDifferentCase(TestEnum1.ENUM2, TestEnum1.ENUM1, true))
		.map(value -> dynamicTest(getDefaultDisplayName(value.value1 + " " + value.value2), Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not(value)));
    }

    private Executable Should_Return_True_Or_False_Whether_Values_Are_Different_Or_Not(final AreDifferentCase testCase) {
	return () -> {
	    // when
	    final boolean result = valueChanger.areDifferentValues(testCase.value1, testCase.value2);
	    // then
	    assertThat(result).isEqualTo(testCase.result);
	};
    }

    @Test
    void Should_Throw_Exception_When_Enum_Has_No_Constants() {
	// given
	// when
	final Throwable result = catchThrowable(() -> valueChanger.increaseValue(null, EnumWithoutConstants.class));
	// then
	assertThat(result).isInstanceOf(ImpossibleEnumValueChangeException.class);
    }

    @AllArgsConstructor
    private class AreDifferentCase {
	private TestEnum1 value1;
	private TestEnum1 value2;
	private boolean result;
    }

    @AllArgsConstructor
    private class CanChangeCase {
	private Field field;
	private boolean result;
    }
}
