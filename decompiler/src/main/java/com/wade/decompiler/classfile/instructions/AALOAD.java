package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class AALOAD.
 */
@ToString(callSuper = true)
public class AALOAD extends Instruction {
    /**
     * Instantiates a new aaload.
     */
    public AALOAD() {
        super(InstructionOpCodes.AALOAD, 1);
    }
}
