package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FMUL.
 */
@ToString(callSuper = true)
public class FMUL extends Instruction {
    /**
     * Instantiates a new fmul.
     */
    public FMUL() {
        super(InstructionOpCodes.FMUL, 1);
    }
}
