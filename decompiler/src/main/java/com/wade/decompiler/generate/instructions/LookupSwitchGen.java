package com.wade.decompiler.generate.instructions;

import java.util.List;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.LOOKUPSWITCH;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class LookupSwitchGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class LookupSwitchGen extends InstructionGen {
    /** The padding. */
    private Integer padding;
    /** The default offset. */
    private Integer defaultOffset;
    /** The offsets. */
    private Integer[] offsets;
    /** The match. */
    private List<Integer> match;

    /**
     * Instantiates a new lookup switch gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public LookupSwitchGen(int offset, LOOKUPSWITCH instr, ConstantPool cp) {
	super(offset, instr.getLength());
	match = instr.getMatch();
	offsets = instr.getOffsets();
	padding = instr.getPadding();
	defaultOffset = instr.getDefaultOffset();
	this.setConstantPool(cp);
    }
}
