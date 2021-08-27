package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantDouble;
import com.wade.decompiler.classfile.constant.ConstantFloat;
import com.wade.decompiler.classfile.constant.ConstantInteger;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantString;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.instructions.ACONST_NULL;
import com.wade.decompiler.classfile.instructions.BIPUSH;
import com.wade.decompiler.classfile.instructions.DCONST;
import com.wade.decompiler.classfile.instructions.FCONST;
import com.wade.decompiler.classfile.instructions.ICONST;
import com.wade.decompiler.classfile.instructions.LCONST;
import com.wade.decompiler.classfile.instructions.LDC;
import com.wade.decompiler.classfile.instructions.LDC2_W;
import com.wade.decompiler.classfile.instructions.LDC_W;
import com.wade.decompiler.classfile.instructions.SIPUSH;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.LoadStatement;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class ConstGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ConstGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The value. */
    private Object value;
    private String signature;

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, ACONST_NULL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = null;
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, BIPUSH instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, DCONST instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, FCONST instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, ICONST instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, LCONST instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, LDC instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = getValue(instr.getIndex(), cp);
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, LDC_W instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = getValue(instr.getIndex(), cp);
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, LDC2_W instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = getValue(instr.getIndex(), cp);
        this.setConstantPool(cp);
    }

    /**
     * Instantiates a new const gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public ConstGen(int offset, SIPUSH instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        value = instr.getValue();
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
        String name = this.getValue().toString();
        if (opcode == InstructionOpCodes.LDC) {
            name = "\"" + name + "\"";
        }
        stack.push(new LoadStatement().comment(null).name(name).signature(signature));
        return null;
    }

    /**
     * Gets the value.
     *
     * @param index        the index
     * @param constantPool the constant pool
     * @return the value
     */
    public Object getValue(int index, ConstantPool constantPool) {
        Constant c = constantPool.getConstant(index);
        if (c == null) {
            return null;
        }
        switch (c.getTag()) {
            case CONSTANT_Long:
                signature = "J";
                return Long.valueOf(((ConstantLong) c).getBytes().longValue());
            case CONSTANT_Double:
                signature = "D";
                return Double.valueOf(((ConstantDouble) c).getBytes().doubleValue());
            case CONSTANT_Float:
                signature = "F";
                return Double.valueOf(((ConstantFloat) c).getBytes().doubleValue());
            case CONSTANT_Integer:
                signature = "I";
                return ((ConstantInteger) c).getBytes();
            case CONSTANT_String:
                signature = "Ljava/lang/String;";
                Integer stringIndex = ((ConstantString) c).getStringIndex();
                ConstantUtf8 constant = (ConstantUtf8) constantPool.getConstant(stringIndex);
                return constant.getBytes();
            default:
                System.out.println(c.getTag());
                return null;
        }
    }
}
