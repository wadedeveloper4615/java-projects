package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.NOP;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class NopGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class NopGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new nop gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public NopGen(int offset, NOP instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.setConstantPool(cp);
    }
}
