package com.wade.pojotester.testfiles.fields;

// TODO: Auto-generated Javadoc
/**
 * The Class EnumFields.
 */
@SuppressWarnings({ "unused" })
public class EnumFields {
    
    /** The null enum. */
    private final TestEnum1 nullEnum = null;
    
    /** The single enum 1. */
    private final SingleEnum singleEnum1 = SingleEnum.ENUM1;
    
    /** The single enum 2. */
    private final SingleEnum singleEnum2 = null;
    
    /** The test enum 1. */
    private TestEnum1 testEnum1 = TestEnum1.ENUM1;
    
    /** The object. */
    private Object object;

    /**
     * Instantiates a new enum fields.
     *
     * @param testEnum1 the test enum 1
     */
    public EnumFields(final TestEnum1 testEnum1) {
	this.testEnum1 = testEnum1;
    }
}
