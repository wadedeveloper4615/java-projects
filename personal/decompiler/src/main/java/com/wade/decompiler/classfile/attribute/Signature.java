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
 * The Class Signature.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Signature extends Attribute {

    /** The signature index. */
    private final Integer signatureIndex;

    /**
     * Instantiates a new signature.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Signature(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_SIGNATURE, nameIndex, length);
        this.signatureIndex = input.readUnsignedShort();
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
