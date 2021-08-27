package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.AALOAD;
import com.wade.decompiler.classfile.instructions.BALOAD;
import com.wade.decompiler.classfile.instructions.CALOAD;
import com.wade.decompiler.classfile.instructions.DALOAD;
import com.wade.decompiler.classfile.instructions.FALOAD;
import com.wade.decompiler.classfile.instructions.IALOAD;
import com.wade.decompiler.classfile.instructions.LALOAD;
import com.wade.decompiler.classfile.instructions.SALOAD;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ArrayLoadGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ArrayLoadGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, AALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, BALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, CALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, DALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, FALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, IALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, LALOAD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array load gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayLoadGen(int offset, SALOAD instr, ConstantPool cp) {
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
//        Expression op2 = stack.pop();
//        String name = String.format("%s[%s]", op2.getName(), op1.getName());
//        stack.push(new Expression(name, op2.getSignaturet()));
//        return "\t\t/*pushing " + name + "*/";
        return super.decompile(stack);
    }
}
