package com.wade.pojotester.testfiles;

import java.util.stream.Stream;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectContainingStream.
 */
public class ObjectContainingStream {
    
    /** The stream. */
    private Stream<Integer> stream;

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
	final ObjectContainingStream that = (ObjectContainingStream) o;
	return new EqualsBuilder().append(stream, that.stream).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(stream).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return new ToStringBuilder(this).append("stream", stream).toString();
    }
}
