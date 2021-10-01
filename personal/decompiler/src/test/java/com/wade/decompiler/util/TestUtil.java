package com.wade.decompiler.util;

import java.io.IOException;

import com.wade.decompiler.classfile.constant.Constant;
import com.wade.decompiler.classfile.constant.ConstantClass;
import com.wade.decompiler.classfile.constant.ConstantDouble;
import com.wade.decompiler.classfile.constant.ConstantDynamic;
import com.wade.decompiler.classfile.constant.ConstantFieldRef;
import com.wade.decompiler.classfile.constant.ConstantFloat;
import com.wade.decompiler.classfile.constant.ConstantInteger;
import com.wade.decompiler.classfile.constant.ConstantInterfaceMethodRef;
import com.wade.decompiler.classfile.constant.ConstantInvokeDynamic;
import com.wade.decompiler.classfile.constant.ConstantLong;
import com.wade.decompiler.classfile.constant.ConstantMethodHandle;
import com.wade.decompiler.classfile.constant.ConstantMethodType;
import com.wade.decompiler.classfile.constant.ConstantMethodref;
import com.wade.decompiler.classfile.constant.ConstantModule;
import com.wade.decompiler.classfile.constant.ConstantNameAndType;
import com.wade.decompiler.classfile.constant.ConstantPackage;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantString;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.exceptions.ClassFormatException;

public class TestUtil {
    public static ConstantPool add(ConstantPool cp, Constant c) throws Exception {
        cp.add(c);
        return cp;
    }

    public static ConstantPool createConstantPool(ClassFileConstants tag) throws Exception {
        ConstantPool cp = new ConstantPool();
        Constant c = readConstant(tag);
        cp.add(c);
        return cp;
    }

    public static ConstantPool createConstantPool(Constant c) throws Exception {
        ConstantPool cp = new ConstantPool();
        cp.add(c);
        return cp;
    }

    public static Constant readConstant(ClassFileConstants constant) throws IOException {
        switch (constant) {
            case CONSTANT_Class:
                return new ConstantClass();
            case CONSTANT_Fieldref:
                return new ConstantFieldRef();
            case CONSTANT_Methodref:
                return new ConstantMethodref();
            case CONSTANT_InterfaceMethodref:
                return new ConstantInterfaceMethodRef();
            case CONSTANT_String:
                return new ConstantString();
            case CONSTANT_Integer:
                return new ConstantInteger();
            case CONSTANT_Float:
                return new ConstantFloat();
            case CONSTANT_Long:
                return new ConstantLong();
            case CONSTANT_Double:
                return new ConstantDouble();
            case CONSTANT_NameAndType:
                return new ConstantNameAndType();
            case CONSTANT_Utf8:
                return new ConstantUtf8();
            case CONSTANT_MethodHandle:
                return new ConstantMethodHandle();
            case CONSTANT_MethodType:
                return new ConstantMethodType();
            case CONSTANT_Dynamic:
                return new ConstantDynamic();
            case CONSTANT_InvokeDynamic:
                return new ConstantInvokeDynamic();
            case CONSTANT_Module:
                return new ConstantModule();
            case CONSTANT_Package:
                return new ConstantPackage();
            default:
                throw new ClassFormatException("Invalid byte tag in constant pool: " + constant);
        }
    }
}
