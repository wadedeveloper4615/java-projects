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
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class EnclosingMethod.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class EnclosingMethod extends Attribute {

    /** The class index. */
    private Integer classIndex;

    /** The method index. */
    private Integer methodIndex;

    /**
     * Instantiates a new enclosing method.
     *
     * @param nameIndex the name index
     * @param len       the len
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public EnclosingMethod(int nameIndex, int len, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_ENCLOSING_METHOD, nameIndex, len);
        this.classIndex = input.readUnsignedShort();
        this.methodIndex = input.readUnsignedShort();
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
