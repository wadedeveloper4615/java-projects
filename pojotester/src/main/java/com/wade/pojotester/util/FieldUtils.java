/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import com.wade.pojotester.exception.GetOrSetValueException;

// TODO: Auto-generated Javadoc
/**
 * The type Field utils.
 */
public class FieldUtils {
    /**
     * The constant MODIFIERS_FIELD_NAME_IN_FIELD_CLASS.
     */
    public static String MODIFIERS_FIELD_NAME_IN_FIELD_CLASS = "modifiers";

    /**
     * Does not contain boolean.
     *
     * @param field          the field
     * @param excludedFields the excluded fields
     *
     * @return the boolean
     */
    private static boolean doesNotContain(Field field, List<String> excludedFields) {
	return !excludedFields.contains(field.getName());
    }

    /**
     * Exclude empty set boolean.
     *
     * @param fields the fields
     *
     * @return the boolean
     */
    private static boolean excludeEmptySet(List<Field> fields) {
	return !fields.isEmpty();
    }

    /**
     * Gets all field names.
     *
     * @param clazz the clazz
     *
     * @return the all field names
     */
    public static List<String> getAllFieldNames(Class<?> clazz) {
	return getAllFields(clazz).stream().map(Field::getName).collect(Collectors.toList());
    }

    /**
     * Gets all fields.
     *
     * @param clazz the clazz
     *
     * @return the all fields
     */
    public static List<Field> getAllFields(Class<?> clazz) {
	return Arrays.stream(clazz.getDeclaredFields()).filter(FieldUtils::isNotSynthetic).filter(FieldUtils::isNotStatic).collect(Collectors.toList());
    }

    /**
     * Gets all fields excluding.
     *
     * @param clazz          the clazz
     * @param excludedFields the excluded fields
     *
     * @return the all fields excluding
     */
    public static List<Field> getAllFieldsExcluding(Class<?> clazz, List<String> excludedFields) {
	return getAllFields(clazz).stream().filter(field -> doesNotContain(field, excludedFields)).collect(Collectors.toList());
    }

    /**
     * Gets field.
     *
     * @param clazz the clazz
     * @param name  the name
     *
     * @return the field
     */
    private static Field getField(Class<?> clazz, String name) {
	try {
	    return clazz.getDeclaredField(name);
	} catch (java.lang.NoSuchFieldException e) {
	    throw new GetOrSetValueException(name, clazz, e);
	}
    }

    /**
     * Gets fields.
     *
     * @param testedClass the tested class
     * @param predicate   the predicate
     *
     * @return the fields
     */
    public static List<Field> getFields(Class<?> testedClass, Predicate<String> predicate) {
	return getAllFields(testedClass).stream().filter(eachField -> predicate.test(eachField.getName())).collect(Collectors.toList());
    }

    /**
     * Gets specified fields.
     *
     * @param clazz the clazz
     * @param names the names
     *
     * @return the specified fields
     */
    public static List<Field> getSpecifiedFields(Class<?> clazz, List<String> names) {
	return names.stream().map(name -> getField(clazz, name)).collect(Collectors.toList());
    }

    /**
     * Gets value.
     *
     * @param targetObject the target object
     * @param field        the field
     *
     * @return the value
     */
    public static Object getValue(Object targetObject, Field field) {
	try {
	    makeModifiable(field);
	    return field.get(targetObject);
	} catch (IllegalAccessException e) {
	    throw new GetOrSetValueException(field.getName(), targetObject.getClass(), e);
	}
    }

    /**
     * Is boolean.
     *
     * @param field the field
     *
     * @return the boolean
     */
    public static boolean isFinal(Field field) {
	int fieldModifiers = field.getModifiers();
	return Modifier.isFinal(fieldModifiers);
    }

    /**
     * Is not static boolean.
     *
     * @param field the field
     *
     * @return the boolean
     */
    private static boolean isNotStatic(Field field) {
	return !Modifier.isStatic(field.getModifiers());
    }

    /**
     * Is not synthetic boolean.
     *
     * @param field the field
     *
     * @return the boolean
     */
    private static boolean isNotSynthetic(Field field) {
	return !field.isSynthetic();
    }

    /**
     * Make modifiable.
     *
     * @param field the field
     */
    private static void makeModifiable(Field field) {
	field.setAccessible(true);
	FieldHelper.makeNon(field);
    }

    /**
     * Permutations list.
     *
     * @param fields the fields
     *
     * @return the list
     */
    public static List<List<Field>> permutations(List<Field> fields) {
	ICombinatoricsVector<Field> vector = Factory.createVector(fields);
	Generator<Field> subSetGenerator = Factory.createSubSetGenerator(vector);
	return subSetGenerator.generateAllObjects().stream().map(ICombinatoricsVector::getVector).filter(FieldUtils::excludeEmptySet).collect(Collectors.toList());
    }

    /**
     * Sets value.
     *
     * @param targetObject the target object
     * @param field        the field
     * @param value        the value
     */
    public static void setValue(Object targetObject, Field field, Object value) {
	try {
	    makeModifiable(field);
	    field.set(targetObject, value);
	} catch (IllegalAccessException e) {
	    throw new GetOrSetValueException(field.getName(), targetObject.getClass(), e);
	}
    }
}
