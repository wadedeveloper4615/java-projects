package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FADD.
 */
@ToString(callSuper = true)
public class FADD extends Instruction {
    /**
     * Instantiates a new fadd.
     */
    public FADD() {
        super(InstructionOpCodes.FADD, 1);
    }
}
