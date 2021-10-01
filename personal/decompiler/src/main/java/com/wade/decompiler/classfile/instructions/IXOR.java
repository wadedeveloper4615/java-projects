package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IXOR.
 */
@ToString(callSuper = true)
public class IXOR extends Instruction {
    /**
     * Instantiates a new ixor.
     */
    public IXOR() {
        super(InstructionOpCodes.IXOR, 1);
    }
}
