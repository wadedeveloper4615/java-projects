/* Copyright (c) 2021. Christopher D. Wade */
/*
 *
 */
package com.wade.pojotester.assertion.equals;

import lombok.Getter;

/**
 * The type Other type equals assertion error.
 */
@Getter
// @Setter
public class OtherTypeEqualsAssertionError extends AbstractEqualsAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 5260466140860513244L;
    /**
     * The constant CONSTRAINT_OTHER_TYPE.
     */
    private static String CONSTRAINT_OTHER_TYPE = "The equals method should return false if object is comparing to object with " + "different type.\n" + "Current implementation returns true.\n" + "Object:\n" + "%s\n" + "should not be equal to:\n" + "%s";
    /**
     * The Tested object.
     */
    private Object testedObject;
    /**
     * The Other object.
     */
    private Object otherObject;

    /**
     * Instantiates a new Other type equals assertion error.
     *
     * @param testedCass   the tested cass
     * @param testedObject the tested object
     * @param otherObject  the other object
     */
    public OtherTypeEqualsAssertionError(Class<?> testedCass, Object testedObject, Object otherObject) {
	super(testedCass);
	this.testedObject = testedObject;
	this.otherObject = otherObject;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_OTHER_TYPE, testedObject, otherObject);
    }
}
