package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class SASTORE.
 */
@ToString(callSuper = true)
public class SASTORE extends Instruction {
    /**
     * Instantiates a new sastore.
     */
    public SASTORE() {
        super(InstructionOpCodes.SASTORE, 1);
    }
}
