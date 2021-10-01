/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester;

import static com.wade.pojotester.preconditions.ParameterPreconditions.checkNotNull;

import java.util.function.Predicate;

import com.wade.pojotester.assertion.AbstractAssertion;
import com.wade.pojotester.assertion.SingleClassAssertion;
import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.predicate.FieldPredicate;
import com.wade.pojotester.testfiles.FullPojo;

/**
 * The type Pojo verifier.
 */
public class PojoVerifier {
    /**
     * Initiates a pojo verfier
     *
     * @param clazz the class the class to be verified as a proper pojo
     *
     * @return the abstract assertion
     */
    public static AbstractAssertion forClass(Class<?> clazz) {
	checkNotNull("clazz", clazz);
	Predicate<String> predicateAcceptingAllFields = FieldPredicate.includeAllFields(clazz);
	return forClass(clazz, predicateAcceptingAllFields);
    }

    /**
     * For class abstract assertion.
     *
     * @param clazz          the clazz
     * @param fieldPredicate the field predicate
     *
     * @return the abstract assertion
     */
    private static AbstractAssertion forClass(Class<?> clazz, Predicate<String> fieldPredicate) {
	checkNotNull("clazz", clazz);
	checkNotNull("fieldPredicate", fieldPredicate);
	ClassAndFieldPredicatePair classAndFieldPredicatePair = new ClassAndFieldPredicatePair(clazz, fieldPredicate);
	return forClass(classAndFieldPredicatePair);
    }

    /**
     * For class abstract assertion.
     *
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     *
     * @return the abstract assertion
     */
    private static AbstractAssertion forClass(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair) {
	checkNotNull("baseClassAndFieldPredicatePair", baseClassAndFieldPredicatePair);
	return new SingleClassAssertion(baseClassAndFieldPredicatePair);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String... args) {
	PojoVerifier.forClass(FullPojo.class).verified();
    }
}
