package com.wade.decompiler.classfile.instructions;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.classfile.instructions.type.Type;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class FCMPL extends Instruction {
    private Type type;
    private Instruction negate;

    public FCMPL(ConstantPool cp) {
        super(InstructionOpCodes.FCMPL, 1, cp);
        type = Type.FLOAT;
        negate = new FCMPG(cp);
    }
}
