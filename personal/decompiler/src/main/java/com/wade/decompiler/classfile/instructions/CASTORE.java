package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class CASTORE.
 */
@ToString(callSuper = true)
public class CASTORE extends Instruction {
    /**
     * Instantiates a new castore.
     */
    public CASTORE() {
        super(InstructionOpCodes.CASTORE, 1);
    }
}
