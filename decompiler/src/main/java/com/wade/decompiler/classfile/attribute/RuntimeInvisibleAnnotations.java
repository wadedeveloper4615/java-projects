/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class RuntimeInvisibleAnnotations.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class RuntimeInvisibleAnnotations extends Annotations {

    /**
     * Instantiates a new runtime invisible annotations.
     *
     * @param nameIndex the name index
     * @param length    the length
     * @param input     the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public RuntimeInvisibleAnnotations(int nameIndex, int length, DataInput input) throws IOException {
        super(ClassFileAttributes.ATTR_RUNTIME_INVISIBLE_ANNOTATIONS, nameIndex, length, input, false);
    }
}
