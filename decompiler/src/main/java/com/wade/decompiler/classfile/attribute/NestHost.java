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
 * The Class NestHost.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class NestHost extends Attribute {

    /** The host class index. */
    private final Integer hostClassIndex;

    /**
     * Instantiates a new nest host.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public NestHost(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_NEST_HOST, nameIndex, length);
        hostClassIndex = input.readUnsignedShort();
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
