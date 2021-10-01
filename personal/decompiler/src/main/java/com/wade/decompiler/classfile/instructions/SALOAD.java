package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class SALOAD.
 */
@ToString(callSuper = true)
public class SALOAD extends Instruction {
    /**
     * Instantiates a new saload.
     */
    public SALOAD() {
        super(InstructionOpCodes.SALOAD, 1);
    }
}
