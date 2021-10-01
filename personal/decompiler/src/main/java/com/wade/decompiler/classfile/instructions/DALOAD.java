package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class DALOAD.
 */
@ToString(callSuper = true)
public class DALOAD extends Instruction {
    /**
     * Instantiates a new daload.
     */
    public DALOAD() {
        super(InstructionOpCodes.DALOAD, 1);
    }
}
