/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.classfile.attribute;

import java.io.DataInput;
import java.io.IOException;
import java.io.PrintStream;

import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class Attribute.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class Attribute {

    /**
     * Gets the attribute tag.
     *
     * @param constantPool the constant pool
     * @param nameIndex    the name index
     * @return the attribute tag
     */
    private static ClassFileAttributes getAttributeTag(ConstantPool constantPool, int nameIndex) {
        ClassFileAttributes tag = ClassFileAttributes.ATTR_UNKNOWN;
        String name = ((ConstantUtf8) constantPool.getConstant(nameIndex, ClassFileConstants.CONSTANT_Utf8)).getBytes();
        for (ClassFileAttributes currentTag : ClassFileAttributes.values()) {
            if (name.equals(currentTag.getName())) {
                tag = currentTag;
                break;
            }
        }
        return tag;
    }

    /**
     * Read attribute.
     *
     * @param file         the file
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @return the attribute
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static Attribute readAttribute(DataInput file, ConstantPool constantPool, Boolean isInnerClass) throws IOException {
        int nameIndex = file.readUnsignedShort();
        int length = file.readInt();
        ClassFileAttributes tag = getAttributeTag(constantPool, nameIndex);
        switch (tag) {
            case ATTR_CONSTANT_VALUE:
                return new ConstantValue(nameIndex, length, file);
            case ATTR_SOURCE_FILE:
                return new SourceFile(nameIndex, length, file);
            case ATTR_CODE:
                return new Code(nameIndex, length, file, constantPool, isInnerClass);
            case ATTR_EXCEPTIONS:
                return new ExceptionTable(nameIndex, length, file);
            case ATTR_LINE_NUMBER_TABLE:
                return new LineNumberTable(nameIndex, length, file);
            case ATTR_LOCAL_VARIABLE_TABLE:
                return new LocalVariableTable(nameIndex, length, file);
            case ATTR_INNER_CLASSES:
                return new InnerClasses(nameIndex, length, file, constantPool, isInnerClass);
            case ATTR_SYNTHETIC:
                return new Synthetic(nameIndex, length, file);
            case ATTR_DEPRECATED:
                return new Deprecated(nameIndex, length, file);
            case ATTR_PMG:
                return new PMGClass(nameIndex, length, file);
            case ATTR_SIGNATURE:
                return new Signature(nameIndex, length, file);
            case ATTR_STACK_MAP:
                return new StackMap(nameIndex, length, file);
            case ATTR_RUNTIME_VISIBLE_ANNOTATIONS:
                return new RuntimeVisibleAnnotations(nameIndex, length, file);
            case ATTR_RUNTIME_INVISIBLE_ANNOTATIONS:
                return new RuntimeInvisibleAnnotations(nameIndex, length, file);
            case ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
                return new RuntimeVisibleParameterAnnotations(nameIndex, length, file);
            case ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
                return new RuntimeInvisibleParameterAnnotations(nameIndex, length, file);
            case ATTR_ANNOTATION_DEFAULT:
                return new AnnotationDefault(nameIndex, length, file);
            case ATTR_LOCAL_VARIABLE_TYPE_TABLE:
                return new LocalVariableTypeTable(nameIndex, length, file);
            case ATTR_ENCLOSING_METHOD:
                return new EnclosingMethod(nameIndex, length, file);
            case ATTR_STACK_MAP_TABLE:
                return new StackMap(nameIndex, length, file);
            case ATTR_BOOTSTRAP_METHODS:
                return new BootstrapMethods(nameIndex, length, file);
            case ATTR_METHOD_PARAMETERS:
                return new MethodParameters(nameIndex, length, file);
            case ATTR_MODULE:
                return new Module(nameIndex, length, file);
            case ATTR_MODULE_PACKAGES:
                return new ModulePackages(nameIndex, length, file);
            case ATTR_MODULE_MAIN_CLASS:
                return new ModuleMainClass(nameIndex, length, file);
            case ATTR_NEST_HOST:
                return new NestHost(nameIndex, length, file);
            case ATTR_NEST_MEMBERS:
                return new NestMembers(nameIndex, length, file);
            default:
                return new Unknown(nameIndex, length, file);
        }
    }

    /** The name index. */
    protected Integer nameIndex;

    /** The length. */
    protected Integer length;

    /** The tag. */
    protected ClassFileAttributes tag;

    /**
     * Instantiates a new attribute.
     *
     * @param tag       the tag
     * @param nameIndex the name index
     * @param length    the length
     */
    protected Attribute(ClassFileAttributes tag, int nameIndex, int length) {
        this.tag = tag;
        this.nameIndex = nameIndex;
        this.length = length;
    }

    /**
     * Prints the useful data.
     *
     * @param out the out
     */
    public void printUsefulData(PrintStream out) {
        out.println(this.getClass().getName());
    }
}
