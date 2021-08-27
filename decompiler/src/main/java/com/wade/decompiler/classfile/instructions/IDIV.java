package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IDIV.
 */
@ToString(callSuper = true)
public class IDIV extends Instruction {
    /**
     * Instantiates a new idiv.
     */
    public IDIV() {
        super(InstructionOpCodes.IDIV, 1);
    }
}
