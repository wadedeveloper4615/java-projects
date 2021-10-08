/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.instantiator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.changer.AbstractFieldValueChanger;
import com.wade.pojotester.permutator.Permutator;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.util.ConstructorParameters;
import com.wade.pojotester.util.FieldUtils;

import lombok.Getter;

/**
 * The type Object generator.
 */
@Getter
public class ObjectGenerator {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(ObjectGenerator.class);
    /**
     * The Abstract field value changer.
     */
    private AbstractFieldValueChanger<Object> abstractFieldValueChanger;
    /**
     * The Constructor parameters.
     */
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters;
    /**
     * The Permutator.
     */
    private Permutator permutator;

    /**
     * Instantiates a new Object generator.
     *
     * @param abstractFieldValueChanger the abstract field value changer
     * @param constructorParameters     the constructor parameters
     * @param permutator                the permutator
     */
    public ObjectGenerator(AbstractFieldValueChanger<Object> abstractFieldValueChanger, MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters, Permutator permutator) {
	this.abstractFieldValueChanger = abstractFieldValueChanger;
	this.constructorParameters = constructorParameters;
	this.permutator = permutator;
    }

    /**
     * Convert to class and fields to change map.
     *
     * @param classAndFieldPredicatePairMap the class and field predicate pair map
     *
     * @return the map
     */
    private Map<Class<?>, List<Field>> convertToClassAndFieldsToChange(Map<Class<?>, Predicate<String>> classAndFieldPredicatePairMap) {
	return classAndFieldPredicatePairMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> FieldUtils.getFields(entry.getKey(), entry.getValue())));
    }

    /**
     * Convert to map map.
     *
     * @param classAndFieldPredicatePairs the class and field predicate pairs
     *
     * @return the map
     */
    private Map<Class<?>, Predicate<String>> convertToMap(ClassAndFieldPredicatePair[] classAndFieldPredicatePairs) {
	return Stream.of(classAndFieldPredicatePairs).collect(Collectors.toMap(ClassAndFieldPredicatePair::getClazz, ClassAndFieldPredicatePair::getFieldsPredicate));
    }

    /**
     * Create copies list.
     *
     * @param baseObject the base object
     * @param size       the size
     *
     * @return the list
     */
    protected List<Object> createCopies(Object baseObject, int size) {
	return IntStream.range(0, size).mapToObj(each -> generateSameInstance(baseObject)).collect(Collectors.toList());
    }

    /**
     * Create copies and fill them list.
     *
     * @param baseObjects        the base objects
     * @param nestedObjectsToSet the nested objects to set
     *
     * @return the list
     */
    private List<Object> createCopiesAndFillThem(List<Object> baseObjects, Map.Entry<Field, List<Object>> nestedObjectsToSet) {
	List<Object> result = new ArrayList<>();
	Field fieldToFill = nestedObjectsToSet.getKey();
	List<Object> objectsToFillWith = nestedObjectsToSet.getValue();
	for (Object baseObject : baseObjects) {
	    List<Object> baseObjectClones = createCopies(baseObject, objectsToFillWith.size());
	    for (int i = 0; i < baseObjectClones.size(); i++) {
		Object baseObjectClone = baseObjectClones.get(i);
		Object valueToSet = objectsToFillWith.get(i);
		FieldUtils.setValue(baseObjectClone, fieldToFill, valueToSet);
	    }
	    result.addAll(baseObjectClones);
	}
	return result;
    }

    /**
     * Create new instance object.
     *
     * @param clazz the clazz
     *
     * @return the object
     */
    public Object createNewInstance(Class<?> clazz) {
	return Instantiable.forClass(clazz, constructorParameters).instantiate();
    }

    /**
     * Generate different objects list.
     *
     * @param clazz          the clazz
     * @param fieldsToChange the fields to change
     *
     * @return the list
     */
    private List<Object> generateDifferentObjects(Class<?> clazz, List<Field> fieldsToChange) {
	List<Object> differentObjects;
	List<List<Field>> permutationOfFields = permutator.permute(fieldsToChange);
	Object fieldObject = createNewInstance(clazz);
	differentObjects = permutationOfFields.stream().map(fields -> generateInstanceWithDifferentFieldValues(fieldObject, fields)).collect(Collectors.toList());
	differentObjects.add(0, fieldObject);
	return differentObjects;
    }

    /**
     * Generate different objects list.
     *
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     * @param classAndFieldPredicatePairs    the class and field predicate pairs
     *
     * @return the list
     */
    public List<Object> generateDifferentObjects(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	return generateDifferentObjects(0, new HashMap<>(), baseClassAndFieldPredicatePair, classAndFieldPredicatePairs);
    }

    /**
     * Generate different objects list.
     *
     * @param level                          the level
     * @param dejaVu                         the deja vu
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     * @param classAndFieldPredicatePairs    the class and field predicate pairs
     *
     * @return the list
     */
    private List<Object> generateDifferentObjects(int level, Map<Class<?>, List<Object>> dejaVu, ClassAndFieldPredicatePair baseClassAndFieldPredicatePair, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	Map<Class<?>, Predicate<String>> userDefinedClassAndFieldPredicatePairsMap = convertToMap(classAndFieldPredicatePairs);
	Class<?> baseClass = baseClassAndFieldPredicatePair.getClazz();
	Predicate<String> baseClassFieldPredicate = baseClassAndFieldPredicatePair.getFieldsPredicate();
	List<Field> baseClassFieldsToChange = FieldUtils.getFields(baseClass, baseClassFieldPredicate);
	userDefinedClassAndFieldPredicatePairsMap.put(baseClass, baseClassFieldPredicate);
	Map<Class<?>, List<Field>> userDefinedClassAndFieldToChangePairsMap = convertToClassAndFieldsToChange(userDefinedClassAndFieldPredicatePairsMap);
	List<List<Field>> baseObjectFieldsPermutations = permutator.permute(baseClassFieldsToChange);
	Object baseObject = createNewInstance(baseClass);
	LinkedList<Object> result = new LinkedList<>();
	result.add(baseObject);
	logWithLevel(level, "Start of generating different objects for base class %s. Base object is %s -- others will be cloned from this one", baseClassAndFieldPredicatePair, baseObject);
	for (List<Field> eachBaseObjectFieldsPermutation : baseObjectFieldsPermutations) {
	    Object baseObjectCopy = generateSameInstance(baseObject);
	    Map<Field, List<Object>> nestedObjectsThatAreWaitingForSetInBaseObjectCopy = new HashMap<>();
	    List<Object> partialResult = new ArrayList<>();
	    for (Field permutationField : eachBaseObjectFieldsPermutation) {
		Class<?> permutationFieldType = permutationField.getType();
		List<Field> nestedFieldsToChangeInFieldType = userDefinedClassAndFieldToChangePairsMap.get(permutationFieldType);
		if (nestedFieldsToChangeInFieldType == null || permutationFieldType.equals(baseClass)) {
		    Object newFieldTypeInstance = createNewInstance(permutationFieldType);
		    if (Objects.deepEquals(newFieldTypeInstance, FieldUtils.getValue(baseObjectCopy, permutationField))) {
			newFieldTypeInstance = abstractFieldValueChanger.increaseValue(newFieldTypeInstance);
		    }
		    FieldUtils.setValue(baseObjectCopy, permutationField, newFieldTypeInstance);
		} else {
		    List<Object> nestedObjectsOfFieldType;
		    if (dejaVu.containsKey(permutationFieldType)) {
			nestedObjectsOfFieldType = new ArrayList<>(dejaVu.get(permutationFieldType));
			logWithLevel(level, "Reusing %s objects from 'dejaVu' cache for %s", nestedObjectsOfFieldType.size(), permutationFieldType);
		    } else {
			Predicate<String> fieldPredicate = userDefinedClassAndFieldPredicatePairsMap.get(permutationFieldType);
			List<Field> fieldClassFields = FieldUtils.getFields(permutationFieldType, fieldPredicate);
			if (hasNestedFieldsToChange(fieldClassFields, userDefinedClassAndFieldPredicatePairsMap)) {
			    ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(permutationFieldType, fieldPredicate);
			    nestedObjectsOfFieldType = generateDifferentObjects(level + 1, dejaVu, classAndFieldPredicatePair, classAndFieldPredicatePairs);
			} else {
			    nestedObjectsOfFieldType = generateDifferentObjects(permutationFieldType, fieldClassFields);
			}
			dejaVu.computeIfAbsent(permutationFieldType, clazz -> logAndPut(level, clazz, nestedObjectsOfFieldType));
		    }
		    nestedObjectsThatAreWaitingForSetInBaseObjectCopy.put(permutationField, nestedObjectsOfFieldType);
		}
	    }
	    partialResult.add(baseObjectCopy);
	    for (Map.Entry<Field, List<Object>> nestedObjectsToSet : nestedObjectsThatAreWaitingForSetInBaseObjectCopy.entrySet()) {
		partialResult = createCopiesAndFillThem(partialResult, nestedObjectsToSet);
	    }
	    result.addAll(partialResult);
	}
	logWithLevel(level, "End of generating different objects (size=%s) for base class %s", result.size(), baseClassAndFieldPredicatePair);
	return result;
    }

    /**
     * Generate instance with different field values object.
     *
     * @param baseObject     the base object
     * @param fieldsToChange the fields to change
     *
     * @return the object
     */
    private Object generateInstanceWithDifferentFieldValues(Object baseObject, List<Field> fieldsToChange) {
	Object objectToChange = generateSameInstance(baseObject);
	abstractFieldValueChanger.changeFieldsValues(baseObject, objectToChange, fieldsToChange);
	return objectToChange;
    }

    /**
     * Generate same instance object.
     *
     * @param object the object
     *
     * @return the object
     */
    public Object generateSameInstance(Object object) {
	Object newInstance = createNewInstance(object.getClass());
	if (!object.equals(newInstance)) {
	    newInstance = makeThemEqual(object, newInstance);
	}
	return newInstance;
    }

    /**
     * Gets all fields.
     *
     * @param object the object
     *
     * @return the all fields
     */
    private List<Field> getAllFields(Object object) {
	Class<?> parent = object.getClass();
	List<Field> allFields = new ArrayList<>();
	do {
	    allFields.addAll(FieldUtils.getAllFields(parent));
	} while ((parent = parent.getSuperclass()) != null);
	return allFields;
    }

    /**
     * Has nested fields to change boolean.
     *
     * @param fields  the fields
     * @param classes the classes
     *
     * @return the boolean
     */
    private boolean hasNestedFieldsToChange(List<Field> fields, Map<Class<?>, Predicate<String>> classes) {
	return fields.parallelStream().map(Field::getType).map(classes::get).anyMatch(Objects::nonNull);
    }

    /**
     * Log and put list.
     *
     * @param level                    the level
     * @param clazz                    the clazz
     * @param nestedObjectsOfFieldType the nested objects of field type
     *
     * @return the list
     */
    private List<Object> logAndPut(int level, Class<?> clazz, List<Object> nestedObjectsOfFieldType) {
	logWithLevel(level, "Caching {} different objects for %s in dejaVu cache", nestedObjectsOfFieldType.size(), clazz);
	return nestedObjectsOfFieldType;
    }

    /**
     * Log with level.
     *
     * @param level   the level
     * @param message the message
     * @param args    the args
     */
    private void logWithLevel(int level, String message, Object... args) {
	if (LOGGER.isDebugEnabled()) {
	    StringBuilder stringBuilder = new StringBuilder();
	    for (int i = 0; i < level; i++) {
		stringBuilder.append("\t");
	    }
	    stringBuilder.append(message);
	    LOGGER.debug(String.format(stringBuilder.toString(), args));
	}
    }

    /**
     * Make them equal object.
     *
     * @param object      the object
     * @param newInstance the new instance
     *
     * @return the object
     */
    private Object makeThemEqual(Object object, Object newInstance) {
	List<Field> allFields = getAllFields(object);
	for (Field field : allFields) {
	    Object value = FieldUtils.getValue(object, field);
	    FieldUtils.setValue(newInstance, field, value);
	}
	return newInstance;
    }
}
