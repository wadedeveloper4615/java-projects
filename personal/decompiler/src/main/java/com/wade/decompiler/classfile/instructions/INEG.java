package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class INEG.
 */
@ToString(callSuper = true)
public class INEG extends Instruction {
    /**
     * Instantiates a new ineg.
     */
    public INEG() {
        super(InstructionOpCodes.INEG, 1);
    }
}
