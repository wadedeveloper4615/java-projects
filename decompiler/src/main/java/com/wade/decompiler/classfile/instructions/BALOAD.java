package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class BALOAD.
 */
@ToString(callSuper = true)
public class BALOAD extends Instruction {
    /**
     * Instantiates a new baload.
     */
    public BALOAD() {
        super(InstructionOpCodes.BALOAD, 1);
    }
}
