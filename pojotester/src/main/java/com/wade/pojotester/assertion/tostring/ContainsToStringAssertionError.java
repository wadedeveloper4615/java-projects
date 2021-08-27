/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.assertion.tostring;

import lombok.Getter;

/**
 * The type Contains to string assertion error.
 */
@Getter
// @Setter
public class ContainsToStringAssertionError extends AbstractToStringAssertionError {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 6565128638793964799L;
    /**
     * The constant CONSTRAINT_CONTAINS.
     */
    private static String CONSTRAINT_CONTAINS = "The toString method should contain:\n" + "%s\n" + "But does not.\n" + "Result of toString:\n" + "%s";
    /**
     * The Value.
     */
    private String value;
    /**
     * The To string.
     */
    private String toString;

    /**
     * Instantiates a new Contains to string assertion error.
     *
     * @param testedCass the tested cass
     * @param value      the value
     * @param toString   the to string
     */
    public ContainsToStringAssertionError(Class<?> testedCass, String value, String toString) {
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
	return String.format(CONSTRAINT_CONTAINS, value, toString);
    }
}
