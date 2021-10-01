package com.wade.pojotester.tester;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

/**
 * The type Hash code tester.
 */
@SuppressWarnings({ "rawtypes" })
public class HashCodeTester extends AbstractTester {
    /**
     * Instantiates a new Hash code tester.
     */
    public HashCodeTester() {
	super();
    }

    /**
     * Instantiates a new Hash code tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public HashCodeTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Assert have different hash codes consumer.
     *
     * @param object the object
     *
     * @return the consumer
     */
    private Consumer<Object> assertHaveDifferentHashCodes(Object object) {
	return eachDifferentObject -> testAssertions.assertThatHashCodeMethodFor(object).returnsDifferentValueFor(eachDifferentObject);
    }

    /**
     * Assert have same hash codes consumer.
     *
     * @param object the object
     *
     * @return the consumer
     */
    private Consumer<Object> assertHaveSameHashCodes(Object object) {
	return eachDifferentObject -> testAssertions.assertThatHashCodeMethodFor(object).returnsSameValueFor(eachDifferentObject);
    }

    /**
     * Invert included fields class and field predicate pair.
     *
     * @param base the base
     *
     * @return the class and field predicate pair
     */
    private ClassAndFieldPredicatePair invertIncludedFields(ClassAndFieldPredicatePair base) {
	Class<?> clazz = base.getClazz();
	Predicate<String> excludedFields = base.getFieldsPredicate().negate();
	return new ClassAndFieldPredicatePair(clazz, excludedFields);
    }

    /**
     * Should have different hash codes for user defined fields.
     *
     * @param base   the base
     * @param nested the nested
     */
    private void shouldHaveDifferentHashCodesForUserDefinedFields(ClassAndFieldPredicatePair base, ClassAndFieldPredicatePair... nested) {
	List<Object> differentObjects = objectGenerator.generateDifferentObjects(base, nested);
	Object firstObject = differentObjects.remove(0);
	differentObjects.forEach(assertHaveDifferentHashCodes(firstObject));
    }

    /**
     * Should have same hash codes.
     *
     * @param object the object
     */
    private void shouldHaveSameHashCodes(Object object) {
	testAssertions.assertThatHashCodeMethodFor(object).isConsistent();
    }

    /**
     * Should have same hash codes for inversion of user defined fields.
     *
     * @param base   the base
     * @param nested the nested
     */
    private void shouldHaveSameHashCodesForInversionOfUserDefinedFields(ClassAndFieldPredicatePair base, ClassAndFieldPredicatePair... nested) {
	ClassAndFieldPredicatePair baseWithInvertedFields = invertIncludedFields(base);
	List<Object> differentObjects = objectGenerator.generateDifferentObjects(baseWithInvertedFields, nested);
	Object firstObject = differentObjects.remove(0);
	differentObjects.forEach(assertHaveSameHashCodes(firstObject));
    }

    /**
     * Should have same hash codes with different instance.
     *
     * @param object the object
     */
    private void shouldHaveSameHashCodesWithDifferentInstance(Object object) {
	Object otherObject = objectGenerator.generateSameInstance(object);
	testAssertions.assertThatHashCodeMethodFor(object).returnsSameValueFor(otherObject);
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	Object instance = objectGenerator.createNewInstance(testedClass);
	shouldHaveSameHashCodes(instance);
	shouldHaveSameHashCodesWithDifferentInstance(instance);
	shouldHaveDifferentHashCodesForUserDefinedFields(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
	shouldHaveSameHashCodesForInversionOfUserDefinedFields(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
    }
}
