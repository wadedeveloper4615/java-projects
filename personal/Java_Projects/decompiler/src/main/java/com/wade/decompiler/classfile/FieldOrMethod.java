package com.wade.decompiler.classfile;

import java.io.DataInput;
import java.io.IOException;

import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public abstract class FieldOrMethod {
    protected int nameIndex;
    protected int signatureIndex;
    protected int accessFlags;
    Attribute[] attributes;

    public FieldOrMethod() {
        super();
    }

    protected FieldOrMethod(DataInput file, ConstantPool constantPool) throws IOException {
        this(file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), null);
        int attributes_count = file.readUnsignedShort();
        attributes = new Attribute[attributes_count];
        for (int i = 0; i < attributes_count; i++) {
            attributes[i] = Attribute.readAttribute(file, constantPool);
        }
    }

    protected FieldOrMethod(int accessFlags, int nameIndex, int signatureIndex, Attribute[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.signatureIndex = signatureIndex;
        this.attributes = attributes;
    }
}
