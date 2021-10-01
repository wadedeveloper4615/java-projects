package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2L.
 */
@ToString(callSuper = true)
public class I2L extends Instruction {
    /**
     * Instantiates a new i2l.
     */
    public I2L() {
        super(InstructionOpCodes.I2L, 1);
    }
}
