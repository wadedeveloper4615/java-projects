package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class D2I.
 */
@ToString(callSuper = true)
public class D2I extends Instruction {
    /**
     * Instantiates a new d2i.
     */
    public D2I() {
        super(InstructionOpCodes.D2I, 1);
    }
}
