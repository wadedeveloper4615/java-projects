/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.IINC;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class IncGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class IncGen extends InstructionGen {

    /** The increment. */
    private Short increment;

    /** The local variable reference. */
    private LocalVariableTableGen localVariableReference;

    /**
     * Instantiates a new inc gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param lvt    the lvt
     * @param cp     the cp
     */
    public IncGen(int offset, IINC instr, LocalVariableTableGen lvt, ConstantPool cp) {
        super(offset, instr.getLength());
        this.setConstantPool(cp);
        increment = instr.getIncrement();
        this.localVariableReference = lvt;
    }
}
