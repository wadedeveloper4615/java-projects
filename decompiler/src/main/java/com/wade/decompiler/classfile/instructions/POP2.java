package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class POP2.
 */
@ToString(callSuper = true)
public class POP2 extends Instruction {
    /**
     * Instantiates a new pop2.
     */
    public POP2() {
        super(InstructionOpCodes.POP2, 1);
    }
}
