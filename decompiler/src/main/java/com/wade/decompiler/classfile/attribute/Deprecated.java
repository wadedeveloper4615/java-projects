/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;

import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.util.ByteArray;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Deprecated.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class Deprecated extends Attribute {

    /** The bytes. */
    private ByteArray bytes;

    /**
     * Instantiates a new deprecated.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Deprecated(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_DEPRECATED, nameIndex, length);
        bytes = new ByteArray();
        if (length > 0) {
            bytes.readFully(input, length);
        }
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
