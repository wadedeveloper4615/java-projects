/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.util;

import com.wade.decompiler.exceptions.ClassFormatException;

/**
 * The Class TypeBase.
 */
public class TypeBase {
    /** The Constant consumed_chars. */
    protected static final ConsumedChars consumed_chars = new ConsumedChars();

    /**
     * Check index.
     *
     * @param signature the signature
     * @param fromIndex the from index
     */
    public void checkIndex(String signature, int fromIndex) {
        if (fromIndex < 0) {
            throw new ClassFormatException("Invalid signature: " + signature);
        }
    }

    /**
     * Gets the from index.
     *
     * @param signature the signature
     * @return the from index
     */
    public int getFromIndex(String signature) {
        int fromIndex = signature.indexOf('<');
        if (fromIndex < 0) {
            fromIndex = 0;
        } else {
            fromIndex = signature.indexOf('>', fromIndex);
            checkIndex(signature, fromIndex);
        }
        return fromIndex;
    }

    /**
     * Gets the index.
     *
     * @param signature the signature
     * @param fromIndex the from index
     * @return the index
     */
    public int getIndex(String signature, int fromIndex) {
        int index = signature.indexOf(';', fromIndex);
        checkIndex(signature, index);
        return index;
    }

    /**
     * Handle is A template.
     *
     * @param signature    the signature
     * @param bracketIndex the bracket index
     * @return the string
     */
    public String handleIsATemplate(String signature, int bracketIndex) {
        int fromIndex;
        String returnValue;
        fromIndex = signature.indexOf(';');
        checkIndex(signature, fromIndex);
        if (fromIndex < bracketIndex) {
            Utility.wrap(consumed_chars, fromIndex + 1);
            returnValue = signature.substring(1, fromIndex);
        } else {
            String templateClass = signature.substring(1, bracketIndex);
            StringBuilder templateParameters = new StringBuilder(templateClass).append("<");
            int consumedchars = bracketIndex + 1;
            consumedchars = handleUnusualTypeParameters(signature, templateParameters, consumedchars);
            consumedchars = handleTypeParameters(signature, templateParameters, consumedchars);
            consumedchars++;
            templateParameters.append(">");
//            System.out.println(signature.charAt(consumedchars));
//            if (signature.charAt(consumedchars) == '.') {
//                type.append(".");
//                type.append(parseJavaTypeString("L" + signature.substring(consumedchars + 1)));
//                consumedchars = Utility.unwrap(consumed_chars) + consumedchars;
//                Utility.wrap(consumed_chars, consumedchars);
//                returnValue = type.toString();
//            } else {
//                if (signature.charAt(consumedchars) != ';') {
//                    throw new ClassFormatException("Invalid signature: " + signature);
//                }
            Utility.wrap(consumed_chars, consumedchars + 1); // remove ";"
            returnValue = templateParameters.toString();
//            }
        }
        return returnValue;
    }

    /**
     * Handle not A template.
     *
     * @param signature the signature
     * @param index     the index
     * @return the string
     */
    public String handleNotATemplate(String signature, int index) {
        Utility.wrap(consumed_chars, index + 1);
        return signature.substring(1, index);
    }

    /**
     * Handle type objects.
     *
     * @param signature the signature
     * @return the string
     */
    public String handleTypeObjects(String signature) {
        int index = signature.indexOf(';');
        checkIndex(signature, index);
        Utility.wrap(consumed_chars, index + 1);
        return signature.substring(1, index);
    }

    /**
     * Handle type parameters.
     *
     * @param signature     the signature
     * @param type          the type
     * @param consumedchars the consumedchars
     * @return the int
     */
    public int handleTypeParameters(String signature, StringBuilder type, int consumedchars) {
        while (signature.charAt(consumedchars) != '>') {
            type.append(", ");
            consumedchars = handleUnusualTypeParameters(signature, type, consumedchars);
        }
        return consumedchars;
    }

    /**
     * Handle unusual type parameters.
     *
     * @param signature     the signature
     * @param type          the type
     * @param consumedchars the consumedchars
     * @return the int
     */
    public int handleUnusualTypeParameters(String signature, StringBuilder type, int consumedchars) {
        if (signature.charAt(consumedchars) == '+') {
            type.append("? extends ");
            consumedchars++;
        } else if (signature.charAt(consumedchars) == '-') {
            type.append("? super ");
            consumedchars++;
        }
        if (signature.charAt(consumedchars) == '*') {
            type.append("?");
            consumedchars++;
        } else {
            type.append(typeSignatureToString(signature.substring(consumedchars), false));
            consumedchars = Utility.unwrap(consumed_chars) + consumedchars;
            Utility.wrap(consumed_chars, consumedchars);
        }
        return consumedchars;
    }

    /**
     * Type signature to string.
     *
     * @param signature the signature
     * @param chopit    the chopit
     * @return the string
     */
    protected String typeSignatureToString(String signature, boolean chopit) {
        Utility.wrap(consumed_chars, 1);
        try {
            switch (signature.charAt(0)) {
                case 'B':
                    return "byte";
                case 'C':
                    return "char";
                case 'D':
                    return "double";
                case 'F':
                    return "float";
                case 'I':
                    return "int";
                case 'J':
                    return "long";
                case 'T': {
                    return handleTypeObjects(signature);
                }
                case 'L': {
                    int fromIndex = getFromIndex(signature);
                    int index = getIndex(signature, fromIndex);
                    int bracketIndex = signature.substring(0, index).indexOf('<');
                    String returnValue = null;
                    if (bracketIndex < 0) {
                        returnValue = handleNotATemplate(signature, index);
                    } else {
                        returnValue = handleIsATemplate(signature, bracketIndex);
                    }
                    return returnValue;
                }
                case 'S':
                    return "short";
                case 'Z':
                    return "boolean";
                case '[': {
                    int n;
                    StringBuilder brackets;
                    String type;
                    int consumedchars;
                    brackets = new StringBuilder();
                    for (n = 0; signature.charAt(n) == '['; n++) {
                        brackets.append("[]");
                    }
                    consumedchars = n;
                    type = typeSignatureToString(signature.substring(n), false);
                    int _temp = Utility.unwrap(consumed_chars) + consumedchars;
                    Utility.wrap(consumed_chars, _temp);
                    return type + brackets.toString();
                }
                case 'V':
                    return "void";
                default:
                    throw new ClassFormatException("Invalid signature: `" + signature + "'");
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new ClassFormatException("Invalid signature: " + signature, e);
        }
    }
}
