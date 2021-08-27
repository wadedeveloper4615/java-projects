package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;

import com.wade.decompiler.classfile.attribute.ModuleMainClass;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModuleMainClassGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModuleMainClassGen extends AttributeGen {
    /** The class name. */
    private String className;

    /**
     * Instantiates a new module main class gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModuleMainClassGen(ModuleMainClass attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        Integer mainClassIndex = attribute.getMainClassIndex();
        ClassFileConstants type = ClassFileConstants.CONSTANT_Class;
        this.className = constantPool.constantToString(mainClassIndex, type);
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
