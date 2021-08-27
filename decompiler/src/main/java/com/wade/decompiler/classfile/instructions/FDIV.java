package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FDIV.
 */
@ToString(callSuper = true)
public class FDIV extends Instruction {
    /**
     * Instantiates a new fdiv.
     */
    public FDIV() {
        super(InstructionOpCodes.FDIV, 1);
    }
}
