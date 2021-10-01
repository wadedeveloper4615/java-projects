package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class F2L.
 */
@ToString(callSuper = true)
public class F2L extends Instruction {
    /**
     * Instantiates a new f2l.
     */
    public F2L() {
        super(InstructionOpCodes.F2L, 1);
    }
}
