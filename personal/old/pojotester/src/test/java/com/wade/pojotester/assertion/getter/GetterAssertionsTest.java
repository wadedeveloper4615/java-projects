/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.getter;

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

class GetterAssertionsTest {
    @Getter
    @Setter
    @ToString
    public class GetterAndFieldPair {
	private Method getter;
	private Field field;

	public GetterAndFieldPair(Method getter, Field field) {
	    this.getter = getter;
	    this.field = field;
	}
    }

    private List<GetterAndFieldPair> findGettersForFields(Class<?> testedClass, List<Field> fields) {
	return fields.stream().map(fieldName -> findSetterAndGetterPairForField(testedClass, fieldName)).collect(Collectors.toList());
    }

    private GetterAndFieldPair findSetterAndGetterPairForField(Class<?> testedClass, Field field) {
	Method getter = MethodUtils.findGetterFor(testedClass, field);
	return new GetterAndFieldPair(getter, field);
    }

    @Test
    void test1() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	GetterAssertions objectUnderTest = new GetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<GetterAndFieldPair> getterAndFieldPairs = findGettersForFields(testedClass, fields);
	Method getter = getterAndFieldPairs.get(0).getGetter();
	Field field = getterAndFieldPairs.get(0).getField();
	objectUnderTest.willGetValueFromField(getter, field);
	assertThat(objectUnderTest.getObjectUnderAssert()).isNotNull();
	assertThat(objectUnderTest.getClassUnderTest()).isNotNull();
    }

    @Test
    void test2() throws Exception {
	Class<?> clazz = SimpleClass.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	GetterAssertions objectUnderTest = new GetterAssertions(a);
	Class<?> clazz2 = FullPojo.class;
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz2, FieldPredicate.includeAllFields(clazz2));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<GetterAndFieldPair> getterAndFieldPairs = findGettersForFields(testedClass, fields);
	Method getter = getterAndFieldPairs.get(0).getGetter();
	Field field = getterAndFieldPairs.get(0).getField();
	Assertions.assertThrows(GetOrSetValueException.class, () -> {
	    objectUnderTest.willGetValueFromField(getter, field);
	});
    }

    @Test
    void test3() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	GetterAssertions objectUnderTest = new GetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<GetterAndFieldPair> getterAndFieldPairs = findGettersForFields(testedClass, fields);
	Method getter = getterAndFieldPairs.get(0).getGetter();
	Field field = getterAndFieldPairs.get(0).getField();
	Object valueFromGetter = getter.invoke(a);
	Object value = FieldUtils.getValue(a, field);
	objectUnderTest.checkResult(true, new GetterAssertionError(clazz, field, valueFromGetter, value));
    }

    @Test
    void test4() throws Exception {
	Class<?> clazz = FullPojo.class;
	Object a = clazz.getDeclaredConstructor().newInstance();
	GetterAssertions objectUnderTest = new GetterAssertions(a);
	ClassAndFieldPredicatePair baseClassAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, FieldPredicate.includeAllFields(clazz));
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<GetterAndFieldPair> getterAndFieldPairs = findGettersForFields(testedClass, fields);
	Method getter = getterAndFieldPairs.get(0).getGetter();
	Field field = getterAndFieldPairs.get(0).getField();
	Object valueFromGetter = getter.invoke(a);
	Object value = FieldUtils.getValue(a, field);
	Assertions.assertThrows(GetterAssertionError.class, () -> {
	    objectUnderTest.checkResult(false, new GetterAssertionError(clazz, field, valueFromGetter, value));
	});
    }
}
