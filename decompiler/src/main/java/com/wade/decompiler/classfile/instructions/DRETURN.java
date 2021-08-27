package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DRETURN.
 */
@ToString(callSuper = true)
public class DRETURN extends Instruction {
    /**
     * Instantiates a new dreturn.
     */
    public DRETURN() {
        super(InstructionOpCodes.DRETURN, 1);
    }
}
