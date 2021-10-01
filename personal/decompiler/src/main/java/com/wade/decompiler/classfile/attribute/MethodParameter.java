/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassAccessFlags;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class MethodParameter.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class MethodParameter {

    /** The name index. */
    private Integer nameIndex;

    /** The access flags. */
    private ClassAccessFlags accessFlags;

    /**
     * Instantiates a new method parameter.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public MethodParameter(DataInput input) throws IOException {
        nameIndex = input.readUnsignedShort();
        accessFlags = ClassAccessFlags.read(input.readUnsignedShort());
    }
}
