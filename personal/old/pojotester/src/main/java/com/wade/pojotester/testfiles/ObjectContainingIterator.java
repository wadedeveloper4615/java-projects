package com.wade.pojotester.testfiles;

import java.util.Iterator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectContainingIterator.
 */
public class ObjectContainingIterator {
    
    /** The iterator. */
    private Iterator<Integer> iterator;

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
	final ObjectContainingIterator that = (ObjectContainingIterator) o;
	return new EqualsBuilder().append(iterator, that.iterator).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(iterator).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return new ToStringBuilder(this).append("iterator", iterator).toString();
    }
}
