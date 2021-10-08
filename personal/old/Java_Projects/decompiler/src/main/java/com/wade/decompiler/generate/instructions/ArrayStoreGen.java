package com.wade.decompiler.generate.instructions;

import com.wade.decompiler.classfile.instructions.AASTORE;
import com.wade.decompiler.classfile.instructions.BASTORE;
import com.wade.decompiler.classfile.instructions.CASTORE;
import com.wade.decompiler.classfile.instructions.DASTORE;
import com.wade.decompiler.classfile.instructions.FASTORE;
import com.wade.decompiler.classfile.instructions.IASTORE;
import com.wade.decompiler.classfile.instructions.LASTORE;
import com.wade.decompiler.classfile.instructions.SASTORE;
import com.wade.decompiler.classfile.instructions.type.Type;
import com.wade.decompiler.decompiler.Expression;
import com.wade.decompiler.decompiler.ExpressionStack;
import com.wade.decompiler.enums.InstructionOpCodes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class ArrayStoreGen extends InstructionGen {
    private InstructionOpCodes opcode;
    private Type type;

    public ArrayStoreGen(int offset, AASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.OBJECT;
    }

    public ArrayStoreGen(int offset, BASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.OBJECT;
    }

    public ArrayStoreGen(int offset, CASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.CHAR;
    }

    public ArrayStoreGen(int offset, DASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.DOUBLE;
    }

    public ArrayStoreGen(int offset, FASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.FLOAT;
    }

    public ArrayStoreGen(int offset, IASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.INTEGER;
    }

    public ArrayStoreGen(int offset, LASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.LONG;
    }

    public ArrayStoreGen(int offset, SASTORE instr) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        type = Type.SHORT;
    }

    @Override
    public String decompile(ExpressionStack stack) {
        Expression resultVar = stack.pop();
        Expression resultIndex = stack.pop();
        Expression var2 = stack.pop();
        return var2.getValue() + "[" + resultIndex.getValue() + "] = " + resultVar.getValue();
    }
}
