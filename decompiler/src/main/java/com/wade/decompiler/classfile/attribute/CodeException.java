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
 * The Class CodeException.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class CodeException {

    /** The from. */
    private Integer from;

    /** The to. */
    private Integer to;

    /** The target. */
    private Integer target;

    /** The type. */
    private Integer type;

    /**
     * Instantiates a new code exception.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public CodeException(DataInput file) throws IOException {
        this(file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort());
    }

    /**
     * Instantiates a new code exception.
     *
     * @param startPc   the start pc
     * @param endPc     the end pc
     * @param handlerPc the handler pc
     * @param catchType the catch type
     */
    public CodeException(int startPc, int endPc, int handlerPc, int catchType) {
        this.from = startPc;
        this.to = endPc;
        this.target = handlerPc;
        this.type = catchType;
    }
}
