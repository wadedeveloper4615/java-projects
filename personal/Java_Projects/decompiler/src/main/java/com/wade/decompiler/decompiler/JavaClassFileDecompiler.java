package com.wade.decompiler.decompiler;

import java.util.List;

import com.wade.decompiler.classfile.instructions.base.Instruction;
import com.wade.decompiler.enums.ClassAccessFlags;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.generate.FieldGen;
import com.wade.decompiler.generate.JavaClassGen;
import com.wade.decompiler.generate.MethodGen;
import com.wade.decompiler.generate.attribute.CodeGen;
import com.wade.decompiler.generate.attribute.LocalVariableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;
import com.wade.decompiler.generate.instructions.InstructionGen;
import com.wade.decompiler.util.MethodSignature;
import com.wade.decompiler.util.Utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class JavaClassFileDecompiler {
    private JavaClassGen jgen;

    public JavaClassFileDecompiler(JavaClassGen jgen) {
        this.jgen = jgen;
        ClassAccessFlagsList accessFlags = jgen.getAccessFlags();
        boolean isAbstract = accessFlags.isAbstract();
        boolean isAnnotation = accessFlags.isAnnotation();
        String type = Utility.classType(accessFlags);
        String access = Utility.accessToString(accessFlags, true);
        String fileBase = String.format("%s %s %s extends %s", access, type, jgen.getClassName(), jgen.getSuperClassName());
        List<String> interfaceNames = jgen.getInterfaceNames();
        int size = interfaceNames.size();
        if (size > 0) {
            fileBase += " implements ";
            for (int i = 0; i < size; i++) {
                fileBase += interfaceNames.get(i);
                if (i < size - 1) {
                    fileBase += ", ";
                }
            }
        }
        System.out.println("/*");
        System.out.println("\tVersion=" + jgen.getVersion());
        System.out.println(jgen.getConstantPool().toString());
        System.out.println("*/");
        System.out.println(fileBase + " {");
        deompileFields(jgen.getFields());
        System.out.println();
        deompileMethods(jgen.getMethods(), isAbstract, isAnnotation);
        System.out.println("}");
    }

    private void decompileInstructions(CodeGen codeGen, LocalVariableTableGen localVariables) {
        System.out.println("\t\t/*");
        if (codeGen != null) {
            System.out.println("\t\t\tlength     = " + codeGen.getLength());
            System.out.println("\t\t\tmax locals = " + codeGen.getMaxLocals());
            System.out.println("\t\t\tmax stack  = " + codeGen.getMaxStack());
            System.out.println("\t\t\tcode size  = " + codeGen.getCodeSize());
            if (localVariables != null) {
                for (LocalVariableGen lv : localVariables.getLocalVariableTable()) {
                    System.out.println("\t\t\t" + lv.toString());
                }
            }
            System.out.println();
            for (Instruction instr : codeGen.getInstructions()) {
                System.out.println("\t\t\t" + instr.toString());
            }
            System.out.println();
            for (InstructionGen instr : codeGen.getInstructionExtracted()) {
                if (instr != null)
                    System.out.println("\t\t\t" + instr.toString());
            }
        }
        System.out.println("\t\t*/");
        System.out.println();
        if (codeGen != null) {
            for (String instr : codeGen.getInstructionDecompiled()) {
                if (instr != null)
                    System.out.println("\t\t" + instr.toString());
            }
        }
    }

    private void deompileFields(List<FieldGen> fields) {
        for (FieldGen fg : fields) {
            String access = Utility.accessToString(fg.getAccessFlags(), true);
            String signature = Utility.typeSignatureToString(fg.getSignature(), false);
            String fieldBase = String.format("\t%s %s %s", access, signature, fg.getName());
            if (fg.getConstant() != null) {
                fieldBase += " = " + fg.getConstant().toString() + ";";
            } else {
                fieldBase += ";";
            }
            System.out.println(fieldBase);
        }
    }

    private void deompileMethods(List<MethodGen> methods, boolean isAbstract, boolean isAnnotation) {
        for (MethodGen mg : methods) {
            ClassAccessFlagsList flags = mg.getAccessFlags();
            boolean isNative = flags.isNative();
            if (isAbstract || isAnnotation) {
                flags.remove(ClassAccessFlags.ACC_ABSTRACT);
            }
            String access = Utility.accessToString(flags, true);
            String name = mg.getName();
            boolean constructor = false;
            if (name.equals("<init>")) {
                name = Utility.extractClassName(jgen.getClassName(), false);
                constructor = true;
            }
            System.out.println("\t/* signature = " + mg.getSignature() + " */");
            String signature = new MethodSignature(mg.getSignature(), name, access, jgen.getClassName(), true, mg.getLocalVariableTable(), constructor).signaturetoString();
            // String signature = Utility.methodSignatureToString(mg.getSignature(), name,
            // access, true, mg.getLocalVariableTable());
            if (!(isAbstract || isAnnotation || isNative)) {
                System.out.println("\t" + signature + "{");
                decompileInstructions(mg.getCode(), mg.getLocalVariableTable());
                System.out.println("\t}");
            } else {
                System.out.println("\t" + signature);
            }
            System.out.println();
        }
    }
}