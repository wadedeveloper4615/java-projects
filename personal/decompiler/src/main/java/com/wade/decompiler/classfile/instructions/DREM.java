package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DREM.
 */
@ToString(callSuper = true)
public class DREM extends Instruction {
    /**
     * Instantiates a new drem.
     */
    public DREM() {
        super(InstructionOpCodes.DREM, 1);
    }
}