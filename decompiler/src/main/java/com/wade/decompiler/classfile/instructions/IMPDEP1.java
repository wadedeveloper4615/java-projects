package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IMPDEP1.
 */
@ToString(callSuper = true)
public class IMPDEP1 extends Instruction {
    /**
     * Instantiates a new impdep1.
     */
    public IMPDEP1() {
        super(InstructionOpCodes.IMPDEP1, 1);
    }
}
