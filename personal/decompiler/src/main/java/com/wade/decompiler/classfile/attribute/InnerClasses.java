/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileAttributes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InnerClasses.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InnerClasses extends Attribute {

    /** The inner classes. */
    private List<InnerClass> innerClasses;

    /**
     * Instantiates a new inner classes.
     *
     * @param nameIndex    the name index
     * @param length       the length
     * @param input        the input
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InnerClasses(int nameIndex, int length, DataInput input, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
        super(ClassFileAttributes.ATTR_INNER_CLASSES, nameIndex, length);
        int number_of_classes = input.readUnsignedShort();
        innerClasses = new ArrayList<>();
        for (int i = 0; i < number_of_classes; i++) {
            innerClasses.add(new InnerClass(input, constantPool, isInnerClass));
        }
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
