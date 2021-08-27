package com.wade.pojotester.exception;

/**
 * The Class NullParameterException.
 */
public class NullParameterException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -136181527951913727L;

    /**
     * Instantiates a new null parameter exception.
     *
     * @param parameterName the parameter name
     */
    public NullParameterException(String parameterName) {
	super(createMessage(parameterName));
    }

    /**
     * Creates the message.
     *
     * @param parameterName the parameter name
     *
     * @return the string
     */
    private static String createMessage(String parameterName) {
	return String.format("Parameter '%s' has null value.", parameterName);
    }
}
