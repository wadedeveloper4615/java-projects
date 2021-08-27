package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DASTORE.
 */
@ToString(callSuper = true)
public class DASTORE extends Instruction {
    /**
     * Instantiates a new dastore.
     */
    public DASTORE() {
        super(InstructionOpCodes.DASTORE, 1);
    }
}
