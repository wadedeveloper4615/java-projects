package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.GOTO;
import com.wade.decompiler.classfile.instructions.GOTO_W;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class GotoGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class GotoGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The offsets. */
    private Integer offsets;

    /**
     * Instantiates a new goto gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public GotoGen(int offset, GOTO instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	offsets = instr.getIndex();
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new goto gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public GotoGen(int offset, GOTO_W instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	offsets = instr.getIndex();
	this.setConstantPool(cp);
    }
}
