package com.wade.decompiler.enums;

/**
 * The Enum ClassFileConstants.
 */
public enum ClassFileConstants {
    /** The constant dummy0. */
    //@formatter:off
    CONSTANT_DUMMY0(0),
 /** The CONSTAN T utf 8. */
 CONSTANT_Utf8(1),
 /** The constant dummy1. */
 CONSTANT_DUMMY1(2),
 /** The CONSTAN T integer. */
 CONSTANT_Integer(3),
 /** The CONSTAN T float. */
 CONSTANT_Float(4),
 /** The CONSTAN T long. */
 CONSTANT_Long(5),
 /** The CONSTAN T double. */
 CONSTANT_Double(6),
 /** The CONSTAN T class. */
 CONSTANT_Class(7),
 /** The CONSTAN T fieldref. */
 CONSTANT_Fieldref(9),
 /** The CONSTAN T string. */
 CONSTANT_String(8),
 /** The CONSTAN T methodref. */
 CONSTANT_Methodref(10),
 /** The CONSTAN T interface methodref. */
 CONSTANT_InterfaceMethodref(11),
 /** The CONSTAN T name and type. */
 CONSTANT_NameAndType(12),
 /** The constant dummy2. */
 CONSTANT_DUMMY2(13),
 /** The constant dummy3. */
 CONSTANT_DUMMY3(14),
 /** The CONSTAN T method handle. */
 CONSTANT_MethodHandle(15),
 /** The CONSTAN T method type. */
 CONSTANT_MethodType(16),
 /** The CONSTAN T dynamic. */
 CONSTANT_Dynamic(17),
 /** The CONSTAN T invoke dynamic. */
 CONSTANT_InvokeDynamic(18),
 /** The CONSTAN T module. */
 CONSTANT_Module(19),
 /** The CONSTAN T package. */
 CONSTANT_Package(20),
 /** The constant unknown. */
 CONSTANT_UNKNOWN(99);

    /**
     * Read.
     *
     * @param tag the tag
     * @return the class file constants
     */
    public static ClassFileConstants read(byte tag) {
	for (ClassFileConstants v : ClassFileConstants.values()) {
	    if (v.getTag() == tag) {
		return v;
	    }
	}
	return CONSTANT_UNKNOWN;
    }

    /** The constant names. */
    private String[] CONSTANT_NAMES = {"", "CONSTANT_Utf8", "", "CONSTANT_Integer", "CONSTANT_Float", "CONSTANT_Long", "CONSTANT_Double", "CONSTANT_Class", "CONSTANT_String", "CONSTANT_Fieldref", "CONSTANT_Methodref", "CONSTANT_InterfaceMethodref", "CONSTANT_NameAndType", "", "", "CONSTANT_MethodHandle", "CONSTANT_MethodType", "CONSTANT_Dynamic", "CONSTANT_InvokeDynamic", "CONSTANT_Module", "CONSTANT_Package"};
    /** The tag. */
    //@formatter:on
    private byte tag;

    /** The name. */
    private String name;

    /**
     * Instantiates a new class file constants.
     *
     * @param tag the tag
     */
    ClassFileConstants(int tag) {
        this.tag = (byte) tag;
        if (tag == 99) {
            this.name = "Unknown";
        } else {
            this.name = CONSTANT_NAMES[tag];
        }
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the tag.
     *
     * @return the tag
     */
    public byte getTag() {
        return tag;
    }
}