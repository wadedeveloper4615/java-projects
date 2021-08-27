/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.classfile.element.ElementValuePair;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class AnnotationEntry.
 */
@Getter
@EqualsAndHashCode
@ToString
public class AnnotationEntry {

    /**
     * Read.
     *
     * @param input            the input
     * @param isRuntimeVisible the is runtime visible
     * @return the annotation entry
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static AnnotationEntry read(DataInput input, boolean isRuntimeVisible) throws IOException {
        int index = input.readUnsignedShort();
        AnnotationEntry annotationEntry = new AnnotationEntry(index, isRuntimeVisible);
        int num_element_value_pairs = input.readUnsignedShort();
        annotationEntry.elementValuePairs = new ArrayList<>();
        for (int i = 0; i < num_element_value_pairs; i++) {
            index = input.readUnsignedShort();
            ElementValue element = ElementValue.readElementValue(input);
            annotationEntry.elementValuePairs.add(new ElementValuePair(index, element));
        }
        return annotationEntry;
    }

    /** The type index. */
    private Integer typeIndex;

    /** The is runtime visible. */
    private Boolean isRuntimeVisible;

    /** The element value pairs. */
    private List<ElementValuePair> elementValuePairs;

    /**
     * Instantiates a new annotation entry.
     */
    public AnnotationEntry() {
    }

    /**
     * Instantiates a new annotation entry.
     *
     * @param type_index       the type index
     * @param isRuntimeVisible the is runtime visible
     */
    public AnnotationEntry(int type_index, boolean isRuntimeVisible) {
        this.typeIndex = type_index;
        this.isRuntimeVisible = isRuntimeVisible;
        this.elementValuePairs = new ArrayList<>();
    }
}
