package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DUP.
 */
@ToString(callSuper = true)
public class DUP extends Instruction {
    /**
     * Instantiates a new dup.
     */
    public DUP() {
        super(InstructionOpCodes.DUP, 1);
    }
}
