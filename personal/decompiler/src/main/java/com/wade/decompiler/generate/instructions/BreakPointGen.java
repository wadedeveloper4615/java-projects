package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.BREAKPOINT;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class BreakPointGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class BreakPointGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new break point gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public BreakPointGen(int offset, BREAKPOINT instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.setConstantPool(cp);
    }
}
