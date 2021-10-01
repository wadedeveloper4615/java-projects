/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InnerClass.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InnerClass {

    /** The inner class index. */
    private Integer innerClassIndex;

    /** The outer class index. */
    private Integer outerClassIndex;

    /** The inner name index. */
    private Integer innerNameIndex;

    /** The inner access flags. */
    private ClassAccessFlagsList innerAccessFlags;

    /**
     * Instantiates a new inner class.
     *
     * @param file         the file
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InnerClass(DataInput file, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
        this(file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), constantPool, isInnerClass);
    }

    /**
     * Instantiates a new inner class.
     *
     * @param innerClassIndex  the inner class index
     * @param outerClassIndex  the outer class index
     * @param innerNameIndex   the inner name index
     * @param innerAccessFlags the inner access flags
     */
    public InnerClass(int innerClassIndex, int outerClassIndex, int innerNameIndex, ClassAccessFlagsList innerAccessFlags) {
        this.innerClassIndex = innerClassIndex;
        this.outerClassIndex = outerClassIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerAccessFlags = innerAccessFlags;
    }

    /**
     * Instantiates a new inner class.
     *
     * @param innerClassIndex  the inner class index
     * @param outerClassIndex  the outer class index
     * @param innerNameIndex   the inner name index
     * @param innerAccessFlags the inner access flags
     * @param constantPool     the constant pool
     * @param isInnerClass     the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public InnerClass(int innerClassIndex, int outerClassIndex, int innerNameIndex, int innerAccessFlags, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
        this.innerClassIndex = innerClassIndex;
        this.outerClassIndex = outerClassIndex;
        this.innerNameIndex = innerNameIndex;
        this.innerAccessFlags = new ClassAccessFlagsList(innerAccessFlags);
    }
}
