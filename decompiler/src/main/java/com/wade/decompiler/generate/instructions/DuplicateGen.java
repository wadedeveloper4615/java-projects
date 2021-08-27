package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.DUP;
import com.wade.decompiler.classfile.instructions.DUP2;
import com.wade.decompiler.classfile.instructions.DUP2_X1;
import com.wade.decompiler.classfile.instructions.DUP2_X2;
import com.wade.decompiler.classfile.instructions.DUP_X1;
import com.wade.decompiler.classfile.instructions.DUP_X2;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class DuplicateGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class DuplicateGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP_X1 instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP_X2 instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP2 instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP2_X1 instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new duplicate gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public DuplicateGen(int offset, DUP2_X2 instr, ConstantPool cp) {
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
//        Expression op1 = stack.pop();
//        stack.push(op1);
//        stack.push(op1);
//        return "\t\t/*duplicating " + op1.getName() + "*/";
        return super.decompile(stack);
    }
}
