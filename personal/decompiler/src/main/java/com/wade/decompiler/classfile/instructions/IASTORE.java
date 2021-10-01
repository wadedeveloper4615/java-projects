package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IASTORE.
 */
@ToString(callSuper = true)
public class IASTORE extends Instruction {
    /**
     * Instantiates a new iastore.
     */
    public IASTORE() {
        super(InstructionOpCodes.IASTORE, 1);
    }
}
