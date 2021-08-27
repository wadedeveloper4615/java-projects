package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.Unknown;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class UnknownGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class UnknownGen extends AttributeGen {
    /**
     * Instantiates a new unknown gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public UnknownGen(Unknown attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
