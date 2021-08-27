package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class D2F.
 */
@ToString(callSuper = true)
public class D2F extends Instruction {
    /**
     * Instantiates a new d2f.
     */
    public D2F() {
        super(InstructionOpCodes.D2F, 1);
    }
}
