/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Reflexive equals assertion error.
 */
@Getter
// @Setter
public class ReflexiveEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -1613076786099732073L;
    /**
     * The constant CONSTRAINT_REFLEXIVE.
     */
    private static String CONSTRAINT_REFLEXIVE = "The equals method should return true if object is comparing to itself.\n" + "Current implementation returns false.\n" + "Object:\n" + "%s\n" + "should be equal to:\n" + "%s";
    /**
     * The Tested object.
     */
    private Object testedObject;

    /**
     * Instantiates a new Reflexive equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param testedObject the tested object
     */
    public ReflexiveEqualsAssertionError(Class<?> testedCass, Object testedObject) {
	super(testedCass);
	this.testedObject = testedObject;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_REFLEXIVE, testedObject, testedObject);
    }
}
