/*
 * (c) 2020 Christopher D. Wade
 */
package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.AnnotationDefault;
import com.wade.decompiler.classfile.attribute.Attribute;
import com.wade.decompiler.classfile.attribute.BootstrapMethods;
import com.wade.decompiler.classfile.attribute.Code;
import com.wade.decompiler.classfile.attribute.ConstantValue;
import com.wade.decompiler.classfile.attribute.EnclosingMethod;
import com.wade.decompiler.classfile.attribute.ExceptionTable;
import com.wade.decompiler.classfile.attribute.InnerClasses;
import com.wade.decompiler.classfile.attribute.LineNumberTable;
import com.wade.decompiler.classfile.attribute.LocalVariableTable;
import com.wade.decompiler.classfile.attribute.LocalVariableTypeTable;
import com.wade.decompiler.classfile.attribute.MethodParameters;
import com.wade.decompiler.classfile.attribute.Module;
import com.wade.decompiler.classfile.attribute.ModuleMainClass;
import com.wade.decompiler.classfile.attribute.ModulePackages;
import com.wade.decompiler.classfile.attribute.NestHost;
import com.wade.decompiler.classfile.attribute.NestMembers;
import com.wade.decompiler.classfile.attribute.PMGClass;
import com.wade.decompiler.classfile.attribute.RuntimeInvisibleAnnotations;
import com.wade.decompiler.classfile.attribute.RuntimeInvisibleParameterAnnotations;
import com.wade.decompiler.classfile.attribute.RuntimeVisibleAnnotations;
import com.wade.decompiler.classfile.attribute.RuntimeVisibleParameterAnnotations;
import com.wade.decompiler.classfile.attribute.Signature;
import com.wade.decompiler.classfile.attribute.SourceFile;
import com.wade.decompiler.classfile.attribute.StackMap;
import com.wade.decompiler.classfile.attribute.Synthetic;
import com.wade.decompiler.classfile.attribute.Unknown;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.classfile.constant.ConstantUtf8;
import com.wade.decompiler.enums.ClassFileAttributes;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class AttributeGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class AttributeGen {
    /**
     * Read attribute.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     * @return the attribute gen
     */
    public static AttributeGen readAttribute(Attribute attribute, ConstantPool constantPool, Boolean isInnerClass) {
        switch (attribute.getTag()) {
            case ATTR_UNKNOWN:
                return new UnknownGen((Unknown) attribute, constantPool);
            case ATTR_CONSTANT_VALUE:
                return new ConstantValueGen((ConstantValue) attribute, constantPool);
            case ATTR_SOURCE_FILE:
                return new SourceFileGen((SourceFile) attribute, constantPool);
            case ATTR_CODE:
                return new CodeGen((Code) attribute, constantPool, isInnerClass);
            case ATTR_EXCEPTIONS:
                return new ExceptionTableGen((ExceptionTable) attribute, constantPool);
            case ATTR_LINE_NUMBER_TABLE:
                return new LineNumberTableGen((LineNumberTable) attribute, constantPool);
            case ATTR_LOCAL_VARIABLE_TABLE:
                return new LocalVariableTableGen((LocalVariableTable) attribute, constantPool);
            case ATTR_INNER_CLASSES:
                return new InnerClassesGen((InnerClasses) attribute, constantPool, isInnerClass);
            case ATTR_SYNTHETIC:
                return new SyntheticGen((Synthetic) attribute, constantPool);
            case ATTR_DEPRECATED:
                return new DeprecatedGen((com.wade.decompiler.classfile.attribute.Deprecated) attribute, constantPool);
            case ATTR_PMG:
                return new PMGClassGen((PMGClass) attribute, constantPool);
            case ATTR_SIGNATURE:
                return new SignatureGen((Signature) attribute, constantPool);
            case ATTR_STACK_MAP:
            case ATTR_STACK_MAP_TABLE:
                return new StackMapGen((StackMap) attribute, constantPool);
            case ATTR_RUNTIME_VISIBLE_ANNOTATIONS:
                return new RuntimeVisibleAnnotationsGen((RuntimeVisibleAnnotations) attribute, constantPool);
            case ATTR_RUNTIME_INVISIBLE_ANNOTATIONS:
                return new RuntimeInvisibleAnnotationsGen((RuntimeInvisibleAnnotations) attribute, constantPool);
            case ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS:
                return new RuntimeVisibleParameterAnnotationsGen((RuntimeVisibleParameterAnnotations) attribute, constantPool);
            case ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS:
                return new RuntimeInvisibleParameterAnnotationsGen((RuntimeInvisibleParameterAnnotations) attribute, constantPool);
            case ATTR_ANNOTATION_DEFAULT:
                return new AnnotationDefaultGen((AnnotationDefault) attribute, constantPool);
            case ATTR_LOCAL_VARIABLE_TYPE_TABLE:
                return new LocalVariableTypeTableGen((LocalVariableTypeTable) attribute, constantPool);
            case ATTR_ENCLOSING_METHOD:
                return new EnclosingMethodGen((EnclosingMethod) attribute, constantPool);
            case ATTR_BOOTSTRAP_METHODS:
                return new BootstrapMethodsGen((BootstrapMethods) attribute, constantPool);
            case ATTR_METHOD_PARAMETERS:
                return new MethodParametersGen((MethodParameters) attribute, constantPool);
            case ATTR_MODULE:
                return new ModuleGen((Module) attribute, constantPool);
            case ATTR_MODULE_PACKAGES:
                return new ModulePackagesGen((ModulePackages) attribute, constantPool);
            case ATTR_MODULE_MAIN_CLASS:
                return new ModuleMainClassGen((ModuleMainClass) attribute, constantPool);
            case ATTR_NEST_HOST:
                return new NestHostGen((NestHost) attribute, constantPool);
            case ATTR_NEST_MEMBERS:
                return new NestMembersGen((NestMembers) attribute, constantPool);
            default:
                throw new IllegalStateException("Unrecognized attribute type tag parsed: " + attribute.getTag());
        }
    }

    /** The tag. */
    protected ClassFileAttributes tag;
    /** The name index. */
    protected Integer nameIndex;
    /** The length. */
    protected Integer length;

    /** The name. */
    protected String name;

    /**
     * Instantiates a new attribute gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public AttributeGen(Attribute attribute, ConstantPool constantPool) {
        this.tag = attribute.getTag();
        this.nameIndex = attribute.getNameIndex();
        this.length = attribute.getLength();
        this.name = ((ConstantUtf8) constantPool.getConstant(nameIndex, ClassFileConstants.CONSTANT_Utf8)).getBytes();
    }

    /**
     * Decompile.
     *
     * @param out the out
     */
    public void decompile(PrintStream out) {
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
