package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class FCMPG.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class FCMPG extends Instruction {
    /**
     * Instantiates a new fcmpg.
     */
    public FCMPG() {
        super(InstructionOpCodes.FCMPG, 1);
    }

    /**
     * Gets the negate.
     *
     * @return the negate
     */
    public Instruction negate() {
        return new FCMPL();
    }
}
