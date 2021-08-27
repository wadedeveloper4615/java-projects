package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class L2I.
 */
@ToString(callSuper = true)
public class L2I extends Instruction {
    /**
     * Instantiates a new l2i.
     */
    public L2I() {
        super(InstructionOpCodes.L2I, 1);
    }
}
