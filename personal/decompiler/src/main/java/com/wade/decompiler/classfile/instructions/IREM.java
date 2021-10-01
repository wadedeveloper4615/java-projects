package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IREM.
 */
@ToString(callSuper = true)
public class IREM extends Instruction {
    /**
     * Instantiates a new irem.
     */
    public IREM() {
        super(InstructionOpCodes.IREM, 1);
    }
}
