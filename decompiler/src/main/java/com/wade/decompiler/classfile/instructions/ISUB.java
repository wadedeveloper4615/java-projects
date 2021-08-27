package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ISUB.
 */
@ToString(callSuper = true)
public class ISUB extends Instruction {
    /**
     * Instantiates a new isub.
     */
    public ISUB() {
        super(InstructionOpCodes.ISUB, 1);
    }
}
