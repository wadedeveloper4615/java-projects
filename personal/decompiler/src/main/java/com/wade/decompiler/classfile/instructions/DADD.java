package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DADD.
 */
@ToString(callSuper = true)
public class DADD extends Instruction {
    /**
     * Instantiates a new dadd.
     */
    public DADD() {
        super(InstructionOpCodes.DADD, 1);
    }
}
