package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DSUB.
 */
@ToString(callSuper = true)
public class DSUB extends Instruction {
    /**
     * Instantiates a new dsub.
     */
    public DSUB() {
        super(InstructionOpCodes.DSUB, 1);
    }
}
