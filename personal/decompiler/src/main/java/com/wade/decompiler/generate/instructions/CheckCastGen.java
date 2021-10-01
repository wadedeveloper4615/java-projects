package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.CHECKCAST;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class CheckCastGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class CheckCastGen extends InstructionGen {
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new check cast gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CheckCastGen(int offset, CHECKCAST instr, ConstantPool cp) {
        super(offset, instr.getLength());
        this.index = instr.getIndex();
        this.setConstantPool(cp);
    }
}
