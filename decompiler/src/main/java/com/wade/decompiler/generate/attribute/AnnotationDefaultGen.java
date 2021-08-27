package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.AnnotationDefault;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AnnotationDefaultGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AnnotationDefaultGen extends AttributeGen {
    /** The default value. */
    private ElementValueGen defaultValue;

    /**
     * Instantiates a new annotation default gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public AnnotationDefaultGen(AnnotationDefault attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        defaultValue = ElementValueGen.readElementValue(attribute.getDefaultValue(), constantPool);
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\n\t" + toString());
    }
}
