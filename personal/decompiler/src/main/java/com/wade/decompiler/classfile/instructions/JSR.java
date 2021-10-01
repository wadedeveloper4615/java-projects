package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class JSR.
 */
@ToString(callSuper = true)
public class JSR extends Instruction {
    /**
     * Instantiates a new jsr.
     */
    public JSR() {
        super(InstructionOpCodes.JSR, 3);
    }
}
