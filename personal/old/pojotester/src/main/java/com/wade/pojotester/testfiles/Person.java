package com.wade.pojotester.testfiles;

import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * The Class Person.
 */
@SuppressWarnings({ "unused" })
public class Person {
    /** The id. */
    private final UUID id;
    /** The name. */
    private final String name;

    /**
     * Instantiates a new person.
     *
     * @param name the name
     */
    private Person(final String name) {
	this.id = UUID.randomUUID();
	this.name = name;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     *
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
	final Person person = (Person) obj;
	return new EqualsBuilder().append(id, person.id).isEquals();
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
	return new HashCodeBuilder().append(id).toHashCode();
    }

    /**
     * The Class PersonBuilder.
     */
    public static class PersonBuilder {
	/** The name. */
	private String name;

	/**
	 * Builds the.
	 *
	 * @return the person
	 */
	public Person build() {
	    return new Person(name);
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name
	 *
	 * @return the person builder
	 */
	public PersonBuilder setName(final String name) {
	    this.name = name;
	    return this;
	}
    }
}
