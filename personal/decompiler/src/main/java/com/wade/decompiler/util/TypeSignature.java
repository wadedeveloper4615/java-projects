/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * The Class TypeSignature.
 */
@Getter
@ToString(callSuper = false, includeFieldNames = true)
@EqualsAndHashCode(callSuper = false)
public class TypeSignature extends TypeBase {
    /** The type. */
    private String type;

    /** The original. */
    private String original;

    /**
     * Instantiates a new type signature.
     *
     * @param signature the signature
     * @param chopit    the chopit
     */
    public TypeSignature(String signature, boolean chopit) {
        if (signature == null) {
            return;
        }
        original = signature;
        type = typeSignatureToString(signature, false);
    }
}
