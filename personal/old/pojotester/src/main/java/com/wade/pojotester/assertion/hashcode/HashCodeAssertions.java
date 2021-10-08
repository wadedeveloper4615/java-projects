/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.hashcode;

import lombok.Getter;

/**
 * The type Hash code assertions.
 */
@Getter
// @Setter
public class HashCodeAssertions {
    /**
     * The Object under assert.
     */
    private Object objectUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new Hash code assertions.
     *
     * @param objectUnderAssert the object under assert
     */
    public HashCodeAssertions(Object objectUnderAssert) {
	this.objectUnderAssert = objectUnderAssert;
	classUnderTest = objectUnderAssert.getClass();
    }

    /**
     * Check result.
     *
     * @param pass         the pass
     * @param errorToThrow the error to throw
     */
    private void checkResult(boolean pass, AbstractHashCodeAssertionError errorToThrow) {
	if (!pass) {
	    throw errorToThrow;
	}
    }

    /**
     * Is consistent.
     */
    public void isConsistent() {
	int result1 = objectUnderAssert.hashCode();
	int result2 = objectUnderAssert.hashCode();
	boolean result = result1 == result2;
	checkResult(result, new ConsistentHashCodeAssertionError(classUnderTest, objectUnderAssert, result1, result2));
    }

    /**
     * Returns different value for.
     *
     * @param otherObject the other object
     */
    public void returnsDifferentValueFor(Object otherObject) {
	int result1 = objectUnderAssert.hashCode();
	int result2 = otherObject.hashCode();
	boolean result = result1 == result2;
	checkResult(!result, new NotEqualHashCodeAssertionError(classUnderTest, objectUnderAssert, otherObject, result1, result2));
    }

    /**
     * Returns same value for.
     *
     * @param otherObject the other object
     */
    public void returnsSameValueFor(Object otherObject) {
	int result1 = objectUnderAssert.hashCode();
	int result2 = otherObject.hashCode();
	boolean result = result1 == result2;
	checkResult(result, new EqualHashCodeAssertionError(classUnderTest, objectUnderAssert, otherObject, result1, result2));
    }
}
