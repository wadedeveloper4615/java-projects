package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.AASTORE;
import com.wade.decompiler.classfile.instructions.BASTORE;
import com.wade.decompiler.classfile.instructions.CASTORE;
import com.wade.decompiler.classfile.instructions.DASTORE;
import com.wade.decompiler.classfile.instructions.FASTORE;
import com.wade.decompiler.classfile.instructions.IASTORE;
import com.wade.decompiler.classfile.instructions.LASTORE;
import com.wade.decompiler.classfile.instructions.SASTORE;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ArrayStoreGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ArrayStoreGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, AASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, BASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, CASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, DASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, FASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, IASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, LASTORE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new array store gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ArrayStoreGen(int offset, SASTORE instr, ConstantPool cp) {
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
//        Expression op3 = stack.pop();
//        String name = String.format("%s[%s]=%s;", op3.getName(), op2.getName(), op1.getName());
//        return "\t\t" + name;
        return super.decompile(stack);
    }
}
