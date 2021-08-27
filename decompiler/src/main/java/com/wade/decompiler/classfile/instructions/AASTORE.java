package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class AASTORE.
 */
@ToString(callSuper = true)
public class AASTORE extends Instruction {
    /**
     * Instantiates a new aastore.
     */
    public AASTORE() {
        super(InstructionOpCodes.AASTORE, 1);
    }
}
