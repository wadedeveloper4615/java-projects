package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IADD.
 */
@ToString(callSuper = true)
public class IADD extends Instruction {
    /**
     * Instantiates a new iadd.
     */
    public IADD() {
        super(InstructionOpCodes.IADD, 1);
    }
}
