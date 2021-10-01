package com.wade.decompiler.generate.instructions;

import java.util.LinkedList;
import java.util.Stack;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.instructions.DCMPG;
import com.wade.decompiler.classfile.instructions.DCMPL;
import com.wade.decompiler.classfile.instructions.FCMPG;
import com.wade.decompiler.classfile.instructions.FCMPL;
import com.wade.decompiler.classfile.instructions.IFEQ;
import com.wade.decompiler.classfile.instructions.IFGE;
import com.wade.decompiler.classfile.instructions.IFGT;
import com.wade.decompiler.classfile.instructions.IFLE;
import com.wade.decompiler.classfile.instructions.IFLT;
import com.wade.decompiler.classfile.instructions.IFNE;
import com.wade.decompiler.classfile.instructions.IFNONNULL;
import com.wade.decompiler.classfile.instructions.IFNULL;
import com.wade.decompiler.classfile.instructions.IF_ACMPEQ;
import com.wade.decompiler.classfile.instructions.IF_ACMPNE;
import com.wade.decompiler.classfile.instructions.IF_ICMPEQ;
import com.wade.decompiler.classfile.instructions.IF_ICMPGE;
import com.wade.decompiler.classfile.instructions.IF_ICMPGT;
import com.wade.decompiler.classfile.instructions.IF_ICMPLE;
import com.wade.decompiler.classfile.instructions.IF_ICMPLT;
import com.wade.decompiler.classfile.instructions.IF_ICMPNE;
import com.wade.decompiler.classfile.instructions.LCMP;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class CompareGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CompareGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The index. */
    private Short index;
    @ToString.Exclude
    private LinkedList<InstructionGen> thenBlock = new LinkedList<>();

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, DCMPG instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = -1;
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, DCMPL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = -1;
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, FCMPG instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = -1;
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, FCMPL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = -1;
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ACMPEQ instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ACMPNE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPEQ instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPGE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPGT instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPLE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPLT instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IF_ICMPNE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFEQ instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFGE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFGT instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFLE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFLT instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFNE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFNONNULL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, IFNULL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = instr.getIndex();
        this.setConstantPool(cp);
        this.ifStatement = true;
    }

    /**
     * Instantiates a new compare gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public CompareGen(int offset, LCMP instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        index = -1;
        this.setConstantPool(cp);
        this.ifStatement = true;
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
//        String name = "";
//        if (opcode == InstructionOpCodes.IF_ICMPNE) {
//            name = String.format("if (%s == %s)", op2.getName(), op1.getName());
//            return "\t\t" + name;
//        }
//        return "\t\t/*pushing " + name + "*/";
        return super.decompile(stack);
    }
}
