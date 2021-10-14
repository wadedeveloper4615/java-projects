package com.wade.pojotester.tester;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;

/**
 * The type Equals tester.
 */
@SuppressWarnings("rawtypes")
public class EqualsTester extends AbstractTester {
    /**
     * Instantiates a new Equals tester.
     */
    public EqualsTester() {
	super();
    }

    /**
     * Instantiates a new Equals tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public EqualsTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Assert is equal to consumer.
     *
     * @param object the object
     *
     * @return the consumer
     */
    private Consumer<Object> assertIsEqualTo(Object object) {
	return eachDifferentObject -> testAssertions.assertThatEqualsMethodFor(object).isEqualTo(eachDifferentObject);
    }

    /**
     * Assert is not equal to consumer.
     *
     * @param object the object
     *
     * @return the consumer
     */
    private Consumer<Object> assertIsNotEqualTo(Object object) {
	return eachDifferentObject -> testAssertions.assertThatEqualsMethodFor(object).isNotEqualTo(eachDifferentObject);
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
     * Should equal different instance.
     *
     * @param object the object
     */
    private void shouldEqualDifferentInstance(Object object) {
	Object otherObject = objectGenerator.generateSameInstance(object);
	testAssertions.assertThatEqualsMethodFor(object).isSymmetric(otherObject);
    }

    /**
     * Should equal object cif object bis equal to object and c.
     *
     * @param object the object
     */
    private void shouldEqualObjectCifObjectBisEqualToObjectAndC(Object object) {
	Object b = objectGenerator.generateSameInstance(object);
	Object c = objectGenerator.generateSameInstance(object);
	testAssertions.assertThatEqualsMethodFor(object).isTransitive(b, c);
    }

    /**
     * Should equal same instance.
     *
     * @param object the object
     */
    private void shouldEqualSameInstance(Object object) {
	testAssertions.assertThatEqualsMethodFor(object).isReflexive();
    }

    /**
     * Should equal same instance few times.
     *
     * @param object the object
     */
    private void shouldEqualSameInstanceFewTimes(Object object) {
	testAssertions.assertThatEqualsMethodFor(object).isConsistent();
    }

    /**
     * Should equal with inverted given fields.
     *
     * @param base   the base
     * @param nested the nested
     */
    private void shouldEqualWithInvertedGivenFields(ClassAndFieldPredicatePair base, ClassAndFieldPredicatePair... nested) {
	ClassAndFieldPredicatePair baseWithInvertedFields = invertIncludedFields(base);
	List<Object> differentObjects = objectGenerator.generateDifferentObjects(baseWithInvertedFields, nested);
	Object firstObject = differentObjects.remove(0);
	differentObjects.forEach(assertIsEqualTo(firstObject));
    }

    /**
     * Should not equal different type.
     *
     * @param object the object
     */
    private void shouldNotEqualDifferentType(Object object) {
	Object objectToCompare = this;
	testAssertions.assertThatEqualsMethodFor(object).isNotEqualToObjectWithDifferentType(objectToCompare);
    }

    /**
     * Should not equal null.
     *
     * @param object the object
     */
    private void shouldNotEqualNull(Object object) {
	testAssertions.assertThatEqualsMethodFor(object).isNotEqualToNull();
    }

    /**
     * Should not equal with given fields.
     *
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     * @param classAndFieldPredicatePairs    the class and field predicate pairs
     */
    private void shouldNotEqualWithGivenFields(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	List<Object> differentObjects = objectGenerator.generateDifferentObjects(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
	Object firstObject = differentObjects.remove(0);
	differentObjects.forEach(assertIsNotEqualTo(firstObject));
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	Object instance = objectGenerator.createNewInstance(testedClass);
	shouldEqualSameInstance(instance);
	shouldEqualSameInstanceFewTimes(instance);
	shouldEqualDifferentInstance(instance);
	shouldEqualObjectCifObjectBisEqualToObjectAndC(instance);
	shouldNotEqualNull(instance);
	shouldNotEqualDifferentType(instance);
	shouldNotEqualWithGivenFields(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
	shouldEqualWithInvertedGivenFields(baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
    }
}
