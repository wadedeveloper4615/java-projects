package com.wade.pojotester.tester;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.util.FieldUtils;
import com.wade.pojotester.util.MethodUtils;

/**
 * The type Getter tester.
 */
@SuppressWarnings({ "rawtypes" })
public class GetterTester extends AbstractTester {
    /**
     * Instantiates a new Getter tester.
     */
    public GetterTester() {
	super();
    }

    /**
     * Instantiates a new Getter tester.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     */
    public GetterTester(AbstractFieldValueChanger abstractFieldValueChanger) {
	super(abstractFieldValueChanger);
    }

    /**
     * Find getters for fields list.
     *
     * @param testedClass the tested class
     * @param fields      the fields
     *
     * @return the list
     */
    private List<GetterAndFieldPair> findGettersForFields(Class<?> testedClass, List<Field> fields) {
	return fields.stream().map(fieldName -> findSetterAndGetterPairForField(testedClass, fieldName)).collect(Collectors.toList());
    }

    /**
     * Find setter and getter pair for field getter and field pair.
     *
     * @param testedClass the tested class
     * @param field       the field
     *
     * @return the getter and field pair
     */
    private GetterAndFieldPair findSetterAndGetterPairForField(Class<?> testedClass, Field field) {
	Method getter = MethodUtils.findGetterFor(testedClass, field);
	return new GetterAndFieldPair(getter, field);
    }

    @Override
    public void test(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Class testedClass = baseClassAndFieldPredicatePair.getClazz();
	List<Field> fields = FieldUtils.getFields(testedClass, baseClassAndFieldPredicatePair.getFieldsPredicate());
	List<GetterAndFieldPair> getterAndFieldPairs = findGettersForFields(testedClass, fields);
	Object instance = objectGenerator.createNewInstance(testedClass);
	getterAndFieldPairs.forEach(eachPair -> testGetter(eachPair, instance));
    }

    /**
     * Test getter.
     *
     * @param eachPair the each pair
     * @param instance the instance
     */
    private void testGetter(GetterAndFieldPair eachPair, Object instance) {
	Method getter = eachPair.getGetter();
	Field field = eachPair.getField();
	testAssertions.assertThatGetMethodFor(instance).willGetValueFromField(getter, field);
    }

    /**
     * The type Getter and field pair.
     */
    private class GetterAndFieldPair {
	/**
	 * The Getter.
	 */
	private Method getter;
	/**
	 * The Field.
	 */
	private Field field;

	/**
	 * Instantiates a new Getter and field pair.
	 *
	 * @param getter the getter
	 * @param field  the field
	 */
	public GetterAndFieldPair(Method getter, Field field) {
	    this.getter = getter;
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
	 * Gets getter.
	 *
	 * @return the getter
	 */
	public Method getGetter() {
	    return getter;
	}
    }
}
