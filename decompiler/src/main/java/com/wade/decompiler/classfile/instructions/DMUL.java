package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DMUL.
 */
@ToString(callSuper = true)
public class DMUL extends Instruction {
    /**
     * Instantiates a new dmul.
     */
    public DMUL() {
        super(InstructionOpCodes.DMUL, 1);
    }
}
