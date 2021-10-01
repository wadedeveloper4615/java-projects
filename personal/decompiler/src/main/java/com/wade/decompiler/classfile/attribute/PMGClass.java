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
 * The Class PMGClass.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class PMGClass extends Attribute {

    /** The pmg class index. */
    private Integer pmgClassIndex;

    /** The pmg index. */
    private Integer pmgIndex;

    /**
     * Instantiates a new PMG class.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public PMGClass(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_PMG, nameIndex, length);
        this.pmgIndex = input.readUnsignedShort();
        this.pmgClassIndex = input.readUnsignedShort();
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
