package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LSHL.
 */
@ToString(callSuper = true)
public class LSHL extends Instruction {
    /**
     * Instantiates a new lshl.
     */
    public LSHL() {
        super(InstructionOpCodes.LSHL, 1);
    }
}
