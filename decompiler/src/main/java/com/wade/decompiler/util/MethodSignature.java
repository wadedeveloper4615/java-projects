/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.util;

import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.exceptions.ClassFormatException;
import com.wade.decompiler.generate.attribute.LocalVariableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class MethodSignature.
 */
@Getter
@ToString(callSuper = false, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class MethodSignature extends TypeBase {
    /** The parameters. */
    private List<TypeSignature> parameters;

    /** The return type. */
    private TypeSignature returnType;

    /**
     * Instantiates a new method signature.
     *
     * @param signature the signature
     * @param chopit    the chopit
     */
    public MethodSignature(String signature, boolean chopit) {
        this.parameters = new ArrayList<>();
        // System.out.println("original signature = " + signature);
        methodSignatureToString(signature, chopit);
    }

    /**
     * Gets the signature.
     *
     * @param className2  the class name 2
     * @param constructor the constructor
     * @param access      the access
     * @param name        the name
     * @param vars        the vars
     * @return the signature
     */
    public String getSignature(String className2, boolean constructor, String access, String name, LocalVariableTableGen vars) {
        String str = Utility.extractClassName(className2, false);
        String functionName = constructor ? str : name;
        String result;
        if (constructor) {
            result = access + " " + functionName + "(";
        } else {
            result = access + " " + returnType.getType() + " " + functionName + "(";
        }
        int i = 1;
        char v = 'a';
        String temp = "";
        for (TypeSignature ts : this.parameters) {
            temp += Utility.compactClassName(ts.getType());
            LocalVariableGen localVariableGen = vars.getLocalVariableTable().get(i);
            if (localVariableGen != null) {
                temp += " " + localVariableGen.getName();
            } else {
                temp += " " + v;
                v++;
            }
            temp += ",";
            i++;
        }
        if (!temp.equals("")) {
            temp = temp.substring(0, temp.length() - 1);
        }
        result += temp + ")";
        return result;
    }

    /**
     * Method signature to string.
     *
     * @param signature the signature
     * @param chopit    the chopit
     * @throws ClassFormatException the class format exception
     */
    protected void methodSignatureToString(String signature, boolean chopit) throws ClassFormatException {
        TypeSignature type;
        int index;
        try {
            index = signature.indexOf('(') + 1;
            if (index <= 0) {
                throw new ClassFormatException("Invalid method signature: " + signature);
            }
            while (signature.charAt(index) != ')') {
                TypeSignature param_type = new TypeSignature(signature.substring(index), chopit);
                parameters.add(param_type);
                index += Utility.unwrap(consumed_chars);
            }
            index++;
            type = new TypeSignature(signature.substring(index), chopit);
        } catch (StringIndexOutOfBoundsException e) {
            throw new ClassFormatException("Invalid method signature: " + signature, e);
        }
        returnType = type;
    }
}
