/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.Field;
import com.wade.decompiler.classfile.attribute.ConstantValue;
import com.wade.decompiler.classfile.attribute.Signature;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.generate.attribute.AttributeGen;
import com.wade.decompiler.generate.attribute.ConstantValueGen;
import com.wade.decompiler.generate.attribute.SignatureGen;
import com.wade.decompiler.util.Utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class FieldGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class FieldGen {

    /** The name. */
    protected String name;

    /** The signature. */
    protected String signature;

    /** The access flags. */
    protected ClassAccessFlagsList accessFlags;

    /** The attributes. */
    protected List<AttributeGen> attributes;

    /** The type signature. */
    @ToString.Exclude
    private SignatureGen typeSignature;

    /** The constant. */
    @ToString.Exclude
    private ConstantValueGen constant;

    /**
     * Instantiates a new field gen.
     *
     * @param value        the value
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     */
    public FieldGen(Field value, ConstantPool constantPool, Boolean isInnerClass) {
        this.name = ((ConstantUtf8) constantPool.getConstant(value.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        this.signature = ((ConstantUtf8) constantPool.getConstant(value.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        this.accessFlags = new ClassAccessFlagsList(value.getAccessFlags());
        this.attributes = new ArrayList<>();
        value.getAttributes().stream().forEach(attribute -> {
            if (attribute instanceof ConstantValue) {
                constant = new ConstantValueGen((ConstantValue) attribute, constantPool);
            }
            if (attribute instanceof Signature) {
                typeSignature = new SignatureGen((Signature) attribute, constantPool);
            }
            attributes.add(AttributeGen.readAttribute(attribute, constantPool, isInnerClass));
        });
        if (typeSignature != null) {
            signature = typeSignature.getSignature();
        }
    }

    /**
     * Decompile.
     *
     * @param out the out
     */
    public void decompile(PrintStream out) {
        String access = Utility.accessToString(getAccessFlags(), true);
        String signature = Utility.typeSignatureToString(getSignature(), false);
        String fieldBase = String.format("\t%s %s %s", access, signature, getName());
        if (getConstant() != null) {
            fieldBase += " = " + getConstant().getValue() + ";";
        } else {
            fieldBase += ";";
        }
        out.println(fieldBase);
    }
}
