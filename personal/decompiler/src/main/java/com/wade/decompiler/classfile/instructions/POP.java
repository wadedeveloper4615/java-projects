package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class POP.
 */
@ToString(callSuper = true)
public class POP extends Instruction {
    /**
     * Instantiates a new pop.
     */
    public POP() {
        super(InstructionOpCodes.POP, 1);
    }
}
