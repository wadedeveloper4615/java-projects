/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LocalVariable.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class LocalVariable {

    /** The start. */
    private Integer start;

    /** The length. */
    private Integer length;

    /** The slot. */
    private Integer slot;

    /** The name index. */
    private Integer nameIndex;

    /** The signature index. */
    private Integer signatureIndex;

    /**
     * Instantiates a new local variable.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public LocalVariable(DataInput file) throws IOException {
        this(file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort());
    }

    /**
     * Instantiates a new local variable.
     *
     * @param start          the start
     * @param length         the length
     * @param nameIndex      the name index
     * @param signatureIndex the signature index
     * @param slot           the slot
     */
    public LocalVariable(int start, int length, int nameIndex, int signatureIndex, int slot) {
        this.start = start;
        this.length = length;
        this.slot = slot;
        this.nameIndex = nameIndex;
        this.signatureIndex = signatureIndex;
    }
}
