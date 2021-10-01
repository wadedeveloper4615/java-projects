package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ARRAYLENGTH;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ArrayLengthGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ArrayLengthGen extends InstructionGen {
    /** The opcode. */
    protected InstructionOpCodes opcode;

    /**
     * Instantiates a new array length gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLengthGen(int offset, ARRAYLENGTH instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.setConstantPool(cp);
    }
}
