/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

import com.wade.pojotester.exception.GetterNotFoundException;
import com.wade.pojotester.exception.SetterNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The type Method utils.
 */
public class MethodUtils {
    /**
     * Find getter for method.
     *
     * @param clazz the clazz
     * @param field the field
     * 
     * @return the method
     */
    public static Method findGetterFor(Class<?> clazz, Field field) {
	return Arrays.stream(clazz.getDeclaredMethods()).filter(hasZeroParameters()).filter(method -> prefixMatchesGettersPrefixAndHasExpectedLength(method, field.getName())).findAny().orElseThrow(() -> new GetterNotFoundException(clazz, field));
    }

    /**
     * Find setter for method.
     *
     * @param clazz the clazz
     * @param field the field
     * 
     * @return the method
     */
    public static Method findSetterFor(Class<?> clazz, Field field) {
	return Arrays.stream(clazz.getDeclaredMethods()).filter(methodHasOnlyOneParameter()).filter(method -> prefixMatchesSettersPrefixAndHasExpectedLength(method, field.getName())).findAny().orElseThrow(() -> new SetterNotFoundException(clazz, field));
    }

    /**
     * Has zero parameters predicate.
     *
     * @return the predicate
     */
    private static Predicate<Method> hasZeroParameters() {
	return method -> method.getParameterCount() == 0;
    }

    /**
     * Method has only one parameter predicate.
     *
     * @return the predicate
     */
    private static Predicate<Method> methodHasOnlyOneParameter() {
	return method -> method.getParameterCount() == 1;
    }

    /**
     * Prefix matches getters prefix and has expected length boolean.
     *
     * @param method    the method
     * @param fieldName the field name
     * 
     * @return the boolean
     */
    private static boolean prefixMatchesGettersPrefixAndHasExpectedLength(Method method, String fieldName) {
	Class<?> returnType = method.getReturnType();
	String methodName = method.getName();
	int fieldNameLength = fieldName.length();
	String upperCaseFirstLetterFieldName = upperCaseFirstLetter(fieldName);
	if (returnType.equals(boolean.class) || returnType.equals(Boolean.class)) {
	    return (methodName.startsWith("is") && methodName.equals(fieldName))
		    || (methodName.endsWith(upperCaseFirstLetterFieldName) && ((methodName.startsWith("is") && (methodName.length() == (fieldNameLength + 2))) || methodName.startsWith("has") && methodName.length() == fieldNameLength + 3 || methodName.startsWith("get") && methodName.length() == fieldNameLength + 3 || methodName.startsWith("have") && methodName.length() == fieldNameLength + 4 || methodName.startsWith("contains") && methodName.length() == fieldNameLength + 8));
	} else {
	    return methodName.startsWith("get") && methodName.length() == fieldNameLength + 3 && methodName.endsWith(upperCaseFirstLetterFieldName);
	}
    }

    /**
     * Prefix matches setters prefix and has expected length boolean.
     *
     * @param method    the method
     * @param fieldName the field name
     * 
     * @return the boolean
     */
    private static boolean prefixMatchesSettersPrefixAndHasExpectedLength(Method method, String fieldName) {
	Class<?> parameterType = method.getParameterTypes()[0];
	String methodName = method.getName();
	int fieldNameLength = fieldName.length();
	String upperCaseFirstLetterFieldName = upperCaseFirstLetter(fieldName);
	if ((parameterType.equals(boolean.class) || parameterType.equals(Boolean.class)) && fieldName.startsWith("is")) {
	    String fieldNameWithoutPrefix = fieldName.substring(2);
	    return methodName.startsWith("set") && methodName.endsWith(fieldNameWithoutPrefix);
	} else {
	    return methodName.startsWith("set") && methodName.length() == fieldNameLength + 3 && methodName.endsWith(upperCaseFirstLetterFieldName);
	}
    }

    /**
     * Upper case first letter string.
     *
     * @param string the string
     * 
     * @return the string
     */
    private static String upperCaseFirstLetter(String string) {
	String firstLetter = string.substring(0, 1).toUpperCase();
	return firstLetter + string.substring(1, string.length());
    }
}
