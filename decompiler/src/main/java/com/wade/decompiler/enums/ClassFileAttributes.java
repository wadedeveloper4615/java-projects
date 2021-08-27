package com.wade.decompiler.enums;

/**
 * The Enum ClassFileAttributes.
 */
public enum ClassFileAttributes {
 //@formatter:off
 /** The attr unknown. */
 ATTR_UNKNOWN(-1),
 /** The attr source file. */
 ATTR_SOURCE_FILE(0),
 /** The attr constant value. */
 ATTR_CONSTANT_VALUE(1),
 /** The attr code. */
 ATTR_CODE(2),
 /** The attr exceptions. */
 ATTR_EXCEPTIONS(3),
 /** The attr line number table. */
 ATTR_LINE_NUMBER_TABLE(4),
 /** The attr local variable table. */
 ATTR_LOCAL_VARIABLE_TABLE(5),
 /** The attr inner classes. */
 ATTR_INNER_CLASSES(6),
 /** The attr synthetic. */
 ATTR_SYNTHETIC(7),
 /** The attr deprecated. */
 ATTR_DEPRECATED(8),
 /** The attr pmg. */
 ATTR_PMG(9),
 /** The attr signature. */
 ATTR_SIGNATURE(10),
 /** The attr stack map. */
 ATTR_STACK_MAP(11),
 /** The attr runtime visible annotations. */
 ATTR_RUNTIME_VISIBLE_ANNOTATIONS(12),
 /** The attr runtime invisible annotations. */
 ATTR_RUNTIME_INVISIBLE_ANNOTATIONS(13),
 /** The attr runtime visible parameter annotations. */
 ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS(14),
 /** The attr runtime invisible parameter annotations. */
 ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS(15),
 /** The attr annotation default. */
 ATTR_ANNOTATION_DEFAULT(16),
 /** The attr local variable type table. */
 ATTR_LOCAL_VARIABLE_TYPE_TABLE(17),
 /** The attr enclosing method. */
 ATTR_ENCLOSING_METHOD(18),
 /** The attr stack map table. */
 ATTR_STACK_MAP_TABLE(19),
 /** The attr bootstrap methods. */
 ATTR_BOOTSTRAP_METHODS(20),
 /** The attr method parameters. */
 ATTR_METHOD_PARAMETERS(21),
 /** The attr module. */
 ATTR_MODULE(22),
 /** The attr module packages. */
 ATTR_MODULE_PACKAGES(23),
 /** The attr module main class. */
 ATTR_MODULE_MAIN_CLASS(24),
 /** The attr nest host. */
 ATTR_NEST_HOST(25),
 /** The attr nest members. */
 ATTR_NEST_MEMBERS(26),
 /** The attr illegal*/
 ATTR_ILLEGAL(27);

    /**
     * Read.
     *
     * @param flag the flag
     * @return the class file attributes
     */
    public static ClassFileAttributes read(int flag) {
	for (ClassFileAttributes attr : ClassFileAttributes.values()) {
	    if (attr.getTag() == flag) {
		return attr;
	    }
	}
	return ATTR_UNKNOWN;
    }

    /** The attribute names. */
    private String[] ATTRIBUTE_NAMES = {"SourceFile", "ConstantValue", "Code", "Exceptions", "LineNumberTable", "LocalVariableTable", "InnerClasses", "Synthetic", "Deprecated", "PMGClass", "Signature", "StackMap", "RuntimeVisibleAnnotations", "RuntimeInvisibleAnnotations", "RuntimeVisibleParameterAnnotations", "RuntimeInvisibleParameterAnnotations", "AnnotationDefault", "LocalVariableTypeTable", "EnclosingMethod", "StackMapTable", "BootstrapMethods", "MethodParameters", "Module", "ModulePackages", "ModuleMainClass", "NestHost", "NestMembers","Illegal"};
    /** The tag. */
    //@formatter:on
    private int tag;

    /** The name. */
    private String name;

    /**
     * Instantiates a new class file attributes.
     *
     * @param tag the tag
     */
    ClassFileAttributes(int tag) {
        this.tag = tag;
        if (tag == -1 || tag >= 27) {
            this.name = "Unknown";
        } else {
            this.name = ATTRIBUTE_NAMES[tag];
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
    public int getTag() {
        return tag;
    }
}
