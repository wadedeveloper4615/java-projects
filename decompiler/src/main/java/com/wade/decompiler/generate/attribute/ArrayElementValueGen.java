package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.element.ArrayElementValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ArrayElementValueGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ArrayElementValueGen extends ElementValueGen {
    /** The value. */
    private List<ElementValueGen> value;

    /**
     * Instantiates a new array element value gen.
     *
     * @param type         the type
     * @param element      the element
     * @param constantPool the constant pool
     */
    public ArrayElementValueGen(byte type, ArrayElementValue element, ConstantPool constantPool) {
	super(type);
	value = new ArrayList<>();
	element.getElementValues().stream().forEach(entry -> value.add(ElementValueGen.readElementValue(entry, constantPool)));
    }
}
