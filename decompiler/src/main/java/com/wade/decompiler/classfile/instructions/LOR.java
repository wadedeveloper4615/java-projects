package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LOR.
 */
@ToString(callSuper = true)
public class LOR extends Instruction {
    /**
     * Instantiates a new lor.
     */
    public LOR() {
        super(InstructionOpCodes.LOR, 1);
    }
}
