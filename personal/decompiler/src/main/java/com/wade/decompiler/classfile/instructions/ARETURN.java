package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ARETURN.
 */
@ToString(callSuper = true)
public class ARETURN extends Instruction {
    /**
     * Instantiates a new areturn.
     */
    public ARETURN() {
        super(InstructionOpCodes.ARETURN, 1);
    }
}
