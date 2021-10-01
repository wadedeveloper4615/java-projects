package com.wade.pojotester.testfiles;

import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassContainingPrivateEnum.
 */
public final class ClassContainingPrivateEnum {
    
    /** The a. */
    private final UUID a;
    
    /** The b. */
    private final UUID b;
    
    /** The c. */
    private final Status c;
    
    /** The d. */
    private final String d;

    /**
     * Instantiates a new class containing private enum.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     */
    private ClassContainingPrivateEnum(final UUID a, final UUID b, final Status c, final String d) {
	this.a = a;
	this.b = b;
	this.c = c;
	this.d = d;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null || getClass() != obj.getClass()) {
	    return false;
	}
	final ClassContainingPrivateEnum that = (ClassContainingPrivateEnum) obj;
	return new EqualsBuilder().append(a, that.a).append(b, that.b).append(c, that.c).append(d, that.d).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(a).append(b).append(c).append(d).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return "ClassContainingPrivateEnum{" + "a=" + a + ", b=" + b + ", c=" + c + ", d='" + d + '\'' + '}';
    }

    /**
     * The Enum Status.
     */
    private enum Status {
	
	/** The ok. */
	OK, 
 /** The ok2. */
 OK2, 
 /** The ok3. */
 OK3
    }
}