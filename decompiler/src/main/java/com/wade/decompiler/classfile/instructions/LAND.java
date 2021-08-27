package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LAND.
 */
@ToString(callSuper = true)
public class LAND extends Instruction {
    /**
     * Instantiates a new land.
     */
    public LAND() {
        super(InstructionOpCodes.LAND, 1);
    }
}