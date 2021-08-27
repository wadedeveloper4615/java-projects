package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IUSHR.
 */
@ToString(callSuper = true)
public class IUSHR extends Instruction {
    /**
     * Instantiates a new iushr.
     */
    public IUSHR() {
        super(InstructionOpCodes.IUSHR, 1);
    }
}
