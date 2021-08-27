/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile;

import java.io.PrintStream;
import java.util.List;

import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.Version;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The Class JavaClass.
 */
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
public class JavaClass {
    /** The class name index. */
    private int classNameIndex;
    /** The superclass name index. */
    private int superclassNameIndex;
    /** The file name. */
    private String fileName;
    /** The version. */
    private Version version;
    /** The access flags. */
    private int accessFlags;
    /** The constant pool. */
    private ConstantPool constantPool;
    /** The interfaces. */
    private List<Integer> interfaces;
    /** The fields. */
    private List<Field> fields;
    /** The methods. */
    private List<Method> methods;
    /** The attributes. */
    private List<Attribute> attributes;

    /**
     * Instantiates a new java class.
     *
     * @param classNameIndex      the class name index
     * @param superclassNameIndex the superclass name index
     * @param fileName            the file name
     * @param version             the version
     * @param accessFlags         the access flags
     * @param constantPool        the constant pool
     * @param interfaces          the interfaces
     * @param fields              the fields
     * @param methods             the methods
     * @param attributes          the attributes
     */
    public JavaClass(int classNameIndex, int superclassNameIndex, String fileName, Version version, int accessFlags, ConstantPool constantPool, List<Integer> interfaces, List<Field> fields, List<Method> methods, List<Attribute> attributes) {
        this.classNameIndex = classNameIndex;
        this.superclassNameIndex = superclassNameIndex;
        this.fileName = fileName;
        this.version = version;
        this.accessFlags = accessFlags;
        this.constantPool = constantPool;
        this.interfaces = interfaces;
        this.fields = fields;
        this.methods = methods;
        this.attributes = attributes;
    }

    /**
     * To useful string.
     *
     * @param out the out
     */
    public void toUsefulString(PrintStream out) {
        out.println("Version=" + getVersion());
        out.println();
        out.println(getConstantPool().readableString());
        out.println("Fields");
        for (Field field : getFields()) {
            out.println(field.getNameIndex() + " " + field.getSignatureIndex());
            for (Attribute ag : field.getAttributes()) {
                ag.printUsefulData(out);
            }
            out.println("--");
        }
        out.println("Methods");
        for (Method method : getMethods()) {
            out.println(method.getNameIndex() + " " + method.getSignatureIndex());
            for (Attribute ag : method.getAttributes()) {
                ag.printUsefulData(out);
            }
            out.println("--");
        }
//        buffer.append("\nClass Attributes:");
//        for (Attribute attribute : getAttributes()) {
//            buffer.append(attribute.printUsefulData(buffer.toString()));
//        }
    }
}
