package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DUP_X1.
 */
@ToString(callSuper = true)
public class DUP_X1 extends Instruction {
    /**
     * Instantiates a new dup x1.
     */
    public DUP_X1() {
        super(InstructionOpCodes.DUP_X1, 1);
    }
}
