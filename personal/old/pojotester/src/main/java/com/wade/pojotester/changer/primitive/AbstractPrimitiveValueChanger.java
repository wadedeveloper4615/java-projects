/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer.primitive;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.util.CollectionUtils;
import com.wade.pojotester.util.FieldUtils;

/**
 * The type Abstract primitive value changer.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractPrimitiveValueChanger<T> extends AbstractFieldValueChanger<T> {
    /**
     * The constant INSTANCE.
     */
//@formatter:off
    public static  AbstractFieldValueChanger<?> INSTANCE = new BooleanValueChanger().attachNext(new ByteValueChanger())
                                                                                      .attachNext(new CharacterValueChanger())
                                                                                      .attachNext(new DoubleValueChanger())
                                                                                      .attachNext(new IntegerValueChanger())
                                                                                      .attachNext(new LongValueChanger())
                                                                                      .attachNext(new ShortValueChanger())
                                                                                      .attachNext(new FloatValueChanger());
    /**
     * The constant LOGGER.
     */
    private static  Log LOGGER = LogFactory.getLog(AbstractPrimitiveValueChanger.class);
    /**
     * The Primitive classes.
     */
    private static  List<Class<?>> PRIMITIVE_CLASSES = CollectionUtils.asList(Float.class,
                                                                                   Integer.class,
                                                                                   Long.class,
                                                                                   Float.class,
                                                                                   Double.class,
                                                                                   Byte.class,
                                                                                   Short.class,
                                                                                   Boolean.class,
                                                                                   Character.class);
    /**
     * The constant FIELD_WITH_PRIMITIVE_CLASS_REFERENCE.
     */
    private static  String FIELD_WITH_PRIMITIVE_CLASS_REFERENCE = "TYPE";
    //@formatter:on

    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    @Override
    protected boolean canChange(Class<?> type) {
	return isPrimitive(type) && isCompatibleWithPrimitive(type) || isWrappedPrimitive(type) && isCompatibleWithWrappedPrimitive(type);
    }

    /**
     * Increase t.
     *
     * @param value the value
     * 
     * @return the t
     */
    protected abstract T increase(T value);

    /**
     * Increase value t.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the t
     */
    @Override
    protected T increaseValue(T value, Class<?> type) {
	return increase(value);
    }

    /**
     * Is compatible with primitive boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    private boolean isCompatibleWithPrimitive(Class<?> type) {
	try {
	    return FieldUtils.getValue(null, getGenericTypeClass().getField(FIELD_WITH_PRIMITIVE_CLASS_REFERENCE)).equals(type);
	} catch (NoSuchFieldException e) {
	    LOGGER.debug("NoSuchFieldException:", e);
	    return false;
	}
    }

    /**
     * Is compatible with wrapped primitive boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    private boolean isCompatibleWithWrappedPrimitive(Class<?> type) {
	try {
	    Object fieldPrimitiveType = FieldUtils.getValue(null, type.getField(FIELD_WITH_PRIMITIVE_CLASS_REFERENCE));
	    return FieldUtils.getValue(null, getGenericTypeClass().getField(FIELD_WITH_PRIMITIVE_CLASS_REFERENCE)).equals(fieldPrimitiveType);
	} catch (NoSuchFieldException e) {
	    LOGGER.debug("NoSuchFieldException:", e);
	    return false;
	}
    }

    /**
     * Is primitive boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    private boolean isPrimitive(Class<?> type) {
	return type.isPrimitive();
    }

    /**
     * Is wrapped primitive boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    private boolean isWrappedPrimitive(Class<?> type) {
	return PRIMITIVE_CLASSES.contains(type);
    }
}
