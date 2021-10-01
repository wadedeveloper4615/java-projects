package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LSUB.
 */
@ToString(callSuper = true)
public class LSUB extends Instruction {
    /**
     * Instantiates a new lsub.
     */
    public LSUB() {
        super(InstructionOpCodes.LSUB, 1);
    }
}