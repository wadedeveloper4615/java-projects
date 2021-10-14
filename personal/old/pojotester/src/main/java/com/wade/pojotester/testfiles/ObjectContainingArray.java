package com.wade.pojotester.testfiles;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectContainingArray.
 */
public class ObjectContainingArray {
    
    /** The array. */
    private int[] array;

    /**
     * Equals.
     *
     * @param o the o
     * @return true, if successful
     */
    @Override
    public boolean equals(final Object o) {
	if (this == o) {
	    return true;
	}
	if (o == null || getClass() != o.getClass()) {
	    return false;
	}
	final ObjectContainingArray that = (ObjectContainingArray) o;
	return new EqualsBuilder().append(array, that.array).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(array).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return new ToStringBuilder(this).append("array", array).toString();
    }
}
