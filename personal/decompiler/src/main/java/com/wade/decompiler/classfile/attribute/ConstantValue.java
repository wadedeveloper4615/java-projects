/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ConstantValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ConstantValue extends Attribute {

    /** The constant value index. */
    private Integer constantValueIndex;

    /**
     * Instantiates a new constant value.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ConstantValue(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_CONSTANT_VALUE, nameIndex, length);
        this.constantValueIndex = input.readUnsignedShort();
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
