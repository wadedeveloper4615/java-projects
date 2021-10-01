package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FALOAD.
 */
@ToString(callSuper = true)
public class FALOAD extends Instruction {
    /**
     * Instantiates a new faload.
     */
    public FALOAD() {
        super(InstructionOpCodes.FALOAD, 1);
    }
}
