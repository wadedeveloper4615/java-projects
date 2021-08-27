package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.ClassElementValue;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ClassElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ClassElementValueGen extends ElementValueGen {
    /** The index. */
    private String index;

    /**
     * Instantiates a new class element value gen.
     *
     * @param type         the type
     * @param value        the value
     * @param constantPool the constant pool
     */
    public ClassElementValueGen(byte type, ClassElementValue value, ConstantPool constantPool) {
	super(type);
	this.index = ((ConstantUtf8) constantPool.getConstant(value.getIdx(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }
}
