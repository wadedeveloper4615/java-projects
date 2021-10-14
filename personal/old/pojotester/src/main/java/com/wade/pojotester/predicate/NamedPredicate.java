/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.predicate;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

/**
 * The type Named predicate.
 *
 * @param <T> the type parameter
 */
@SuppressWarnings("unchecked")
public class NamedPredicate<T> implements Predicate<T> {
    /**
     * The Is not negated.
     */
    private static Predicate<String> IS_NOT_NEGATED;
    /**
     * The Is negated and not single.
     */
    private static Predicate<String> IS_NEGATED_AND_NOT_SINGLE;
    static {
	Predicate<String> startsWithNegationAndBracket = name -> name.startsWith("!(");
	Predicate<String> endsWithBracket = name -> name.endsWith(")");
	Predicate<String> isNotSingle = name -> name.contains(",");
	IS_NOT_NEGATED = startsWithNegationAndBracket.negate().and(endsWithBracket.negate());
	IS_NEGATED_AND_NOT_SINGLE = IS_NOT_NEGATED.negate().and(isNotSingle);
    }
    /**
     * The Name.
     */
    private String name;
    /**
     * The Predicate.
     */
    private Predicate<T> predicate;

    /**
     * Instantiates a new Named predicate.
     *
     * @param predicate the predicate
     */
    public NamedPredicate(Predicate<T> predicate) {
	this("", predicate);
    }

    /**
     * Instantiates a new Named predicate.
     *
     * @param name      the name
     * @param predicate the predicate
     */
    public NamedPredicate(String name, Predicate<T> predicate) {
	this.name = name;
	this.predicate = predicate;
    }

    /**
     * And named predicate.
     *
     * @param otherPredicate the other predicate
     * 
     * @return the named predicate
     */
    @Override
    public NamedPredicate<T> and(Predicate<? super T> otherPredicate) {
	String otherName = "";
	if (otherPredicate instanceof NamedPredicate) {
	    otherName = ((NamedPredicate<T>) otherPredicate).getName();
	}
	return new NamedPredicate<>(this.skipFirstIfAlwaysTrueOrFalse() + otherName, this.predicate.and(otherPredicate));
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Negate named predicate.
     *
     * @return the named predicate
     */
    @Override
    public NamedPredicate<T> negate() {
	String newName;
	if (IS_NEGATED_AND_NOT_SINGLE.test(this.name) || IS_NOT_NEGATED.test(this.name)) {
	    newName = "!(" + this.name + ")";
	} else {
	    newName = this.name.substring(2, this.name.length() - 1);
	}
	return new NamedPredicate<>(newName, this.predicate.negate());
    }

    /**
     * Or named predicate.
     *
     * @param otherPredicate the other predicate
     * 
     * @return the named predicate
     */
    @Override
    public NamedPredicate<T> or(Predicate<? super T> otherPredicate) {
	String otherName = "";
	if (otherPredicate instanceof NamedPredicate) {
	    otherName = ((NamedPredicate<?>) otherPredicate).getName();
	}
	return new NamedPredicate<>(this.skipFirstIfAlwaysTrueOrFalse() + otherName, this.predicate.or(otherPredicate));
    }

    /**
     * Skip first if always true or false string.
     *
     * @return the string
     */
    private String skipFirstIfAlwaysTrueOrFalse() {
	if (StringUtils.isNotBlank(this.name)) {
	    return this.name + ",";
	} else {
	    return "";
	}
    }

    /**
     * Test boolean.
     *
     * @param t the t
     * 
     * @return the boolean
     */
    @Override
    public boolean test(T t) {
	return this.predicate.test(t);
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return this.name;
    }
}