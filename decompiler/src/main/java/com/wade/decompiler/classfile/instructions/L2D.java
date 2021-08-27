package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class L2D.
 */
@ToString(callSuper = true)
public class L2D extends Instruction {
    /**
     * Instantiates a new l2d.
     */
    public L2D() {
        super(InstructionOpCodes.L2D, 1);
    }
}
