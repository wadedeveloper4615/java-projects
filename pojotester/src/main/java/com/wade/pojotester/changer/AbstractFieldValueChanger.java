/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.changer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.util.FieldUtils;

/**
 * The type Abstract field value changer.
 *
 * @param <T> the type parameter
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractFieldValueChanger<T> {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(AbstractFieldValueChanger.class);
    /**
     * The Next.
     */
    private AbstractFieldValueChanger next;

    /**
     * Are different values boolean.
     *
     * @param sourceValue the source value
     * @param targetValue the target value
     * 
     * @return the boolean
     */
    public boolean areDifferentValues(T sourceValue, T targetValue) {
	return !Objects.equals(sourceValue, targetValue);
    }

    /**
     * Attach next abstract field value changer.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     * 
     * @return the abstract field value changer
     */
    public AbstractFieldValueChanger attachNext(AbstractFieldValueChanger abstractFieldValueChanger) {
	if (this.next == null) {
	    this.next = abstractFieldValueChanger;
	    LOGGER.debug(String.format("Attaching %s to %s", abstractFieldValueChanger.getClass().getCanonicalName(), this.getClass().getCanonicalName()));
	} else {
	    this.next.attachNext(abstractFieldValueChanger);
	}
	return this;
    }

    /**
     * Call next values changer.
     *
     * @param sourceObject   the source object
     * @param targetObject   the target object
     * @param fieldsToChange the fields to change
     */
    private void callNextValuesChanger(Object sourceObject, Object targetObject, List<Field> fieldsToChange) {
	if (next != null) {
	    next.changeFieldsValues(sourceObject, targetObject, fieldsToChange);
	}
    }

    /**
     * Can change boolean.
     *
     * @param type the type
     * 
     * @return the boolean
     */
    protected abstract boolean canChange(Class<?> type);

    /**
     * Change fields values.
     *
     * @param sourceObject   the source object
     * @param targetObject   the target object
     * @param fieldsToChange the fields to change
     */
    public void changeFieldsValues(Object sourceObject, Object targetObject, List<Field> fieldsToChange) {
	fieldsToChange.forEach(eachField -> checkAndChange(sourceObject, targetObject, eachField));
	callNextValuesChanger(sourceObject, targetObject, fieldsToChange);
    }

    /**
     * Change field value.
     *
     * @param sourceObject the source object
     * @param targetObject the target object
     * @param field        the field
     */
    private void changeFieldValue(Object sourceObject, Object targetObject, Field field) {
	T sourceFieldValue = (T) FieldUtils.getValue(sourceObject, field);
	T targetFieldValue = (T) FieldUtils.getValue(targetObject, field);
	if (!areDifferentValues(sourceFieldValue, targetFieldValue)) {
	    T increasedValue = increaseValue(targetFieldValue, field.getType());
	    LOGGER.debug(String.format("Changing value of type %s from '%s' to '%s' (%s)", field.getType(), sourceFieldValue, increasedValue, this));
	    FieldUtils.setValue(targetObject, field, increasedValue);
	}
    }

    /**
     * Check and change.
     *
     * @param sourceObject the source object
     * @param targetObject the target object
     * @param field        the field
     */
    private void checkAndChange(Object sourceObject, Object targetObject, Field field) {
	if (canChange(field.getType())) {
	    changeFieldValue(sourceObject, targetObject, field);
	}
    }

    /**
     * Gets generic type class.
     *
     * @return the generic type class
     */
    protected Class<T> getGenericTypeClass() {
	Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	return type instanceof ParameterizedType ? (Class<T>) ((ParameterizedType) type).getRawType() : (Class<T>) type;
    }

    /**
     * Increase value t.
     *
     * @param value the value
     * 
     * @return the t
     */
    public T increaseValue(T value) {
	if (canChange(value.getClass())) {
	    T increasedValue = increaseValue(value, value.getClass());
	    LOGGER.debug(String.format("Changing value of type %s from '%s' to '%s' (%s)", value.getClass(), value, increasedValue, this));
	    return increasedValue;
	} else {
	    if (next != null) {
		return (T) next.increaseValue(value);
	    }
	    LOGGER.debug(String.format("Could not change value '%s' ot type %s by any field value changer", value, value.getClass()));
	    return value;
	}
    }

    /**
     * Increase value t.
     *
     * @param value the value
     * @param type  the type
     * 
     * @return the t
     */
    protected abstract T increaseValue(T value, Class<?> type);
}
