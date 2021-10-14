package com.wade.pojotester.exception;

/**
 * The Class BlankParameterException.
 */
public class BlankParameterException extends RuntimeException {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -297597588109139158L;

    /**
     * Instantiates a new blank parameter exception.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public BlankParameterException(String parameterName, String parameterValue) {
	super(createMessage(parameterName, parameterValue));
    }

    /**
     * Creates the message.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     *
     * @return the string
     */
    private static String createMessage(String parameterName, String parameterValue) {
	return String.format("Parameter '%s' is blank. It's value is '%s'", parameterName, parameterValue);
    }
}
