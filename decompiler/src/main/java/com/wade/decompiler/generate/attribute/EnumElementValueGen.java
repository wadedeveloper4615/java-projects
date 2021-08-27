package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.EnumElementValue;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class EnumElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class EnumElementValueGen extends ElementValueGen {
    /** The value name. */
    private String valueName;
    /** The type name. */
    private String typeName;

    /**
     * Instantiates a new enum element value gen.
     *
     * @param type         the type
     * @param element      the element
     * @param constantPool the constant pool
     */
    public EnumElementValueGen(int type, EnumElementValue element, ConstantPool constantPool) {
	super(type);
	this.typeName = ((ConstantUtf8) constantPool.getConstant(element.getTypeIdx(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
	this.valueName = ((ConstantUtf8) constantPool.getConstant(element.getValueIdx(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }
}
