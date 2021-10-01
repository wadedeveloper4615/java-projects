package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class BREAKPOINT.
 */
@ToString(callSuper = true)
public class BREAKPOINT extends Instruction {
    /**
     * Instantiates a new breakpoint.
     */
    public BREAKPOINT() {
        super(InstructionOpCodes.BREAKPOINT, 1);
    }
}
