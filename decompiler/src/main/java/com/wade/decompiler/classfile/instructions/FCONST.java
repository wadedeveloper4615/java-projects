package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class FCONST.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class FCONST extends Instruction {
    /** The value. */
    private Number value;

    /**
     * Instantiates a new fconst.
     *
     * @param f the f
     */
    public FCONST(float f) {
        super(InstructionOpCodes.FCONST_0, 1);
        if (f == 0.0) {
            this.opcode = InstructionOpCodes.FCONST_0;
        } else if (f == 1.0) {
            this.opcode = InstructionOpCodes.FCONST_1;
        } else if (f == 2.0) {
            this.opcode = InstructionOpCodes.FCONST_2;
        } else {
            throw new ClassGenException("FCONST can be used only for 0.0, 1.0 and 2.0: " + f);
        }
        value = f;
    }
}
