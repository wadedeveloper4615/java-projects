package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.NestHost;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class NestHostGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class NestHostGen extends AttributeGen {
    /** The host class name. */
    private String hostClassName;

    /**
     * Instantiates a new nest host gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public NestHostGen(NestHost attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.hostClassName = constantPool.constantToString(attribute.getHostClassIndex(), ClassFileConstants.CONSTANT_Class);
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
