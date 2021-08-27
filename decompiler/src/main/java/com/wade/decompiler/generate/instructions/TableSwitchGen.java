package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.TABLESWITCH;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class TableSwitchGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class TableSwitchGen extends InstructionGen {
    /** The padding. */
    private Integer padding;
    /** The default offset. */
    private Integer defaultOffset;
    /** The offsets. */
    private Integer[] offsets;
    /** The match. */
    private Integer[] match;

    /**
     * Instantiates a new table switch gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public TableSwitchGen(int offset, TABLESWITCH instr, ConstantPool cp) {
	super(offset, instr.getLength());
	match = instr.getMatch();
	offsets = instr.getOffsets();
	padding = instr.getPadding();
	defaultOffset = instr.getDefaultOffset();
	this.setConstantPool(cp);
    }
}
