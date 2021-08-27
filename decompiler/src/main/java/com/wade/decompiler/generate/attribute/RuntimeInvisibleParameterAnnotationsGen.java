package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.RuntimeInvisibleParameterAnnotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RuntimeInvisibleParameterAnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class RuntimeInvisibleParameterAnnotationsGen extends ParameterAnnotationsGen {
    /**
     * Instantiates a new runtime invisible parameter annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public RuntimeInvisibleParameterAnnotationsGen(RuntimeInvisibleParameterAnnotations attribute, ConstantPool constantPool) {
	super(attribute, constantPool);
    }
}
