package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LASTORE.
 */
@ToString(callSuper = true)
public class LASTORE extends Instruction {
    /**
     * Instantiates a new lastore.
     */
    public LASTORE() {
        super(InstructionOpCodes.LASTORE, 1);
    }
}
