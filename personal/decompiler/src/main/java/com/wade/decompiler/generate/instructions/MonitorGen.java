package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.MONITORENTER;
import com.wade.decompiler.classfile.instructions.MONITOREXIT;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class MonitorGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class MonitorGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new monitor gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public MonitorGen(int offset, MONITORENTER instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new monitor gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public MonitorGen(int offset, MONITOREXIT instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.setConstantPool(cp);
    }
}
