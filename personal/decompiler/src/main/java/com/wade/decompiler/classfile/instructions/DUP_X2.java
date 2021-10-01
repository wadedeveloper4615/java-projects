package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DUP_X2.
 */
@ToString(callSuper = true)
public class DUP_X2 extends Instruction {
    /**
     * Instantiates a new dup x2.
     */
    public DUP_X2() {
        super(InstructionOpCodes.DUP_X2, 1);
    }
}
