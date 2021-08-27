/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;

import com.wade.decompiler.classfile.element.ElementValue;
import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationDefault.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationDefault extends Attribute {

    /** The default value. */
    private ElementValue defaultValue;

    /**
     * Instantiates a new annotation default.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public AnnotationDefault(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_ANNOTATION_DEFAULT, nameIndex, length);
        this.defaultValue = ElementValue.readElementValue(input);
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
