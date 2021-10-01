package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IAND.
 */
@ToString(callSuper = true)
public class IAND extends Instruction {
    /**
     * Instantiates a new iand.
     */
    public IAND() {
        super(InstructionOpCodes.IAND, 1);
    }
}
