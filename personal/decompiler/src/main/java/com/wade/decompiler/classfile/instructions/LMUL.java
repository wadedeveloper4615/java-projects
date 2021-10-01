package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LMUL.
 */
@ToString(callSuper = true)
public class LMUL extends Instruction {
    /**
     * Instantiates a new lmul.
     */
    public LMUL() {
        super(InstructionOpCodes.LMUL, 1);
    }
}
