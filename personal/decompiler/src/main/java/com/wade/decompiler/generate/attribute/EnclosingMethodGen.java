package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.EnclosingMethod;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class EnclosingMethodGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class EnclosingMethodGen extends AttributeGen {
    /** The super name. */
    private String superName;
    /** The method name. */
    private String methodName;
    /** The signature. */
    private String signature;

    /**
     * Instantiates a new enclosing method gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public EnclosingMethodGen(EnclosingMethod attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        int classIndex = attribute.getClassIndex();
        int methodIndex = attribute.getMethodIndex();
        ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
        ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(methodIndex, ClassFileConstants.CONSTANT_NameAndType);
        superName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        methodName = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\n\t" + toString());
    }
}
