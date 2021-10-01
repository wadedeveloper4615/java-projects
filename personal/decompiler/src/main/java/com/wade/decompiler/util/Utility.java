/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.util;

import com.wade.decompiler.constants.Const;
import com.wade.decompiler.enums.ClassAccessFlags;
import com.wade.decompiler.enums.ClassAccessFlagsList;
import com.wade.decompiler.exceptions.ClassFormatException;
import com.wade.decompiler.generate.attribute.LocalVariableGen;
import com.wade.decompiler.generate.attribute.LocalVariableTableGen;

/**
 * The Class Utility.
 */
public abstract class Utility {

    /** The Constant consumed_chars. */
    private static final ConsumedChars consumed_chars = new ConsumedChars();

    /**
     * Access to string.
     *
     * @param access_flags the access flags
     * @return the string
     */
    public static String accessToString(ClassAccessFlagsList access_flags) {
        return accessToString(access_flags, false);
    }

    /**
     * Access to string.
     *
     * @param access_flags the access flags
     * @param for_class    the for class
     * @return the string
     */
    public static String accessToString(ClassAccessFlagsList access_flags, boolean for_class) {
        StringBuilder buf = new StringBuilder();
        int p = 0;
        for (int i = 0; p < Const.MAX_ACC_FLAG_I; i++) { // Loop through known flags
            p = pow2(i);
            if ((access_flags.getFlags() & p) != 0) {
                if (for_class && ((p == ClassAccessFlags.ACC_SUPER.getFlag()) || (p == ClassAccessFlags.ACC_INTERFACE.getFlag()))) {
                    continue;
                }
                buf.append(ClassAccessFlags.read(i).getName()).append(" ");
            }
        }
        return buf.toString().trim();
    }

    /**
     * Class type.
     *
     * @param flags the flags
     * @return the string
     */
    public static String classType(ClassAccessFlagsList flags) {
        boolean isAnnotation = flags.isInterface() && flags.isAnnotation() && flags.isAbstract();
        boolean isInterface = flags.isInterface() && !flags.isAnnotation() && !flags.isAbstract();
        if (isAnnotation) {
            flags.remove(ClassAccessFlags.ACC_ABSTRACT);
            flags.remove(ClassAccessFlags.ACC_ABSTRACT);
            flags.remove(ClassAccessFlags.ACC_ANNOTATION);
            return "@interface";
        } else if (isInterface) {
            return "interface";
        } else {
            return "class";
        }
    }

    /**
     * Compact class name.
     *
     * @param str the str
     * @return the string
     */
    public static String compactClassName(String str) {
        return compactClassName(str, true);
    }

    /**
     * Compact class name.
     *
     * @param str    the str
     * @param chopit the chopit
     * @return the string
     */
    public static String compactClassName(String str, boolean chopit) {
        return compactClassName(str, "java.lang.", chopit);
    }

    /**
     * Compact class name.
     *
     * @param str    the str
     * @param prefix the prefix
     * @param chopit the chopit
     * @return the string
     */
    public static String compactClassName(String str, String prefix, boolean chopit) {
        int len = prefix.length();
        str = str.replace('/', '.');
        if (chopit) {
            if (str.startsWith(prefix) && (str.substring(len).indexOf('.') == -1)) {
                str = str.substring(len);
            }
        }
        return str;
    }

    /**
     * Extract class name.
     *
     * @param path the path
     * @return the object
     */
    public static Object extractClassName(String path) {
        int index = path.lastIndexOf('.');
        return path.substring(index + 1);
    }

    /**
     * Extract class name.
     *
     * @param className the class name
     * @param b         the b
     * @return the string
     */
    public static String extractClassName(String className, boolean b) {
        String name = Utility.compactClassName(className, b);
        int index = name.lastIndexOf(".") + 1;
        return name.substring(index);
    }

    /**
     * Method signature to string.
     *
     * @param signature the signature
     * @param name      the name
     * @param access    the access
     * @param chopit    the chopit
     * @param vars      the vars
     * @return the string
     * @throws ClassFormatException the class format exception
     */
    public static String methodSignatureToString(String signature, String name, String access, boolean chopit, LocalVariableTableGen vars) throws ClassFormatException {
        StringBuilder buf = new StringBuilder("(");
        String type;
        int index;
        int var_index = access.contains("static") ? 0 : 1;
        try {
            // Skip any type arguments to read argument declarations between `(' and `)'
            index = signature.indexOf('(') + 1;
            if (index <= 0) {
                throw new ClassFormatException("Invalid method signature: " + signature);
            }
            while (signature.charAt(index) != ')') {
                String param_type = typeSignatureToString(signature.substring(index), chopit);
                buf.append(param_type);
                if (vars != null) {
                    LocalVariableGen l = vars.getLocalVariable(var_index, 0);
                    if (l != null) {
                        buf.append(" ").append(l.getName());
                    }
                } else {
                    buf.append(" arg").append(var_index);
                }
                if ("double".equals(param_type) || "long".equals(param_type)) {
                    var_index += 2;
                } else {
                    var_index++;
                }
                buf.append(", ");
                // corrected concurrent private static field acess
                index += unwrap(consumed_chars); // update position
            }
            index++; // update position
            // Read return type after `)'
            type = typeSignatureToString(signature.substring(index), chopit);
        } catch (StringIndexOutOfBoundsException e) { // Should never occur
            throw new ClassFormatException("Invalid method signature: " + signature, e);
        }
        // ignore any throws information in the signature
        if (buf.length() > 1) {
            buf.setLength(buf.length() - 2);
        }
        buf.append(")");
        return access + ((access.length() > 0) ? " " : "") + type + " " + name + buf.toString();
    }

