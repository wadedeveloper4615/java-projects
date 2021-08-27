package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class ISHR.
 */
@ToString(callSuper = true)
public class ISHR extends Instruction {
    /**
     * Instantiates a new ishr.
     */
    public ISHR() {
        super(InstructionOpCodes.ISHR, 1);
    }
}