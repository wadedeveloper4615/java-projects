package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FSUB.
 */
@ToString(callSuper = true)
public class FSUB extends Instruction {
    /**
     * Instantiates a new fsub.
     */
    public FSUB() {
        super(InstructionOpCodes.FSUB, 1);
    }
}
