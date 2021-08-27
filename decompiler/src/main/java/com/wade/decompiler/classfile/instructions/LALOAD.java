package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LALOAD.
 */
@ToString(callSuper = true)
public class LALOAD extends Instruction {
    /**
     * Instantiates a new laload.
     */
    public LALOAD() {
        super(InstructionOpCodes.LALOAD, 1);
    }
}
