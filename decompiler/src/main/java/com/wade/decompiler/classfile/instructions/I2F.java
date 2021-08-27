package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class I2F.
 */
@ToString(callSuper = true)
public class I2F extends Instruction {
    /**
     * Instantiates a new i2f.
     */
    public I2F() {
        super(InstructionOpCodes.I2F, 1);
    }
}
