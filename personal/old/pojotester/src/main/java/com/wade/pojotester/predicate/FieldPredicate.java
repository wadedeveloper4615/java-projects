/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.wade.pojotester.util.FieldUtils;

/**
 * The type Field predicate.
 */
public class FieldPredicate {
    /**
     * Exclude predicate.
     *
     * @param excludedFields the excluded fields
     * 
     * @return the predicate
     */
    public static Predicate<String> exclude(List<String> excludedFields) {
	Predicate<String> predicate = getAlwaysTruePredicate();
	for (String filedName : excludedFields) {
	    predicate = predicate.and(getNonEqualPredicate(filedName));
	}
	return predicate;
    }

    /**
     * Exclude predicate.
     *
     * @param excludedFields the excluded fields
     * 
     * @return the predicate
     */
    public static Predicate<String> exclude(String... excludedFields) {
	return exclude(Arrays.asList(excludedFields));
    }

    /**
     * Gets always false predicate.
     *
     * @return the always false predicate
     */
    private static Predicate<String> getAlwaysFalsePredicate() {
	return new NamedPredicate<>(fieldName -> false);
    }

    /**
     * Gets always true predicate.
     *
     * @return the always true predicate
     */
    private static Predicate<String> getAlwaysTruePredicate() {
	return new NamedPredicate<>(fieldName -> true);
    }

    /**
     * Gets equal predicate.
     *
     * @param filedName the filed name
     * 
     * @return the equal predicate
     */
    private static NamedPredicate<String> getEqualPredicate(String filedName) {
	return new NamedPredicate<>(filedName, otherFieldName -> otherFieldName.equals(filedName));
    }

    /**
     * Gets non equal predicate.
     *
     * @param filedName the filed name
     * 
     * @return the non equal predicate
     */
    private static Predicate<String> getNonEqualPredicate(String filedName) {
	NamedPredicate<String> equalPredicate = getEqualPredicate(filedName);
	return new NamedPredicate<>(equalPredicate.negate());
    }

    /**
     * Include predicate.
     *
     * @param includedFields the included fields
     * 
     * @return the predicate
     */
    public static Predicate<String> include(List<String> includedFields) {
	Predicate<String> predicate = getAlwaysFalsePredicate();
	for (String filedName : includedFields) {
	    predicate = predicate.or(getEqualPredicate(filedName));
	}
	return predicate;
    }

    /**
     * Include predicate.
     *
     * @param includedFields the included fields
     * 
     * @return the predicate
     */
    public static Predicate<String> include(String... includedFields) {
	return include(Arrays.asList(includedFields));
    }

    /**
     * Include all fields predicate.
     *
     * @param clazz the clazz
     * 
     * @return the predicate
     */
    public static Predicate<String> includeAllFields(Class<?> clazz) {
	List<String> allFieldNames = FieldUtils.getAllFieldNames(clazz);
	return include(allFieldNames);
    }
}
