package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.BootstrapMethods;
import com.wade.decompiler.classfile.constant.ConstantPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class BootstrapMethodsGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class BootstrapMethodsGen extends AttributeGen {
    /** The bootstrap methods. */
    private List<BootstrapMethodGen> bootstrapMethods;

    /**
     * Instantiates a new bootstrap methods gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public BootstrapMethodsGen(BootstrapMethods attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.bootstrapMethods = new ArrayList<>();
        attribute.getBootstrapMethods().stream().forEach(entry -> this.bootstrapMethods.add(new BootstrapMethodGen(entry, constantPool)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println("\nBootstrap methods:");
        for (BootstrapMethodGen inst : getBootstrapMethods()) {
            out.println("\n\tmethod ref = " + inst.getBootstrapMethodName());
            for (String arg : inst.getBootstrapArguments()) {
                out.println("\n\t\t arg=" + arg);
            }
        }
    }
}
