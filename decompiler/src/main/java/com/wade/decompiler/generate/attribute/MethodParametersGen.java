package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.MethodParameters;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class MethodParametersGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class MethodParametersGen extends AttributeGen {
    /** The parameters. */
    private List<MethodParameterGen> parameters;

    /**
     * Instantiates a new method parameters gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public MethodParametersGen(MethodParameters attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.parameters = new ArrayList<>();
        attribute.getParameters().stream().forEach(entry -> this.parameters.add(new MethodParameterGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
