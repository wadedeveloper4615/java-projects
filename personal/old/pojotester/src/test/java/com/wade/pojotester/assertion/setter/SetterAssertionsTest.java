/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.setter;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.exception.GetOrSetValueException;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.FullPojo;
import com.wade.pojotester.testfiles.SimpleClass;
import com.wade.pojotester.util.FieldUtils;
import com.wade.pojotester.util.MethodUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

class SetterAssertionsTest {
    private SetterAndFieldPair findSetterAndGetterPairForField(Class<?> testedClass, Field field) {
	Method setter = MethodUtils.findSetterFor(testedClass, field);
	return new SetterAndFieldPair(setter, field);
    }

    private List<SetterAndFieldPair> findSetterAndGetterPairsForFields(Class<?> testedClass, List<Field> fields) {
	return fields.stream().filter(field -> !FieldUtils.isFinal(field)).map(fieldName -> findSetterAndGetterPairForField(testedClass, fieldName)).collect(Collectors.toList());
    }

    @Test
    void test1() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	SetterAssertions objectUnderTest = new SetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<SetterAndFieldPair> setterAndFieldPairs = findSetterAndGetterPairsForFields(testedClass, fields);
	Method getter = setterAndFieldPairs.get(0).getSetter();
	Field field = setterAndFieldPairs.get(0).getField();
	Object value = (char) 25;
	objectUnderTest.willSetValueOnField(getter, field, value);
	assertThat(objectUnderTest.getObjectUnderAssert()).isNotNull();
	assertThat(objectUnderTest.getClassUnderTest()).isNotNull();
    }

    @Test
    void test2() throws Exception {
	Class<?> clazz = SimpleClass.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	SetterAssertions objectUnderTest = new SetterAssertions(a);
	Class<?> clazz2 = FullPojo.class;
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz2, FieldPredicate.includeAllFields(clazz2));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<SetterAndFieldPair> setterAndFieldPairs = findSetterAndGetterPairsForFields(testedClass, fields);
	Method getter = setterAndFieldPairs.get(1).getSetter();
	Field field = setterAndFieldPairs.get(1).getField();
	Object value = (char) 25;
	Assertions.assertThrows(GetOrSetValueException.class, () -> {
	    objectUnderTest.willSetValueOnField(getter, field, value);
	});
    }

    @Test
    void test3() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	SetterAssertions objectUnderTest = new SetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<SetterAndFieldPair> setterAndFieldPairs = findSetterAndGetterPairsForFields(testedClass, fields);
	Method getter = setterAndFieldPairs.get(0).getSetter();
	Field field = setterAndFieldPairs.get(0).getField();
	Object value = (char) 25;
	objectUnderTest.willSetValueOnField(getter, field, value);
	objectUnderTest.checkResult(true, new SetterAssertionError(clazz, field, value, value));
    }

    @Test
    void test4() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	SetterAssertions objectUnderTest = new SetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<SetterAndFieldPair> setterAndFieldPairs = findSetterAndGetterPairsForFields(testedClass, fields);
	Method getter = setterAndFieldPairs.get(0).getSetter();
	Field field = setterAndFieldPairs.get(0).getField();
	Object value = (char) 25;
	objectUnderTest.willSetValueOnField(getter, field, value);
	Assertions.assertThrows(SetterAssertionError.class, () -> {
	    objectUnderTest.checkResult(false, new SetterAssertionError(clazz, field, value, value));
	});
    }

    @Getter
    @Setter
    @ToString
    private class SetterAndFieldPair {
	private Method setter;
	private Field field;

	public SetterAndFieldPair(Method setter, Field field) {
	    this.setter = setter;
	    this.field = field;
	}
    }
}
