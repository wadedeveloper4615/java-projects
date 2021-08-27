package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2B.
 */
@ToString(callSuper = true)
public class I2B extends Instruction {
    /**
     * Instantiates a new i2b.
     */
    public I2B() {
        super(InstructionOpCodes.I2B, 1);
    }
}
