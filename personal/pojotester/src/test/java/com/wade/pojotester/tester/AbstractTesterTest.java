package com.wade.pojotester.tester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.function.Predicate;

import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.instantiator.ObjectGenerator;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

import helpers.ClassAndFieldPredicatePairArgumentMatcher;
import helpers.RecursivelyEqualArgumentMatcher;
import helpers.StringPredicateArgumentMatcher;
import lombok.Data;

@SuppressWarnings("rawtypes")
class AbstractTesterTest {
    @Test
    void Should_Call_Test_With_Expected_Class_And_Field_Predicate_Pair() {
	// given
	AbstractTester abstractTester = spy(AbstractTester.class);
	Class<A> clazz = A.class;
	Predicate<String> predicate = string -> string.equals("a");
	// when
	abstractTester.test(clazz, predicate);
	// then
	verify(abstractTester).test(argThat(new ClassAndFieldPredicatePairArgumentMatcher(clazz, "a")));
    }

    @Test
    void Should_Call_Test_With_Expected_Class_And_Field_Predicate_Pairs() {
	// given
	AbstractTester abstractTester = spy(AbstractTester.class);
	Class<A> clazz = A.class;
	ClassAndFieldPredicatePair expectedParameter = new ClassAndFieldPredicatePair(clazz);
	// when
	abstractTester.testAll(clazz);
	// then
	verify(abstractTester).testAll(argThat(new RecursivelyEqualArgumentMatcher(expectedParameter)));
    }

    @Test
    void Should_Call_Test_With_Expected_Class_And_Field_Predicate_Pairs_Two_Times() {
	// given
	AbstractTester abstractTester = spy(AbstractTester.class);
	Class<A> aClazz = A.class;
	Class<B> bClazz = B.class;
	ClassAndFieldPredicatePair pair1 = new ClassAndFieldPredicatePair(aClazz);
	ClassAndFieldPredicatePair pair2 = new ClassAndFieldPredicatePair(bClazz);
	// when
	abstractTester.testAll(pair1, pair2);
	// then
	verify(abstractTester, times(1)).test(argThat(new ClassAndFieldPredicatePairArgumentMatcher(aClazz, "a")), argThat(new ClassAndFieldPredicatePairArgumentMatcher(aClazz, "a")), argThat(new ClassAndFieldPredicatePairArgumentMatcher(bClazz, "b")));
	verify(abstractTester, times(1)).test(argThat(new ClassAndFieldPredicatePairArgumentMatcher(bClazz, "b")), argThat(new ClassAndFieldPredicatePairArgumentMatcher(aClazz, "a")), argThat(new ClassAndFieldPredicatePairArgumentMatcher(bClazz, "b")));
    }

    @Test
    void Should_Call_Test_With_Expected_Predicate() {
	// given
	AbstractTester abstractTester = spy(AbstractTester.class);
	Class<A> clazz = A.class;
	// when
	abstractTester.test(clazz);
	// then
	verify(abstractTester).test(eq(clazz), argThat(new StringPredicateArgumentMatcher()));
    }

    @Test
    void Should_Create_New_Object_Generator_When_Set_Field_Value_Changer() {
	// given
	AbstractTester abstractTester = new AbstractTesterImplementation();
	AbstractFieldValueChanger fieldValuesChanger = DefaultFieldValueChanger.INSTANCE;
	ObjectGenerator beforeChange = abstractTester.objectGenerator;
	// when
	abstractTester.setFieldValuesChanger(fieldValuesChanger);
	ObjectGenerator afterChange = abstractTester.objectGenerator;
	// then
	assertThat(beforeChange).isNotEqualTo(afterChange);
    }

    @Test
    void Should_Create_New_Object_Generator_When_User_Defined_Class_And_Constructor() {
	// given
	AbstractTester abstractTester = new AbstractTesterImplementation();
	ObjectGenerator beforeChange = abstractTester.objectGenerator;
	// when
	abstractTester.setUserDefinedConstructors(new ArrayListValuedHashMap<>());
	ObjectGenerator afterChange = abstractTester.objectGenerator;
	// then
	assertThat(beforeChange).isNotEqualTo(afterChange);
    }

    @Test
    void Should_Equal_Itself() {
	// given
	AbstractTester abstractTester = new AbstractTesterImplementation();
	// when
	boolean result = abstractTester.equals(abstractTester);
	// then
	assertThat(result).isTrue();
    }

    @Test
    void Should_Generate_Different_Hash_Codes_For_Every_New_Instance() {
	// given
	AbstractTester abstractTester1 = new AbstractTesterImplementation();
	AbstractTester abstractTester2 = new AbstractTesterImplementation();
	// when
	int result1 = abstractTester1.hashCode();
	int result2 = abstractTester2.hashCode();
	// then
	assertThat(result1).isNotEqualTo(result2);
    }

    @Test
    void Should_Generate_Same_Hash_Codes() {
	// given
	AbstractTester abstractTester1 = new AbstractTesterImplementation();
	// when
	int result1 = abstractTester1.hashCode();
	int result2 = abstractTester1.hashCode();
	// then
	assertThat(result1).isEqualTo(result2);
    }

    @Test
    void Should_Not_Equal_Null() {
	// given
	AbstractTester abstractTester = new AbstractTesterImplementation();
	// when
	boolean result = abstractTester.equals(null);
	// then
	assertThat(result).isFalse();
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void Should_Not_Equal_Other_Class() {
	// given
	AbstractTester abstractTester1 = new AbstractTesterImplementation();
	// when
	boolean result = abstractTester1.equals(String.class);
	// then
	assertThat(result).isFalse();
    }

    @Test
    void Should_Not_Equal_Other_Object_With_Different_Values() {
	// given
	AbstractTester abstractTester1 = new AbstractTesterImplementation();
	AbstractTester abstractTester2 = new AbstractTesterImplementation(null);
	// when
	boolean result = abstractTester1.equals(abstractTester2);
	// then
	assertThat(result).isFalse();
    }

    @Test
    void Should_Not_Equal_Other_Object_With_Same_Values() {
	// given
	AbstractTester abstractTester1 = new AbstractTesterImplementation();
	AbstractTester abstractTester2 = new AbstractTesterImplementation();
	// when
	boolean result = abstractTester1.equals(abstractTester2);
	// then
	assertThat(result).isFalse();
    }

    @Data
    private class A {
	int a;
    }

    class AbstractTesterImplementation extends AbstractTester {
	AbstractTesterImplementation() {
	}

	AbstractTesterImplementation(AbstractFieldValueChanger o) {
	    super(o);
	}

	@Override
	public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	    // not needed for tests
	}
    }

    @Data
    private class B {
	int b;
    }
}
