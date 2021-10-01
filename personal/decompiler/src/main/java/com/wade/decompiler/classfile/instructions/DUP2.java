package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DUP2.
 */
@ToString(callSuper = true)
public class DUP2 extends Instruction {
    /**
     * Instantiates a new dup2.
     */
    public DUP2() {
        super(InstructionOpCodes.DUP2, 1);
    }
}
