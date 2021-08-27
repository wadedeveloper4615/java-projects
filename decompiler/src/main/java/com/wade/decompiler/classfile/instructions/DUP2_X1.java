package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DUP2_X1.
 */
@ToString(callSuper = true)
public class DUP2_X1 extends Instruction {
    /**
     * Instantiates a new dup2 x1.
     */
    public DUP2_X1() {
        super(InstructionOpCodes.DUP2_X1, 1);
    }
}
