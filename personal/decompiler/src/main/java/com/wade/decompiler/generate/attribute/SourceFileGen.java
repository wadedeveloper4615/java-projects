package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.SourceFile;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class SourceFileGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class SourceFileGen extends AttributeGen {
    /** The source file. */
    private String sourceFile;

    /**
     * Instantiates a new source file gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public SourceFileGen(SourceFile attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.sourceFile = ((ConstantUtf8) constantPool.getConstant(attribute.getSourceFileIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
