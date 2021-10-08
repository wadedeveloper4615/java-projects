package com.wade.pojotester.testfiles;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectContainingList.
 */
class ObjectContainingList {
    
    /** The list. */
    private List<Integer> list;

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
	final ObjectContainingList that = (ObjectContainingList) o;
	return new EqualsBuilder().append(list, that.list).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(list).toHashCode();
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	return new ToStringBuilder(this).append("list", list).toString();
    }
}
