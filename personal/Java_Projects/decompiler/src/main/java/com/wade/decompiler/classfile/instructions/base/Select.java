package com.wade.decompiler.classfile.instructions.base;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public abstract class Select extends BranchInstruction {
    protected int[] match;
    protected int[] indices;
    protected int fixed_length;
    protected int match_length;
    protected int padding = 0;

    public Select(InstructionOpCodes opcode, int[] match, ConstantPool cp) {
        super(opcode, cp);
        this.match = match;
    }
}
