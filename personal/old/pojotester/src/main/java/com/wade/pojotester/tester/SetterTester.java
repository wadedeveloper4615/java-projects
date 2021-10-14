package com.wade.pojotester.tester;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.util.FieldUtils;
import com.wade.pojotester.util.MethodUtils;

/**
 * The type Setter tester.
 */
@SuppressWarnings({ "rawtypes" })
public class SetterTester extends AbstractTester {
    /**
     * Instantiates a new Setter tester.
     */
    public SetterTester() {
	super();
    }

    /**
     * Instantiates a new Setter tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public SetterTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Find setter and getter pair for field setter and field pair.
     *
     * @param testedClass the tested class
     * @param field       the field
     *
     * @return the setter and field pair
     */
    private SetterAndFieldPair findSetterAndGetterPairForField(Class<?> testedClass, Field field) {
	Method setter = MethodUtils.findSetterFor(testedClass, field);
	return new SetterAndFieldPair(setter, field);
    }

    /**
     * Find setter and getter pairs for fields list.
     *
     * @param testedClass the tested class
     * @param fields      the fields
     *
     * @return the list
     */
    private List<SetterAndFieldPair> findSetterAndGetterPairsForFields(Class<?> testedClass, List<Field> fields) {
	Predicate<? super Field> predicate = field -> !FieldUtils.isFinal(field);
	Stream<Field> filter = fields.stream().filter(predicate);
	Stream<SetterAndFieldPair> map = filter.map(fieldName -> findSetterAndGetterPairForField(testedClass, fieldName));
	return map.collect(Collectors.toList());
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<SetterAndFieldPair> setterAndFieldPairs = findSetterAndGetterPairsForFields(testedClass, fields);
	Object instance = objectGenerator.createNewInstance(testedClass);
	setterAndFieldPairs.forEach(eachPair -> testSetterAndGetter(eachPair, instance));
    }

    /**
     * Test setter and getter.
     *
     * @param eachPair the each pair
     * @param instance the instance
     */
    private void testSetterAndGetter(SetterAndFieldPair eachPair, Object instance) {
	Method setter = eachPair.getSetter();
	Field field = eachPair.getField();
	Class<?> fieldType = field.getType();
	Object newValue = objectGenerator.createNewInstance(fieldType);
	testAssertions.assertThatSetMethodFor(instance).willSetValueOnField(setter, field, newValue);
    }

    /**
     * The type Setter and field pair.
     */
    private class SetterAndFieldPair {
	/**
	 * The Setter.
	 */
	private Method setter;
	/**
	 * The Field.
	 */
	private Field field;

	/**
	 * Instantiates a new Setter and field pair.
	 *
	 * @param setter the setter
	 * @param field  the field
	 */
	public SetterAndFieldPair(Method setter, Field field) {
	    this.setter = setter;
	    this.field = field;
	}

	/**
	 * Gets field.
	 *
	 * @return the field
	 */
	public Field getField() {
	    return field;
	}

	/**
	 * Gets setter.
	 *
	 * @return the setter
	 */
	public Method getSetter() {
	    return setter;
	}
    }
}
