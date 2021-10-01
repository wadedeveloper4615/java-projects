package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.ToString;

/**
 * The Class IMPDEP2.
 */
@ToString(callSuper = true)
public class IMPDEP2 extends Instruction {
    /**
     * Instantiates a new impdep2.
     */
    public IMPDEP2() {
        super(InstructionOpCodes.IMPDEP2, 1);
    }
}
