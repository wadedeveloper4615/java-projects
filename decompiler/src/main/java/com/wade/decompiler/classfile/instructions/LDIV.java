package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class LDIV.
 */
@ToString(callSuper = true)
public class LDIV extends Instruction {
    /**
     * Instantiates a new ldiv.
     */
    public LDIV() {
        super(InstructionOpCodes.LDIV, 1);
    }
}
