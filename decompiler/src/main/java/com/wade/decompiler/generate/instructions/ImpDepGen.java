package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.IMPDEP1;
import com.wade.decompiler.classfile.instructions.IMPDEP2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ImpDepGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ImpDepGen extends InstructionGen {
    /**
     * Instantiates a new imp dep gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ImpDepGen(int offset, IMPDEP1 instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new imp dep gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ImpDepGen(int offset, IMPDEP2 instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }
}
