package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LXOR.
 */
@ToString(callSuper = true)
public class LXOR extends Instruction {
    /**
     * Instantiates a new lxor.
     */
    public LXOR() {
        super(InstructionOpCodes.LXOR, 1);
    }
}