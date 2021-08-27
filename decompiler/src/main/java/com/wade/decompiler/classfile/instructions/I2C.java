package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2C.
 */
@ToString(callSuper = true)
public class I2C extends Instruction {
    /**
     * Instantiates a new i2c.
     */
    public I2C() {
        super(InstructionOpCodes.I2C, 1);
    }
}
