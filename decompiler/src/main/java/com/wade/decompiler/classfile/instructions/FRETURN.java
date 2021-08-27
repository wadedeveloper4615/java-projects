package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FRETURN.
 */
@ToString(callSuper = true)
public class FRETURN extends Instruction {
    /**
     * Instantiates a new freturn.
     */
    public FRETURN() {
        super(InstructionOpCodes.FRETURN, 1);
    }
}