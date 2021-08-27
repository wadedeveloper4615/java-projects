package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FNEG.
 */
@ToString(callSuper = true)
public class FNEG extends Instruction {
    /**
     * Instantiates a new fneg.
     */
    public FNEG() {
        super(InstructionOpCodes.FNEG, 1);
    }
}
