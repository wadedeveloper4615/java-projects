/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LineNumber.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class LineNumber {

    /** The start pc. */
    private Short startPc;

    /** The line number. */
    private Short lineNumber;

    /**
     * Instantiates a new line number.
     *
     * @param file the file
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public LineNumber(DataInput file) throws IOException {
        this.startPc = (short) file.readUnsignedShort();
        this.lineNumber = (short) file.readUnsignedShort();
    }
}
