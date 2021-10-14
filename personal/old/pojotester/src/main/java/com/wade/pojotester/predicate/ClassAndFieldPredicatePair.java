/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.predicate;

import java.util.function.Predicate;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Class and field predicate pair.
 */
@Getter
@Setter
public class ClassAndFieldPredicatePair {
    /**
     * The Clazz.
     */
    private Class<?> clazz;
    /**
     * The Fields predicate.
     */
    private Predicate<String> fieldsPredicate;

    /**
     * Instantiates a new class and field predicate pair.
     *
     * @param clazz the clazz
     */
    public ClassAndFieldPredicatePair(Class<?> clazz) {
	this(clazz, FieldPredicate.includeAllFields(clazz));
    }

    /**
     * Instantiates a new Class and field predicate pair.
     *
     * @param clazz           the clazz
     * @param fieldsPredicate the fields predicate
     */
    public ClassAndFieldPredicatePair(Class<?> clazz, Predicate<String> fieldsPredicate) {
	this.clazz = clazz;
	this.fieldsPredicate = fieldsPredicate;
    }
}
