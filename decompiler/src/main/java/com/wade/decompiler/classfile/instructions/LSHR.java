package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LSHR.
 */
@ToString(callSuper = true)
public class LSHR extends Instruction {
    /**
     * Instantiates a new lshr.
     */
    public LSHR() {
        super(InstructionOpCodes.LSHR, 1);
    }
}
