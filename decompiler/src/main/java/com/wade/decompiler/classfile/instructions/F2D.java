package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class F2D.
 */
@ToString(callSuper = true)
public class F2D extends Instruction {
    /**
     * Instantiates a new f2d.
     */
    public F2D() {
        super(InstructionOpCodes.F2D, 1);
    }
}
