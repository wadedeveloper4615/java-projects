/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.constants.Const;
import com.wade.decompiler.exceptions.ClassFormatException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class StackMapEntry.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class StackMapEntry {

    /** The frame type. */
    private Integer frameType;

    /** The byte code offset. */
    private Integer byteCodeOffset;

    /** The types of locals. */
    private List<StackMapType> typesOfLocals;

    /** The types of stack items. */
    private List<StackMapType> typesOfStackItems;

    /**
     * Instantiates a new stack map entry.
     *
     * @param input the input
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public StackMapEntry(DataInput input) throws IOException {
        this.frameType = input.readByte() & 0xFF;
        this.byteCodeOffset = -1;
        this.typesOfLocals = null;
        this.typesOfStackItems = null;
        if (frameType >= Const.SAME_FRAME && frameType <= Const.SAME_FRAME_MAX) {
            byteCodeOffset = frameType - Const.SAME_FRAME;
        } else if (frameType >= Const.SAME_LOCALS_1_STACK_ITEM_FRAME && frameType <= Const.SAME_LOCALS_1_STACK_ITEM_FRAME_MAX) {
            byteCodeOffset = frameType - Const.SAME_LOCALS_1_STACK_ITEM_FRAME;
            typesOfStackItems = new ArrayList<>();
            typesOfStackItems.add(new StackMapType(input));
        } else if (frameType == Const.SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED) {
            byteCodeOffset = Integer.valueOf(input.readShort());
            typesOfStackItems = new ArrayList<>();
            typesOfStackItems.add(new StackMapType(input));
        } else if (frameType >= Const.CHOP_FRAME && frameType <= Const.CHOP_FRAME_MAX) {
            byteCodeOffset = Integer.valueOf(input.readShort());
        } else if (frameType == Const.SAME_FRAME_EXTENDED) {
            byteCodeOffset = Integer.valueOf(input.readShort());
        } else if (frameType >= Const.APPEND_FRAME && frameType <= Const.APPEND_FRAME_MAX) {
            byteCodeOffset = Integer.valueOf(input.readShort());
            int number_of_locals = frameType - 251;
            typesOfLocals = new ArrayList<>();
            for (int i = 0; i < number_of_locals; i++) {
                typesOfLocals.add(new StackMapType(input));
            }
        } else if (frameType == Const.FULL_FRAME) {
            byteCodeOffset = Integer.valueOf(input.readShort());
            int number_of_locals = input.readShort();
            typesOfLocals = new ArrayList<>();
            for (int i = 0; i < number_of_locals; i++) {
                typesOfLocals.add(new StackMapType(input));
            }
            int number_of_stack_items = input.readShort();
            typesOfStackItems = new ArrayList<>();
            for (int i = 0; i < number_of_stack_items; i++) {
                typesOfStackItems.add(new StackMapType(input));
            }
        } else {
            throw new ClassFormatException("Invalid frame type found while parsing stack map table: " + frameType);
        }
    }

    /**
     * Instantiates a new stack map entry.
     *
     * @param tag               the tag
     * @param byteCodeOffset    the byte code offset
     * @param typesOfLocals     the types of locals
     * @param typesOfStackItems the types of stack items
     */
    public StackMapEntry(int tag, int byteCodeOffset, List<StackMapType> typesOfLocals, List<StackMapType> typesOfStackItems) {
        this.frameType = tag;
        this.byteCodeOffset = byteCodeOffset;
        this.typesOfLocals = typesOfLocals;
        this.typesOfStackItems = typesOfStackItems;
    }
}
