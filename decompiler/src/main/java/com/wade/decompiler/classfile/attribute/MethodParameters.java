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
 * The Class MethodParameters.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class MethodParameters extends Attribute {

    /** The parameters. */
    private List<MethodParameter> parameters;

    /**
     * Instantiates a new method parameters.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public MethodParameters(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_METHOD_PARAMETERS, nameIndex, length);
        int parameters_count = input.readUnsignedByte();
        parameters = new ArrayList<>();
        for (int i = 0; i < parameters_count; i++) {
            parameters.add(new MethodParameter(input));
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
