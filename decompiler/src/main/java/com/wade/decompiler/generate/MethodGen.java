/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.Method;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassAccessFlags;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.generate.attribute.AttributeGen;
import com.wade.decompiler.generate.attribute.CodeGen;
import com.wade.decompiler.generate.attribute.LineNumberTableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.attribute.SignatureGen;
import com.wade.decompiler.util.MethodSignature;
import com.wade.decompiler.util.Utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class MethodGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class MethodGen {

    /** The name. */
    protected String name;

    /** The signature. */
    protected String signature;

    /** The signature. */
    protected String className;

    /** The access flags. */
    protected ClassAccessFlagsList accessFlags;

    /** The attributes. */
    protected List<AttributeGen> attributes;

    /** The line number table. */
    private LineNumberTableGen lineNumberTable;

    /** The local variable table. */
    private LocalVariableTableGen localVariableTable;

    /** The signature gen. */
    private SignatureGen signatureGen;

    /** The code. */
    private CodeGen code;

    /**
     * Instantiates a new method gen.
     *
     * @param value        the value
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     */
    public MethodGen(Method value, ConstantPool constantPool, Boolean isInnerClass) {
        this.name = ((ConstantUtf8) constantPool.getConstant(value.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        this.signature = ((ConstantUtf8) constantPool.getConstant(value.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        this.accessFlags = new ClassAccessFlagsList(value.getAccessFlags());
        this.attributes = new ArrayList<>();
        value.getAttributes().stream().forEach(attribute -> {
            AttributeGen attr = AttributeGen.readAttribute(attribute, constantPool, isInnerClass);
            attributes.add(attr);
            if (attr instanceof CodeGen) {
                code = (CodeGen) attr;
                lineNumberTable = code.getLineNumberTable();
                localVariableTable = code.getLocalVariableTable();
            }
            if (attr instanceof SignatureGen) {
                signatureGen = (SignatureGen) attr;
            }
        });
    }

    /**
     * Decompile.
     *
     * @param out the out
     */
    public void decompile(PrintStream out) {
        boolean isAbstract = accessFlags.isAbstract();
        boolean isAnnotation = accessFlags.isAnnotation();
        ClassAccessFlagsList flags = getAccessFlags();
        boolean isNative = flags.isNative();
        if (isAbstract || isAnnotation) {
            flags.remove(ClassAccessFlags.ACC_ABSTRACT);
        }
        String access = Utility.accessToString(flags, true);
        String name = getName();
        boolean constructor = false;
        if (name.equals("<init>")) {
            name = Utility.extractClassName(getName(), false);
            constructor = true;
        }
        SignatureGen sg = getSignatureGen();
        String s;
        if (sg != null) {
            s = sg.getSignature();
        } else {
            s = signature;
        }
        signature = new MethodSignature(s, true).getSignature(className, constructor, access, name, getLocalVariableTable());
        if (!(isAbstract || isAnnotation || isNative)) {
            out.println("\t" + signature + "{");
            if (code != null) {
                code.decompile(out);
            }
            out.println("\t}");
        } else {
            out.println("\t" + signature);
        }
        out.println();
    }

    /**
     * Sets the class name.
     *
     * @param className the new class name
     */
    public void setClassName(String className) {
        this.className = className;
    }
}
