/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import lombok.Getter;

/**
 * The type Not contain to string assertion error.
 */
@Getter
// @Setter
public class NotContainToStringAssertionError extends AbstractToStringAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 912497987048847563L;
    /**
     * The constant CONSTRAINT_NOT_CONTAIN.
     */
    private static String CONSTRAINT_NOT_CONTAIN = "The toString method should not contain:\n" + "%s\n" + "but does.\n" + "Result of toString:\n" + "%s";
    /**
     * The Value.
     */
    private String value;
    /**
     * The To string.
     */
    private String toString;

    /**
     * Instantiates a new Not contain to string assertion error.
     *
     * @param testedCass the tested cass
     * @param value      the value
     * @param toString   the to string
     */
    public NotContainToStringAssertionError(Class<?> testedCass, String value, String toString) {
	super(testedCass);
	this.value = value;
	this.toString = toString;
    }

    /**
     * Gets detailed message.
     *
     * @return the detailed message
     */
    @Override
    protected String getDetailedMessage() {
	return String.format(CONSTRAINT_NOT_CONTAIN, value, toString);
    }
}
