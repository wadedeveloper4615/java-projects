package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IRETURN.
 */
@ToString(callSuper = true)
public class IRETURN extends Instruction {
    /**
     * Instantiates a new ireturn.
     */
    public IRETURN() {
        super(InstructionOpCodes.IRETURN, 1);
    }
}
