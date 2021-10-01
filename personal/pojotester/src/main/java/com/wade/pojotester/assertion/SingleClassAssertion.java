/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wade.pojotester.predicate.ClassAndFieldPredicatePair;
import com.wade.pojotester.tester.EqualsTester;
import com.wade.pojotester.tester.GetterTester;
import com.wade.pojotester.tester.HashCodeTester;
import com.wade.pojotester.tester.SetterTester;
import com.wade.pojotester.tester.ToStringTester;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Single class assertion.
 */
@Getter
@Setter
@ToString
public class SingleClassAssertion extends AbstractAssertion {
    /**
     * The constant LOGGER.
     */
    private static Log LOGGER = LogFactory.getLog(SingleClassAssertion.class);
    /**
     * The Base class and field predicate pair.
     */
    private ClassAndFieldPredicatePair baseClassAndFieldPredicatePair;

    /**
     * Instantiates a new Single class assertion.
     */
    public SingleClassAssertion() {
	super();
    }

    /**
     * Instantiates a new Single class assertion.
     *
     * @param baseClassAndFieldPredicatePair the base class and field predicate pair
     */
    public SingleClassAssertion(ClassAndFieldPredicatePair baseClassAndFieldPredicatePair) {
	super();
	this.baseClassAndFieldPredicatePair = baseClassAndFieldPredicatePair;
    }

    /**
     * Log testers and classes.
     *
     * @param logger                      the logger
     * @param classAndFieldPredicatePairs the class and field predicate pairs
     */
    @Override
    protected void logTestersAndClasses(Log logger, ClassAndFieldPredicatePair... classAndFieldPredicatePairs) {
	if (LOGGER.isDebugEnabled()) {
	    ClassAndFieldPredicatePair[] classes = new ClassAndFieldPredicatePair[classAndFieldPredicatePairs.length + 1];
	    classes[0] = baseClassAndFieldPredicatePair;
	    System.arraycopy(classAndFieldPredicatePairs, 0, classes, 1, classes.length - 1);
	    super.logTestersAndClasses(LOGGER, classes);
	}
    }

    /**
     * Run assertions.
     */
    @Override
    protected void runAssertions() {
	System.out.println(toString());
	logTestersAndClasses(LOGGER);
	testers.forEach(tester -> {
	    LOGGER.info(String.format("runing tester ==> %s", tester));
	    if (tester instanceof EqualsTester && !skipEquals) {
		tester.test(baseClassAndFieldPredicatePair);
	    } else if (tester instanceof GetterTester && !skipGetters) {
		tester.test(baseClassAndFieldPredicatePair);
	    } else if (tester instanceof HashCodeTester && !skipHashCode) {
		tester.test(baseClassAndFieldPredicatePair);
	    } else if (tester instanceof SetterTester && !skipSetters) {
		tester.test(baseClassAndFieldPredicatePair);
	    } else if (tester instanceof ToStringTester && !skipToString) {
		tester.test(baseClassAndFieldPredicatePair);
	    }
	    LOGGER.info(String.format("runing tester ==> %s complete", tester));
	});
    }
}
