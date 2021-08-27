package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LRETURN.
 */
@ToString(callSuper = true)
public class LRETURN extends Instruction {
    /**
     * Instantiates a new lreturn.
     */
    public LRETURN() {
        super(InstructionOpCodes.LRETURN, 1);
    }
}