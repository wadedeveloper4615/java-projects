package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class LCONST.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class LCONST extends Instruction {
    /** The value. */
    private Number value;

    /**
     * Instantiates a new lconst.
     *
     * @param l the l
     */
    public LCONST(long l) {
        super(InstructionOpCodes.LCONST_0, 1);
        if (l == 0) {
            this.opcode = InstructionOpCodes.LCONST_0;
        } else if (l == 1) {
            this.opcode = InstructionOpCodes.LCONST_1;
        } else {
            throw new ClassGenException("LCONST can be used only for 0 and 1: " + l);
        }
        value = l;
    }
}
