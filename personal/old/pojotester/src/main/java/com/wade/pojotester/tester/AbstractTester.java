package com.wade.pojotester.tester;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.wade.pojotester.assertion.TestAssertions;
import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.changer.DefaultFieldValueChanger;
import com.wade.pojotester.instantiator.ObjectGenerator;
import com.wade.pojotester.permutator.Permutator;
import com.wade.pojotester.permutator.ThoroughFieldPermutator;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.util.ConstructorParameters;

/**
 * The type Abstract tester.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractTester {
    /**
     * The Test assertions.
     */
    TestAssertions testAssertions = new TestAssertions();
    /**
     * The Object generator.
     */
    ObjectGenerator objectGenerator;
    /**
     * The Constructor parameters.
     */
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
    /**
     * The Field values changer.
     */
    private AbstractFieldValueChanger fieldValuesChanger = DefaultFieldValueChanger.INSTANCE;
    /**
     * The Permutator.
     */
    private Permutator permutator = new ThoroughFieldPermutator();

    /**
     * Instantiates a new Abstract tester.
     */
    public AbstractTester() {
	this(DefaultFieldValueChanger.INSTANCE);
    }

    /**
     * Instantiates a new Abstract tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public AbstractTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	objectGenerator = new ObjectGenerator(abstractFieldValueChanger, constructorParameters, permutator);
    }

    /**
     * object comparison
     *
     * @param otherObject the object to be compared
     */
    @Override
    public boolean equals(Object otherObject) {
	if (this == otherObject) {
	    return true;
	}
	if (otherObject == null || getClass() != otherObject.getClass()) {
	    return false;
	}
	AbstractTester that = (AbstractTester) otherObject;
	return new EqualsBuilder().append(objectGenerator, that.objectGenerator).append(testAssertions, that.testAssertions).append(constructorParameters, that.constructorParameters).append(fieldValuesChanger, that.fieldValuesChanger).isEquals();
    }

    /**
     * Gets constructor parameters.
     *
     * @return the constructor parameters
     */
    protected MultiValuedMap<Class<?>, ConstructorParameters> getConstructorParameters() {
	return constructorParameters;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(objectGenerator).append(testAssertions).append(constructorParameters).append(fieldValuesChanger).toHashCode();
    }

    /**
     * Sets field values changer.
     *
     * @param fieldValuesChanger the field values changer
     */
    public void setFieldValuesChanger(AbstractFieldValueChanger fieldValuesChanger) {
	this.fieldValuesChanger = fieldValuesChanger;
	objectGenerator = new ObjectGenerator(fieldValuesChanger, constructorParameters, permutator);
    }

    /**
     * Sets permutator.
     *
     * @param permutator the permutator
     */
    public void setPermutator(Permutator permutator) {
	this.permutator = permutator;
    }

    /**
     * Sets user defined constructors.
     *
     * @param constructorParameters the constructor parameters
     */
    public void setUserDefinedConstructors(MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
	this.constructorParameters = constructorParameters;
	objectGenerator = new ObjectGenerator(fieldValuesChanger, constructorParameters, permutator);
    }

    /**
     * Test.
     *
     * @param clazz the clazz
     */
    public void test(Class<?> clazz) {
	Predicate<String> predicateAcceptingAllFields = FieldPredicate.includeAllFields(clazz);
	test(clazz, predicateAcceptingAllFields);
    }

    /**
     * Test.
     *
     * @param clazz          the clazz
     * @param fieldPredicate the field predicate
     */
    public void test(Class<?> clazz, Predicate<String> fieldPredicate) {
	ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, fieldPredicate);
	test(classAndFieldPredicatePair);
    }

    /**
     * Test.
     *
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     * @param classAndFieldPredicatePairs    the class and field predicate pairs
     */
    public abstract void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs);

    /**
     * Test all.
     *
     * @param classes the classes
     */
    public void testAll(Class... classes) {
	ClassAndFieldPredicatePair[] classesAndFieldPredicatesPairs = Arrays.stream(classes).map(ClassAndFieldPredicatePair::new).toArray(ClassAndFieldPredicatePair[]::new);
	testAll(classesAndFieldPredicatesPairs);
    }

    /**
     * Test all.
     *
     * @param classesAndFieldPredicatesPairs the classes and field predicates pairs
     */
    public void testAll(ClassAndFieldPredicatePair... classesAndFieldPredicatesPairs) {
	List<ClassAndFieldPredicatePair> classAndFieldPredicatePairs = Arrays.asList(classesAndFieldPredicatesPairs);
	classAndFieldPredicatePairs.forEach(base -> test(base, classesAndFieldPredicatesPairs));
    }

    @Override
    public String toString() {
	return this.getClass().getSimpleName();
    }
}
