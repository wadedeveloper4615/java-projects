package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class MONITOREXIT.
 */
@ToString(callSuper = true)
public class MONITOREXIT extends Instruction {
    /**
     * Instantiates a new monitorexit.
     */
    public MONITOREXIT() {
        super(InstructionOpCodes.MONITOREXIT, 1);
    }
}
