package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ACONST_NULL.
 */
@ToString(callSuper = true)
public class ACONST_NULL extends Instruction {
    /**
     * Instantiates a new aconst null.
     */
    public ACONST_NULL() {
        super(InstructionOpCodes.ACONST_NULL, 1);
    }
}
