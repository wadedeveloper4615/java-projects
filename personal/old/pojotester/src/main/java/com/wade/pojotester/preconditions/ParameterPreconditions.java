package com.wade.pojotester.preconditions;

import java.util.Arrays;

import com.wade.pojotester.exception.BlankParameterException;
import com.wade.pojotester.exception.NullParameterException;

/**
 * The Class ParameterPreconditions.
 */
public class ParameterPreconditions {
    /**
     * Check not blank.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public static void checkNotBlank(String parameterName, String parameterValue) {
	checkNotNull(parameterName, parameterValue);
	if (hasZeroLength(parameterValue)) {
	    throw new BlankParameterException(parameterName, parameterValue);
	}
    }

    /**
     * Check not blank.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public static void checkNotBlank(String parameterName, String[] parameterValue) {
	Arrays.stream(parameterValue).forEach(each -> checkNotBlank(parameterName, each));
    }

    /**
     * Check not null.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public static void checkNotNull(String parameterName, Object parameterValue) {
	if (parameterValue == null) {
	    throw new NullParameterException(parameterName);
	}
    }

    /**
     * Check not null.
     *
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public static void checkNotNull(String parameterName, Object[] parameterValue) {
	Arrays.stream(parameterValue).forEach(each -> checkNotNull(parameterName, each));
    }

    /**
     * Checks for zero length.
     *
     * @param parameterValue the parameter value
     *
     * @return true, if successful
     */
    private static boolean hasZeroLength(String parameterValue) {
	return parameterValue.trim().length() == 0;
    }

    /**
     * Instantiates a new parameter preconditions.
     */
    private ParameterPreconditions() {
    }
}
