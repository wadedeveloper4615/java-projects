package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class CALOAD.
 */
@ToString(callSuper = true)
public class CALOAD extends Instruction {
    /**
     * Instantiates a new caload.
     */
    public CALOAD() {
        super(InstructionOpCodes.CALOAD, 1);
    }
}
