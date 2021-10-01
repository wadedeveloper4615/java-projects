package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.StackMapType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class StackMapTypeGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class StackMapTypeGen {
    /** The type. */
    private Byte type;
    /** The name. */
    private String name;

    /**
     * Instantiates a new stack map type gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public StackMapTypeGen(StackMapType attribute, ConstantPool constantPool) {
	this.type = attribute.getType();
	if (attribute.getIndex() > 0) {
	    this.name = constantPool.constantToString(attribute.getIndex(), ClassFileConstants.CONSTANT_Class);
	} else {
	    this.name = "unknown(-1)";
	}
    }
}
