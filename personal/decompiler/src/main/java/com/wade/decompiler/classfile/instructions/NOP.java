package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class NOP.
 */
@ToString(callSuper = true)
public class NOP extends Instruction {
    /**
     * Instantiates a new nop.
     */
    public NOP() {
        super(InstructionOpCodes.NOP, 1);
    }
}
