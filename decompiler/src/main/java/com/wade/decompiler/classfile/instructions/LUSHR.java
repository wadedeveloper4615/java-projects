package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LUSHR.
 */
@ToString(callSuper = true)
public class LUSHR extends Instruction {
    /**
     * Instantiates a new lushr.
     */
    public LUSHR() {
        super(InstructionOpCodes.LUSHR, 1);
    }
}
