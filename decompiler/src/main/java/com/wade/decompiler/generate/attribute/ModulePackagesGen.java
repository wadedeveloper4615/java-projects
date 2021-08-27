package com.wade.decompiler.generate.attribute;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.wade.decompiler.classfile.attribute.ModulePackages;
import com.wade.decompiler.classfile.constant.ConstantPool;
import com.wade.decompiler.enums.ClassFileConstants;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The Class ModulePackagesGen.
 */
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@NoArgsConstructor
public class ModulePackagesGen extends AttributeGen {
    /** The package index names. */
    private List<String> packageIndexNames;

    /**
     * Instantiates a new module packages gen.
     *
     * @param attribute    the attribute
     * @param constantPool the constant pool
     */
    public ModulePackagesGen(ModulePackages attribute, ConstantPool constantPool) {
        super(attribute, constantPool);
        this.packageIndexNames = new ArrayList<>();
        attribute.getPackageIndexTable().stream().forEach(entry -> this.packageIndexNames.add(constantPool.constantToString(entry, ClassFileConstants.CONSTANT_Package)));
    }

    @Override
    public void decompile(PrintStream out) {
    }

    @Override
    public void printUsefulData(PrintStream out) {
        out.println(toString());
    }
}
