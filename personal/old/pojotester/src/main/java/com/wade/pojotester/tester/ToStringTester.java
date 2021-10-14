package com.wade.pojotester.tester;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.util.FieldUtils;

/**
 * The type To string tester.
 */
@SuppressWarnings({ "rawtypes" })
public class ToStringTester extends AbstractTester {
    /**
     * Instantiates a new To string tester.
     */
    public ToStringTester() {
	super();
    }

    /**
     * Instantiates a new To string tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public ToStringTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Assert that to string contains value consumer.
     *
     * @param instance the instance
     *
     * @return the consumer
     */
    private Consumer<Field> assertThatToStringContainsValue(Object instance) {
	return field -> {
	    String fieldName = field.getName();
	    Object value = FieldUtils.getValue(instance, field);
	    testAssertions.assertThatToStringMethodFor(instance).contains(fieldName, value);
	};
    }

    /**
     * Assert that to string does not contain value consumer.
     *
     * @param instance the instance
     *
     * @return the consumer
     */
    private Consumer<Field> assertThatToStringDoesNotContainValue(Object instance) {
	return field -> {
	    String fieldName = field.getName();
	    Object value = FieldUtils.getValue(instance, field);
	    testAssertions.assertThatToStringMethodFor(instance).doestNotContain(fieldName, value);
	};
    }

    /**
     * Gets excluded fields.
     *
     * @param classAndFieldPredicatePair the class and field predicate pair
     *
     * @return the excluded fields
     */
    private List<Field> getExcludedFields(ClassAndFieldPredicatePair classAndFieldPredicatePair) {
	List<Field> includedFields = getIncludedFields(classAndFieldPredicatePair);
	List<String> included = includedFields.stream().map(Field::getName).collect(Collectors.toList());
	return FieldUtils.getAllFieldsExcluding(classAndFieldPredicatePair.getClazz(), included);
    }

    /**
     * Gets included fields.
     *
     * @param classAndFieldPredicatePair the class and field predicate pair
     *
     * @return the included fields
     */
    private List<Field> getIncludedFields(ClassAndFieldPredicatePair classAndFieldPredicatePair) {
	Class<?> testedClass = classAndFieldPredicatePair.getClazz();
	return FieldUtils.getFields(testedClass, classAndFieldPredicatePair.getFieldsPredicate());
    }

    /**
     * Should contain values.
     *
     * @param instance the instance
     * @param fields   the fields
     */
    private void shouldContainValues(Object instance, List<Field> fields) {
	fields.forEach(assertThatToStringContainsValue(instance));
    }

    /**
     * Should not contain values.
     *
     * @param instance the instance
     * @param fields   the fields
     */
    private void shouldNotContainValues(Object instance, List<Field> fields) {
	fields.forEach(assertThatToStringDoesNotContainValue(instance));
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class<?> testedClass = baseClassAndFieldPredicatePair.getClazz();
	Object instance = objectGenerator.createNewInstance(testedClass);
	List<Field> includedFields = getIncludedFields(baseClassAndFieldPredicatePair);
	shouldContainValues(instance, includedFields);
	List<Field> excludedFields = getExcludedFields(baseClassAndFieldPredicatePair);
	shouldNotContainValues(instance, excludedFields);
    }
}
