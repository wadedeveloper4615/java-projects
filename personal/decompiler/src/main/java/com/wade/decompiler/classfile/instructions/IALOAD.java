package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IALOAD.
 */
@ToString(callSuper = true)
public class IALOAD extends Instruction {
    /**
     * Instantiates a new iaload.
     */
    public IALOAD() {
        super(InstructionOpCodes.IALOAD, 1);
    }
}
