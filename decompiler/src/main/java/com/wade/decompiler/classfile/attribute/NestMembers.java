/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class NestMembers.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class NestMembers extends Attribute {

    /** The classes. */
    private final List<Integer> classes;

    /**
     * Instantiates a new nest members.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public NestMembers(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_NEST_MEMBERS, nameIndex, length);
        int number_of_classes = input.readUnsignedShort();
        this.classes = new ArrayList<>();
        for (int i = 0; i < number_of_classes; i++) {
            classes.add(input.readUnsignedShort());
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
