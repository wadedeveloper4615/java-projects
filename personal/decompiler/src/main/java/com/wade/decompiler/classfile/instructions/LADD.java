package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LADD.
 */
@ToString(callSuper = true)
public class LADD extends Instruction {
    /**
     * Instantiates a new ladd.
     */
    public LADD() {
        super(InstructionOpCodes.LADD, 1);
    }
}
