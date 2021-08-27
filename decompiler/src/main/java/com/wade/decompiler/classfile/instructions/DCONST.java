package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class DCONST.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class DCONST extends Instruction {
    /** The value. */
    private Double value = 0.0;

    /**
     * Instantiates a new dconst.
     *
     * @param f the f
     */
    public DCONST(double f) {
        super(InstructionOpCodes.DCONST_0, 1);
        if (f == 0.0) {
            this.opcode = InstructionOpCodes.DCONST_0;
        } else if (f == 1.0) {
            this.opcode = InstructionOpCodes.DCONST_1;
        } else {
            throw new ClassGenException("DCONST can be used only for 0.0 and 1.0: " + f);
        }
        value = f;
    }
}
