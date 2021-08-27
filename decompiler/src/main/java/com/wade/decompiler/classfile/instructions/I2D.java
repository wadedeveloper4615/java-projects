package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2D.
 */
@ToString(callSuper = true)
public class I2D extends Instruction {
    /**
     * Instantiates a new i2d.
     */
    public I2D() {
        super(InstructionOpCodes.I2D, 1);
    }
}
