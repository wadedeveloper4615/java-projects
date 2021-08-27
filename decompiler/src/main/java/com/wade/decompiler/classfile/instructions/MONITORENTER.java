package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class MONITORENTER.
 */
@ToString(callSuper = true)
public class MONITORENTER extends Instruction {
    /**
     * Instantiates a new monitorenter.
     */
    public MONITORENTER() {
        super(InstructionOpCodes.MONITORENTER, 1);
    }
}
