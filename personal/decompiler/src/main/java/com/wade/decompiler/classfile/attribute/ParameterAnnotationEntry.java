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
 * The Class ParameterAnnotationEntry.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ParameterAnnotationEntry {

    /** The annotation table. */
    private List<AnnotationEntry> annotationTable;

    /**
     * Instantiates a new parameter annotation entry.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public ParameterAnnotationEntry(DataInput input) throws IOException {
        int annotation_table_length = input.readUnsignedShort();
        annotationTable = new ArrayList<>();
        for (int i = 0; i < annotation_table_length; i++) {
            annotationTable.add(AnnotationEntry.read(input, false));
        }
    }
}
