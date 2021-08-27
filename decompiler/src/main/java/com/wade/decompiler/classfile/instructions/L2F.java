package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class L2F.
 */
@ToString(callSuper = true)
public class L2F extends Instruction {
    /**
     * Instantiates a new l2f.
     */
    public L2F() {
        super(InstructionOpCodes.L2F, 1);
    }
}
