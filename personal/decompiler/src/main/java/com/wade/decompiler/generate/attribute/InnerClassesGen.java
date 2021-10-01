package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.InnerClasses;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class InnerClassesGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class InnerClassesGen extends AttributeGen {
    /** The inner classes. */
    private List<InnerClassGen> innerClasses;

    /**
     * Instantiates a new inner classes gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     * @param isInnerClass the is inner class
     */
    public InnerClassesGen(InnerClasses attribute, ConstantPool constantPool, Boolean isInnerClass) {
        super(attribute, constantPool);
        innerClasses = new ArrayList<>();
        attribute.getInnerClasses().stream().forEach(entry -> innerClasses.add(new InnerClassGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("Inner Classes:");
        for (InnerClassGen inst : getInnerClasses()) {
            out.println(inst.toString());
        }
    }
}
