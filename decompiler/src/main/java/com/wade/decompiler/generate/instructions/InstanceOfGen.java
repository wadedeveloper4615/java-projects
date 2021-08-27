package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.INSTANCEOF;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class InstanceOfGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class InstanceOfGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The index. */
    private Integer index;
    /** The name. */
    private String name;

    /**
     * Instantiates a new instance of gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InstanceOfGen(int offset, INSTANCEOF instr, ConstantPool cp) {
	super(offset, instr.getLength());
	opcode = instr.getOpcode();
	index = instr.getIndex();
	this.setConstantPool(cp);
    }
}
