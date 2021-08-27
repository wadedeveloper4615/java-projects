package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.POP;
import com.wade.decompiler.classfile.instructions.POP2;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class PopGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class PopGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new pop gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public PopGen(int offset, POP instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new pop gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public PopGen(int offset, POP2 instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
//        Expression op1 = stack.peek();
//        return "\t\t/*poping " + op1.getName() + "*/";
        return super.decompile(stack);
    }
}
