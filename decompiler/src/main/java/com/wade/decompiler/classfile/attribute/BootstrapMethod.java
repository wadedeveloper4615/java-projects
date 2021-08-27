/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class BootstrapMethod.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class BootstrapMethod {

    /** The bootstrap method ref. */
    private final Integer bootstrapMethodRef;

    /** The bootstrap arguments. */
    private final List<Integer> bootstrapArguments;

    /**
     * Instantiates a new bootstrap method.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public BootstrapMethod(DataInput input) throws IOException {
        this.bootstrapMethodRef = input.readUnsignedShort();
        Integer num_bootstrap_arguments = input.readUnsignedShort();
        this.bootstrapArguments = new ArrayList<>();
        for (int i = 0; i < num_bootstrap_arguments; i++) {
            bootstrapArguments.add(input.readUnsignedShort());
        }
    }
}
