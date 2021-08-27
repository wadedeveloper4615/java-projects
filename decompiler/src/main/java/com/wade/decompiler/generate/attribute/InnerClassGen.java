package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.InnerClass;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InnerClassGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InnerClassGen {
    /** The inner class. */
    private String innerClass;
    /** The outer class. */
    private String outerClass;
    /** The inner name. */
    private String innerName;
    /** The access flags. */
    private ClassAccessFlagsList accessFlags;

    /**
     * Instantiates a new inner class gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public InnerClassGen(InnerClass attribute, ConstantPool constantPool) {
	this.innerClass = constantPool.constantToString(attribute.getInnerClassIndex(), ClassFileConstants.CONSTANT_Class);
	this.outerClass = constantPool.constantToString(attribute.getOuterClassIndex(), ClassFileConstants.CONSTANT_Class);
	this.innerName = constantPool.constantToString(attribute.getInnerNameIndex(), ClassFileConstants.CONSTANT_Utf8);
	this.accessFlags = attribute.getInnerAccessFlags();
    }
}
