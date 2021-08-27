package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.RuntimeVisibleParameterAnnotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RuntimeVisibleParameterAnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class RuntimeVisibleParameterAnnotationsGen extends ParameterAnnotationsGen {
    /**
     * Instantiates a new runtime visible parameter annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public RuntimeVisibleParameterAnnotationsGen(RuntimeVisibleParameterAnnotations attribute, ConstantPool constantPool) {
	super(attribute, constantPool);
    }
}