    /**
     * Pow 2.
     *
     * @param n the n
     * @return the int
     */
    private static int pow2(int n) {
        return 1 << n;
    }

    /**
     * Type signature to string.
     *
     * @param signature the signature
     * @param chopit    the chopit
     * @return the string
     */
    public static String typeSignatureToString(String signature, boolean chopit) {
        wrap(consumed_chars, 1);
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
                    int index = signature.indexOf(';');
                    if (index < 0) {
                        throw new ClassFormatException("Invalid type variable signature: " + signature);
                    }
                    wrap(consumed_chars, index + 1);
                    return compactClassName(signature.substring(1, index), chopit);
                }
                case 'L': {
                    int fromIndex = signature.indexOf('<');
                    if (fromIndex < 0) {
                        fromIndex = 0;
                    } else {
                        fromIndex = signature.indexOf('>', fromIndex);
                        if (fromIndex < 0) {
                            throw new ClassFormatException("Invalid signature: " + signature);
                        }
                    }
                    int index = signature.indexOf(';', fromIndex);
                    if (index < 0) {
                        throw new ClassFormatException("Invalid signature: " + signature);
                    }

                    int bracketIndex = signature.substring(0, index).indexOf('<');
                    if (bracketIndex < 0) {
                        wrap(consumed_chars, index + 1);
                        return compactClassName(signature.substring(1, index), chopit);
                    }
                    fromIndex = signature.indexOf(';');
                    if (fromIndex < 0) {
                        throw new ClassFormatException("Invalid signature: " + signature);
                    }
                    if (fromIndex < bracketIndex) {
                        wrap(consumed_chars, fromIndex + 1);
                        return compactClassName(signature.substring(1, fromIndex), chopit);
                    }
                    StringBuilder type = new StringBuilder(compactClassName(signature.substring(1, bracketIndex), chopit)).append("<");
                    int consumed_chars = bracketIndex + 1;
                    if (signature.charAt(consumed_chars) == '+') {
                        type.append("? extends ");
                        consumed_chars++;
                    } else if (signature.charAt(consumed_chars) == '-') {
                        type.append("? super ");
                        consumed_chars++;
                    }
                    if (signature.charAt(consumed_chars) == '*') {
                        type.append("?");
                        consumed_chars++;
                    } else {
                        type.append(typeSignatureToString(signature.substring(consumed_chars), chopit));
                        consumed_chars = unwrap(Utility.consumed_chars) + consumed_chars;
                        wrap(Utility.consumed_chars, consumed_chars);
                    }
                    while (signature.charAt(consumed_chars) != '>') {
                        type.append(", ");
                        if (signature.charAt(consumed_chars) == '+') {
                            type.append("? extends ");
                            consumed_chars++;
                        } else if (signature.charAt(consumed_chars) == '-') {
                            type.append("? super ");
                            consumed_chars++;
                        }
                        if (signature.charAt(consumed_chars) == '*') {
                            type.append("?");
                            consumed_chars++;
                        } else {
                            type.append(typeSignatureToString(signature.substring(consumed_chars), chopit));
                            consumed_chars = unwrap(Utility.consumed_chars) + consumed_chars;
                            wrap(Utility.consumed_chars, consumed_chars);
                        }
                    }
                    consumed_chars++;
                    type.append(">");

                    if (signature.charAt(consumed_chars) == '.') {
                        type.append(".");
                        type.append(typeSignatureToString("L" + signature.substring(consumed_chars + 1), chopit));
                        consumed_chars = unwrap(Utility.consumed_chars) + consumed_chars;
                        wrap(Utility.consumed_chars, consumed_chars);
                        return type.toString();
                    }
                    if (signature.charAt(consumed_chars) != ';') {
                        throw new ClassFormatException("Invalid signature: " + signature);
                    }
                    wrap(Utility.consumed_chars, consumed_chars + 1); // remove ";"
                    return type.toString();
                }
                case 'S':
                    return "short";
                case 'Z':
                    return "boolean";
                case '[': {
                    int n;
                    StringBuilder brackets;
                    String type;
                    int consumed_chars;
                    brackets = new StringBuilder();
                    for (n = 0; signature.charAt(n) == '['; n++) {
                        brackets.append("[]");
                    }
                    consumed_chars = n;
                    type = typeSignatureToString(signature.substring(n), chopit);
                    int _temp = unwrap(Utility.consumed_chars) + consumed_chars;
                    wrap(Utility.consumed_chars, _temp);
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

    /**
     * Unwrap.
     *
     * @param tl the tl
     * @return the int
     */
    public static int unwrap(ThreadLocal<Integer> tl) {
        return tl.get().intValue();
    }

    /**
     * Wrap.
     *
     * @param tl    the tl
     * @param value the value
     */
    public static void wrap(ThreadLocal<Integer> tl, int value) {
        tl.set(Integer.valueOf(value));
    }
}
