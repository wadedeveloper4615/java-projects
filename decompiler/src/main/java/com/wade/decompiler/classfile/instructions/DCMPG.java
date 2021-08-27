package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class DCMPG.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class DCMPG extends Instruction {
    /**
     * Instantiates a new dcmpg.
     */
    public DCMPG() {
        super(InstructionOpCodes.DCMPG, 1);
    }

    /**
     * Negate.
     *
     * @return the instruction
     */
    public Instruction negate() {
        return new DCMPL();
    }
}
