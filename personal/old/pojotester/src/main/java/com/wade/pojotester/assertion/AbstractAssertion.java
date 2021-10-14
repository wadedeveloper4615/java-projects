/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.logging.Log;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.tester.AbstractTester;
import com.wade.pojotester.util.ConstructorParameters;
import com.wade.pojotester.util.Method;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Abstract assertion.
 */
@Getter
@Setter
public abstract class AbstractAssertion {
    /**
     * The Constructor parameters.
     */
    private MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters = new ArrayListValuedHashMap<>();
    /**
     * The Testers.
     */
    protected Set<AbstractTester> testers = new HashSet<>();
    /** The skip equals. */
    protected boolean skipEquals = false;
    /** The skip getters. */
    protected boolean skipGetters = false;
    /** The skip hash code. */
    protected boolean skipHashCode = false;
    /** The skip setters. */
    protected boolean skipSetters = false;
    /** The skip to string. */
    protected boolean skipToString = false;

    /**
     * Instantiates a new Abstract assertion.
     */
    public AbstractAssertion() {
	testers = new HashSet<>();
	Arrays.stream(Method.values()).map(Method::getTester).forEach(testers::add);
    }

    /**
     * Log testers and classes.
     *
     * @param logger                      the logger
     * @param classAndFieldPredicatePairs the class and field predicate pairs
     */
    protected void logTestersAndClasses(Log logger, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	if (logger.isDebugEnabled()) {
	    String classes = Arrays.stream(classAndFieldPredicatePairs).map(ClassAndFieldPredicatePair::toString).collect(Collectors.joining(", ", "[", "]"));
	    logger.debug(String.format("Running %s testers on %s classes", testers.size(), classAndFieldPredicatePairs.length));
	    logger.debug(String.format("Testers: %s", testers));
	    logger.debug(String.format("Classes: %s", classes));
	}
    }

    /**
     * Run assertions.
     */
    protected abstract void runAssertions();

    /**
     * Skip equals.
     *
     * @return the abstract assertion
     */
    public AbstractAssertion skipEquals() {
	skipEquals = true;
	return this;
    }

    /**
     * Skip getters.
     *
     * @return the abstract assertion
     */
    public AbstractAssertion skipGetters() {
	skipGetters = true;
	return this;
    }

    /**
     * Skip hash code.
     *
     * @return the abstract assertion
     */
    public AbstractAssertion skipHashCode() {
	skipHashCode = true;
	return this;
    }

    /**
     * Skip setters.
     *
     * @return the abstract assertion
     */
    public AbstractAssertion skipSetters() {
	skipSetters = true;
	return this;
    }

    /**
     * Skip to string.
     *
     * @return the abstract assertion
     */
    public AbstractAssertion skipToString() {
	skipToString = true;
	return this;
    }

    /**
     * Are well implemented.
     */
    public void verified() {
	this.runAssertions();
    }
}
