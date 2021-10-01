package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class FCMPL.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class FCMPL extends Instruction {
    /**
     * Instantiates a new fcmpl.
     */
    public FCMPL() {
        super(InstructionOpCodes.FCMPL, 1);
    }

    /**
     * Gets the negate.
     *
     * @return the negate
     */
    public Instruction negate() {
        return new FCMPG();
    }
}
