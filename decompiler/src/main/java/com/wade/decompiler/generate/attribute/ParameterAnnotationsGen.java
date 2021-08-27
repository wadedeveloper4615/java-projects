package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ParameterAnnotations;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ParameterAnnotationsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ParameterAnnotationsGen extends AttributeGen {
    /** The parameter annotation table. */
    private List<ParameterAnnotationEntryGen> parameterAnnotationTable;

    /**
     * Instantiates a new parameter annotations gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ParameterAnnotationsGen(ParameterAnnotations attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.parameterAnnotationTable = new ArrayList<>();
        attribute.getParameterAnnotationTable().stream().forEach(entry -> this.parameterAnnotationTable.add(new ParameterAnnotationEntryGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
