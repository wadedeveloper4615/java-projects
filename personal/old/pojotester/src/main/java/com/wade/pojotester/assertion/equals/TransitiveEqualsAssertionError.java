/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Transitive equals assertion error.
 */
@Getter
// @Setter
public class TransitiveEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 4877596144423153804L;
    /**
     * The constant CONSTRAINT_TRANSITIVE.
     */
    private static String CONSTRAINT_TRANSITIVE = "The equals method should return true in all cases: a.equals(b), b.equals(c) and " + "a.equals(c).\n" + "Current implementation returns:\n" + "%s for a.equals(b),\n" + "%s for b.equals(c),\n" + "%s for a.equals(c),\n" + "where 'a' is:\n" + "%s\n" + "and 'b' is:\n" + "%s\n" + "and 'c' is:\n" + "%s";
    /**
     * The A.
     */
    private Object a;
    /**
     * The B.
     */
    private Object b;
    /**
     * The C.
     */
    private Object c;
    /**
     * The First result.
     */
    private Boolean firstResult;
    /**
     * The Second result.
     */
    private Boolean secondResult;
    /**
     * The Third result.
     */
    private Boolean thirdResult;

    /**
     * Instantiates a new Transitive equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param a            the a
     * @param b            the b
     * @param c            the c
     * @param firstResult  the first result
     * @param secondResult the second result
     * @param thirdResult  the third result
     */
    public TransitiveEqualsAssertionError(Class<?> testedCass, Object a, Object b, Object c, boolean firstResult, boolean secondResult, boolean thirdResult) {
	super(testedCass);
	this.a = a;
	this.b = b;
	this.c = c;
	this.firstResult = firstResult;
	this.secondResult = secondResult;
	this.thirdResult = thirdResult;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_TRANSITIVE, firstResult, secondResult, thirdResult, a, b, c);
    }
}
