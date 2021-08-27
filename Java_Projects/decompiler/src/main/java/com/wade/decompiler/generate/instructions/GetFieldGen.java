package com.wade.decompiler.generate.instructions;

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
import com.wade.decompiler.classfile.instructions.type.Type;
import com.wade.decompiler.decompiler.Expression;
import com.wade.decompiler.decompiler.ExpressionStack;
import com.wade.decompiler.decompiler.ExpressionType;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class GetFieldGen extends InstructionGen {
    @ToString.Exclude
    private ConstantPool constantPool;
    private String superName;
    private String methodName;
    private String signature;
    private Object constantValue;
    private String constantString;
    private Type type;

    public GetFieldGen(int offset, GETFIELD instr) {
        super(offset, instr.getLength());
        constantPool = instr.getConstantPool();
        ConstantCP c = (ConstantCP) constantPool.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        type = instr.getType();
    }

    public GetFieldGen(int offset, GETSTATIC instr) {
        super(offset, instr.getLength());
        constantPool = instr.getConstantPool();
        ConstantCP c = (ConstantCP) constantPool.getConstant(instr.getIndex());
        extractConstantPoolInfo(c);
        type = instr.getType();
    }

    @Override
    public String decompile(ExpressionStack stack) {
        if (!stack.empty()) {
            Expression item1 = stack.pop();
            String name = methodName;
            stack.push(new Expression(ExpressionType.VARIABLE, item1.getValue() + "." + name));
        }
        return null;
    }

    private void extractConstantPoolInfo(Constant c) {
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
            constantValue = Long.valueOf(((ConstantLong) c).getBytes());
        } else {
            System.out.println("Unknow class in getfileldgen " + c.getClass().getName());
        }
    }
}
