package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.element.ElementValuePair;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ElementValuePairGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ElementValuePairGen {
    /** The element value. */
    private ElementValueGen elementValue;
    /** The element name. */
    private String elementName;

    /**
     * Instantiates a new element value pair gen.
     *
     * @param elementValuePairs the element value pairs
     * @param elementValue      the element value
     * @param constantPool      the constant pool
     */
    public ElementValuePairGen(ElementValuePair elementValuePairs, ElementValueGen elementValue, ConstantPool constantPool) {
	this.elementValue = elementValue;
	this.elementName = ((ConstantUtf8) constantPool.getConstant(elementValuePairs.getElementNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }
}
