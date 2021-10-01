package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.JSR;
import com.wade.decompiler.classfile.instructions.JSR_W;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class JsrGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class JsrGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The index. */
    private Integer index;

    /**
     * Instantiates a new jsr gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public JsrGen(int offset, JSR instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	index = -1;
	this.setConstantPool(cp);
    }

    /**
     * Instantiates a new jsr gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public JsrGen(int offset, JSR_W instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	index = instr.getIndex();
	this.setConstantPool(cp);
    }
}
