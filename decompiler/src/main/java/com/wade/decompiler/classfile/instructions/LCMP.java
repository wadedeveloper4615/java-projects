package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LCMP.
 */
@ToString(callSuper = true)
public class LCMP extends Instruction {
    /**
     * Instantiates a new lcmp.
     */
    public LCMP() {
        super(InstructionOpCodes.LCMP, 1);
    }
}
