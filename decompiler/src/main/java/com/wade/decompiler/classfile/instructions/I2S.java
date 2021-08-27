package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2S.
 */
@ToString(callSuper = true)
public class I2S extends Instruction {
    /**
     * Instantiates a new i2s.
     */
    public I2S() {
        super(InstructionOpCodes.I2S, 1);
    }
}