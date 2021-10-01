package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IMUL.
 */
@ToString(callSuper = true)
public class IMUL extends Instruction {
    /**
     * Instantiates a new imul.
     */
    public IMUL() {
        super(InstructionOpCodes.IMUL, 1);
    }
}
