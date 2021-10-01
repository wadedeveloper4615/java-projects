package com.wade.decompiler.enums;

/**
 * The Enum TypeEnum.
 */
public enum TypeEnum {
    /** The t boolean. */
    //@formatter:off
    T_BOOLEAN(4),
 /** The t char. */
 T_CHAR(5),
 /** The t float. */
 T_FLOAT(6),
 /** The t double. */
 T_DOUBLE(7),
 /** The t byte. */
 T_BYTE(8),
 /** The t short. */
 T_SHORT(9),
 /** The t integer. */
 T_INTEGER(10),
 /** The t long. */
 T_LONG(11),
 /** The t void. */
 T_VOID(12),
 /** The t array. */
 T_ARRAY(13),
 /** The t object. */
 T_OBJECT(14),
 /** The t reference. */
 T_REFERENCE(14),
 /** The t unknown. */
 T_UNKNOWN(15),
 /** The t address. */
 T_ADDRESS(16),
 /** The t none. */
 T_NONE(17);

    /**
     * Read.
     *
     * @param flag the flag
     * @return the type enum
     */
    public static TypeEnum read(int flag) {
        for (TypeEnum attr : TypeEnum.values()) {
            if (attr.getTag() == flag) {
                return attr;
            }
        }
        return T_UNKNOWN;
    }

    /** The tag. */
    //@formatter:off
    private final int tag;

    /** The type name. */
    private final String typeName;

    /** The class type name. */
    private final String classTypeName;

    /** The short type name. */
    private final String shortTypeName;

    /** The illegal type. */
    public String ILLEGAL_TYPE = "<illegal type>";

    /** The type names. */
    private final String[] TYPE_NAMES = {ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, "boolean", "char", "float", "double", "byte", "short", "int", "long", "void", "array", "object", "unknown", "address", ILLEGAL_TYPE};

    /** The class type names. */
    private final String[] CLASS_TYPE_NAMES = {ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, "java.lang.Boolean", "java.lang.Character", "java.lang.Float", "java.lang.Double", "java.lang.Byte", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Void", ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE};

    /** The short type names. */
    private final String[] SHORT_TYPE_NAMES = {ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, "Z", "C", "F", "D", "B", "S", "I", "J", "V", ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE, ILLEGAL_TYPE};

    /**
     * Instantiates a new type enum.
     *
     * @param tag the tag
     */
    TypeEnum(int tag) {
        this.tag = tag;
        this.typeName = TYPE_NAMES[tag];
        this.classTypeName = CLASS_TYPE_NAMES[tag];
        this.shortTypeName = SHORT_TYPE_NAMES[tag];
    }

    /**
     * Gets the class type name.
     *
     * @return the class type name
     */
    public String getClassTypeName() {
        return classTypeName;
    }

    /**
     * Gets the short type name.
     *
     * @return the short type name
     */
    public String getShortTypeName() {
        return shortTypeName;
    }

    /**
     * Gets the tag.
     *
     * @return the tag
     */
    public int getTag() {
        return tag;
    }

    /**
     * Gets the type name.
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }
}
