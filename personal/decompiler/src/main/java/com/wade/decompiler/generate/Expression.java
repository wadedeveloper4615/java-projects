/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate;

import com.wade.decompiler.util.MethodSignature;
import com.wade.decompiler.util.TypeSignature;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class Expression.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Expression {
    /** The name. */
    private String name;

    /** The signature. */
    private TypeSignature signaturet;

    /** The signature. */
    private MethodSignature signaturem;

    /** The method. */
    private boolean method;

    /**
     * Instantiates a new expression.
     *
     * @param name      the name
     * @param signature the signature
     * @param method    the method
     */
    public Expression(String name, MethodSignature signature, boolean method) {
        this.method = true;
        this.name = name;
        this.signaturem = signature;
    }

    /**
     * Instantiates a new expression.
     *
     * @param name      the name
     * @param signature the signature
     */
    public Expression(String name, String signature) {
        this.method = false;
        this.name = name;
        this.signaturet = new TypeSignature(signature, false);
    }

    /**
     * Instantiates a new expression.
     *
     * @param name      the name
     * @param signature the signature
     * @param method    the method
     */
    public Expression(String name, String signature, boolean method) {
        this.method = true;
        this.name = name;
        this.signaturem = new MethodSignature(signature, false);
    }

    /**
     * Instantiates a new expression.
     *
     * @param name      the name
     * @param signature the signature
     */
    public Expression(String name, TypeSignature signature) {
        this.method = false;
        this.name = name;
        this.signaturet = signature;
    }
}
