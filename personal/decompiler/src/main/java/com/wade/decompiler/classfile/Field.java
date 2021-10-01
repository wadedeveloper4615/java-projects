package com.wade.decompiler.classfile;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * The Class Field.
 */
@Getter
@EqualsAndHashCode
public class Field {
    /** The name index. */
    protected Integer nameIndex;
    /** The signature index. */
    protected Integer signatureIndex;
    /** The access flags. */
    protected Integer accessFlags;
    /** The attributes. */
    protected List<Attribute> attributes;

    /**
     * Instantiates a new field.
     *
     * @param file         the file
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected Field(DataInput file, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
	this(file.readUnsignedShort(), file.readUnsignedShort(), file.readUnsignedShort(), null);
	int attributes_count = file.readUnsignedShort();
	attributes = new ArrayList<>();
	for (int i = 0; i < attributes_count; i++) {
	    attributes.add(Attribute.readAttribute(file, constantPool, isInnerClass));
	}
    }

    /**
     * Instantiates a new field.
     *
     * @param accessFlags    the access flags
     * @param nameIndex      the name index
     * @param signatureIndex the signature index
     * @param attributes     the attributes
     */
    protected Field(int accessFlags, int nameIndex, int signatureIndex, List<Attribute> attributes) {
	this.accessFlags = accessFlags;
	this.nameIndex = nameIndex;
	this.signatureIndex = signatureIndex;
	this.attributes = attributes;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Field [nameIndex=").append(nameIndex).append(", signatureIndex=").append(signatureIndex).append(", accessFlags=").append(accessFlags).append(", attributes=").append(attributes).append("]");
	return builder.toString();
    }
}
