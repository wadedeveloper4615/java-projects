package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class FREM.
 */
@ToString(callSuper = true)
public class FREM extends Instruction {
    /**
     * Instantiates a new frem.
     */
    public FREM() {
        super(InstructionOpCodes.FREM, 1);
    }
}
