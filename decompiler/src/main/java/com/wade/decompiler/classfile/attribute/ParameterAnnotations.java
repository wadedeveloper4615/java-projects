/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ParameterAnnotations.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public abstract class ParameterAnnotations extends Attribute {

    /** The parameter annotation table. */
    private List<ParameterAnnotationEntry> parameterAnnotationTable;

    /**
     * Instantiates a new parameter annotations.
     *
     * @param parameterAnnotationType the parameter annotation type
     * @param nameIndex               the name index
     * @param length                  the length
     * @param input                   the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ParameterAnnotations(ClassFileAttributes parameterAnnotationType, int nameIndex, int length, DataInput input) throws IOException {
        super(parameterAnnotationType, nameIndex, length);
        int num_parameters = input.readUnsignedByte();
        parameterAnnotationTable = new ArrayList<>();
        for (int i = 0; i < num_parameters; i++) {
            parameterAnnotationTable.add(new ParameterAnnotationEntry(input));
        }
    }
}
