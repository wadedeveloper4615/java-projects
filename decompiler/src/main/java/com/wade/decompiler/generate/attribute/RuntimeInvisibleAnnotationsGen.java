package com.wade.decompiler.generate.attribute;

import com.wade.decompiler.classfile.attribute.RuntimeInvisibleAnnotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class RuntimeInvisibleAnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class RuntimeInvisibleAnnotationsGen extends AnnotationsGen {
    /**
     * Instantiates a new runtime invisible annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public RuntimeInvisibleAnnotationsGen(RuntimeInvisibleAnnotations attribute, ConstantPool constantPool) {
	super(attribute, constantPool);
    }
}
