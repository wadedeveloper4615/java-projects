package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LNEG.
 */
@ToString(callSuper = true)
public class LNEG extends Instruction {
    /**
     * Instantiates a new lneg.
     */
    public LNEG() {
        super(InstructionOpCodes.LNEG, 1);
    }
}
