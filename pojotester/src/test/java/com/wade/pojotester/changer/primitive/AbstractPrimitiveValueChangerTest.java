package com.wade.pojotester.changer.primitive;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

class AbstractPrimitiveValueChangerTest {
    @Test
    void Should_Return_False_When_Field_Is_Not_Primitive() throws Exception {
	final Field field = Thread.class.getDeclaredField("tid");
	final AbstractPrimitiveValueChanger<Object> changerMock = new ImplementationForTest();
	changerMock.increase(null);
	final boolean result = changerMock.canChange(field.getType());
	assertThat(result).isFalse();
    }

    private class ImplementationForTest extends AbstractPrimitiveValueChanger<Object> {
	@Override
	protected Object increase(final Object value) {
	    return null;
	}
    }
}
