package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ARRAYLENGTH.
 */
@ToString(callSuper = true)
public class ARRAYLENGTH extends Instruction {
    /**
     * Instantiates a new arraylength.
     */
    public ARRAYLENGTH() {
        super(InstructionOpCodes.ARRAYLENGTH, 1);
    }
}
