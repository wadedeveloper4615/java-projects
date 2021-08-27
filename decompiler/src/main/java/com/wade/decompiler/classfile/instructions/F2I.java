package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class F2I.
 */
@ToString(callSuper = true)
public class F2I extends Instruction {
    /**
     * Instantiates a new f2i.
     */
    public F2I() {
        super(InstructionOpCodes.F2I, 1);
    }
}
