package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DDIV.
 */
@ToString(callSuper = true)
public class DDIV extends Instruction {
    /**
     * Instantiates a new ddiv.
     */
    public DDIV() {
        super(InstructionOpCodes.DDIV, 1);
    }
}
