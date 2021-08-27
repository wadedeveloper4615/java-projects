/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.tester.AbstractTester;
import com.wade.pojotester.tester.EqualsTester;
import com.wade.pojotester.tester.GetterTester;
import com.wade.pojotester.tester.HashCodeTester;
import com.wade.pojotester.tester.SetterTester;
import com.wade.pojotester.tester.ToStringTester;

class SingleClassAssertionTest {
    @Test
    void test1() {
	SingleClassAssertion objectUnderTest = new SingleClassAssertion();
	assertThat(objectUnderTest).isNotNull();
	assertThat(objectUnderTest.toString()).isNotNull();
	assertThat(objectUnderTest.getBaseClassAndFieldPredicatePair()).isNull();
	assertThat(objectUnderTest.getConstructorParameters()).isNotNull();
	assertThat(objectUnderTest.getTesters()).isNotNull();
    }

    @Test
    void test10() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	SetterTester mockTester = mock(SetterTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.skipSetters().verified();
	verify(mockTester, never()).test(cfpp);
    }

    @Test
    void test11() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	ToStringTester mockTester = mock(ToStringTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.verified();
	verify(mockTester).test(cfpp);
    }

    @Test
    void test13() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	ToStringTester mockTester = mock(ToStringTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.skipToString().verified();
	verify(mockTester, never()).test(cfpp);
    }

    @Test
    void test2() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	assertThat(objectUnderTest).isNotNull();
	assertThat(objectUnderTest.getBaseClassAndFieldPredicatePair()).isNotNull();
	assertThat(objectUnderTest.getConstructorParameters()).isNotNull();
	assertThat(objectUnderTest.getTesters()).isNotNull();
    }

    @Test
    void test3() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	EqualsTester mockTester = mock(EqualsTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.verified();
	verify(mockTester).test(cfpp);
    }

    @Test
    void test4() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	EqualsTester mockTester = mock(EqualsTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.skipEquals().verified();
	verify(mockTester, never()).test(cfpp);
    }

    @Test
    void test5() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	GetterTester mockTester = mock(GetterTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.verified();
	verify(mockTester).test(cfpp);
    }

    @Test
    void test6() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	GetterTester mockTester = mock(GetterTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.skipGetters().verified();
	verify(mockTester, never()).test(cfpp);
    }

    @Test
    void test7() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	HashCodeTester mockTester = mock(HashCodeTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.verified();
	verify(mockTester).test(cfpp);
    }

    @Test
    void test8() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	HashCodeTester mockTester = mock(HashCodeTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.skipHashCode().verified();
	verify(mockTester, never()).test(cfpp);
    }

    @Test
    void test9() {
	ClassAndFieldPredicatePair cfpp = mock(ClassAndFieldPredicatePair.class);
	Set<AbstractTester> mockTesters = new HashSet<>();
	SetterTester mockTester = mock(SetterTester.class);
	mockTesters.add(mockTester);
	SingleClassAssertion objectUnderTest = new SingleClassAssertion(cfpp);
	objectUnderTest.setConstructorParameters(new ArrayListValuedHashMap<>());
	objectUnderTest.setTesters(mockTesters);
	objectUnderTest.verified();
	verify(mockTester).test(cfpp);
    }
}
