package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.exceptions.ClassGenException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ICONST.
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ICONST extends Instruction {
    /** The value. */
    private Integer value;

    /**
     * Instantiates a new iconst.
     *
     * @param i the i
     */
    public ICONST(int i) {
        super(InstructionOpCodes.ICONST_0.add(i), 1);
        if (!(i >= -1 && i <= 5)) {
            throw new ClassGenException("ICONST can be used only for value between -1 and 5: " + i);
        }
        value = i;
    }
}
