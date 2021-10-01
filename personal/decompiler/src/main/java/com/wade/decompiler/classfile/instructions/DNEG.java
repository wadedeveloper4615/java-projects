package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DNEG.
 */
@ToString(callSuper = true)
public class DNEG extends Instruction {
    /**
     * Instantiates a new dneg.
     */
    public DNEG() {
        super(InstructionOpCodes.DNEG, 1);
    }
}
