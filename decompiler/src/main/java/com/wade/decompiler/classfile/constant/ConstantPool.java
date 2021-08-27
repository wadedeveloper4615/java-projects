package com.wade.decompiler.classfile.constant;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.wade.decompiler.constants.Const;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.exceptions.ClassFormatException;
import com.wade.decompiler.util.Utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ConstantPool.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ConstantPool {
    /** The constant pool. */
    private List<Constant> constantPool;

    /**
     * Instantiates a new constant pool.
     */
    public ConstantPool() {
        constantPool = new ArrayList<>();
    }

    /**
     * Instantiates a new constant pool.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantPool(DataInput input) throws IOException {
        int constant_pool_count = input.readUnsignedShort();
        Constant[] cp = new Constant[constant_pool_count];
        for (int i = 1; i < constant_pool_count; i++) {
            cp[i] = Constant.readConstant(input);
            ClassFileConstants tag = cp[i].getTag();
            if (tag == ClassFileConstants.CONSTANT_Double || tag == ClassFileConstants.CONSTANT_Long) {
                i++;
            }
        }
        constantPool = Arrays.asList(cp);
    }

    /**
     * Adds the.
     *
     * @param c the c
     * @return true, if successful
     */
    public boolean add(Constant c) {
        return this.constantPool.add(c);
    }

    /**
     * Constant to string.
     *
     * @param c the c
     * @return the string
     * @throws ClassFormatException the class format exception
     */
    public String constantToString(Constant c) throws ClassFormatException {
        int i;
        ClassFileConstants tag = c.getTag();
        String str = switch (tag) {
            case CONSTANT_Class -> {
                i = ((ConstantClass) c).getNameIndex();
                c = getConstant(i, ClassFileConstants.CONSTANT_Utf8);
                yield Utility.compactClassName(((ConstantUtf8) c).getBytes(), false);
            }
            case CONSTANT_String -> {
                i = ((ConstantString) c).getStringIndex();
                c = getConstant(i, ClassFileConstants.CONSTANT_Utf8);
                yield "\"" + ((ConstantUtf8) c).getBytes() + "\"";
            }
            case CONSTANT_Utf8 -> ((ConstantUtf8) c).getBytes();
            case CONSTANT_Double -> String.valueOf(((ConstantDouble) c).getBytes());
            case CONSTANT_Float -> String.valueOf(((ConstantFloat) c).getBytes());
            case CONSTANT_Long -> String.valueOf(((ConstantLong) c).getBytes());
            case CONSTANT_Integer -> String.valueOf(((ConstantInteger) c).getBytes());
            case CONSTANT_NameAndType -> constantToString(((ConstantNameAndType) c).getNameIndex(), ClassFileConstants.CONSTANT_Utf8) + " " + constantToString(((ConstantNameAndType) c).getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8);
            case CONSTANT_InterfaceMethodref, CONSTANT_Methodref, CONSTANT_Fieldref -> constantToString(((ConstantCP) c).getClassIndex(), ClassFileConstants.CONSTANT_Class) + "." + constantToString(((ConstantCP) c).getNameAndTypeIndex(), ClassFileConstants.CONSTANT_NameAndType);
            case CONSTANT_MethodHandle -> {
                // Note that the ReferenceIndex may point to a Fieldref, Methodref or
                // InterfaceMethodref - so we need to peek ahead to get the actual type.
                ConstantMethodHandle cmh = (ConstantMethodHandle) c;
                yield Const.getMethodHandleName(cmh.getReferenceKind()) + " " + constantToString(cmh.getReferenceIndex(), getConstant(cmh.getReferenceIndex()).getTag());
            }
            case CONSTANT_MethodType -> {
                ConstantMethodType cmt = (ConstantMethodType) c;
                yield constantToString(cmt.getDescriptorIndex(), ClassFileConstants.CONSTANT_Utf8);
            }
            case CONSTANT_InvokeDynamic -> {
                ConstantInvokeDynamic cid = (ConstantInvokeDynamic) c;
                yield cid.getClassIndex() + ":" + constantToString(cid.getNameAndTypeIndex(), ClassFileConstants.CONSTANT_NameAndType);
            }
            case CONSTANT_Module -> {
                i = ((ConstantModule) c).getNameIndex();
                c = getConstant(i, ClassFileConstants.CONSTANT_Utf8);
                yield Utility.compactClassName(((ConstantUtf8) c).getBytes(), false);
            }
            case CONSTANT_Package -> {
                i = ((ConstantPackage) c).getNameIndex();
                c = getConstant(i, ClassFileConstants.CONSTANT_Utf8);
                yield Utility.compactClassName(((ConstantUtf8) c).getBytes(), false);
            }
            default -> throw new IllegalArgumentException("Unknown constant type " + tag);
        };
        return str;
    }

    /**
     * Constant to string.
     *
     * @param index the index
     * @return the string
     * @throws ClassFormatException the class format exception
     */
    public String constantToString(int index) throws ClassFormatException {
        Constant c = getConstant(index);
        return constantToString(c);
    }

    /**
     * Constant to string.
     *
     * @param index the index
     * @param tag   the tag
     * @return the string
     * @throws ClassFormatException the class format exception
     */
    public String constantToString(int index, ClassFileConstants tag) throws ClassFormatException {
        Constant c = getConstant(index, tag);
        return constantToString(c);
    }

    /**
     * Gets the constant.
     *
     * @param index the index
     * @return the constant
     */
    public Constant getConstant(int index) {
        if (index >= constantPool.size() || index <= 0) {
            System.out.println("Invalid constant pool reference: " + index + ". Constant pool size is: " + constantPool.size());
            throw new ClassFormatException("Invalid constant pool reference: " + index + ". Constant pool size is: " + constantPool.size());
        }
        return constantPool.get(index);
    }

    /**
     * Gets the constant.
     *
     * @param index the index
     * @param tag   the tag
     * @return the constant
     * @throws ClassFormatException the class format exception
     */
    public Constant getConstant(int index, ClassFileConstants tag) throws ClassFormatException {
        Constant c = getConstant(index);
        return c;
    }

    /**
     * Readable string.
     *
     * @return the string
     */
    public String readableString() {
        final StringBuilder buf = new StringBuilder();
        for (int i = 0; i < constantPool.size(); i++) {
            buf.append(String.format("%4d) %s\n", i, constantPool.get(i)));
        }
        return buf.toString();
    }
}
