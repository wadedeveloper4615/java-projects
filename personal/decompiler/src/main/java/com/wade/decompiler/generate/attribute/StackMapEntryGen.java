package com.wade.decompiler.generate.attribute;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.StackMapEntry;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class StackMapEntryGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class StackMapEntryGen {
    /** The frame type. */
    private Integer frameType;
    /** The byte code offset. */
    private Integer byteCodeOffset;
    /** The types of locals. */
    private List<StackMapTypeGen> typesOfLocals;
    /** The types of stack items. */
    private List<StackMapTypeGen> typesOfStackItems;

    /**
     * Instantiates a new stack map entry gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public StackMapEntryGen(StackMapEntry attribute, ConstantPool constantPool) {
	frameType = attribute.getFrameType();
	byteCodeOffset = attribute.getByteCodeOffset();
	this.typesOfLocals = new ArrayList<>();
	if (attribute.getTypesOfLocals() != null) {
	    attribute.getTypesOfLocals().stream().forEach(entry -> this.typesOfLocals.add(new StackMapTypeGen(entry, constantPool)));
	}
	this.typesOfStackItems = new ArrayList<>();
	if (attribute.getTypesOfStackItems() != null) {
	    attribute.getTypesOfStackItems().stream().forEach(entry -> this.typesOfStackItems.add(new StackMapTypeGen(entry, constantPool)));
	}
    }
}
