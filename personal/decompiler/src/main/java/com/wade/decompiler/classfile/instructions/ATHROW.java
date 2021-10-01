package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ATHROW.
 */
@ToString(callSuper = true)
public class ATHROW extends Instruction {
    /**
     * Instantiates a new athrow.
     */
    public ATHROW() {
        super(InstructionOpCodes.ATHROW, 1);
    }
}
