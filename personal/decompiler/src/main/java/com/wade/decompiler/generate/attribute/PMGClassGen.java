package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.PMGClass;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class PMGClassGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class PMGClassGen extends AttributeGen {
    /** The pmg. */
    private String pmg;
    /** The pmg class. */
    private String pmgClass;

    /**
     * Instantiates a new PMG class gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public PMGClassGen(PMGClass attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.pmg = ((ConstantUtf8) constantPool.getConstant(attribute.getPmgIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        this.pmgClass = ((ConstantUtf8) constantPool.getConstant(attribute.getPmgClassIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
