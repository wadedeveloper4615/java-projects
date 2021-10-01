package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class DCMPL.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class DCMPL extends Instruction {
    /**
     * Instantiates a new dcmpl.
     */
    public DCMPL() {
        super(InstructionOpCodes.DCMPL, 1);
    }

    /**
     * Negate.
     *
     * @return the instruction
     */
    public Instruction negate() {
        return new DCMPG();
    }
}
