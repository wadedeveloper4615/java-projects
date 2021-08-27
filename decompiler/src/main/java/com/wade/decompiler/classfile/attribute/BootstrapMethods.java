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
 * The Class BootstrapMethods.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class BootstrapMethods extends Attribute {

    /** The bootstrap methods. */
    private List<BootstrapMethod> bootstrapMethods;

    /**
     * Instantiates a new bootstrap methods.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public BootstrapMethods(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_BOOTSTRAP_METHODS, nameIndex, length);
        int num_bootstrap_methods = input.readUnsignedShort();
        this.bootstrapMethods = new ArrayList<>();
        for (int i = 0; i < num_bootstrap_methods; i++) {
            bootstrapMethods.add(new BootstrapMethod(input));
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
