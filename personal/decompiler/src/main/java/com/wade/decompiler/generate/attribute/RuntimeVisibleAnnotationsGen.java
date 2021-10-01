package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.RuntimeVisibleAnnotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RuntimeVisibleAnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class RuntimeVisibleAnnotationsGen extends AnnotationsGen {
    /**
     * Instantiates a new runtime visible annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public RuntimeVisibleAnnotationsGen(RuntimeVisibleAnnotations attribute, ConstantPool constantPool) {
	super(attribute, constantPool);
    }
}