/* Copyright (c) 2021. Christopher D. Wade */
package com.wade.pojotester.util;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

// TODO: Auto-generated Javadoc
/**
 * The type Constructor parameters.
 */
public class ConstructorParameters {
    /**
     * The Parameters.
     */
    private Object[] parameters;
    /**
     * The Parameters types.
     */
    private Class<?>[] parametersTypes;

    /**
     * Instantiates a new Constructor parameters.
     *
     * @param constr the constr
     */
    public ConstructorParameters(Constructor<?> constr) {
	this.parameters = constr.getParameters();
	this.parametersTypes = constr.getParameterTypes();
    }

    /**
     * Instantiates a new Constructor parameters.
     *
     * @param parameters      the parameters
     * @param parametersTypes the parameters types
     */
    public ConstructorParameters(Object[] parameters, Class<?>[] parametersTypes) {
	this.parameters = Arrays.copyOf(parameters, parameters.length);
	this.parametersTypes = Arrays.copyOf(parametersTypes, parametersTypes.length);
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * 
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || this.getClass() != o.getClass()) {
	    return false;
	}
	ConstructorParameters that = (ConstructorParameters) o;
	return new EqualsBuilder().append(this.parameters, that.parameters).append(this.parametersTypes, that.parametersTypes).isEquals();
    }

    /**
     * Get parameters object [ ].
     *
     * @return the object [ ]
     */
    public Object[] getParameters() {
	return this.parameters;
    }

    /**
     * Get parameters types class [ ].
     *
     * @return the class [ ]
     */
    public Class<?>[] getParametersTypes() {
	return this.parametersTypes;
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(this.parameters).append(this.parametersTypes).toHashCode();
    }

    /**
     * Matches boolean.
     *
     * @param parameterTypes the parameter types
     * 
     * @return the boolean
     */
    public boolean matches(Class<?>[] parameterTypes) {
	return Arrays.equals(this.parametersTypes, parameterTypes);
    }
}
