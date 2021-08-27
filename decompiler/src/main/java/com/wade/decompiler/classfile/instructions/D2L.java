package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class D2L.
 */
@ToString(callSuper = true)
public class D2L extends Instruction {
    /**
     * Instantiates a new d2l.
     */
    public D2L() {
        super(InstructionOpCodes.D2L, 1);
    }
}
