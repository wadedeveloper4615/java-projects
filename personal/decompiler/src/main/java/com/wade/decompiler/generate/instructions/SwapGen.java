package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.SWAP;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class SwapGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class SwapGen extends InstructionGen {
    /**
     * Instantiates a new swap gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public SwapGen(int offset, SWAP instr, ConstantPool cp) {
	super(offset, instr.getLength());
	this.setConstantPool(cp);
    }
}
