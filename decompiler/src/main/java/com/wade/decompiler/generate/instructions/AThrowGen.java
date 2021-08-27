package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ATHROW;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class AThrowGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class AThrowGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new a throw gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public AThrowGen(int offset, ATHROW instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	this.constantPool = cp;
    }
}
