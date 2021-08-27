package com.wade.decompiler.classfile.element;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class EnumElementValue.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class EnumElementValue extends ElementValue {
    /** The type idx. */
    private Integer typeIdx;
    /** The value idx. */
    private Integer valueIdx;

    /**
     * Instantiates a new enum element value.
     *
     * @param type     the type
     * @param typeIdx  the type idx
     * @param valueIdx the value idx
     */
    public EnumElementValue(int type, int typeIdx, int valueIdx) {
	super(type);
	if (type != ENUM_CONSTANT) {
	    throw new IllegalArgumentException("Only element values of type enum can be built with this ctor - type specified: " + type);
	}
	this.typeIdx = typeIdx;
	this.valueIdx = valueIdx;
    }
//
//    public String getEnumTypeString(ConstantPool cpool) {
//	ConstantUtf8 cu8 = (ConstantUtf8) cpool.getConstant(typeIdx, ClassFileConstants.CONSTANT_Utf8);
//	return cu8.getBytes();// Utility.signatureToString(cu8.getBytes());
//    }
//
//    public String getEnumValueString(ConstantPool cpool) {
//	ConstantUtf8 cu8 = (ConstantUtf8) cpool.getConstant(valueIdx, ClassFileConstants.CONSTANT_Utf8);
//	return cu8.getBytes();
//    }
//
//    public String stringifyValue(ConstantPool cpool) {
//	ConstantUtf8 cu8 = (ConstantUtf8) cpool.getConstant(valueIdx, ClassFileConstants.CONSTANT_Utf8);
//	return cu8.getBytes();
//    }
}
