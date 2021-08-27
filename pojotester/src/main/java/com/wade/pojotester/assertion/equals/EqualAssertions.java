/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Equal assertions.
 */
@Getter
@Setter
public class EqualAssertions {
    /**
     * The Object under assert.
     */
    private Object objectUnderAssert;
    /**
     * The Class under test.
     */
    private Class<?> classUnderTest;

    /**
     * Instantiates a new Equal assertions.
     *
     * @param objectUnderAssert the object under assert
     */
    public EqualAssertions(Object objectUnderAssert) {
	this.objectUnderAssert = objectUnderAssert;
	this.classUnderTest = objectUnderAssert.getClass();
    }

    /**
     * Check result.
     *
     * @param pass         the pass
     * @param errorToThrow the error to throw
     */
    private void checkResult(boolean pass, AbstractEqualsAssertionError errorToThrow) {
	if (!pass) {
	    throw errorToThrow;
	}
    }

    /**
     * Is consistent.
     */
    public void isConsistent() {
	boolean result1 = objectUnderAssert.equals(objectUnderAssert);
	boolean result2 = objectUnderAssert.equals(objectUnderAssert);
	boolean result = result1 && result2;
	checkResult(result, new ConsistentEqualsAssertionError(classUnderTest, objectUnderAssert, result1, result2));
    }

    /**
     * Is equal to.
     *
     * @param objectToCompare the object to compare
     */
    public void isEqualTo(Object objectToCompare) {
	boolean result = objectUnderAssert.equals(objectToCompare);
	checkResult(result, new EqualEqualsAssertionError(classUnderTest, objectUnderAssert, objectToCompare));
    }

    /**
     * Is not equal to.
     *
     * @param objectToCompare the object to compare
     */
    public void isNotEqualTo(Object objectToCompare) {
	boolean result = !objectUnderAssert.equals(objectToCompare);
	checkResult(result, new NotEqualEqualsAssertionError(classUnderTest, objectUnderAssert, objectToCompare));
    }

    /**
     * Is not equal to null.
     */
    public void isNotEqualToNull() {
	boolean result = objectUnderAssert != null;
	checkResult(result, new NullEqualsAssertionError(classUnderTest));
    }

    /**
     * Is not equal to object with different type.
     *
     * @param otherObject the other object
     */
    public void isNotEqualToObjectWithDifferentType(Object otherObject) {
	boolean result = !objectUnderAssert.equals(otherObject);
	checkResult(result, new OtherTypeEqualsAssertionError(classUnderTest, objectUnderAssert, otherObject));
    }

    /**
     * Is reflexive.
     */
    public void isReflexive() {
	boolean result = objectUnderAssert.equals(objectUnderAssert);
	checkResult(result, new ReflexiveEqualsAssertionError(classUnderTest, objectUnderAssert));
    }

    /**
     * Is symmetric.
     *
     * @param otherObject the other object
     */
    public void isSymmetric(Object otherObject) {
	boolean result1 = objectUnderAssert.equals(otherObject);
	boolean result2 = otherObject.equals(objectUnderAssert);
	boolean result = result1 == result2;
	checkResult(result, new SymmetricEqualsAssertionError(classUnderTest, objectUnderAssert, otherObject, result1, result2));
    }

    /**
     * Is transitive.
     *
     * @param b the b
     * @param c the c
     */
    public void isTransitive(Object b, Object c) {
	boolean result1 = objectUnderAssert.equals(b);
	boolean result2 = b.equals(c);
	boolean result3 = objectUnderAssert.equals(c);
	boolean partialResult1 = result1 == result2;
	boolean partialResult2 = result2 == result3;
	boolean result = partialResult1 && partialResult2;
	checkResult(result, new TransitiveEqualsAssertionError(classUnderTest, objectUnderAssert, b, c, result1, result2, result3));
    }
}
