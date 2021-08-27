package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class BASTORE.
 */
@ToString(callSuper = true)
public class BASTORE extends Instruction {
    /**
     * Instantiates a new bastore.
     */
    public BASTORE() {
        super(InstructionOpCodes.BASTORE, 1);
    }
}
