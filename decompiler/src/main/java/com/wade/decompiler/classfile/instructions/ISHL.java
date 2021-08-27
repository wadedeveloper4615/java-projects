package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ISHL.
 */
@ToString(callSuper = true)
public class ISHL extends Instruction {
    /**
     * Instantiates a new ishl.
     */
    public ISHL() {
        super(InstructionOpCodes.ISHL, 1);
    }
}
