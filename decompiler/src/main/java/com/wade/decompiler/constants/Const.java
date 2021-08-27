package com.wade.decompiler.constants;

import java.util.Arrays;
import java.util.Collections;

import com.wade.decompiler.enums.ClassAccessFlags;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.enums.Version;

//@formatter:off
/**
 * The Class Const.
 */
//@formatter:off
public final class Const {

    /** The Constant JVM_CLASSFILE_MAGIC. */
    public static final int JVM_CLASSFILE_MAGIC = 0xCAFEBABE;

    /** The Constant MAJOR_1_9. */
    @Deprecated
    public static final short MAJOR_1_9 = (short) Version.Version_9.getMajor();

    /** The Constant MINOR_1_9. */
    @Deprecated
    public static final short MINOR_1_9 = (short) Version.Version_9.getMinor();

    /** The Constant MAJOR. */
    public static final short MAJOR = (short) Version.Version_1_1.getMajor();

    /** The Constant MINOR. */
    public static final short MINOR = (short) Version.Version_1_1.getMajor();

    /** The Constant MAX_SHORT. */
    public static final int MAX_SHORT = 65535; // 2^16 - 1

    /** The Constant MAX_BYTE. */
    public static final int MAX_BYTE = 255; // 2^8 - 1

    /** The Constant MAX_ACC_FLAG. */
    public static final short MAX_ACC_FLAG = (short) ClassAccessFlags.ACC_ENUM.getIndex();

    /** The Constant MAX_ACC_FLAG_I. */
    public static final int MAX_ACC_FLAG_I = 0x8000; // ACC_MODULE is negative as a short

    /** The Constant STATIC_INITIALIZER_NAME. */
    public static final String STATIC_INITIALIZER_NAME = "<clinit>";

    /** The Constant CONSTRUCTOR_NAME. */
    public static final String CONSTRUCTOR_NAME = "<init>";

    /** The Constant MAX_CP_ENTRIES. */
    public static final int MAX_CP_ENTRIES = 65535;

    /** The Constant MAX_CODE_SIZE. */
    public static final int MAX_CODE_SIZE = 65536; //bytes

    /** The Constant MAX_ARRAY_DIMENSIONS. */
    public static final int MAX_ARRAY_DIMENSIONS = 255;

    /** The Constant PUSH. */
    public static final short PUSH = 4711;

    /** The Constant SWITCH. */
    public static final short SWITCH = 4712;

    /** The Constant UNDEFINED. */
    public static final short UNDEFINED = -1;

    /** The Constant UNPREDICTABLE. */
    public static final short UNPREDICTABLE = -2;

    /** The Constant RESERVED. */
    public static final short RESERVED = -3;

    /** The Constant ILLEGAL_OPCODE. */
    public static final String ILLEGAL_OPCODE = "<illegal opcode>";

    /** The Constant ILLEGAL_TYPE. */
    public static final String ILLEGAL_TYPE = "<illegal type>";

    /** The Constant OPCODE_NAMES_LENGTH. */
    public static final int OPCODE_NAMES_LENGTH = InstructionOpCodes.IMPDEP2.getOpcode();

    /** The Constant SAME_FRAME. */
    public static final int SAME_FRAME = 0;

    /** The Constant SAME_LOCALS_1_STACK_ITEM_FRAME. */
    public static final int SAME_LOCALS_1_STACK_ITEM_FRAME = 64;

    /** The Constant SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED. */
    public static final int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED = 247;

    /** The Constant CHOP_FRAME. */
    public static final int CHOP_FRAME = 248;

    /** The Constant SAME_FRAME_EXTENDED. */
    public static final int SAME_FRAME_EXTENDED = 251;

    /** The Constant APPEND_FRAME. */
    public static final int APPEND_FRAME = 252;

    /** The Constant FULL_FRAME. */
    public static final int FULL_FRAME = 255;

    /** The Constant SAME_FRAME_MAX. */
    public static final int SAME_FRAME_MAX = 63;

    /** The Constant SAME_LOCALS_1_STACK_ITEM_FRAME_MAX. */
    public static final int SAME_LOCALS_1_STACK_ITEM_FRAME_MAX = 127;

    /** The Constant CHOP_FRAME_MAX. */
    public static final int CHOP_FRAME_MAX = 250;

    /** The Constant APPEND_FRAME_MAX. */
    public static final int APPEND_FRAME_MAX = 254;

    /** The Constant REF_getField. */
    public static final byte REF_getField = 1;

    /** The Constant REF_getStatic. */
    public static final byte REF_getStatic = 2;

    /** The Constant REF_putField. */
    public static final byte REF_putField = 3;

    /** The Constant REF_putStatic. */
    public static final byte REF_putStatic = 4;

    /** The Constant REF_invokeVirtual. */
    public static final byte REF_invokeVirtual = 5;

    /** The Constant REF_invokeStatic. */
    public static final byte REF_invokeStatic = 6;

    /** The Constant REF_invokeSpecial. */
    public static final byte REF_invokeSpecial = 7;

    /** The Constant REF_newInvokeSpecial. */
    public static final byte REF_newInvokeSpecial = 8;

    /** The Constant REF_invokeInterface. */
    public static final byte REF_invokeInterface = 9;

    /** The Constant INTERFACES_IMPLEMENTED_BY_ARRAYS. */
    private static final String[] INTERFACES_IMPLEMENTED_BY_ARRAYS = {"java.lang.Cloneable", "java.io.Serializable"};

    /** The Constant METHODHANDLE_NAMES. */
    private static final String[] METHODHANDLE_NAMES = {"", "getField", "getStatic", "putField", "putStatic", "invokeVirtual", "invokeStatic", "invokeSpecial", "newInvokeSpecial", "invokeInterface"};

    /**
     * Gets the interfaces implemented by arrays.
     *
     * @return the interfaces implemented by arrays
     */
    public static Iterable<String> getInterfacesImplementedByArrays() {
        return Collections.unmodifiableList(Arrays.asList(INTERFACES_IMPLEMENTED_BY_ARRAYS));
    }

    /**
     * Gets the method handle name.
     *
     * @param index the index
     * @return the method handle name
     */
    public static String getMethodHandleName(final int index) {
        return METHODHANDLE_NAMES[index];
    }

    /**
     * Instantiates a new const.
     */
    private Const() {
    } // not instantiable
}
