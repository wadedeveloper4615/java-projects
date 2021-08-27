package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class RETURN.
 */
@ToString(callSuper = true)
public class RETURN extends Instruction {
    /**
     * Instantiates a new return.
     */
    public RETURN() {
        super(InstructionOpCodes.RETURN, 1);
    }
}
