package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.ConstantValue;
import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantDouble;
import com.wade.decompiler.classfile.constant.ConstantFloat;
import com.wade.decompiler.classfile.constant.ConstantInteger;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantString;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ConstantValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ConstantValueGen extends AttributeGen {
    /** The value. */
    private Object value;

    /**
     * Instantiates a new constant value gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ConstantValueGen(ConstantValue attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        Constant constant = constantPool.getConstant(attribute.getConstantValueIndex());
        value = toBytes(constant, constantPool);
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\n\t" + toString());
    }

    /**
     * To bytes.
     *
     * @param constant     the constant
     * @param constantPool the constant pool
     * @return the object
     */
    protected Object toBytes(Constant constant, ConstantPool constantPool) {
        switch (constant.getTag()) {
            case CONSTANT_Long:
                return ((ConstantLong) constant).getBytes();
            case CONSTANT_Float:
                return ((ConstantFloat) constant).getBytes();
            case CONSTANT_Double:
                return ((ConstantDouble) constant).getBytes();
            case CONSTANT_Integer:
                return ((ConstantInteger) constant).getBytes();
            case CONSTANT_String:
                int i = ((ConstantString) constant).getStringIndex();
                Constant c = constantPool.getConstant(i, ClassFileConstants.CONSTANT_Utf8);
                return ((ConstantUtf8) c).getBytes();
            default:
                throw new IllegalStateException("Type of ConstValue invalid: " + constant);
        }
    }
}
