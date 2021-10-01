/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.JavaClass;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.enums.ClassFileConstants;
import com.wade.decompiler.enums.Version;
import com.wade.decompiler.generate.attribute.AttributeGen;
import com.wade.decompiler.util.Utility;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Class JavaClassGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class JavaClassGen {

    /** The constant pool. */
    private ConstantPool constantPool;

    /** The class name. */
    private String className;

    /** The super class name. */
    private String superClassName;

    /** The filename. */
    private String filename;

    /** The version. */
    private Version version;

    /** The access flags. */
    private ClassAccessFlagsList accessFlags;

    /** The interface names. */
    private List<String> interfaceNames;

    /** The fields. */
    private List<FieldGen> fields;

    /** The methods. */
    private List<MethodGen> methods;

    /** The attributes. */
    private List<AttributeGen> attributes;

    /**
     * Instantiates a new java class gen.
     *
     * @param javaClass    the java class
     * @param isInnerClass the is inner class
     */
    public JavaClassGen(JavaClass javaClass, Boolean isInnerClass) {
        if (javaClass != null) {
            this.constantPool = javaClass.getConstantPool();
            this.className = constantPool.constantToString(javaClass.getClassNameIndex(), ClassFileConstants.CONSTANT_Class);
            if (javaClass.getSuperclassNameIndex() != 0) {
                this.superClassName = constantPool.constantToString(javaClass.getSuperclassNameIndex(), ClassFileConstants.CONSTANT_Class);
            } else {
                this.superClassName = "";
            }
            this.filename = javaClass.getFileName();
            this.version = javaClass.getVersion();
            this.accessFlags = new ClassAccessFlagsList(javaClass.getAccessFlags());
            this.interfaceNames = new ArrayList<>();
            javaClass.getInterfaces().stream().forEach(interfaceNameIndex -> interfaceNames.add(constantPool.constantToString(interfaceNameIndex, ClassFileConstants.CONSTANT_Class)));
            this.fields = new ArrayList<>();
            javaClass.getFields().stream().forEach(field -> fields.add(new FieldGen(field, constantPool, isInnerClass)));
            this.methods = new ArrayList<>();
            javaClass.getMethods().stream().forEach(method -> methods.add(new MethodGen(method, constantPool, isInnerClass)));
            this.attributes = new ArrayList<>();
            javaClass.getAttributes().stream().forEach(entry -> attributes.add(AttributeGen.readAttribute(entry, constantPool, isInnerClass)));
        }
    }

    /**
     * Decompile.
     *
     * @param out the out
     */
    public void decompile(PrintStream out) {
        out.println();
        ClassAccessFlagsList accessFlags = getAccessFlags();
        String type = Utility.classType(accessFlags);
        String access = Utility.accessToString(accessFlags, true);
        out.print(String.format("%s %s %s extends %s", access, type, getClassName(), getSuperClassName()));
        List<String> interfaceNames = getInterfaceNames();
        int size = interfaceNames.size();
        if (size > 0) {
            out.print(" implements ");
            for (int i = 0; i < size; i++) {
                out.print(interfaceNames.get(i));
                if (i < size - 1) {
                    out.print(", ");
                }
            }
        }
        out.println(" {");
        for (FieldGen field : getFields()) {
            field.decompile(out);
        }
        out.println();
        for (MethodGen method : getMethods()) {
            method.setClassName(getClassName());
            method.decompile(out);
        }
        out.println("}");
    }

    /**
     * To useful string.
     *
     * @param out the out
     */
    public void toUsefulString(PrintStream out) {
        out.println("Version = " + this.getVersion());
        out.println("Flags = " + this.getAccessFlags());
        out.println();
        out.println(getConstantPool().getConstantPool().size() + " entries");
        out.println(getConstantPool().readableString());
        out.println();
        out.println("Class Name = " + this.className);
        out.println("Super Class Name =" + this.superClassName);
        out.println("Interfaces");
        for (String name : this.getInterfaceNames()) {
            out.println("   " + name);
        }
        out.println();
        out.println("Fields");
        for (FieldGen field : getFields()) {
            out.println(field.getName() + " " + field.getSignature() + " " + field.getAccessFlags());
            for (AttributeGen ag : field.getAttributes()) {
                ag.printUsefulData(out);
            }
        }
        out.println();
        out.println("Methods");
        for (MethodGen method : getMethods()) {
            out.println(method.getName() + " " + method.getSignature() + " " + method.getAccessFlags());
            for (AttributeGen ag : method.getAttributes()) {
                ag.printUsefulData(out);
            }
            out.println();
        }
        out.println("Class Attributes:");
        for (AttributeGen attribute : getAttributes()) {
            attribute.printUsefulData(out);
        }
    }
}
