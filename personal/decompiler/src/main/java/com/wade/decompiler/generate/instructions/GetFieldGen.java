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
import com.wade.decompiler.classfile.instructions.GETFIELD;
import com.wade.decompiler.classfile.instructions.GETSTATIC;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.InstructionOpCodes;
import com.wade.decompiler.generate.statement.LoadStatement;
import com.wade.decompiler.generate.statement.Statement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class GetFieldGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@NoArgsConstructor
public class GetFieldGen extends InstructionGen {
    /** The super name. */
    private String superName;
    /** The method name. */
    private String methodName;
    /** The signature. */
    private String signature;
    /** The constant value. */
    private Object constantValue;
    /** The constant string. */
    private String constantString;
    private InstructionOpCodes op;

    /**
     * Instantiates a new gets the field gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public GetFieldGen(int offset, GETFIELD instr, ConstantPool cp) {
        super(offset, instr.getLength());
        op = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
    }

    /**
     * Instantiates a new gets the field gen.
     *
     * @param offset the offset
     * @param instr  the instr
     * @param cp     the cp
     */
    public GetFieldGen(int offset, GETSTATIC instr, ConstantPool cp) {
        super(offset, instr.getLength());
        op = instr.getOpcode();
        this.setConstantPool(cp);
        ConstantCP c = (ConstantCP) cp.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
    }

    /**
     * Decompile.
     *
     * @param stack the stack
     * @return the string
     */
    @Override
    public Statement decompile(Stack<Statement> stack) {
        if (op == InstructionOpCodes.GETFIELD) {
            Statement op1 = stack.pop();
            String name1 = "";
            if (op1 instanceof LoadStatement) {
                name1 = ((LoadStatement) op1).getName();
            }
            String name = String.format("%s.%s", name1, this.methodName);
            stack.push(new LoadStatement().comment(null).name(name).signature(signature));
            // stack.push(new Expression(name, this.signature));
            // return "\t\t/*pushing " + name + " type=" + signature + " */";
            return null;
        }
        if (op == InstructionOpCodes.GETSTATIC) {
            String name = String.format("%s.%s", this.superName.replace('/', '.'), this.methodName);
            stack.push(new LoadStatement().comment(null).name(name).signature(signature));
            // return "\t\t/*pushing " + name + " type=" + signature + " */";
            return null;
        }
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
            superName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            methodName = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantFieldRef) {
            int classIndex = ((ConstantFieldRef) c).getClassIndex();
            int nameAndTypeIndex = ((ConstantFieldRef) c).getNameAndTypeIndex();
            ConstantClass cc = (ConstantClass) constantPool.getConstant(classIndex, ClassFileConstants.CONSTANT_Class);
            ConstantNameAndType cnt = (ConstantNameAndType) constantPool.getConstant(nameAndTypeIndex, ClassFileConstants.CONSTANT_NameAndType);
            superName = ((ConstantUtf8) constantPool.getConstant(cc.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            methodName = ((ConstantUtf8) constantPool.getConstant(cnt.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
            signature = ((ConstantUtf8) constantPool.getConstant(cnt.getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantClass) {
            ConstantClass constantClass = (ConstantClass) c;
            constantValue = ((ConstantUtf8) constantPool.getConstant(constantClass.getNameIndex(), ClassFileConstants.CONSTANT_Utf8)).getBytes();
        } else if (c instanceof ConstantUtf8) {
            constantString = ((ConstantUtf8) c).getBytes();
        } else if (c instanceof ConstantNameAndType) {
            methodName = constantPool.constantToString(((ConstantNameAndType) c).getNameIndex(), ClassFileConstants.CONSTANT_Utf8);
            signature = constantPool.constantToString(((ConstantNameAndType) c).getSignatureIndex(), ClassFileConstants.CONSTANT_Utf8);
        } else if (c instanceof ConstantLong) {
            constantValue = Long.valueOf(((ConstantLong) c).getBytes().longValue());
        } else {
            System.out.println("Unknow class in getfileldgen " + c.getClass().getName());
        }
    }
}
