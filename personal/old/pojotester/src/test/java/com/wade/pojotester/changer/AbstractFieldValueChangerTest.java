package com.wade.pojotester.changer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.reflect.Whitebox.getInternalState;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.wade.pojotester.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings({ "rawtypes", "unchecked" })
class AbstractFieldValueChangerTest {
    @Test
    void Should_Not_Change_If_No_Matching_Changer() {
	// given
	final AbstractFieldValueChanger abstractFieldValueChanger = new ImplementationForTest();
	final String expectedValue = "string";
	// when
	final Object result = abstractFieldValueChanger.increaseValue(expectedValue);
	// then
	assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    void Should_Not_Change_If_Values_Are_Different() throws NoSuchFieldException {
	// given
	final AbstractFieldValueChanger valueChanger = mock(AbstractFieldValueChanger.class, Mockito.CALLS_REAL_METHODS);
	when(valueChanger.canChange(any())).thenReturn(true);
	when(valueChanger.areDifferentValues(any(), any())).thenReturn(true);
	final int expectedResult = 2;
	final ClassWithSingleIntField sourceObject = new ClassWithSingleIntField(1);
	final ClassWithSingleIntField targetObject = new ClassWithSingleIntField(expectedResult);
	final ArrayList<Field> fields = CollectionUtils.asList(sourceObject.getClass().getDeclaredField("i"));
	// when
	valueChanger.changeFieldsValues(sourceObject, targetObject, fields);
	// then
	assertThat(targetObject.getI()).isEqualTo(expectedResult);
    }

    @Test
    void Should_Register_First_Value_Changer() {
	// given
	final AbstractFieldValueChanger abstractFieldValueChanger = new ImplementationForTest();
	// when
	abstractFieldValueChanger.attachNext(abstractFieldValueChanger);
	final AbstractFieldValueChanger result = getInternalState(abstractFieldValueChanger, "next");
	// then
	assertThat(result).isNotNull();
    }

    @Test
    void Should_Register_Value_Changer_To_Already_Registered_One() {
	// given
	final AbstractFieldValueChanger abstractFieldValueChanger = new ImplementationForTest();
	final AbstractFieldValueChanger first = mock(AbstractFieldValueChanger.class, Mockito.CALLS_REAL_METHODS);
	final AbstractFieldValueChanger second = mock(AbstractFieldValueChanger.class, Mockito.CALLS_REAL_METHODS);
	// when
	abstractFieldValueChanger.attachNext(first).attachNext(second);
	// then
	verify(first).attachNext(second);
    }

    @Data
    @AllArgsConstructor
    private class ClassWithSingleIntField {
	private int i;
    }

    private class ImplementationForTest extends AbstractFieldValueChanger<Object> {
	@Override
	public boolean areDifferentValues(final Object sourceValue, final Object targetValue) {
	    return false;
	}

	@Override
	protected boolean canChange(final Class<?> type) {
	    return false;
	}

	@Override
	protected Object increaseValue(final Object value, final Class<?> type) {
	    return null;
	}
    }
}
