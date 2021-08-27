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
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Annotations.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class Annotations extends Attribute {

    /** The annotation table. */
    private List<AnnotationEntry> annotationTable;

    /** The is runtime visible. */
    private Boolean isRuntimeVisible;

    /**
     * Instantiates a new annotations.
     *
     * @param annotationType   the annotation type
     * @param nameIndex        the name index
     * @param length           the length
     * @param input            the input
     * @param isRuntimeVisible the is runtime visible
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Annotations(ClassFileAttributes annotationType, int nameIndex, int length, DataInput input, boolean isRuntimeVisible) throws IOException {
        super(annotationType, nameIndex, length);
        this.isRuntimeVisible = isRuntimeVisible;
        int annotation_table_length = input.readUnsignedShort();
        this.annotationTable = new ArrayList<>();
        for (int i = 0; i < annotation_table_length; i++) {
            annotationTable.add(AnnotationEntry.read(input, isRuntimeVisible));
        }
    }

    /**
     * Instantiates a new annotations.
     *
     * @param annotationType   the annotation type
     * @param nameIndex        the name index
     * @param length           the length
     * @param annotationTable  the annotation table
     * @param isRuntimeVisible the is runtime visible
     */
    public Annotations(ClassFileAttributes annotationType, int nameIndex, int length, List<AnnotationEntry> annotationTable, boolean isRuntimeVisible) {
        super(annotationType, nameIndex, length);
        this.annotationTable = annotationTable;
        this.isRuntimeVisible = isRuntimeVisible;
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
