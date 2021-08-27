/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantCP;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantFieldRef;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantMethodref;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.instructions.PUTFIELD;
import com.wade.decompiler.classfile.instructions.PUTSTATIC;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.LoadStatement;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class PutFieldGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class PutFieldGen extends InstructionGen {
    /** The super name. */
    private String superName;
    /** The name. */
    private String name;
    /** The signature. */
    private String signature;
    /** The constant value. */
    private Object constantValue;
    /** The constant string. */
    private String constantString;
    /** The op. */
    private InstructionOpCodes op;

    /**
     * Instantiates a new put field gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public PutFieldGen(int offset, PUTFIELD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        op = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c, cp);
    }

    /**
     * Instantiates a new put field gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public PutFieldGen(int offset, PUTSTATIC instr, ConstantPool cp) {
        super(offset, instr.getLength());
        op = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c, cp);
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
        Statement op1 = stack.pop();
        Statement op2 = stack.pop();
        String name1 = "";
        String name2 = "";
        if (op1 instanceof LoadStatement) {
            name1 = ((LoadStatement) op1).getName();
        }
        if (op2 instanceof LoadStatement) {
            name2 = ((LoadStatement) op2).getName();
        }
        return new AssignmentStatement().comment(null).op1(name1).op2(name2).name(name);
    }

    /**
     * Extract constant pool info.
     *
     * @param c  the c
     * @param cp the cp
     */
    protected void extractConstantPoolInfo(Constant c, ConstantPool cp) {
        ConstantPool constantPool = cp;
        if (c == null) {
            return;
        }
        if (c instanceof ConstantMethodref) {
            int classIndex = ((ConstantMethodref) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantMethodref) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            name = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantFieldRef) {
            int classIndex = ((ConstantFieldRef) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantFieldRef) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            name = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantClass) {
            ConstantClass constantClass = (ConstantClass) c;
            constantValue = ((ConstantUtf8) constantPool.getConstant(constantClass.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantUtf8) {
            constantString = ((ConstantUtf8) c).getBytes();
        } else if (c instanceof ConstantNameAndType) {
            name = constantPool.constantToString(((ConstantNameAndType) c).getNameIndex(), ClassFileConstants.CONSTANT_Utf8);
            signature = constantPool.constantToString(((ConstantNameAndType) c).getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8);
        } else if (c instanceof ConstantLong) {
            constantValue = Long.valueOf(((ConstantLong) c).getBytes().longValue());
        } else {
            System.out.println(c.getClass().getName());
        }
    }
}
