package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IOR.
 */
@ToString(callSuper = true)
public class IOR extends Instruction {
    /**
     * Instantiates a new ior.
     */
    public IOR() {
        super(InstructionOpCodes.IOR, 1);
    }
}
