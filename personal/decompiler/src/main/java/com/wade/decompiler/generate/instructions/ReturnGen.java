/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.ARETURN;
import com.wade.decompiler.classfile.instructions.DRETURN;
import com.wade.decompiler.classfile.instructions.FRETURN;
import com.wade.decompiler.classfile.instructions.IRETURN;
import com.wade.decompiler.classfile.instructions.LRETURN;
import com.wade.decompiler.classfile.instructions.RET;
import com.wade.decompiler.classfile.instructions.RETURN;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.LoadStatement;
import com.wade.decompiler.generate.statement.ReturnStatement;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ReturnGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ReturnGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, ARETURN instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, DRETURN instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, FRETURN instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, IRETURN instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, LRETURN instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, RET instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new return gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ReturnGen(int offset, RETURN instr, ConstantPool cp) {
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
        if (opcode == InstructionOpCodes.RETURN) {
            return new ReturnStatement();
        } else {
            Statement op1 = stack.pop();
            String name1 = "";
            if (op1 instanceof LoadStatement) {
                name1 = ((LoadStatement) op1).getName();
            }
            return new ReturnStatement().name(name1);
        }
    }
}
