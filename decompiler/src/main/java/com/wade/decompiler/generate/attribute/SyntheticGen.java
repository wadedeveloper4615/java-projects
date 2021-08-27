package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.Synthetic;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.util.ByteArray;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class SyntheticGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class SyntheticGen extends AttributeGen {
    /** The bytes. */
    private ByteArray bytes;

    /**
     * Instantiates a new synthetic gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public SyntheticGen(Synthetic attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.bytes = attribute.getBytes();
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
