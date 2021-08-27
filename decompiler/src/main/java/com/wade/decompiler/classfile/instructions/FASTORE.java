package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FASTORE.
 */
@ToString(callSuper = true)
public class FASTORE extends Instruction {
    /**
     * Instantiates a new fastore.
     */
    public FASTORE() {
        super(InstructionOpCodes.FASTORE, 1);
    }
}
