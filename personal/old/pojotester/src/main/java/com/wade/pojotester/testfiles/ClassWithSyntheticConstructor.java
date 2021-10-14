package com.wade.pojotester.testfiles;

// TODO: Auto-generated Javadoc
/**
 * The Class ClassWithSyntheticConstructor.
 */
@SuppressWarnings({ "unused" })
public class ClassWithSyntheticConstructor {
    
    /**
     * Instantiates a new class with synthetic constructor.
     *
     * @param parameter the parameter
     */
    private ClassWithSyntheticConstructor(final String parameter) {
    }

    /**
     * The Class Builder.
     */
    private static class Builder {
	
	/**
	 * Builds the.
	 *
	 * @return the class with synthetic constructor
	 */
	public ClassWithSyntheticConstructor build() {
	    return new ClassWithSyntheticConstructor("test");
	}
    }
}
