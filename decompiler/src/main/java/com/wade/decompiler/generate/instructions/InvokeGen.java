/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.instructions;

import java.util.Stack;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantCP;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantFieldRef;
import com.wade.decompiler.classfile.constant.ConstantInterfaceMethodRef;
import com.wade.decompiler.classfile.constant.ConstantInvokeDynamic;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantMethodref;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.classfile.instructions.INVOKEDYNAMIC;
import com.wade.decompiler.classfile.instructions.INVOKEINTERFACE;
import com.wade.decompiler.classfile.instructions.INVOKESPECIAL;
import com.wade.decompiler.classfile.instructions.INVOKESTATIC;
import com.wade.decompiler.classfile.instructions.INVOKEVIRTUAL;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InvokeGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class InvokeGen extends InstructionGen {
    /** The opcode. */
    private InstructionOpCodes opcode;
    /** The nargs. */
    private Integer nargs;
    /** The super class name. */
    private String superClassName;
    /** The name. */
    private String name;
    /** The signature. */
    private String signature;
    /** The constant value. */
    private Object constantValue;
    /** The constant string. */
    private String constantString;

    /**
     * Instantiates a new invoke gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InvokeGen(int offset, INVOKEDYNAMIC instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        nargs = null;
    }

    /**
     * Instantiates a new invoke gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InvokeGen(int offset, INVOKEINTERFACE instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        nargs = instr.getNargs();
    }

    /**
     * Instantiates a new invoke gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InvokeGen(int offset, INVOKESPECIAL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        nargs = null;
    }

    /**
     * Instantiates a new invoke gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InvokeGen(int offset, INVOKESTATIC instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        nargs = null;
    }

    /**
     * Instantiates a new invoke gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public InvokeGen(int offset, INVOKEVIRTUAL instr, ConstantPool cp) {
        super(offset, instr.getLength());
        opcode = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        nargs = null;
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
//        if (opcode == InstructionOpCodes.INVOKESPECIAL) {
//            Expression op1 = stack.pop();
//            if (op1.getName().equals("this") && name.equals("<init>") && signature.equals("()V")) {
//                return "\t\tsuper();";
//            }
//            return "\t\t/*invoking " + op1.getName() + "*/";
//        }
//        if (opcode == InstructionOpCodes.INVOKESTATIC) {
//            MethodSignature ms = new MethodSignature(this.signature, false);
//            String parameters = "";
//            for (int i = 1; i <= ms.getParameters().size(); i++) {
//                Expression op1 = stack.pop();
//                if (i < ms.getParameters().size()) {
//                    parameters = op1.getName() + "," + parameters;
//                } else {
//                    parameters += op1.getName();
//                }
//            }
//            String name = String.format("%s.%s(%s)", this.superClassName.replace('/', '.'), this.name, parameters);
//            stack.push(new Expression(name, this.signature, true));
//            return "\t\t/*invoking " + name + "*/";
//        }
//        if (opcode == InstructionOpCodes.INVOKEVIRTUAL) {
//            Expression op1 = stack.pop();
//            if (stack.size() >= 2) {
//                Expression op2 = stack.pop();
//                String name = String.format("%s.%s(%s);", op2.getName(), this.name, op1.getName());
//                stack.push(new Expression("null", this.signature, true));
//                return "\t\t" + name;
//            } else {
//                String name = String.format("%s.%s();", op1.getName(), this.name);
//                stack.push(new Expression("null", this.signature, true));
//                return "\t\t/*" + name + "*/";
//            }
//        }
//        if (opcode == InstructionOpCodes.INVOKEDYNAMIC) {
//            Expression op1 = stack.pop();
//            String name = String.format("%s", op1.getName());
//            stack.push(new Expression(name, this.signature, true));
//            return "\t\t/*pushing " + name + "*/";
//        }
//        if (opcode == InstructionOpCodes.INVOKEINTERFACE) {
//            Expression op1 = stack.pop();
//            String name = String.format("%s.%s()", op1.getName(), this.name);
//            stack.push(new Expression(name, this.signature, true));
//            return "\t\t/*invoking " + name + "*/";
//        }
        return super.decompile(stack);
    }

    /**
     * Extract constant pool info.
     *
     * @param c the c
     */
    protected void extractConstantPoolInfo(Constant c) {
        ConstantPool constantPool = this.getConstantPool();
        if (c == null) {
            return;
        }
        if (c instanceof ConstantMethodref) {
            int classIndex = ((ConstantMethodref) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantMethodref) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superClassName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            name = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantInterfaceMethodRef) {
            int classIndex = ((ConstantInterfaceMethodRef) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantInterfaceMethodRef) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superClassName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            name = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantFieldRef) {
            int classIndex = ((ConstantFieldRef) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantFieldRef) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superClassName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            name = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantInvokeDynamic) {
            int classIndex = ((ConstantInvokeDynamic) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantInvokeDynamic) c).getNameAndTypeIndex();
            ConstantClass cc = null;
            if (classIndex > 0) {
                cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            }
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superClassName = null;
            if (cc != null) {
                superClassName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            }
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
